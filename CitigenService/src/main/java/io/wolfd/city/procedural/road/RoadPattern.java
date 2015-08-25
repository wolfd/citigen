package io.wolfd.city.procedural.road;

import mikera.vectorz.Vector3;

public interface RoadPattern {
  /**
   * Generates the child roads for this pattern
   *
   * @param parent            the previous road reached for this road to build off of
   * @param generateDirection the road direction to generate toward
   * @return proposed location of the end of the new road
   */
  Vector3 generate(Road parent, Direction generateDirection);

  /**
   * Decides where in the queue to place this road, based upon the pattern's
   * importance. E.g. highways should be important, suburban roads should not
   * be. Importance scaled from [0 to 1]
   *
   * @return importance from [0 to 1]
   */
  Importance getQueueImportance();

  /**
   * Weight in range {-1} U [0 to 1] for mixing of patterns. A weight of -1
   * takes all priority, regardless of other weights
   *
   * @return weight to mix for pattern mixing {-1} U [0 to 1]
   */
  Importance getMixingImportance();

  /**
   * mutate takes the RoadPattern and modifies certain parameters for the
   * next iteration. E.g. weight could decrease with time. Also, methods can
   * choose to keep the pattern the same, or modify variables specific to that
   * class.
   *
   * @return the new RoadPattern after changes
   */
  RoadPattern mutate();

  /**
   * Direction specifies the direction of the generated road
   *
   * @author Daniel Wolf <wolf@ccs.neu.edu>
   * @version Jan 21, 2014
   */
  enum Direction {
    FORWARD, LEFT, RIGHT
  }
}
