package geometries;
import primitives.Point3D;
import primitives.Vector;
/*
interface for all Geometries with getNormal
*/
public interface Geometry {
    Vector getNormal(Point3D point);
}
