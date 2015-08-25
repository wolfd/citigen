package io.wolfd.city.procedural.road.patterns;

import java.util.Random;

import io.wolfd.city.procedural.road.Importance;
import io.wolfd.city.procedural.road.RoadPattern;

public abstract class AbstractRoadPattern implements RoadPattern {
  private final Random random;
  private final Importance mixingImportance;
  private final Importance queueImportance;

  public AbstractRoadPattern(Random random, Importance mixingImportance, Importance queueImportance) {
    this.random = random;
    this.mixingImportance = mixingImportance;
    this.queueImportance = queueImportance;
  }

  Random getRandom() {
    return random;
  }

  public Importance getMixingImportance() {
    return mixingImportance;
  }

  public Importance getQueueImportance() {
    return queueImportance;
  }
}
