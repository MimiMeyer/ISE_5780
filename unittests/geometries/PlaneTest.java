//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
public class PlaneTest extends Object {
    /**
     * Test method for plane getNormal(Point3D point)
     */
    @Test
    public void getNormal() {
        Plane p=new Plane(new Point3D(2.0,0.0,2.0),new Vector(0.0,1.0,0.0));
        assertEquals(p.getNormal(new Point3D(8.0,0.0,4.0)),new Vector(new Point3D(0.0,1.0,0.0)));
        assertEquals(p.getNormal(new Point3D(90.0,0.0,7.0)),new Vector(new Point3D(0.0,1.0,0.0)));
    }
    @Test
    void findIntersections(){
        Plane p=new Plane( new Point3D(0.0,2.0,2.0),new Vector(1.0,0.0,0.0));

        // ============ Equivalence Partitions Tests ==============

        //part 1- the ray intersects the plane:
        Ray r=new Ray(new Point3D(6.0,4.0,3.0), new Vector(-1.0,1.0,1.0));
        List<Point3D> l=p.findIntersections(r);
        List<Point3D> expectList=new ArrayList<Point3D>();
        expectList.add(new Point3D(0.0,10.0,9.0));
        assertEquals(expectList,l);

        //part 2- the ray does not intersect the plane:
        r=new Ray(new Point3D(4.0,2.0,1.0),new Vector(5.0,-2.0,2.0));
        l=p.findIntersections(r);
        assertEquals(null,l);

        // =============== Boundary Values Tests ==================

        //case 1: ray is not included in plane:
        r=new Ray(new Point3D(4.0,-1.0,1.0),new Vector(0.0,2.0,0.0));
        l=p.findIntersections(r);
        assertEquals(null,l);

        //case 2: ray is included in plane:
        r=new Ray(new Point3D(0.0,-1.0,1.0),new Vector(0.0,2.0,0.0));
        l=p.findIntersections(r);
        assertEquals(null,l);

        //Ray is neither orthogonal nor parallel to the plane and begins in
        //the same point which appears as reference point in the plane:
        r=new Ray(new Point3D(0.0,2.0,2.0),new Vector(5.0,3.0,1.0));
        l=p.findIntersections(r);
        assertEquals(null,l);
    }
}