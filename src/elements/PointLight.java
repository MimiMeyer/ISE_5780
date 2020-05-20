package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource{
Point3D _position;
double _kC,_kL,kQ;

    public PointLight(Color _intensity, Point3D _postion, double _kC, double _kL, double kQ) {
        super(_intensity);
        this._position = new Point3D(_postion);
        this._kC = _kC;
        this._kL = _kL;
        this.kQ = kQ;
    }

    @Override
    public Color getIntensity(Point3D p) {
        double dsquared = p.distanceSquared(_position);
        double d = p.distance(_position);

        return (_intensity.reduce(_kC + _kL * d + kQ * dsquared));
    }

    @Override
    public Vector getL(Point3D p) {
        if (p.equals(_position)) {
            return null;
        } else {
            return p.subtract(_position).normalize();
        }
    }
}
