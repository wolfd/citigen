package io.wolfd.city.procedural.road;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import io.wolfd.city.procedural.util.Vector3d;

/**
 * PatternLibrary contains all methods related to the adding, mutating, purging,
 * and mixing of patterns.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public class PatternLibrary {
  /**
   * List of RoadPatterns to store the patterns
   */
  private LinkedList<RoadPattern> patterns;
  /**
   * Number of patterns to remember before purging
   */
  private static final int MAX_REMEMBERED_PATTERNS = 5;

  /**
   * @return the patterns
   */
  public LinkedList<RoadPattern> getPatterns() {
    return patterns;
  }

  /**
   * @param patterns the patterns to set
   */
  public void setPatterns(LinkedList<RoadPattern> patterns) {
    this.patterns = patterns;
    sortPatterns();
  }

  /**
   * Adds a pattern to the library and purges least important ones
   *
   * @param pattern
   */
  public void addPattern(RoadPattern pattern) {
    this.patterns.add(pattern);
    sortPatterns();
    cleanPatterns();
  }

  public Vector3d generate(Road parent,
                           RoadPattern.Direction direction) {
    double total = 0;
    Vector3d averaged = new Vector3d(0d, 0d, 0d);
    Vector3d[] positions = new Vector3d[getPatterns().size()];

    for (int i = 0; i < getPatterns().size(); i++) {
      RoadPattern p = getPatterns().get(i);
      double weight = p.getWeight();

      total += weight;
      positions[i] = p.generate(parent, direction);

    }
    for (int i = 0; i < getPatterns().size(); i++) {
      averaged = averaged.add(positions[i]);
    }
    return averaged.multiply(1 / total);
  }

  /**
   * Uses the weight of the patterns to decide the order of the sort. Converts
   * double to int for Comparator.
   */
  private void sortPatterns() {
    Collections.sort(this.patterns, new Comparator<RoadPattern>() {
      public int compare(RoadPattern o1, RoadPattern o2) {
        // Convert double to int approximately by multiplying by 255^2
        return (int) (255d * 255d * (o1.getWeight() - o2.getWeight()));
      }
    });
  }

  /**
   * Recursively remove the least prominent patterns
   */
  private void cleanPatterns() {
    if (this.patterns.size() > MAX_REMEMBERED_PATTERNS) {
      this.patterns.remove(0);
      cleanPatterns();
    }
  }

  public PatternLibrary mutate() {
    PatternLibrary newLibrary = new PatternLibrary();
    for (int i = 0; i < patterns.size(); i++) {
      newLibrary.addPattern(patterns.get(i).mutate());
    }
    return newLibrary;
  }

}
