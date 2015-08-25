package io.wolfd.city.procedural;

import java.util.List;
import java.util.Random;

import io.wolfd.city.procedural.road.FilterLibrary;
import io.wolfd.city.procedural.road.Importance;
import io.wolfd.city.procedural.road.PatternLibrary;
import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.road.RoadPattern;
import io.wolfd.city.procedural.road.patterns.Forking;
import io.wolfd.city.procedural.road.patterns.Manhattan;
import io.wolfd.city.procedural.util.PriorityQueue;
import mikera.vectorz.Vector3;

/**
 * CityBuilder directs the generation of cities, holding the unfinished data,
 * and pushing data into the City object when done. CityBuilder also constructs
 * the procedural pattern to start with.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class CityBuilder {
  //TODO fill out CityBuilder class
  PriorityQueue<Road> q;
  City parent;

  /**
   * Constructs a CityBuilder object, and calls methods to begin procedural
   * development.
   */
  public CityBuilder(City parent) {
    q = new PriorityQueue<>();
    this.parent = parent;
  }

  public CityBuilder seedCityAtCenter() {
    Road seedRoad = Road.seed(
        new Vector3(0, 0, 0),
        0,
        new PatternLibrary()
            .addPattern(
                new Manhattan(
                    new Random(System.currentTimeMillis()),
                    new Importance(0.9),
                    new Importance(0.9)
                )
            )
            .addPattern(
                new Forking(
                    new Random(System.currentTimeMillis()),
                    new Importance(0.0),
                    new Importance(0.5),
                    3,
                    3
                )
            ),
        new FilterLibrary(parent)
    );
    parent.roads.addRoad(seedRoad);
    q.insert(Road.create(seedRoad, RoadPattern.Direction.LEFT));
    return this;
  }

  public CityBuilder seedCityFromEdges() {
    return this;
  }

  public CityBuilder generate() {
    while (processRoad()) {
    }
    return this;
  }

  private boolean processRoad() {
    if (q.isEmpty() || parent.roads.getRoads().size() > 1000) {
      return false;
    }
    Road r = q.getTop();
    r = r.filter();
    if (r.failed) {
      r.remove();
    } else {
      parent.roads.addRoad(r);
      q.insert(Road.create(r, RoadPattern.Direction.LEFT));
      q.insert(Road.create(r, RoadPattern.Direction.FORWARD));
      q.insert(Road.create(r, RoadPattern.Direction.RIGHT));
    }

    return true;
  }
}
