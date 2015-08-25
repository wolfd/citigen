package io.wolfd.city.procedural.road.filters;

import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.road.RoadFilter;

public class Angle implements RoadFilter {

  /**
   * Filters this road to a "reasonable" location and removes it if necessary.
   *
   * @param road
   * @return a filtered road
   */
  @Override public Road filter(Road road) {
    return road;
  }

  /**
   * If the RoadFilter implements it, this allows the filter to change with
   * every iteration.
   *
   * @return a new RoadFilter or the same object, depending on the
   * implementation.
   */
  @Override public RoadFilter mutate() {
    return this;
  }
}
