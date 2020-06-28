package elements;

import primitives.*;
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
        double yi =  ((i - nY/2d)*Ry + Ry/2d);//middle height of pixel
        double xj=   ((j - nX/2d)*Rx + Rx/2d);//middle width of pixel

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
        return new Ray(_p0,Vij); //will return the ray in middle of the pixel
    }

/*constructs 100 rays throgh same pixel each time moving a bit within the pixel*/
    public List<Ray> constructMultipleRaysThroughPixel(int nX, int nY, int j, int i, double screenDistance,
                                               double screenWidth, double screenHeight)
    {
        if (isZero(screenDistance))//screen distance can't be zero
        {
            throw new IllegalArgumentException("distance cannot be 0");
        }

    List<Ray> rays = new ArrayList<>();//creating a new list of rays
        Point3D Pc = new Point3D( _p0.add(_vTo.scale(screenDistance)));
    double Ry = screenHeight/nY; //height of the pixel
    double Rx = screenWidth/nX;//Width of the pixel
    double yi =  ((i - nY/2d)*Ry); // yi distance of original pixel from (0,0) on Y axis
    double xj=   ((j - nX/2d)*Rx);//xj distance of original pixel from (0,0) on X axis
      int multipleRays=100;//num of rays
        for (int count = 0; count < multipleRays; ++count) {

            double minY =-Ry;//minimum height of the pixel
            double maxY=Ry;//maximum height of the pixel
            double minX=-Rx;//minimum width of the pixel
            double maxX=Rx;//maximum width of the pixel
            double randomY =   rnd.nextDouble() ;//generates random number between 0-1
            double randomX=   rnd.nextDouble();//generates random number between 0-1
            double y=minY+(randomY*(maxY-minY));//y will be number between -Ry and Ry
            double x=minX+(randomX*(maxX-minX));//x will be number between -Rx and Rx
            Point3D Pij = Pc;

            if (!Util.isZero(x + xj))//if x+xj  doesnt equel zero do the next line
            {
                Pij = Pij.add(_vRight.scale(x + xj));//will move the ray along the width of the pixel.
            }
            if (!Util.isZero(y + yi))//if y+yi doesnt equel zero do the next line
            {
                Pij = Pij.add(_vUp.scale(-y -yi ));//will move the ray along the hight of the pixel.
            }
            Vector Vij = Pij.subtract(_p0);
           Ray r=new Ray(_p0,Vij);

           rays.add(r);//adds new ray to list
        }

        return rays;//returns full list of rays
}


}


