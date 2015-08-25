package io.wolfd.city.procedural.road.filters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.ArrayUtils;

import io.wolfd.city.procedural.City;
import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.road.RoadFilter;
import io.wolfd.city.procedural.road.RoadRectangle;
import mikera.vectorz.Vector2;
import mikera.vectorz.Vector3;

public class Overlapping implements RoadFilter {
  private final City city;

  public Overlapping(City city) {

    this.city = city;
  }

  /**
   * Filters this road to a "reasonable" location and removes it if necessary.
   *
   * @param road
   * @return a filtered road
   */
  @Override public Road filter(Road road) {
    final List<Road> roadsWithinRadius = city.roads.getRoadsWithinRadius(
        road.a.getPosition(),
        road.a.getPosition().distance(road.b.getPosition())
    );

    List<Road> intersectingRoads = roadsWithinRadius
        .parallelStream()
        .filter((r) -> this.roadIntersects(road, r))
        .collect(Collectors.toList());

    intersectingRoads = intersectingRoads
        .stream()
        .filter((r) -> !road.a.equals(r.b) && !road.a.equals(r.a))
        .collect(Collectors.toList());
    if (intersectingRoads.size() > 1) {
      road.failed = true;
    }
    return road;
  }

  private boolean roadIntersects(Road a, Road b) {
    RoadRectangle rra = a.getRoadRectangle();
    RoadRectangle rrb = b.getRoadRectangle();

    List<Vector2> axises = new ArrayList<>(4);

    Vector3 axis1 = Vector3.create(rra.getAr().subCopy(rra.getAl()));
    Vector3 axis2 = Vector3.create(rra.getAr().subCopy(rra.getBr()));
    Vector3 axis3 = Vector3.create(rrb.getAl().subCopy(rrb.getBl()));
    Vector3 axis4 = Vector3.create(rrb.getAl().subCopy(rrb.getBl()));
    axises.add(Vector2.of(axis1.getX(), axis1.getY()));
    axises.add(Vector2.of(axis2.getX(), axis2.getY()));
    axises.add(Vector2.of(axis3.getX(), axis3.getY()));
    axises.add(Vector2.of(axis4.getX(), axis4.getY()));

    boolean intersects = true;
    for (Vector2 axis : axises) {

      final List<Double> doublesA = Arrays.asList(ArrayUtils.toObject(getAxisPositions(axis, rra)));
      final List<Double> doublesB = Arrays.asList(ArrayUtils.toObject(getAxisPositions(axis, rrb)));
      final double maxA = Collections.max(doublesA);
      final double maxB = Collections.max(doublesB);
      final double minA = Collections.min(doublesA);
      final double minB = Collections.min(doublesB);
      if (!(minB <= maxA && maxB >= minA)) {
        intersects = false;
        break;
      }
    }
    return intersects;
  }

  private double[] getAxisPositions(Vector2 axis, RoadRectangle rr) {
    double[] positions = new double[6];
    int index = 0;
    for (Vector3 v3 : new Vector3[] {rr.getAl(), rr.getAr(), rr.getBl(), rr.getBr()}) {
      final Vector2 v = Vector2.of(v3.getX(), v3.getY());
      // project corners onto axis
      final Vector2 projection = Vector2.create(axis.multiplyCopy(v.dotProduct(axis) / Math.pow(axis.length(), 2)));
      // get "position" of projected corners with respect to the axis
      final double position = projection.dotProduct(axis);

      positions[index] = position;
      index++;
    }
    return positions;
  }

  /**
   * If the RoadFilter implements it, this allows the filter to change with
   * every iteration.
   *
   * @return a new RoadFilter or the same object, depending on the
   * implementation.
   */
  @Override public RoadFilter mutate() {
    return this;
  }
}
