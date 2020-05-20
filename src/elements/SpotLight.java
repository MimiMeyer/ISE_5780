package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

import static java.lang.Math.max;

public class SpotLight extends PointLight {
    Vector _direction;

    public SpotLight(Color intensity, Point3D position, Vector direction, double kC, double kL, double kQ) {
        super(intensity, position, kC, kL, kQ);
        this._direction = new Vector(direction);
    }



    @Override
    public Vector getL(Point3D p) {
        return _direction.normalize();
    }

    public Color getIntensity(Point3D p)
    {
        double _distance=p.distance(_position);
        double m=max(0,_direction.dotProduct(super.getL(p)));
        return _intensity.scale(m/(_kC+_kL*_distance+ kQ *_distance*_distance));

    }
}
