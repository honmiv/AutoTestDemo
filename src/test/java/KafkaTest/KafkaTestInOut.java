package KafkaTest;

import AutoTest.ConfProperties;
import com.google.gson.Gson;
import dto.ResponseDto;
import dto.Sexes;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class KafkaTestInOut {

    @Test
    public void testKafka() throws InterruptedException {
        KafkaProducerIn kafkaProducerIn = new KafkaProducerIn();
        KafkaConsumerOut kafkaConsumerOut = new KafkaConsumerOut();

        KafkaProducerIn.runProducer(5, ConfProperties.getProperty("UserId"));
        KafkaConsumerOut.runConsumer();

        String content = KafkaConsumerOut.strValue;

        Gson gson = new Gson();
        ResponseDto actual = gson.fromJson(content, ResponseDto.class);
        ResponseDto expected = new ResponseDto(
                ConfProperties.getProperty("UserId"),
                Sexes.valueOf(ConfProperties.getProperty("UserSex"))
        );

        Assertions.assertEquals(expected, actual);
    }

}
