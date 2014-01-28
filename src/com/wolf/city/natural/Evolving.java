/**
 * 
 */
package com.wolf.city.natural;

/**
 * Evolving is an interface for natural types that evolve over time.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public interface Evolving {
    /**
     * iterate evolves the natural type one time.
     * @return true if the type has finished evolving
     */
    public boolean iterate();
    /**
     * Return the current generation number from 0 to x.
     * @return the current generation number
     */
    public int generation();
}
