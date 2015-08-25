package io.wolfd.city.procedural;

import java.util.LinkedList;

import io.wolfd.city.procedural.road.Road;
import mikera.vectorz.Vector3;

/**
 * Node
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public class Node {
  /**
   * Keeps track of connected roads
   */
  private LinkedList<Road> roads;
  private Vector3 position;

  /**
   * Creates a node
   *
   * @param position
   */
  public Node(Vector3 position) {
    this.position = position;
    roads = new LinkedList<>();
  }

  /**
   * @return the roads
   */
  public LinkedList<Road> getRoads() {
    return roads;
  }

  /**
   * @param roads the roads to set
   */
  public void setRoads(LinkedList<Road> roads) {
    this.roads = roads;
  }

  public void addRoad(Road road) {
    roads.add(road);
  }

  /**
   * @return the position
   */
  public Vector3 getPosition() {
    return position;
  }

  /**
   * @param position the position to set
   */
  public void setPosition(Vector3 position) {
    this.position = position;
  }

  @Override public String toString() {
    return "Node{" +
        "position=" + position +
        '}';
  }
}
