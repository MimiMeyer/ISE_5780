package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Util;
import primitives.Vector;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static primitives.Util.isZero;


public class Camera {
    Point3D _p0;
    Vector _vUp;
    Vector _vRight;
    Vector _vTo;

    private static final Random rnd = new Random();
    /**getters*
     * @return _po,vup,vright,vto***/
    public Point3D get_p0() {
        return _p0;
    }

    public Vector get_vUp() {
        return _vUp;
    }

    public Vector get_vRight() {
        return _vRight;
    }

    public Vector get_vTo() {
        return _vTo;
    }

    public Camera(Point3D _p0, Vector _vTo, Vector _vUp) {

        //if the the vectors are not orthogonal, throw exception.
        if (_vUp.dotProduct(_vTo) != 0)
            throw new IllegalArgumentException("the vectors must be orthogonal");

        this._p0 = new Point3D(_p0);
        this._vTo = _vTo.normalized();
        this._vUp = _vUp.normalized();
        _vRight = this._vTo.crossProduct(this._vUp).normalize();

    }
/*constructs 1 ray through pixel
*/
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i, double screenDistance,
                                        double screenWidth, double screenHeight)
    {
        if (isZero(screenDistance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }
        Point3D Pc = new Point3D( _p0.add(_vTo.scale(screenDistance)));
        double Ry = screenHeight/nY;
        double Rx = screenWidth/nX;
        double yi =  ((i - nY/2d)*Ry + Ry/2d);
        double xj=   ((j - nX/2d)*Rx + Rx/2d);

        Point3D Pij = Pc;

        if (!Util.isZero(xj))
        {
            Pij = Pij.add(_vRight.scale(xj));
        }
        if (!Util.isZero(yi))
        {
            Pij = Pij.add(_vUp.scale(-yi));
        }
        Vector Vij = Pij.subtract(_p0);
        return new Ray(_p0,Vij);
    }

/*constructs 100 rays throgh same pixel each time moving a bit within the pixel*/
    public List<Ray> constructMultipleRaysThroughPixel(int nX, int nY, int j, int i, double screenDistance,
                                               double screenWidth, double screenHeight)
    {
        if (isZero(screenDistance))
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

    List<Ray> rays = new ArrayList<>();
        Point3D Pc = new Point3D( _p0.add(_vTo.scale(screenDistance)));
    double Ry = screenHeight/nY;
    double Rx = screenWidth/nX;
    double yi =  ((i - nY/2d)*Ry);
    double xj=   ((j - nX/2d)*Rx);
      int multipleRays=100;
        for (int count = 0; count < multipleRays; ++count) {

            double y =  rnd.nextDouble();
            double x=   rnd.nextDouble();

            Point3D Pij = Pc;

            if (!Util.isZero(x + xj))
            {
                Pij = Pij.add(_vRight.scale(x + xj));
            }
            if (!Util.isZero(y + yi))
            {
                Pij = Pij.add(_vUp.scale(-y -yi ));
            }
            Vector Vij = Pij.subtract(_p0);
           Ray r=new Ray(_p0,Vij);

           rays.add(r);
        }

        return rays;
}


}


