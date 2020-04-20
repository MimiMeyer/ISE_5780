package geometries;
import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import java.util.List;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane implements Geometry {
    Point3D point;
    primitives.Vector _normal;


    /***constructer***/
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        point= new Point3D(p1);

        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N;
    }

    public Plane(Point3D point, Vector _normal) {
        this.point = new Point3D(point);
        this._normal = new Vector(_normal);
    }


    /***getnormal*****/
    @Override
    public Vector getNormal(Point3D point) {
        return _normal.normalized();
    }
    public Vector getNormal() {
        return getNormal(new Point3D(0.0,0.0,0.0));
    }
/***getters*****/
    public Point3D getPoint() {
        return point;
    }

    public Vector get_normal() {
        return _normal;
    }
/******tostring******/
    @Override
    public String toString() {
        return "Plane{" +
                "point=" + point +
                ", _normal=" + _normal +
                '}';
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        Vector p0Q;
        try {
            p0Q = point.subtract(ray.getPoint());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = _normal.dotProduct(ray.getDirection());
        if (isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double t = alignZero(_normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(ray.getTargetPoint(t));
    }
}
