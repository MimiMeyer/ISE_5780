
package primitives;
import static primitives.Util.isZero;
public class Ray {
    private static final double DELTA = 0.1;
    Point3D _p0;
    Vector _dir;
    public Point3D getTargetPoint(double length) {
        return isZero(length ) ? _p0 : _p0.add(_dir.scale(length));
    }

    /*****constructor*
     * @param direction tyoe vector
     * @param point tyor point3d
     * *******/

    public Ray(Point3D point, Vector direction) {
        _p0 = new Point3D(point);
        _dir = new Vector(direction).normalized();
    }

    public Ray(Point3D point, Vector direction, Vector normal) {
        //point + normal.scale(±DELTA)
        _dir = new Vector(direction).normalized();

        double nv = normal.dotProduct(direction);

        Vector normalDelta = normal.scale((nv > 0 ? DELTA : -DELTA));
        _p0 = point.add(normalDelta);
    }
    /**
     * Ray copy constructor- receives another Ray
     * @param _other the Ray that is copied
     */
    public Ray(Ray _other)
    {
        this._p0 = new Point3D(_other._p0);
        this._dir = new Vector(_other._dir);
    }
/*******getters and setters**
 * @return _p0,_dir *******/

    public Point3D getPoint() {
        return _p0;
    }

    public Vector getDirection() {
        return _dir;
    }

    public void setPoint(Point3D _P0) {
        this._p0 = _P0;
    }

    public void setDirection(Vector _dir) {
        this._dir = _dir;
    }
/********tostring*******/
    @Override
    public String toString() {
        return "Ray{" +
                "_P0=" + _p0 +
                ", _dir=" + _dir +
                '}';
    }
/********equals********/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ray)) {
            return false;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _p0.equals( ray._p0) &&
                _dir.equals( ray._dir);
    }



}
