package com.wolf.city.road;

import com.wolf.city.util.Vector3d;

public interface RoadPattern {
    /**
     * Generates the child roads for this pattern
     * 
     * @param parent
     *            the previous road reached for this road to build off of
     * @param generateDirection
     *            the road direction to generate toward
     * @return
     */
    public Vector3d generate(Road parent, Direction generateDirection);

    /**
     * Decides where in the queue to place this road, based upon the pattern's
     * importance. E.g. highways should be important, suburban roads should not
     * be. Importance scaled from (0 to 1]
     * 
     * @return importance from (0 to 1]
     */
    public double queueWeight();

    /**
     * Sets queue weight, where higher values indicate quicker wait on the
     * queue.
     * 
     * @param importance
     *            scale from (0 to 1]
     * @return
     */
    public double setQueueWeight(double importance);

    /**
     * Sets the weight from default value
     * 
     * @param weight
     */
    public void setWeight(double weight);

    /**
     * Weight in range {-1} U (0 to 1] for mixing of patterns. A weight of -1
     * takes all priority, regardless of other weights
     * 
     * @return weight to mix for pattern mixing {-1} U (0 to 1]
     */
    public double getWeight();

    /**
     * Mutate takes the current pattern and modifies certain parameters for the
     * next iteration. E.g. weight could decrease with time. Also, methods can
     * choose to keep the pattern the same, or modify variables specific to that
     * class.
     * 
     * @return the new RoadPattern after changes
     */
    public RoadPattern mutate();

    /**
     * Direction specifies the direction of the generated road
     * 
     * @author Daniel Wolf <wolf@ccs.neu.edu>
     * @version Jan 21, 2014
     */
    enum Direction {
        FORWARD, LEFT, RIGHT;
    }
}
