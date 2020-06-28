package elements;

import primitives.*;
/*constructor*/
public class DirectionalLight extends Light implements LightSource {
    private Vector _direction;

    public DirectionalLight(Color _intensity, Vector _direction) {
        super(_intensity);
        this._direction = _direction;
    }
/*getters*/
    @Override
    public Color getIntensity(Point3D p) {
        return super.getIntensity();
    }

    @Override
    public Vector getL(Point3D p) {
        return _direction.normalize();
    }
    @Override
    public double getDistance(Point3D point) {
        return Double.POSITIVE_INFINITY;
    }

}
