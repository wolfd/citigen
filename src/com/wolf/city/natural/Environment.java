package com.wolf.city.natural;

import com.wolf.city.util.Vector3d;

/**
 * Environment contains the natural aspects of a city, the water, terrain, and
 * even the city population. Water has two representations, terrain below a
 * certain height, and rivers, which are created from the terrain and rainfall.
 * Environment also holds a global position, which is used if there are multiple
 * cities in the world.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Environment {
    public Vector3d center;
    public Terrain t;
    public Population p;
    
    public Water w;
    private EnvironmentBuilder environmentBuilder;
    
    public Environment(){
        environmentBuilder = new EnvironmentBuilder();
    }
    
    //TODO
}
