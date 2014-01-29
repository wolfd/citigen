package com.wolf.city.natural;

import com.wolf.city.util.SampleMap;
import com.wolf.city.util.Vector3d;

/**
 * Water is a geometric representation of rivers and lakes.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Water implements Evolving, SampleMap{
    //TODO Water implementation
    Terrain terrain;
    

    /* (non-Javadoc)
     * @see com.wolf.city.natural.Evolving#iterate()
     */
    @Override
    public boolean iterate() {
        // TODO Auto-generated method stub
        return false;
    }

    /* (non-Javadoc)
     * @see com.wolf.city.natural.Evolving#generation()
     */
    @Override
    public int generation() {
        // TODO Auto-generated method stub
        return 0;
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
