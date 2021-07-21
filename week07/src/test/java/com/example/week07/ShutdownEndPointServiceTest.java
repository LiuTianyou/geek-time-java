package com.example.week07;

import java.net.MalformedURLException;
import java.net.URL;
import org.eclipse.microprofile.rest.client.RestClientBuilder;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.junit.jupiter.api.Test;

/**
 * @author Liutianyou
 * @date 2021/7/21 11:52 下午
 */
public class ShutdownEndPointServiceTest {

  @Test
  public void testShutdownEndPointService() throws MalformedURLException {
    ShutdownEndpointService shutdownEndpointService = RestClientBuilder.newBuilder()
        .baseUrl(new URL("http://127.0.0.1:8900")).build(ShutdownEndpointService.class);
    System.out.println(shutdownEndpointService.callShutdownEndpoint());
  }
}
