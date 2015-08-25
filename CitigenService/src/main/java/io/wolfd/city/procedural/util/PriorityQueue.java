package io.wolfd.city.procedural.util;

import java.util.ArrayList;

/**
 * BasicQueue is a double sided queue with insertion that determines a position
 * based on item importance.
 *
 * @param <T> the type that the queue uses
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 27, 2014
 */
public class PriorityQueue<T extends HasPriority> implements Queue<T> {
  private ArrayList<T> list;

  /**
   * Creates a new BasicQueue
   */
  public PriorityQueue() {
    list = new ArrayList<T>();
  }

  /*
   * (non-Javadoc)
   * @see com.wolf.procedural.util.Queue#getTop()
   */
  public T getTop() {
    return list.remove(0);
  }

  /*
   * (non-Javadoc)
   * @see com.wolf.procedural.util.Queue#getBottom()
   */
  public T getBottom() {
    return list.remove(list.size() - 1);
  }

  /* (non-Javadoc)
   * @see com.wolf.procedural.util.Queue#insert(java.lang.Object, double)
   */
  public void insert(T item) {
    int position =
        (int) Math.min(item.getPriority() * list.size() + 1, list.size());
    list.add(position, item);
  }

  /*
   * (non-Javadoc)
   * @see com.wolf.procedural.util.Queue#remove(java.lang.Object)
   */
  public void remove(T item) {
    list.remove(item);
  }

  public boolean isEmpty() {
    return list.isEmpty();
  }
}
