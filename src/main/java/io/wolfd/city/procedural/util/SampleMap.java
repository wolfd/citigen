package io.wolfd.city.procedural.util;

/**
 * SampleMap is an interface for 2D noise and 2D images for returning values
 * from arbitrary points
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public interface SampleMap {
  /**
   * Finds the gradient of the map.
   *
   * @param x position to sample
   * @param y position to sample
   * @return the gradient vector at the sample point
   */
  public Vector3d gradient(double x, double y);

  /**
   * Gets the value of the map at a position. Should, but does not need to be
   * (0 to 1].
   *
   * @param x position to sample
   * @param y position to sample
   * @return the value of the map
   */
  public double value(double x, double y);
}
