
package geometries;

import primitives.Point3D;
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
     * @param ray
     * @return list of Point3D that intersect the osef
     */
        @Override
        public List<Point3D> findIntersections(Ray ray) {
            List<Point3D> intersections = null;

            for (Intersectable geometry : _geometries) {
                List<Point3D> tempIntersections = geometry.findIntersections(ray);
                if (tempIntersections != null) {
                    if (intersections == null)
                        intersections = new ArrayList<Point3D>();
                    intersections.addAll(tempIntersections);
                }
            }
            return intersections;

        }
    }
