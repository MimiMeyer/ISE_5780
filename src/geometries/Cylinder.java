package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;
public class Cylinder extends Tube {
 double _height;
/***constructer***/
    public Cylinder(double _radius, Ray _axisRay,double _height) {
        super(_radius,_axisRay);
        this._height = _height;
    }
/***getter****/
    public double get_height() {
        return _height;
    }
/****tostring****/
    @Override
    public String toString() {
        return "Cylinder{" +
                "_height=" + _height +
                ", _radius=" + _radius +
                '}';
    }

    /***getnormal***/
    public Vector getNormal(Point3D point) {
        Point3D o = _axisRay.getPoint();
        Vector v = _axisRay.getDirection();

        // projection of P-O on the ray:
        double t;
        try {
            t = alignZero(point.subtract(o).dotProduct(v));
        } catch (IllegalArgumentException e) { // P = O
            return v;
        }

        // if the point is at a base
        if (t == 0 || isZero(_height - t)) // if it's close to 0, we'll get ZERO vector exception
            return v;

        o = o.add(v.scale(t));
        return point.subtract(o).normalize();
    }
    @Override
    public List<GeoPoint> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
    }

