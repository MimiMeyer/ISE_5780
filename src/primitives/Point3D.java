package primitives;

public class Point3D {
    Coordinate _x;
    Coordinate _y;
    Coordinate _z;
    public final static Point3D ZERO = new Point3D(0.0, 0.0, 0.0);

/******constructer********/
    public Point3D(Coordinate _x, Coordinate _y, Coordinate _z) {
        this._x = _x;
        this._y = _y;
        this._z = _z;
    }
    public Point3D(Point3D p) {
        this._x = new Coordinate(p._x);
        this._y = new Coordinate(p._y);
        this._z = new Coordinate(p._z);
    }
    public Point3D(double _x,double _y,double _z){
        this(new Coordinate(_x),new Coordinate(_y),new Coordinate(_z));
    }
    /*********getters********/
    public Coordinate get_x() {
        return new Coordinate(_x);
    }

    public Coordinate get_y() {
        return new Coordinate(_y);
    }

    public Coordinate get_z() {
        return new Coordinate(_z);
    }
/***********setters*********/
    public void set_x(Coordinate _x) {
        this._x = new Coordinate(_x);
    }

    public void set_y(Coordinate _y) {
        this._y = new Coordinate(_y);
    }

    public void set_z(Coordinate _z) {
        this._z = new Coordinate(_z);
    }
/********tostring********/
    @Override
    public String toString() {
        return "Point3D{" +
                "" + _x +
                "" + _y +
                "" + _z +
                '}';
    }
/**********equals********/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return _x.equals( point3D._x) &&
        _y.equals(point3D._y) &&
                _z.equals(point3D._z);
    }
    /******subtract******/
    public Vector subtract(Point3D other){
        return new Vector(new Point3D(this._x._coord-other._x.get(),this._y._coord-other._y.get(),this._z._coord-other._z.get()));
    }
    public Point3D subtract(Vector v) {
        return new Point3D(this._x._coord - v._head._x._coord,
                this._y._coord - v._head._y._coord,
                this._z._coord - v._head._z._coord);
    }


    /******add******/
    public Point3D add(Vector other){
        return new Point3D(this._x._coord +other._head._x._coord, this._y._coord + other._head._y._coord, this._z._coord + other._head._z._coord);
    }
    /******distanceSquared******/
    public double distanceSquared(Point3D other){
      return  ((this._x._coord-other._x.get())*(this._x._coord-other._x.get()))+
              ((this._y._coord-other._y.get())*(this._y._coord-other._y.get()))+
                ((this._z._coord-other._z.get())*(this._z._coord-other._z.get()));

    }
    /******distance******/
    public double distance (Point3D other){
        return Math.sqrt(distanceSquared(other));
    }



}
