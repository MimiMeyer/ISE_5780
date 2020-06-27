package renderer;

import elements.AmbientLight;
import elements.Camera;
import elements.DirectionalLight;
import elements.SpotLight;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;
import primitives.Color;
import primitives.Material;
import primitives.Point3D;
import primitives.Vector;
import scene.Scene;

public class miniProjectTest {
    @Test
    public void Mini_Project() {
        Scene scene = new Scene("odelia_Mimi");
        scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(1000);
        scene.setBackground(new Color(java.awt.Color.GRAY));
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries(


                new Sphere(100, new Point3D(0, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),


                new Sphere(100, new Point3D(-300, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),

                new Sphere(100, new Point3D(300, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),

        new Triangle(Color.BLACK, new Material(0.8, 1, 1000, 0, 1),
                new Point3D(800, 100, -100), new Point3D(-800, 100, -100), new Point3D(800, 100, -1000)),
                new Triangle(Color.BLACK, new Material(0.8, 1, 1000, 0, 1),
                        new Point3D(-800, 100, -100), new Point3D(800, 100, -1000), new Point3D(-800, 100, -1000))
        );

        scene.addLights(new DirectionalLight(new Color(30, 15, 15), new Vector(30, 0, -1)),
                new DirectionalLight(new Color(30, 15, 15), new Vector(-30, 0, -1)),
                new SpotLight(new Color(600, 400, 1020), new Point3D(0, -450, -200), new Vector(1, 3, -3), 1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("miniProject", 1000, 1000, 1000, 1000);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToImage();
    }
}
