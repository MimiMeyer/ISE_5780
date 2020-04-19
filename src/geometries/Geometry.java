package geometries;
import Primitives.Point3D;
import Primitives.Vector;
/*
interface for all Geometries with getNormal
*/
public interface Geometry {
    Vector getNormal(Point3D point);
}
