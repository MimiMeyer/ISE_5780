package geometries;

import Primitives.*;
import static Primitives.Util.isZero;

public class Tube extends RadialGeometry {
   Ray _axisRay;
/***constructer***////
    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = _axisRay;
    }
/***getter****/
    public Ray get_axisRay() {
        return _axisRay;
    }
/***tostring****/
    @Override
    public String toString() {
        return "Tube{" +
                "_axisRay=" + _axisRay +
                ", _radius=" + _radius +
                '}';
    }

    /***getnormal***/
    public Vector getNormal(Point3D point) {
        //The vector from the point of the cylinder to the given point
        Point3D o = _axisRay.getPoint(); // at this point o = p0
        Vector v = _axisRay.getDirection();

        Vector vector1 = point.subtract(o);

        //We need the projection to multiply the _direction unit vector
        double projection = vector1.dotProduct(v);
        if(!isZero(projection))
        {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.subtract(o);
        return check.normalize();
    }

    }

