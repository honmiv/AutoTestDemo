package KafkaTest;

import AutoTest.ConfProperties;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class KafkaTestInOut {

    @Test
    public void testKafka() throws InterruptedException {
        KafkaProducerIn kafkaProducerIn = new KafkaProducerIn();
        KafkaConsumerOut kafkaConsumerOut = new KafkaConsumerOut();

        kafkaProducerIn.runProducer(5, ConfProperties.getProperty("UserId"));
        kafkaConsumerOut.runConsumer();

        String content = kafkaConsumerOut.strValue;
        JsonElement parser = new JsonParser().parse(content);
        String Id = parser.getAsJsonObject().get("clientId").getAsString();
        String Sex = parser.getAsJsonObject().get("sex").getAsString();
        Assert.assertEquals((ConfProperties.getProperty("UserId")), Id);
        Assert.assertEquals((ConfProperties.getProperty("UserSex")),Sex);
    }

}
