package io.wolfd.city.procedural.road;

import mikera.matrixx.Matrix33;
import mikera.matrixx.Matrixx;
import mikera.vectorz.Vector3;

public class RoadRectangle {
  private final static Matrix33 turnLeft = Matrixx.createZAxisRotationMatrix(-Math.PI / 2);
  private final static Matrix33 turnRight = Matrixx.createZAxisRotationMatrix(Math.PI/2);

  private final Vector3 al;
  private final Vector3 ar;
  private final Vector3 bl;
  private final Vector3 br;

  public RoadRectangle(Vector3 a, Vector3 b, double width) {
    double halfWidth = width / 2;

    Vector3 direction = b.copy();
    direction.sub(a);
    direction.normalise();

    al = turnLeft.transform(direction);
    ar = turnRight.transform(direction);

    al.multiply(halfWidth);
    ar.multiply(halfWidth);

    bl = al.addCopy(b);
    br = ar.addCopy(b);
    al.add(a);
    ar.add(a);
  }

  public RoadRectangle(Vector3 al, Vector3 ar,
                       Vector3 bl, Vector3 br) {
    this.al = al;
    this.ar = ar;
    this.bl = bl;
    this.br = br;
  }

  public Vector3 getAl() {
    return al;
  }

  public Vector3 getAr() {
    return ar;
  }

  public Vector3 getBl() {
    return bl;
  }

  public Vector3 getBr() {
    return br;
  }
}
