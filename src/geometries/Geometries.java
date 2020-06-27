
package geometries;

import primitives.Ray;

import java.util.ArrayList;
import java.util.List;
/* class Geometries is a class that represents the basic geometries*/
    public class Geometries implements Intersectable {

        private List<Intersectable> _geometries = new ArrayList<Intersectable>();
    /**
     * constructor
     */
    public Geometries(){
        this._geometries = new ArrayList<Intersectable>();
    }

    /**
     *  parameter constructor
     * @param _geometries geometries collection parameter
     */
        public Geometries(Intersectable... _geometries) {
            add( _geometries);
        }
    /**
     * the function get collection of geometries and add it to the class geometries collection
     * @param geometries collection of geometries
     */
        public void add(Intersectable... geometries) {
            for (Intersectable geo : geometries ) {
                _geometries.add(geo);
            }
        }

    /**
     * the function gets a ray and returns a list of intersection points with all the geometries collection
     * @param ray type ray
     * @param maxDistance type double
     * @return list of Point3D that intersect the osef
     */
        @Override
        public List<GeoPoint> findIntersections(Ray ray,double maxDistance) {
            List<GeoPoint> intersections = null;

            for (Intersectable geometry : _geometries) {
                List<GeoPoint> tempIntersections = geometry.findIntersections(ray,maxDistance);
                if (tempIntersections != null) {
                    if (intersections == null)
                        intersections = new ArrayList<GeoPoint>();
                    intersections.addAll(tempIntersections);
                }
            }
            return intersections;

        }
    }
