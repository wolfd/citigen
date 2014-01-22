package com.wolf.city;

import com.wolf.city.util.Vector3d;

/**
 * SampleMap is an interface for 2D noise and 2D images for returning values
 * from arbitrary points
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public interface SampleMap {
    /**
     * Finds the gradient of the map.
     * 
     * @param position
     *            the position to find gradient of
     * @return the gradient vector
     */
    public Vector3d gradient(Vector3d position);

    /**
     * Gets the value of the map at a position. Should, but does not need to be
     * (0 to 1].
     * 
     * @param position
     *            to sample
     * @return the value of the map
     */
    public double value(Vector3d position);
}
