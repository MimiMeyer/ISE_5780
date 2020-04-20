package geometries;

import primitives.*;
import java.util.List;
import static primitives.Util.alignZero;

public class Sphere extends RadialGeometry {
    Point3D _center;
/****constructor****/
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

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Point3D p0 = ray.getPoint();
        Vector v = ray.getDirection();
        Vector u;
        try {
            u = _center.subtract(p0);
        } catch (IllegalArgumentException e) {
            return List.of(ray.getTargetPoint(_radius));
        }
        double tm = alignZero(v.dotProduct(u));
        double dSquared = tm == 0 ? u.lengthSquared() : u.lengthSquared() - tm * tm;
        double thSquared = alignZero(_radius * _radius - dSquared);
        if (thSquared <= 0) return null;
        double th = alignZero(Math.sqrt(thSquared));
        if (th == 0) return null;
        double t1 = alignZero(tm - th);
        double t2 = alignZero(tm + th);
        if (t1 <= 0 && t2 <= 0) return null;
        if (t1 > 0 && t2 > 0) return List.of(ray.getTargetPoint(t1), ray.getTargetPoint(t2));
        if (t1 > 0)
            return List.of(ray.getTargetPoint(t1));
        else
            return List.of(ray.getTargetPoint(t2));
    }

}
