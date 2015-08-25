package io.wolfd.city.procedural.natural;

import io.wolfd.city.procedural.util.SampleMap;
import mikera.vectorz.Vector3;

/**
 * Water is a geometric representation of rivers and lakes.
 *
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 28, 2014
 */
public class Water implements Evolving, SampleMap {
  //TODO Water implementation
  Terrain terrain;

  /* (non-Javadoc)
   * @see com.wolf.procedural.natural.Evolving#iterate()
   */
  public boolean iterate() {
    // TODO Auto-generated method stub
    return false;
  }

  /* (non-Javadoc)
   * @see com.wolf.procedural.natural.Evolving#generation()
   */
  public int generation() {
    // TODO Auto-generated method stub
    return 0;
  }

  public Vector3 gradient(double x, double y) {
    // TODO Auto-generated method stub
    return null;
  }

  public double value(double x, double y) {
    // TODO Auto-generated method stub
    return 0;
  }

}
