package io.wolfd.city.procedural.road;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import mikera.vectorz.Vector3;

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
  private List<RoadPattern> patterns;
  /**
   * Number of patterns to remember before purging
   */
  private static final int MAX_REMEMBERED_PATTERNS = 5;

  public PatternLibrary() {
    patterns = new LinkedList<RoadPattern>();
  }

  /**
   * @return the patterns
   */
  public List<RoadPattern> getPatterns() {
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
   * @param pattern pattern to add
   */
  public PatternLibrary addPattern(RoadPattern pattern) {
    this.patterns.add(pattern);
    sortPatterns();
    cleanPatterns();
    return this;
  }

  public double getPriority() {
    double weight = 0;
    int numberOfPatterns = getPatterns().size();

    if(numberOfPatterns > 0) {
      for (RoadPattern rp : getPatterns()) {
        weight += rp.getQueueImportance().getWeight();
      }

      weight /= numberOfPatterns;
    }

    return weight;
  }

  public Vector3 generate(Road parent,
                          RoadPattern.Direction direction) {
    double total = 0;
    Vector3 averaged = new Vector3(0d, 0d, 0d);
    Vector3[] positions = new Vector3[getPatterns().size()];

    for (int i = 0; i < getPatterns().size(); i++) {
      RoadPattern p = getPatterns().get(i);
      double weight = p.getMixingImportance().getWeight();

      total += weight;
      positions[i] = p.generate(parent, direction);
      averaged.add(positions[i].multiplyCopy(weight));
    }
    averaged.multiply(1d / total);
    return averaged;
  }

  /**
   * Uses the weight of the patterns to decide the order of the sort. Converts
   * double to int for Comparator.
   */
  private PatternLibrary sortPatterns() {
    Collections.sort(this.patterns, new Comparator<RoadPattern>() {
      public int compare(RoadPattern o1, RoadPattern o2) {
        // Convert double to int approximately by multiplying by 255^2
        return (int) (255d * 255d * (o1.getMixingImportance().getWeight() - o2.getMixingImportance().getWeight()));
      }
    });
    return this;
  }

  /**
   * Recursively remove the least prominent patterns
   */
  private PatternLibrary cleanPatterns() {
    if (this.patterns.size() > MAX_REMEMBERED_PATTERNS) {
      this.patterns.remove(0);
      cleanPatterns();
    }
    return this;
  }

  public PatternLibrary mutate() {
    PatternLibrary newLibrary = new PatternLibrary();
    for (RoadPattern pattern : patterns) {
      newLibrary.addPattern(pattern.mutate());
    }
    return newLibrary;
  }
}
