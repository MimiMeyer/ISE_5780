//Mimi Meyer 317924835
// Odelia Sfez 342472966
package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Point3DTest extends Object {
    /**
     * Test method for point3d testsubtract()
     */
    @Test
    void testsubtract() {
       Point3D p=new Point3D(1.0,2.0,3.0);
       Point3D p1=new Point3D(-1.0,-2.0,3.0);
       Vector v=p.subtract(p1);

       assertEquals(new Vector(2.0,4.0,0.0),v);

    }
    /**
     * Test method for point3d testadd()
     */
    @Test
    void testadd() {
        Point3D p=new Point3D(1.0,2.0,3.0);
        Vector v = new Vector(2.0,-4.0,0.0);
        Point3D p1=p.add(v);

        assertEquals(new Point3D(3.0,-2.0,3.0),p1);
    }
    /**
     * Test method for point3d testsdistanceSquare()
     */
    @Test
    void testdistanceSquared() {
        Point3D p=new Point3D(1.0,2.0,3.0);
        Point3D p1=new Point3D(-3.0,-1.0,3.0);
        double x1=p.distanceSquared(p1);
        // ============ Equivalence Partitions Tests ==============
        assertEquals(25.00,x1);

    }
    /**
     * Test method for point3d testsdistance()
     */
    @Test
    void testdistance() {
        Point3D p=new Point3D(1.0,2.0,3.0);
        Point3D p1=new Point3D(-3.0,-1.0,3.0);
        double x1=p.distance(p1);
        assertEquals(5.00,x1);
    }
}