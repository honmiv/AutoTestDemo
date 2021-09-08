package AutoTest;


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
        String str = "{\"clientId\":\"1337\",\"sex\":\"MALE\"}";
        final String baseUrl = "http://localhost:8080/getClientSex?clientId=1337";
        URI uri = null;
        try {
            uri = new URI(baseUrl);
        } catch (URISyntaxException e) {
            Assertions.fail(e);
        }

        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals(str, result.getBody());

    }
}



