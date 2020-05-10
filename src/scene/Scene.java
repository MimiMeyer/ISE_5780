package scene;
import primitives.*;
import geometries.*;
import elements.*;

public class Scene {
    private  String _name;
   private Color _background;
  private  AmbientLight _ambientLight;
   private final Geometries _geometries= new Geometries();
   private Camera _camera;
   private double _distance;
/*constructor*/
    public Scene(String _name) {
        this._name = _name;
    }
/*getters*/
    public String get_name() {
        return _name;
    }

    public Color getBackground() {
        return _background;
    }

    public AmbientLight getAmbientLight() {
        return _ambientLight;
    }

    public Geometries getGeometries() {
        return _geometries;
    }

    public Camera getCamera() {
        return _camera;
    }

    public double getDistance() {
        return _distance;
    }
/*setters*/

    public void setBackground(Color _background) {
        this._background = _background;
    }

    public void setAmbientLight(AmbientLight _ambientLight) {
        this._ambientLight = _ambientLight;
    }

    public void setCamera(Camera _camera) {
        this._camera = _camera;
    }

    public void setDistance(double _distance) {
        this._distance = _distance;
    }
    /*addGeometries*/
    public void addGeometries(Intersectable... geometries) {
        _geometries.add(geometries);
    }
}
