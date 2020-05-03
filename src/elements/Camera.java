package elements;
import primitives.*;
import static primitives.Util.isZero;

public class Camera {
    Point3D _point0;
    Vector _vTo;
    Vector _vUp;
    Vector _vRight;
/*constructer*/
    public Camera(Point3D _point0, Vector _vTo, Vector _vUp)        {
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");
        this._point0 = new Point3D(_point0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();
        this._vRight = _vRight = this._vTo.crossProduct(this._vUp).normalize();
    }
    public Ray constructRayThroughPixel(int nX, int nY,
                                        int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight)
    {
        if (isZero(screenDistance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

        Point3D Pc = _point0.add(_vTo.scale(screenDistance));

        double Ry = screenHeight/nY;
        double Rx = screenWidth/nX;

        double yi =  ((i - nY/2d)*Ry + Ry/2d);
        double xj=   ((j - nX/2d)*Rx + Rx/2d);

        Point3D Pij = Pc;

        if (! isZero(xj))
        {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (! isZero(yi))
        {
            Pij = Pij.subtract(_vUp.scale(yi)); // Pij.add(_vUp.scale(-yi))
        }

        Vector Vij = Pij.subtract(_point0);

        return new Ray(_point0,Vij);

    }


    public Point3D get_p0() {
        return new Point3D(_point0);
    }

    public Vector get_vTo() {
        return new Vector(_vTo);
    }

    public Vector get_vUp() {
        return new Vector(_vUp);
    }

    public Vector get_vRight() {
        return new Vector(_vRight);
    }
}

