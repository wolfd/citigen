/**
 * 
 */
package com.wolf.city.util;

/**
 * Vector3f keeps track of 3D coordinates and other vector data.
 * 
 * @author Daniel Wolf <wolf@ccs.neu.edu>
 * @version Jan 21, 2014
 */
public class Vector3d {
    public double x;
    public double y;
    public double z;
    
    public Vector3d(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    public Vector3d(Vector3d v){
        this.x = v.x;
        this.y = v.y;
        this.z = v.z;
    }

    public String toString() {
        // TODO toString for Vector3d
        return "";
    }

    public int hashCode() {
        // TODO hashCode for Vector3d
        return 0;
    }

    /**
     * Computes the angle between two vectors in radians
     * @param a the starting vector
     * @param b the ending vector
     * @return the angle in radians
     */
    public static double angleBetween(Vector3d a, Vector3d b) {
        return Math.atan2(a.x - b.x, a.y - b.y);
    }
    
    public Vector3d multiply(double scale){
        return new Vector3d(x * scale, y * scale, z * scale);
    }
    
    public Vector3d add(Vector3d v){
        return new Vector3d(x + v.x, y + v.y, z + v.z);
    }
}
