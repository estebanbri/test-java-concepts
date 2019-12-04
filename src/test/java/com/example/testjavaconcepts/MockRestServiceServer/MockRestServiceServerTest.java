package com.example.testjavaconcepts.MockRestServiceServer;

import com.example.testjavaconcepts.MockRestServiceServerPOC.MockRestServiceServerPOC;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.client.ResponseCreator;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.client.ExpectedCount.once;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import org.apache.commons.io.IOUtils;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MockRestServiceServerTest {

    private MockRestServiceServer mockServer;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    private MockRestServiceServerPOC service;

    @Before
    public void setUp(){
        this.mockServer = MockRestServiceServer.createServer(restTemplate);
    }

    @Test
    public void callWS() throws IOException, URISyntaxException {
        String fakeJsonResponsePath = "/fakes_responses/fake_response.json";
        expectSuccessResponse(fakeJsonResponsePath);

        String jsonResponse = service.callWS();
        System.out.print(jsonResponse);
        assertTrue(jsonResponse.contains("\"PricingAreaId\": \"FAKE_ID\","));
        assertTrue(jsonResponse.contains("\"PricingAreaName\": \"FAKE_NAME\""));
        assertTrue(jsonResponse.contains("\"PricingAreaTdmCapable\": true"));
        this.mockServer.verify();
}

    private void expectSuccessResponse(String jsonResourceName) throws IOException, URISyntaxException {
        expectResponseWithBody(HttpStatus.OK, MediaType.APPLICATION_JSON, jsonResourceName);
    }

    private void expectResponseWithBody(HttpStatus httpStatus, MediaType contentType, String resourceName) throws IOException, URISyntaxException {
        expectResponse(contentType, withStatus(httpStatus).body(getResourceContents(resourceName)).contentType(contentType));
    }

    private void expectResponse(MediaType contentType, ResponseCreator responseCreator) throws IOException, URISyntaxException {
        this.mockServer.expect(once(),
                requestTo(new URI("https://httpbin.org/get")))
                .andExpect(method(HttpMethod.GET))
                .andRespond(responseCreator);
    }

    private String getResourceContents(String name) throws IOException {
        return IOUtils.toString(getClass().getResourceAsStream(name));
    }
}
