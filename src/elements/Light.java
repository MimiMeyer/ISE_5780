package elements;
import primitives.*;
public class Light {
    protected Color _intensity;

    /**
     *
     * @param intensity light intensity
     */
    public Light(Color intensity) {
        this._intensity =  new Color(intensity);
    }

    public Color getIntensity() {
        return _intensity;
    }
}
