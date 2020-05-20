package elements;
import primitives.Color;

public class AmbientLight extends Light{

  //double _kA;

/*CONSTRUCTORS*/
    public AmbientLight(Color _IA, double _kA) {
        super(_IA.scale(_kA));

    }

    public AmbientLight(Color _IA) {
        this(_IA,1.0);
    }

}
