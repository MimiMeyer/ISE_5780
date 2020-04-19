package geometries;

import Primitives.Point3D;
import Primitives.Vector;

public class Plane implements Geometry {
    Point3D point;
    Primitives.Vector _normal;


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
}
