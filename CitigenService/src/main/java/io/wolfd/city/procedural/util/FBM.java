package io.wolfd.city.procedural.util;

import java.util.Random;

import mikera.vectorz.Vector3;

/**
 * FBM is a basic fractional brownian motion implementation using Simplex noise.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class FBM implements SampleMap {
  /**
   * for calculating gradient, sample distance from point
   */
  private static final double gradDelta = .1d;

  /**
   * Simplex noise map to sample
   */
  private final OpenSimplexNoise simplexNoise;
  /**
   * scales down all layers by value
   */
  private double delta = 16;
  /**
   * number of raw Perlin noise samples
   */
  public int octaves;
  /**
   * An array of z-value offsets for each octave (layer) of noise
   */
  private double[] offset;
  /**
   * A cosine table for rotating the noise layers
   */
  private double[] cos;
  /**
   * A sine table for rotating the noise layers
   */
  private double[] sin;
  /**
   * An array of doubles that determine how prominent each octave is
   */
  private double[] amplitude;
  /**
   * An array of doubles that scale of each octave
   */
  private double[] frequency;

  /**
   * Constructs a FBM with a specified number of octaves and a random number
   * generator seed.
   *
   * @param octaves number of layers of Simplex noise to combine, larger values
   *                take longer but are more detailed
   * @param seed    the random number generator's seed
   */
  public FBM(int octaves, long seed) {
    this(octaves, seed, .5);
  }

  /**
   * @param octaves     number of noise layers to combine
   * @param seed        is the random number generator's seed
   * @param persistence .5 is a good value for persistence. Watch out for very high
   *                    octaves too.
   */
  public FBM(int octaves, long seed, double persistence) {
    this.octaves = octaves;
    // create the random number generator and seed it
    Random r = new Random(seed);
    // initialize the offset array
    offset = new double[octaves];
    // initialize the rotation table
    cos = new double[octaves];
    sin = new double[octaves];
    // initialize the amplitude array
    amplitude = new double[octaves];
    // initialize the frequency array
    frequency = new double[octaves];

    simplexNoise = new OpenSimplexNoise(seed);

    // loop through each octave and set the array values accordingly
    for (int i = 0; i < octaves; i++) {
      // create a rotation value for this layer/octave
      double angle = r.nextDouble() * 2d * Math.PI;
      // set the octave's rotation table values
      cos[i] = Math.cos(angle);
      sin[i] = Math.sin(angle);

      // set the offset value somewhere between [0 and 256)
      offset[i] = r.nextDouble() * 256d;

      // set the frequency accordingly, using the equation 2^i
      frequency[i] = Math.pow(2, i);

      // set the amplitude accordingly, using the equation persistence^i
      amplitude[i] = Math.pow(persistence, i);
    }

  }

  /**
   * sample the FBM noise for a 2D value
   *
   * @param x coordinate to sample
   * @param y coordinate to sample
   * @return a value approximately between 0 and 1, but not necessarily in
   * that range
   */
  public double noise(double x, double y) {
    double total = 0;
    // for every octave
    for (int i = 0; i < this.octaves; i++) {
      // rotate the noise using the rotation table
      double xV = x * cos[i] + y * -sin[i]; // rotated value of x
      double yV = x * sin[i] + y * cos[i]; // rotated value of y
      // samples the current octave at a rotated and scaled point
      double val =
          (simplexNoise.eval(xV * frequency[i] / delta, yV
              * frequency[i] / delta, offset[i]));
      // amplitude decreases with every octave
      val = (val * amplitude[i]);
      // sums the value of the noise onto the total
      total += val;
    }

    // tries to return a value between 0 and 1
    return (total + 1) / 2;
  }

  /*
   * (non-Javadoc)
   * @see com.wolf.procedural.util.SampleMap#gradient(double, double)
   */
  public Vector3 gradient(double x, double y) {
    double dx =
        (value(x - gradDelta, y) - value(x + gradDelta, y))
            / (2d * gradDelta);
    double dy =
        (value(x, y - gradDelta) - value(x, y + gradDelta))
            / (2d * gradDelta);
    return new Vector3(dx, dy, 0);
  }

  /*
   * (non-Javadoc)
   * @see com.wolf.procedural.util.SampleMap#value(double, double)
   */
  public double value(double x, double y) {
    return noise(x, y);
  }

}
