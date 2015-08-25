package io.wolfd.city.server;

import java.util.List;
import java.util.stream.Collectors;
import com.codahale.metrics.annotation.Timed;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.wolfd.city.procedural.City;
import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.server.data.RoadData;

@Path("/city")
@Produces(MediaType.APPLICATION_JSON)
public class CityResource {
  public CityResource() {

  }

  @GET
  @Timed
  public List<RoadData> generate() {
    City city = new City();
    city.build().seedCityAtCenter().generate();
    List<RoadData> roadData = city.roads.getRoads()
        .stream()
        .map(Road::toPOJO)
        .collect(Collectors.toList());

    roadData.size();
    return roadData;
  }
}
