package geometries;
import primitives.*;

import static primitives.Util.isZero;

public abstract class RadialGeometry extends Geometry {

    double _radius;
/***constructer****/
    /**
     *
     * @param radius radius
     */
    public RadialGeometry(double radius) {
        super(Color.BLACK);
        initRadius(radius);
    }

    public RadialGeometry( Color emmission,double radius) {
        super(emmission);
       initRadius(radius);
    }

    /***constructor
     * @param emmission type color emmision
     * @param material matriel
     * @param radius radius
     * ****/
    public RadialGeometry(Color emmission, Material material, double radius) {
        super(emmission,material);
        initRadius(radius);
    }

    /******copy constructor******/
    void RadialGeometry(RadialGeometry c){
       this._emmission  = new Color(c._emmission);
       this._material = c._material;
       initRadius(c._radius);
    }


    private void initRadius(double _radius) {
        if (isZero(_radius) || (_radius < 0.0))
            throw new IllegalArgumentException("radius "+ _radius +" is not valid");
        this._radius = _radius;
    }

    /****getter**
     * @return _radius**/
    public double get_radius() {
        return _radius;
    }
}
