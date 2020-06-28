//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;

import org.junit.jupiter.api.Test;
import primitives.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TriangleTest extends Object {

    @Test
    void getNormal() {
        Triangle t=new Triangle(new Point3D(0.0,2.0,0.0),new Point3D(0.0,0.0,2.0),new Point3D(0.0,-2.0,0.0));

        // ============ Equivalence Partitions Tests ==============

        assertEquals(t.getNormal(new Point3D(0.0,3.0,4.0)),(new Vector(new Point3D(1.0,0.0,0.0))));
        assertEquals(t.getNormal(new Point3D(0.0,0.0,3.0)),(new Vector(new Point3D(1.0,0.0,0.0))));
    }
    @Test
    void findIntersectionsTest()
    {
        Triangle t=new Triangle( new Point3D(1.0,3.0,5.0),new Point3D(5.0,3.0,1.0),new Point3D(0.0,3.0,1.0));

        // ============ Equivalence Partitions Tests ==============
        //case 1
        //the ray intersects with triangle
        Ray r=new Ray(
                new Point3D(1.0,-5.0,4.0),
                new Vector(0.0,3.0,0.0));
        List<Intersectable.GeoPoint> l=t.findIntersections(r);
        List<Point3D> expectList=new ArrayList<Point3D>();
        expectList.add(new Point3D(1.0,3.0,4.0));
        assertEquals(expectList.size(),l.size());

        //case 2
        //the ray intersects with plane but outside the triangle against  edge
        r=new Ray(new Point3D(1.0,-5.0,4.0),new Vector(3.0,0.0,-1.0));
        l=t.findIntersections(r);
        assertEquals(null,l);

        //case 3
        //the ray intersects with plane but outside the triangle against vertex
        r=new Ray(new Point3D(1.0,-5.0,4.0),new Vector(1.0,3.0,6.0));
        l=t.findIntersections(r);
        assertEquals(null,l);

        // =============== Boundary Values Tests ==================
//case 1
        //the ray begins before the plane on the edge of the triangle
        r=new Ray(new Point3D(4.0,2.0,1.0),new Vector(0.0,1.0,0.0));
        l=t.findIntersections(r);
        assertEquals(null,l);
//case 2
        // the ray begins before the plane on the vertex
        r=new Ray(new Point3D(1.0,2.0,5.0),new Vector(0.0,1.0,0.0));
        l=t.findIntersections(r);
        assertEquals(null,l);
//case 3
        //the ray begins before the plane on the edge's continuation
        r=new Ray(new Point3D(8.0,6.0,1.0),new Vector(0.0,1.0,0.0));
        l=t.findIntersections(r);
        assertEquals(null,l);
    }

}