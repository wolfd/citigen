package com.wolf.city.util;

import java.util.ArrayList;

/**
 * BasicQueue is a double sided queue with insertion that determines a position
 * based on item importance.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 27, 2014
 * @param <T>
 *            the type that the queue uses
 */
public class PriorityQueue<T> implements Queue<T> {
    private ArrayList<T> list;

    /**
     * Creates a new BasicQueue
     */
    public PriorityQueue() {
        list = new ArrayList<T>();
    }

    /*
     * (non-Javadoc)
     * @see com.wolf.city.util.Queue#getTop()
     */
    @Override
    public T getTop() {
        return list.remove(0);
    }

    /*
     * (non-Javadoc)
     * @see com.wolf.city.util.Queue#getBottom()
     */
    @Override
    public T getBottom() {
        return list.remove(list.size() - 1);
    }

    /* (non-Javadoc)
     * @see com.wolf.city.util.Queue#insert(java.lang.Object, double)
     */
    public void insert(T item, double importance) {
        int position =
                (int) Math.min(importance * list.size() + 1, list.size());
        list.add(position, item);
    }

    /*
     * (non-Javadoc)
     * @see com.wolf.city.util.Queue#remove(java.lang.Object)
     */
    @Override
    public void remove(T item) {
        list.remove(item);
    }

}
