//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;

import primitives.Point3D;
import primitives.Vector;
import org.junit.jupiter.api.Test;
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

}