package primitives;
import java.util.Objects;

public class Vector  {
    Point3D _head;


/******constructers*********/

    /**
     * @param p point3d
     */
    public Vector(Point3D p) {
        if (p.equals(Point3D.ZERO)) {
            throw new IllegalArgumentException("Point3D(0.0,0.0,0.0) not valid for vector head");
        }
        this._head = new Point3D(p._x._coord, p._y._coord, p._z._coord);
    }

    /**
     * @param v vector
     */
    public Vector(Vector v) {
        this(v._head);
    }

    public Vector(Point3D p1, Point3D p2) {
        this(p1.subtract(p2));
    }

    public Vector(double x,double y, double z) {
        this(new Point3D(x,y,z));
    }

    /************getter
     * **
     * @return  _head
     * *******/
    public Point3D get_head() {
        return _head;
    }

    /************setter**
     * @param _head setter for point 3d _head
     * *******/
    public void set_head(Point3D _head) {
        this._head = _head;
    }

    /************tostring*********/
    @Override
    public String toString() {
        return "Vector{" +
                "_head=" + _head +
                '}';
    }
    /************equals*********/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return Objects.equals(_head, vector._head);
    }
    /****add*
     * @return vector plus other vector
     * *
     * @param other *
     * **/
    public Vector add(Vector other){
        return new Vector(new Point3D(this._head._x._coord+other._head._x.get(),this._head._y._coord+other._head._y.get(),this._head._z._coord+other._head._z.get()));



    }
    /***
     * *subtract
     * @return vector minus the other vector
     * @param other vector to be used to sustract from original vector
     * *****/
    public Vector subtract(Vector other){
        return new Vector(new Point3D(this._head._x._coord-other._head._x.get(),this._head._y._coord-other._head._y.get(),this._head._z._coord-other._head._z.get()));

    }
    /****scale*
     * @return  vector times a number
     * @param n number which will be used to time the vector***/
    public Vector scale(double n){
        return new Vector(new Point3D(this._head._x._coord*n,this._head._y._coord*n,this._head._z._coord*n));

}
/*****dotproduct*
 * @return  returns a number of type double
 * @param other othe vector to use for dot product
 * ***/
    public double dotProduct(Vector other)
    {
        return this._head._x._coord*other._head._x._coord+this._head._y._coord*other._head._y._coord+this._head._z._coord*other._head._z._coord;
    }
    /****crossProduct
     * @return Vector
     * @param other vector to use inorder yo do the crossproduct
     * *****/
    public Vector crossProduct (Vector other)
    {
        double w1 = this._head._y._coord * other._head._z._coord - this._head._z._coord * other._head._y._coord;
        double w2 = this._head._z._coord * other._head._x._coord - this._head._x._coord * other._head._z._coord;
        double w3 = this._head._x._coord * other._head._y._coord - this._head._y._coord * other._head._x._coord;

        return new Vector(new Point3D(w1, w2, w3));
    }

    /****lengthSquared**
     * @return lengthSquared*
     * ********/

    public double	lengthSquared (){
        return this.dotProduct(this);

    }

    /****length**
     * @return length
     * ***/
    public double length (){

        return Math.sqrt(this.lengthSquared());
    }
    /*****normalize***
     * @return normalized vector
     */

    public Vector normalize( )
    {
        Vector _v=new Vector(new Point3D(this._head._x._coord/this.length(),this._head._y._coord/this.length(),this._head._z._coord/this.length()));
        this._head=_v.get_head();
        return this;
    }
    public Vector normalized(){
        Vector _v=new Vector(this._head);
        return _v.normalize();
    }
}
