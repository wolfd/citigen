/**
 * 
 */
package com.wolf.city;

import com.wolf.city.road.Road;
import com.wolf.city.util.PriorityQueue;

/**
 * CityBuilder directs the generation of cities, holding the unfinished data, 
 * and pushing data into the City object when done. CityBuilder also constructs
 * the city pattern to start with.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class CityBuilder {
    //TODO fill out CityBuilder class
    PriorityQueue<Road> q;
    City parent;
    
    /**
     * Constructs a CityBuilder object, and calls methods to begin a city's
     * development.
     */
    public CityBuilder() {
        
    }
    
    /**
     * 
     */
    private void seedCityAtCenter(){
        
    }
    
    private void seedCityFromEdges(){
        
    }

}
