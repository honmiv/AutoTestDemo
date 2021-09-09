package KafkaTest;


import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.LongSerializer;
import org.apache.kafka.common.serialization.StringSerializer;
import java.util.Properties;

public class KafkaProducerIn {

    private final static String TOPIC = "in-topic-name";
    private final static String BOOTSTRAP_SERVERS = "localhost:9092";

    private static Producer<Long, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,
                BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.CLIENT_ID_CONFIG, "KafkaProducer");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                LongSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                StringSerializer.class.getName());
        return new KafkaProducer<>(props);
}

    static void runProducer(final int sendMessageCount, String value) {
         final Producer<Long, String> producer = createProducer();
         long time = System.currentTimeMillis();

                 for (long index = time; index < time + sendMessageCount; index++) {
                         final ProducerRecord<Long, String> record =
                                 new ProducerRecord<>(TOPIC, index,
                                         value);

                         producer.send(record);
                         System.out.printf("ClientId = "+ record.value()+"\n");

                        }
                 producer.flush();
                 producer.close();

    }

    public static void main(String[] args) throws Exception {
        runProducer(8, "1337");
    }
}

