package io.wolfd.city.procedural.road;

import java.util.ArrayList;
import java.util.List;

import io.wolfd.city.procedural.City;
import io.wolfd.city.procedural.road.filters.Overlapping;
import io.wolfd.city.procedural.road.filters.RoadLength;

public class FilterLibrary {
  private final List<RoadFilter> filters;

  public FilterLibrary(City city) {
    filters = new ArrayList<>();
    filters.add(new RoadLength());
    filters.add(new Overlapping(city));
  }

  public Road filter(Road road) {
    for (RoadFilter f : filters) {
      f.filter(road);
      if(road.failed) break;
    }
    return road;
  }
}
