package io.wolfd.city.procedural;

import io.wolfd.city.procedural.natural.Environment;

/**
 * City contains the data storage for a procedural, as well as the main method for
 * generating a procedural.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public class City {
  //TODO fill out City class
  public RoadStorage roads;
  public Environment env;
  private CityBuilder cityBuilder;

  /**
   * Constructs a new City
   */
  public City() {
    roads = new RoadStorageImpl();
    cityBuilder = new CityBuilder(this);
  }

  public CityBuilder build() {
    return cityBuilder;
  }
}
