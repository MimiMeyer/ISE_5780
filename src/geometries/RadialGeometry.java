package geometries;
import static Primitives.Util.isZero;

public abstract class RadialGeometry implements Geometry {

    double _radius;
/***constructer****/
    /**
     *
     * @param _radius
     */
    public RadialGeometry(double _radius) {
        if (isZero(_radius) || (_radius < 0.0))
            throw new IllegalArgumentException("radius "+ _radius +" is not valid");
        this._radius = _radius;
    }
    /******copy constructer******/
    void RadialGeometry(RadialGeometry c)
    {
        _radius =c._radius;
    }
/****getter****/
    public double get_radius() {
        return _radius;
    }



}
