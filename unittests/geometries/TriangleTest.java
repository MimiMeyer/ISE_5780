//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;

import org.junit.jupiter.api.Test;
import primitives.Point3D;
import primitives.Vector;
import static org.junit.jupiter.api.Assertions.*;

class TriangleTest extends Object {

    @Test
    void getNormal() {
        Triangle t=new Triangle(new Point3D(0.0,2.0,0.0),new Point3D(0.0,0.0,2.0),new Point3D(0.0,-2.0,0.0));

        // ============ Equivalence Partitions Tests ==============

        assertEquals(t.getNormal(new Point3D(0.0,3.0,4.0)),(new Vector(new Point3D(1.0,0.0,0.0))));
        assertEquals(t.getNormal(new Point3D(0.0,0.0,3.0)),(new Vector(new Point3D(1.0,0.0,0.0))));
    }

}