/**
 * 
 */
package com.wolf.city.natural;

import com.wolf.city.util.FBM;
import com.wolf.city.util.SampleMap;
import com.wolf.city.util.Vector3d;

/**
 * Terrain holds data about the height of the terrain at a given position.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Terrain implements SampleMap {
    private static final int octaves = 6;
    private FBM sample;

    /**
     * Constructs a Terrain object with a random position
     */
    public Terrain(long seed) {
        sample = new FBM(octaves, seed);
    }

    @Override
    public Vector3d gradient(double x, double y) {
        return sample.gradient(x, y);
    }

    @Override
    public double value(double x, double y) {
        return sample.value(x, y);
    }

}
