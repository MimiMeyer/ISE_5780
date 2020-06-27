package geometries;
import primitives.*;

import java.util.List;
import static primitives.Util.alignZero;
import static primitives.Util.isZero;

public class Plane extends Geometry {
    Point3D _point;
    primitives.Vector _normal;


    /***constructer*

     *@param material type matirel
    * @param emmission type color
    * @param p1 point3d
     * @param p2 point3d
     * @param p3  point3d
     * **/
    public Plane(Color emmission, Material material,Point3D p1, Point3D p2, Point3D p3) {
        this._emmission = new Color(emmission);
        this._material= material;

        this._point = new Point3D(p1);

        Vector U = new Vector(p1, p2);
        Vector V = new Vector(p1, p3);
        Vector N = U.crossProduct(V);
        N.normalize();

        _normal = N;
    }

    public Plane(Color emmission, Point3D p1, Point3D p2, Point3D p3) {
        this(emmission,new Material(1,0,0),p1,p2,p3);
    }

    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this(Color.BLACK,new Material(1,0,0),p1,p2,p3);
    }

    public Plane(Point3D point, Vector normal) {
        this(Color.BLACK, new Material(1.0, 0, 0), point, normal);
    }

    public Plane(Color emission, Point3D point, Vector normal) {
        this(emission, new Material(1.0, 0, 0), point, normal);
    }

    public Plane(Color emmission, Material material, Point3D point, Vector _normal) {
        super(emmission, material);
        this._point = point;
        this._normal = _normal;
    }

    /***getnormal*****/
    @Override
    public Vector getNormal(Point3D point) {
        return _normal.normalized();
    }
    public Vector getNormal() {
        return getNormal(null);
    }
/***getters*
 * @return new point3d
 * ****/
    public Point3D getPoint() {
        return new Point3D(_point);
    }
/******tostring******/
    @Override
    public String toString() {
        return "Plane{" +
                "point=" + _point +
                ", _normal=" + _normal +
                '}';
    }
    /**
     * find all intersections of received ray with the sphere
     *
     * @param ray  type ray
     * @param maxDistance  type double is the maximum distance
     * @return list of GeopPoints- intersection points with the plane
     */
    @Override
    public List<GeoPoint> findIntersections(Ray ray,double maxDistance) {
        Vector p0Q;
        try {
            p0Q = _point.subtract(ray.getPoint());
        } catch (IllegalArgumentException e) {
            return null; // ray starts from point Q - no intersections
        }

        double nv = _normal.dotProduct(ray.getDirection());
        if (isZero(nv)) // ray is parallel to the plane - no intersections
            return null;

        double t = alignZero(_normal.dotProduct(p0Q) / nv);

        return t <= 0 ? null : List.of(( new GeoPoint(this, ray.getTargetPoint(t))));
    }
}
