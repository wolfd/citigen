package io.wolfd.city.procedural.road.filters;

import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.road.RoadFilter;

public class RoadLength implements RoadFilter {
  private static final double MIN_ROAD_LENGTH = 5;

  /**
   * Filters this road to a "reasonable" location and removes it if necessary.
   *
   * @param road
   * @return a filtered road
   */
  public Road filter(Road road) {
    double distance = road.a.getPosition().distance(road.b.getPosition());
    if (distance <= MIN_ROAD_LENGTH) {
      road.failed = true;
    }

    return road;
  }

  /**
   * If the RoadFilter implements it, this allows the filter to change with
   * every iteration.
   *
   * @return a new RoadFilter or the same object, depending on the
   * implementation.
   */
  public RoadFilter mutate() {
    return this;
  }
}
