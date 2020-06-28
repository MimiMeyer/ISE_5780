package scene;
import elements.*;
import geometries.*;
import primitives.*;

import java.util.LinkedList;
import java.util.List;

public class Scene {
    private  String _name;
   private Color _background;
  private  AmbientLight _ambientLight;
   private final Geometries _geometries= new Geometries();
   private Camera _camera;
   List<LightSource> _lights=null;  private double _distance;
/*constructor*/
    public Scene(String _name) {
        this._name = _name;
        _lights = new LinkedList<LightSource>();
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

    public List<LightSource> get_lights() {
        return _lights;
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
    public void addGeometries(Intersectable... intersectables) {
        for (Intersectable i : intersectables) {
            _geometries.add(i);
        }
    }
    /*addlights*/
    public void addLights(LightSource... lights) {
        for (LightSource light:lights) {
            _lights.add(light);
        }
    }
}
