package io.wolfd.city.procedural;

import java.util.ArrayList;

import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.util.Vector3d;

/**
 * RoadGraph contains the graph representation of the procedural's roads.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public class RoadGraph implements RoadStorage {

  public RoadGraph() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public ArrayList<Road> getRoads() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ArrayList<Road> getRoadsWithinRadius(Vector3d center, double radius) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void addRoad(Road road) {
    // TODO Auto-generated method stub

  }

  @Override
  public void removeRoad(Road road) {
    // TODO Auto-generated method stub

  }

  public String toString() {
    //TODO toString for RoadGraph
    return "";
  }

  public int hashCode() {
    //TODO hashCode for RoadGraph
    return 0;
  }
}