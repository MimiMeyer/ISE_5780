package primitives;

public class Material {
    double _kD;
    double _kS;
    double _kT;
    double _kR;
    int _nShininess;
/***constructor*
 * @param _kD type double
 * @param _kS  type ks
 * @param _nShininess type int
 * **/
public Material(double _kD, double _kS, int _nShininess) {
    this(_kD, _kS, _nShininess, 0, 0);
}
    public Material(double _kD, double _kS,int _nShininess,double _kT,double _kR) {
        this._kD = _kD;
        this._kS = _kS;
        this._kT=_kT;
        this._kR=_kR;
        this._nShininess = _nShininess;
    }
/***getters*
 * @return _kd,_ks,_kt,_kr,_nShinieness
 * **/
    public double get_kD() {
        return _kD;
    }
    public double get_kS() {
        return _kS;
    }
    public double getKT() { return _kT;}
    public double getkR() {
        return _kR;
    }

    public int get_nShininess() {
        return _nShininess;
    }
}
