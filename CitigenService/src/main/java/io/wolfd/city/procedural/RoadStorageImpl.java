package io.wolfd.city.procedural;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import io.wolfd.city.procedural.road.Road;
import mikera.vectorz.Vector3;

public class RoadStorageImpl implements RoadStorage {

  private final List<Road> roads;

  public RoadStorageImpl() {
    this.roads = new ArrayList<>();
  }

  /**
   * Returns all roads contained within the storage
   *
   * @return all roads
   */
  public List<Road> getRoads() {
    return roads;
  }

  /**
   * Returns all roads with nodes contained within a radius of the position
   * given, ignoring height (z).
   *
   * @param center the center of the circle
   * @param radius the radius to search within.
   * @return all roads with nodes within a radius of center
   */
  public List<Road> getRoadsWithinRadius(Vector3 center, double radius) {
    return roads
        .parallelStream()
        .filter((r) -> r.a.getPosition().distance(center) < radius || r.b.getPosition().distance(center) < radius)
        .collect(Collectors.toList());
  }

  /**
   * Adds a road to the storage structure.
   *
   * @param road the road to add to the structure.
   */
  public void addRoad(Road road) {
    this.roads.add(road);
  }

  /**
   * Removes a road from the storage structure.
   *
   * @param road the road to remove from the storage
   */
  public void removeRoad(Road road) {
    this.roads.remove(road);
  }
}
