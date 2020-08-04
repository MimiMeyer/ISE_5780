package renderer;

import elements.*;
import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;

public class miniProjectTest {
    @Test
    public void Mini_Project() {
        Scene scene = new Scene("odelia_Mimi");
        scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(1000);
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries(
//pyramid
                new Triangle(new Color(255,255,255), new Material(0.8, 0.8, 30, 1, 0), new Point3D(-10,30,0), new Point3D(30,30,0), new Point3D(0,-30,10)),
                new Triangle(new Color(255,255,255), new Material(0.8, 0.8, 30, 1, 0), new Point3D(30,30,0), new Point3D(-10,30,30), new Point3D(0,-30,10)),
                new Triangle(new Color(java.awt.Color.ORANGE), new Material(0.8, 0.8, 30, 1, 0), new Point3D(-10,30,0), new Point3D(-30,30,30), new Point3D(0,-30,10)),
//middle sphereinsphere
                new Sphere(100, new Point3D(0, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(0, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
//left sphereinsphere

                new Sphere(100, new Point3D(-300, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(-300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
//right sphereinsphere
                new Sphere(100, new Point3D(300, 0, -200),new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(80,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(60,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(40,  new Point3D(300, 0, -200), new Color(java.awt.Color.BLUE), new Material(0.8, 0.8, 30, 0.8, 0)),
//mishtach
        new Triangle(Color.BLACK, new Material(0.8, 1, 1000, 0, 1),
                new Point3D(800, 100, -100), new Point3D(-800, 100, -100), new Point3D(800, 100, -1000)),
                new Triangle(Color.BLACK, new Material(0.8, 1, 1000, 0, 1),
                        new Point3D(-800, 100, -100), new Point3D(800, 100, -1000), new Point3D(-800, 100, -1000))
        );

        scene.addLights(new DirectionalLight(new Color(30, 15, 15), new Vector(30, 0, -1)),
                new DirectionalLight(new Color(30, 15, 15), new Vector(-30, 0, -1)),
                new SpotLight(new Color(600, 400, 1020), new Point3D(0, -450, -200), new Vector(1, 3, -3), 1, 0.00001, 0.000005),
                new SpotLight(new Color(600, 400, 1020), new Point3D(-450, -450, -200), new Vector(1, 3, -3), 1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("miniProject", 1000, 1000, 1000, 1000);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToImage();
    }
}
