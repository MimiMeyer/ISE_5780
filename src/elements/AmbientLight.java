package elements;
import primitives.Color;

public class AmbientLight {
  Color _intensity;
  //double _kA;

/*CONSTRUCTORS*/
    public AmbientLight(Color _intensity, double _kA) {
        //this._kA = _kA;
        this._intensity = _intensity.scale(_kA);
    }

    public AmbientLight(Color _intensity) {
        this(_intensity,1.0);
    }
/*getters*/
    public Color getIntensity() {
        return _intensity;
    }
}
