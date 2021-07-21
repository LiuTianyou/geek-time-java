package com.example.week07;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

/**
 * @author Liutianyou
 * @date 2021/7/21 11:52 下午
 */

public interface ShutdownEndpointService {
  @POST
  @Path("/actuator/shutdown")
  String callShutdownEndpoint();

}
