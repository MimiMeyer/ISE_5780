//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;
import primitives.Point3D;
import primitives.Vector;
import primitives.Ray;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CylinderTest extends Object {
    /**
     * Test method for cylinder getNormal(Point3D point)
     */
    @Test
    public void getNormal() {
            Cylinder c=new Cylinder(4, new Ray(new Point3D(3.0,4.0,5.0), new Vector(2.0,2.0,4.0)), 8);
        Point3D p1=new Point3D(0.7,0.7,0.7);
        Vector normal =c.getNormal(p1);
        Vector ExpResult= new Vector(0.064650818383524,-0.9051114573693299,0.4202303194929042);
        assertEquals(normal,ExpResult);
    }
}