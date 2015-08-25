package io.wolfd.city.procedural.natural;

import mikera.vectorz.Vector3;

/**
 * Environment contains the natural aspects of a procedural, the water, terrain, and
 * even the procedural population. Water has two representations, terrain below a
 * certain height, and rivers, which are created from the terrain and rainfall.
 * Environment also holds a global position, which is used if there are multiple
 * cities in the world.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Environment {
  public Vector3 center;
  public Terrain t;
  public Population p;

  public Water w;
  private EnvironmentBuilder environmentBuilder;

  public Environment() {
    environmentBuilder = new EnvironmentBuilder();
  }

  //TODO fill out Environment class
}
