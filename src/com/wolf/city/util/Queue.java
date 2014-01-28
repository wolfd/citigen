/**
 * 
 */
package com.wolf.city.util;

/**
 * Queue is an abstract class representing a queue with the ability to insert
 * items based upon a importance weight.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public interface Queue<T> {

    /**
     * Gets the top of the queue (most important). Removes item from queue.
     * 
     * @return the top of the queue
     */
    public T getTop();

    /**
     * Gets the bottom of the queue (least important) Removes item from queue.
     * 
     * @return the bottom of the queue
     */
    public T getBottom();

    /**
     * Insert item into the queue, position defined by its importance.
     * 
     * @param item
     *            object being inserted into the queue
     * @param importance
     *            the weight of the item in the queue {-1} U (0 to 1]. 0 being
     *            least important, and 1 being most important. -1 meaning
     *            automatic placement on the top of the queue.
     */
    public void insert(T item, double importance);

    /**
     * Removes an item from the queue.
     * @param item to remove from the queue
     */
    public void remove(T item);
}
