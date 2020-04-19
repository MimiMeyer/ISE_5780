package geometries;

import primitives.Point3D;
import primitives.Vector;

public class Sphere extends RadialGeometry {
    Point3D _center;
/****constructer****/
    public Sphere(double _radius, Point3D _center) {
        super(_radius);
        this._center = _center;
    }
/*getter*/
    public Point3D get_center() {
        return _center;
    }
/*tostring*/
    @Override
    public String toString() {
        return "Sphere{" +
                "_center=" + _center +
                ", _radius=" + _radius +
                '}';
    }
/***getnormal***/
public Vector getNormal(Point3D point) {
    Vector normal = point.subtract(_center);
    return normal.normalize();

    }
}
