package io.wolfd.city.procedural;

public class TestMain {
  /**
   * Constructs and generates a procedural city
   *
   * @param args
   */
  public static void main(String[] args) {
    CityBuilder cb = new City()
        .build()
        .seedCityAtCenter()
        .generate();
  }
}
