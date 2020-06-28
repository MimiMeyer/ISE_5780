package geometries;

import primitives.*;

import java.util.List;

import static primitives.Util.isZero;

public class Tube extends RadialGeometry {

    protected final Ray _axisRay;

    /***constructer*
     * @param _radius radius
     * @param _axisRay ray **////
    public Tube(double _radius, Ray _axisRay) {
        super(_radius);
        this._axisRay = new Ray(_axisRay);
    }

    /***getter*
     * @return _axisRay
     * ***/
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
        if (!isZero(projection)) {
            // projection of P-O on the ray:
            o = o.add(v.scale(projection));
        }

        //This vector is orthogonal to the _direction vector.
        Vector check = point.subtract(o);
        return check.normalize();

    }

    /**
     * find all intersections of received ray with the sphere
     *
     * @param ray ray
     * @return list of GeopPoints- intersection points with the tube
     */


    @Override
    public List<GeoPoint> findIntersections(Ray ray, double maxDistance) {
        //TODO implements here
        return null;
    }


}

