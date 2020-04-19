//Mimi Meyer 317924835
// Odelia Sfez 342472966
package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class TubeTest extends Object {
    /**
     * Test method for Tube getNormal(Point3D point)
     */
    @Test
    public void getNormal() {
        Point3D _p = new Point3D(3.0, 4.0, 5.0);
        Vector _v = new Vector(2.0,2.0,4.0);
         Ray _r=new Ray(_p,_v);
                 double radius=5;
                 Tube tube=new Tube(radius,_r);
                 Point3D p1=new Point3D(0.7,0.7,0.7);
                 Vector normal =tube.getNormal(p1);
                 Vector ExpResult= new Vector(0.064650818383524,-0.9051114573693299,0.4202303194929042);
                 assertEquals(normal,ExpResult);

    }
}