package KafkaTest;

import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.common.serialization.LongDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;


import java.time.Duration;
import java.util.Collections;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;

public class KafkaConsumerOut {

    private final static String TOPIC = "out-topic-name";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";
    static String strValue;

    private static Consumer<Long, String> createConsumer() {
        final Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG,
                "KafkaConsumer");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
                LongDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
                StringDeserializer.class.getName());

        final Consumer<Long, String> consumer =
                new KafkaConsumer<>(props);

        consumer.subscribe(Collections.singletonList(TOPIC));
        return consumer;
    }


    static void runConsumer() throws InterruptedException {
        final Consumer<Long, String> consumer = createConsumer();

        final int giveUp = 100;   int noRecordsCount = 0;
        final Duration MAX_WAIT = Duration.ofNanos(Long.MAX_VALUE);
        AtomicBoolean flag = new AtomicBoolean(true);

        while (flag.get()) {
            final ConsumerRecords<Long, String> consumerRecords =
                   consumer.poll(MAX_WAIT);

            if (consumerRecords.count()==0) {
                noRecordsCount++;
                if (noRecordsCount > giveUp) break;
                else continue;
            }

            consumerRecords.forEach(record -> {
                System.out.printf("Полученная запись: "+record.value()+"\n");
                strValue = record.value();
                flag.set(false);
            });

            consumer.commitAsync();
        }
        consumer.close();
    }

    public static void main(String[] args) throws Exception {
        runConsumer();
    }
}



