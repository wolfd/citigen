package io.wolfd.city.procedural.util;

public interface HasPriority {
  /**
   * the weight of the item in the queue {-1} U [0 to 1]. 0 being
   * least important, and 1 being most important. -1 meaning
   * automatic placement on the top of the queue.
   * @return priority
   */
  double getPriority();
}
