package io.wolfd.city.procedural;

import java.util.List;

import io.wolfd.city.procedural.road.Road;
import mikera.vectorz.Vector3;

public interface RoadStorage {
  /**
   * Returns all roads contained within the storage
   *
   * @return all roads
   */
  public List<Road> getRoads();

  /**
   * Returns all roads with nodes contained within a radius of the position
   * given, ignoring height (z).
   *
   * @param center the center of the circle
   * @param radius the radius to search within.
   * @return all roads with nodes within a radius of center
   */
  public List<Road> getRoadsWithinRadius(Vector3 center, double radius);

  /**
   * Adds a road to the storage structure.
   *
   * @param road the road to add to the structure.
   */
  public void addRoad(Road road);

  /**
   * Removes a road from the storage structure.
   *
   * @param road the road to remove from the storage
   */
  public void removeRoad(Road road);
}
