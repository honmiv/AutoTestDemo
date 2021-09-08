package AutoTest;


import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.junit.jupiter.api.Assertions;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class TestRestTeamplate {
    @Test
    public void testGetEmployeeListSuccess() {
        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8080/getClientSex?clientId="+ConfProperties.getProperty("UserId");
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
             Assertions.fail(e);
        }

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
        String content = result.getBody();
        JsonElement parser = new JsonParser().parse(content);
        String Id = parser.getAsJsonObject().get("clientId").getAsString();
        String Sex = parser.getAsJsonObject().get("sex").getAsString();

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals((ConfProperties.getProperty("UserId")), Id);
        Assert.assertEquals((ConfProperties.getProperty("UserSex")),Sex);
    }
}



