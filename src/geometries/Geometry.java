package geometries;

import primitives.*;

/*
interface for all Geometries with getNormal
*/
public abstract class Geometry implements Intersectable {
    protected Color _emmission;
    protected Material _material;

    public abstract Vector getNormal(Point3D point);

    /***getter***/
    public Color get_emmission() {
        return _emmission;
    }

    public Material get_material() {
        return _material;
    }


    /***constructor****/

    public Geometry(Color emmission, Material _material) {
        _emmission = new Color(emmission);
        this._material = _material;
    }

    public Geometry(Color emmission) {
        this(emmission, new Material(0, 0, 0));
    }

    public Geometry() {
        this(Color.BLACK, new Material(0, 0, 0));
    }


}
