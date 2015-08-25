package io.wolfd.city.procedural.road;

import java.util.Random;

public class Importance {
  private static final double JITTER_DISTANCE = 0.03;
  private final double weight;

  public Importance(double weight) {
    this.weight = weight;
  }

  /**
   * Decides where in the queue to place this road, based upon the pattern's
   * importance. E.g. highways should be important, suburban roads should not
   * be. Importance scaled from [0 to 1]
   *
   * @return importance from [0 to 1]
   */

  public double getWeight() {
    return weight;
  }

  /**
   * Sets queue weight, where higher values indicate quicker wait on the
   * queue.
   *
   * @param weight scale from [0 to 1]
   * @return new object
   */
  public Importance setWeight(double weight) {
    return new Importance(Math.max(Math.min(1, weight), 0));
  }

  public Importance mutate(Random random) {
    return setWeight(getWeight() + (random.nextDouble() - 0.5) * JITTER_DISTANCE);
  }
}
