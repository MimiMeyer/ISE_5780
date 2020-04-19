package Primitives;

public class Ray {
    Point3D _P0;
    Vector _dir;
/*****constructer********/
    public Ray(Point3D _P0, Vector _dir) {
        if (this.equals(_dir.length()!=1))
            throw new IllegalArgumentException("dimensions disagree");
        this._P0 = new Point3D(_P0);
        this._dir = new Vector(_dir).normalized();
    }
/*******getters and setters*********/
    public Point3D getPoint() {
        return _P0;
    }

    public Vector getDirection() {
        return _dir;
    }

    public void setPoint(Point3D _P0) {
        this._P0 = _P0;
    }

    public void setDirection(Vector _dir) {
        this._dir = _dir;
    }
/********tostring*******/
    @Override
    public String toString() {
        return "Ray{" +
                "_P0=" + _P0 +
                ", _dir=" + _dir +
                '}';
    }
/********equals********/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return _P0.equals( ray._P0) &&
                _dir.equals( ray._dir);
    }



}
