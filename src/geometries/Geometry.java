package geometries;
import primitives.Point3D;
import primitives.Vector;
/*
interface for all Geometries with getNormal
*/
public interface Geometry extends Intersectable {
    Vector getNormal(Point3D point);
}
