package io.wolfd.city.procedural.natural;

import io.wolfd.city.procedural.util.FBM;
import io.wolfd.city.procedural.util.SampleMap;
import mikera.vectorz.Vector3;

/**
 * Terrain holds data about the height of the terrain at a given position.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Terrain implements SampleMap {
  private static final int octaves = 6;
  private FBM sample;

  /**
   * Constructs a Terrain object with a random position
   */
  public Terrain(long seed) {
    sample = new FBM(octaves, seed);
  }

  public Vector3 gradient(double x, double y) {
    return sample.gradient(x, y);
  }

  public double value(double x, double y) {
    return sample.value(x, y);
  }
}
