package io.wolfd.city.server;

import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
  public CityResource() {
  }

  @POST
  @Timed
  public String generate() {
    return "";
  }
}
