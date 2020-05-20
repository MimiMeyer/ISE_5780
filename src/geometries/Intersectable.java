package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.List;
public interface Intersectable {

    public static class GeoPoint {
        protected Geometry geometry;
        protected Point3D point;
/***constructor***/
        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }
/****getters***/
        public Geometry getGeometry() {
            return geometry;
        }

        public Point3D getPoint() {
            return point;
        }

        @Override
        public String toString() {
            return "GeoPoint{" +
                    "geometry=" + geometry +
                    ", point=" + point +
                    '}';
        }
    }
    /**
     * find all intersections of received ray with the sphere
     * @param ray
     * @return list of GeopPoints- intersection points with the sphere
     */

    default List<GeoPoint> findIntersections(Ray ray){
        return findIntersections(ray,Double.POSITIVE_INFINITY);
    }

    List<GeoPoint> findIntersections(Ray ray, double maxDistance);

}
