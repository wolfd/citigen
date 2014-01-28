/**
 * 
 */
package com.wolf.city.natural;

import com.wolf.city.util.SampleMap;
import com.wolf.city.util.Vector3d;

/**
 * Terrain holds data about the height of the terrain at a given position.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Terrain implements SampleMap {
    //TODO
    /**
     * Constructs a Terrain object with a random position
     */
    public Terrain() {
        // TODO Auto-generated constructor stub
    }
    
    /**
     * Constructs a Terrain object centered at a position
     * @param position
     */
    public Terrain(Vector3d position, long seed){
        
    }

    @Override
    public Vector3d gradient(double x, double y) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public double value(double x, double y) {
        // TODO Auto-generated method stub
        return 0;
    }

}
