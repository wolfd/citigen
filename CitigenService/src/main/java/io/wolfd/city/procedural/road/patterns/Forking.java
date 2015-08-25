package io.wolfd.city.procedural.road.patterns;

import java.util.Random;

import io.wolfd.city.procedural.road.Importance;
import io.wolfd.city.procedural.road.Road;
import io.wolfd.city.procedural.road.RoadPattern;
import mikera.matrixx.Matrix33;
import mikera.matrixx.Matrixx;
import mikera.vectorz.Vector3;

public class Forking extends AbstractRoadPattern {
  private static final double ROAD_LENGTH = 15;
  private static final double MUTATION_DEVIATION = 0.5;

  private double left = 3;
  private double right = 3;

  private Matrix33 turnLeft;
  private Matrix33 turnRight;

  public Forking(Random random, Importance mixingImportance, Importance queueImportance, double left, double right) {
    super(random, mixingImportance, queueImportance);
    turnLeft = Matrixx.createZAxisRotationMatrix(-Math.PI / left);
    turnRight = Matrixx.createZAxisRotationMatrix(Math.PI / right);
    this.left = left;
    this.right = right;
  }

  /**
   * Generates the child roads for this pattern
   *
   * @param parent            the previous road reached for this road to build off of
   * @param generateDirection the road direction to generate toward
   * @return
   */
  public Vector3 generate(Road parent, Direction generateDirection) {
    Vector3 direction = parent.b.getPosition().copy();
    direction.sub(parent.a.getPosition());
    direction.normalise();

    Vector3 next = new Vector3(0, 0, 0);
    switch (generateDirection) {
      case FORWARD:
        next = direction.multiplyCopy(ROAD_LENGTH);
        break;
      case LEFT:
        next = turnLeft.transform(direction);
        next.multiply(ROAD_LENGTH);
        break;
      case RIGHT:
        next = turnRight.transform(direction);
        next.multiply(ROAD_LENGTH);
        break;
    }

    next.add(parent.b.getPosition());

    return next;
  }

  /**
   * mutate takes the RoadPattern and modifies certain parameters for the
   * next iteration. E.g. weight could decrease with time. Also, methods can
   * choose to keep the pattern the same, or modify variables specific to that
   * class.
   *
   * @return the new RoadPattern after changes
   */
  public RoadPattern mutate() {
    return new Forking(
        getRandom(),
        this.getMixingImportance().mutate(getRandom()),
        this.getQueueImportance().mutate(getRandom()),
        Math.max(Math.min(((getRandom().nextDouble() - 0.5) * MUTATION_DEVIATION) + left, 5), 2),
        Math.max(Math.min(((getRandom().nextDouble() - 0.5) * MUTATION_DEVIATION) + right, 5), 2)
    );
  }
}
