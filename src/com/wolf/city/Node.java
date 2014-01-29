package com.wolf.city;

import java.util.LinkedList;

import com.wolf.city.road.Road;
import com.wolf.city.util.Vector3d;

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
    private Vector3d position;

    /**
     * Creates a node
     * 
     * @param position
     */
    public Node(Vector3d position) {
        this.position = position;
        roads = new LinkedList<Road>();
    }

    /**
     * @return the roads
     */
    public LinkedList<Road> getRoads() {
        return roads;
    }

    /**
     * @param roads
     *            the roads to set
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
    public Vector3d getPosition() {
        return position;
    }

    /**
     * @param position
     *            the position to set
     */
    public void setPosition(Vector3d position) {
        this.position = position;
    }

    public String toString() {
        // TODO toString for Nodes
        return "";
    }

    public int hashCode() {
        // TODO hashCode for Nodes
        return 0;
    }
}
