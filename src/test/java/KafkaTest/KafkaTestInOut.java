package KafkaTest;

import AutoTest.ConfProperties;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class KafkaTestInOut {

    @Test
    public void testKafka() throws InterruptedException {
        KafkaProducerIn kafkaProducerIn = new KafkaProducerIn();
        KafkaConsumerOut kafkaConsumerOut = new KafkaConsumerOut();
        String clientId = ConfProperties.getProperty("ExpectedId");
        String str = "{\"clientId\":"+ ConfProperties.getProperty("ExpectedId")+",\"sex\":"+ConfProperties.getProperty("ExpectedSex")+"}";

        kafkaProducerIn.runProducer(5, ConfProperties.getProperty("UserId"));
        kafkaConsumerOut.runConsumer();
        Assert.assertEquals(str,kafkaConsumerOut.strValue);
    }

}
