//Mimi Meyer 317924835
// Odelia Sfez 342472966
package primitives;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest extends Object {
    /**
     * Test method for vector add()
     */

    @Test
   public void add() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        Vector v2 = new Vector(-1.0, -1.0, -1.5);
        v1 = new Vector(1.0, 1.0, 1.0);

        v2 = new Vector(-1.0, -1.0, -1.5);



        v1 = v1.add(v2);

        assertEquals(new Vector(0.0,0.0,-0.5),v1);



        v2 = v2.add(v1);

        assertEquals(new Vector(-1.0, -1.0, -2.0),v2);
    }
    /**
     * Test method for vector subtract()
     */
    @Test
    void subtract() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);

        Vector v2 = new Vector(-1.0, -1.0, -1.5);
        v1 = new Vector(1.0, 1.0, 1.0);
        v2 = new Vector(-1.0, -1.0, -1.5);
        v1=v1.subtract(v2);
        assertEquals(new Vector (2.0,2.0,2.5),v1);
        v2=v2.subtract(v1);
        assertEquals(new Vector (-3.0,-3.0,-4.0),v2);
    }
    /**
     * Test method for vector scale()
     */
    @Test
    void scale() {
        Vector v1 = new Vector(1.0, 1.0, 1.0);


        v1=v1.scale(1);
        assertEquals(new Vector(1.0,1.0,1.0),v1);
        v1=v1.scale(2);
        assertEquals(new Vector(2.0,2.0,2.0),v1);
        v1=v1.scale(-2);
        assertEquals(new Vector(-4.0,-4.0,-4.0),v1);
        try{
            v1= v1.scale(0.0);
        } catch (IllegalArgumentException e){
            System.out.println("can't be zero");
            assertTrue(true);
        }
    }
    /**
     * Test method for vector dotProduct()
     */
    @Test
    void dotProduct() {
        Vector v1 = new Vector(3.5, -5.0, 10.0);

        Vector v2 = new Vector(2.5,7,0.5);

        double x1 = v1.dotProduct(v2);
        assertEquals( -21.25,x1);
    }
    /**
     * Test method for vector crossProduct()
     */
    @Test
    void crossProduct() {


        Vector v1 = new Vector(3.5, -5.0, 10.0);

        Vector v2 = new Vector(2.5,7,0.5);

        Vector v3 = v1.crossProduct(v2);

        assertEquals( 0, v3.dotProduct(v2), 1e-10);

        assertEquals( 0, v3.dotProduct(v1), 1e-10);



        Vector v4 = v2.crossProduct(v1);



        System.out.println(v3.toString());

        System.out.println(v4.toString());



        try {

            v3.add(v4);

            fail("Vector (0,0,0) not valid");

        }

        catch  (IllegalArgumentException e)

        {

            assertTrue(e.getMessage()!= null);

        }

//        assertTrue(v3.length() >84);

        assertEquals(84,v3.length(),0.659);
    }


    /**
     * Test method for vector length()
     */
    @Test
    void length() {
        Vector v1 = new Vector(2.0, 2.0, 1.0);
        double x1 = v1.length();
        assertEquals(3.0, x1 );
        Vector v2 = new Vector(-2.0, -2.0, -1.0);
        double x2 = v2.length();
        // ============ Equivalence Partitions Tests ==============
        assertEquals(3.0, x2 );

    }

    /**
     * Test method for vector normalized()
     */
    @Test
    void normalized() {


            Vector v = new Vector(3.5, -5, 10);

            v.normalize();

            assertEquals(1, v.length(), 1e-10);


            try {

                Vector v1 = new Vector(0, 0, 0);

                v.normalize();

                fail("Vector (0,0,0) not valid");

            }

            catch  (IllegalArgumentException e)

            {

                assertTrue(e.getMessage()!= null);
                assertTrue(true);

            }

        }
    }
