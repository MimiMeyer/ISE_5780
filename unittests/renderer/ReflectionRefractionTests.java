package renderer;
import elements.*;
import geometries.*;
import org.junit.jupiter.api.Test;
import primitives.*;
import scene.*;

class ReflectionRefractionTests {
    /**
     * Produce a picture of a sphere lighted by a spot light
     */
    @Test
    public void twoSpheres() {
        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(1000);
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(Color.BLACK, 0));

        scene.addGeometries(
                new Sphere(50, new Point3D(0, 0, 50), new Color(java.awt.Color.BLUE), new Material(0.4, 0.3, 100, 0.3, 0)),
                new Sphere(25, new Point3D(0, 0, 50), new Color(java.awt.Color.RED), new Material(0.5, 0.5, 100)));

        scene.addLights(new SpotLight(new Color(1000, 600, 0), new Point3D(-100, 100, -500), new Vector(-1, 1, 2), 1,
                0.0004, 0.0000006));

        ImageWriter imageWriter = new ImageWriter("twoSpheres", 150, 150, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Produce a picture of a sphere lighted by a spot light
     */
    @Test
    public void twoSpheresOnMirrors() {
        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(0, 0, -10000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(10000);
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(new Color(255, 255, 255), 0.1));

        scene.addGeometries(
                new Sphere(400, new Point3D(-950, 900, 1000), new Color(0, 0, 100), new Material(0.25, 0.25, 20, 0.5, 0)),
                new Sphere(200, new Point3D(-950, 900, 1000), new Color(100, 20, 20), new Material(0.25, 0.25, 20)),
                new Triangle(new Color(20, 20, 20), new Material(0, 0, 0, 0, 1), new Point3D(1500, 1500, 1500),
                        new Point3D(-1500, -1500, 1500), new Point3D(670, -670, -3000)),
                new Triangle(new Color(20, 20, 20), new Material(0, 0, 0, 0, 0.5), new Point3D(1500, 1500, 1500),
                        new Point3D(-1500, -1500, 1500), new Point3D(-1500, 1500, 2000)));

        scene.addLights(new SpotLight(new Color(1020, 400, 400), new Point3D(-750, 750, 150),
                new Vector(-1, 1, 4), 1, 0.00001, 0.000005));

        ImageWriter imageWriter = new ImageWriter("twoSpheresMirrored", 2500, 2500, 500, 500);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    /**
     * Produce a picture of a two triangles lighted by a spot light with a partially transparent Sphere
     * producing partial shadow
     */
    @Test
    public void trianglesTransparentSphere() {
        Scene scene = new Scene("Test scene");
        scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(1000);
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.WHITE), 0.15));

        scene.addGeometries( //
                new Triangle(Color.BLACK, new Material(0.5, 0.5, 60), //
                        new Point3D(-150, 150, 115), new Point3D(150, 150, 135), new Point3D(75, -75, 150)), //
                new Triangle(Color.BLACK, new Material(0.5, 0.5, 60), //
                        new Point3D(-150, 150, 115), new Point3D(-70, -70, 140), new Point3D(75, -75, 150)), //
                new Sphere(30, new Point3D(60, -50, 50), new Color(java.awt.Color.BLUE), new Material(0.2, 0.2, 30, 0.6, 0)));

        scene.addLights(new SpotLight(new Color(700, 400, 400), //
                new Point3D(60, -50, 0), new Vector(0, 0, 1), 1, 4E-5, 2E-7));

        ImageWriter imageWriter = new ImageWriter("shadow with transparency", 200, 200, 600, 600);
        Render render = new Render(imageWriter, scene);

        render.renderImage();
        render.writeToImage();
    }

    @Test
    public void our_image() {
        Scene scene = new Scene("odelia-Mimi");
        scene.setCamera(new Camera(new Point3D(0, 0, -1000), new Vector(0, 0, 1), new Vector(0, -1, 0)));
        scene.setDistance(1000);
        scene.setBackground(Color.BLACK);
        scene.setAmbientLight(new AmbientLight(new Color(java.awt.Color.BLUE), 0.15));

        scene.addGeometries(


                new Sphere(192, new Point3D(0, 0, -200), Color.BLACK, new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(152, new Point3D(0, 0, -200), Color.BLACK, new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(112, new Point3D(0, 0, -200), Color.BLACK, new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(72, new Point3D(0, 0, -200), Color.BLACK, new Material(0.8, 0.8, 30, 0.8, 0)),
                new Sphere(32, new Point3D(0, 0, -200), Color.BLACK, new Material(0.8, 0.8, 30, 0.8, 0))



        );

        scene.addLights(new DirectionalLight(new Color(10, 10, 10), new Vector(1, -1, 0)),
                new SpotLight(new Color(600, 400, 1020), new Point3D(-300, -300, -100), new Vector(2, 2, -3), 1, 0.00001, 0.000005))
        ;

        ImageWriter imageWriter = new ImageWriter("SphereInSphere", 1000, 1000, 1000, 1000);

        Render render = new Render(imageWriter, scene);

        render.renderImage();
        imageWriter.writeToImage();
    }



}