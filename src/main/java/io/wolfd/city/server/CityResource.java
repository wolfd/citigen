package io.wolfd.city.server;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
  private final AtomicLong counter;

  public CityResource() {
    this.counter = new AtomicLong();
  }

  @GET
  @Timed
  public String sayHello(@QueryParam("name") Optional<String> name) {
    return name.or(String.valueOf(counter.incrementAndGet()));
  }
}
