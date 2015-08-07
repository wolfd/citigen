/**
 *
 */
package io.wolfd.city.procedural.road;

/**
 * RoadFilter is an interface for processing candidate roads
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public interface RoadFilter {
  /**
   * Filters this road to a "reasonable" location and removes it if necessary.
   *
   * @return a filtered road
   */
  public Road filter(Road road);

  /**
   * If the RoadFilter implements it, this allows the filter to change with
   * every iteration.
   *
   * @return a new RoadFilter or the same object, depending on the
   * implementation.
   */
  public RoadFilter mutate();
}
