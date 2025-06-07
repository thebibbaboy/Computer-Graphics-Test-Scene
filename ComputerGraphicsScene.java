 

/*
 * I was responsible for the creation and texturing of the Volcano. 
 * The Volcano was modelled in Blender and textured in Substance Painter
 * 
 * I was also responsible for creation of the rock, grass and lava textures. 
 * They were created and exported in Substance Designer.
 * 
 */

//Import necessary items
import static org.lwjgl.opengl.GL40.*;
import static org.lwjgl.glfw.GLFW.*;

import graphics.core.*;
import graphics.math.*;
import graphics.geometry.*;
import graphics.material.*;
import graphics.extras.*;
import graphics.light.*;

public class ComputerGraphicsScene extends Base
{
    public Renderer renderer;
    public Scene scene;
    public Camera camera;
    public Mesh mesh;
    public MovementRig rig;

    public DirectionalLight directionalLight;
    public PointLight pointLight;

    public static void main(String[] args)
    {
        Base test = new ComputerGraphicsScene();
        test.setWindowSize(900, 900);
        test.run();
    }

    public void initialize()
    {
        renderer = new Renderer();
        scene    = new Scene();
        camera   = new Camera();
        // camera.setPosition( new Vector(0.5, 1, 4) );

        //Create camera movement
        rig = new MovementRig();
        rig.attach( camera );
        rig.setPosition( new Vector(0.5, 6, 30) );
        rig.unitsPerSecond = 20;
        scene.add( rig );

        Light ambient = new AmbientLight( new Vector(0.1, 0.1, 0.1) ); 
        scene.add( ambient );

        directionalLight = new DirectionalLight( new Vector(0.8, 0.8, 0.8), new Vector(-1, -1, -2) );
        scene.add( directionalLight );

        pointLight = new PointLight(new Vector(0.9, 0, 0), new Vector(1, 1, 0.8) );
        scene.add( pointLight );
        
        //Skybox creation
        Geometry sphereGeo = new SphereGeometry(100);
        Material sphereMat = new TextureMaterial( new Texture("graphics/models/FinalExam/skybox_cp_biodomes_ll.png") );
        Mesh sphere = new Mesh(sphereGeo, sphereMat);
        scene.add(sphere);

        Geometry planeGeo = new PlaneGeometry(100,100, 500,500);
        
        //Create terrain
        Material planeMat = new SplatMaterial(
                new Texture("graphics/images/heightmap2.png"),
                new Texture("graphics/images/lava.png"),
                new Texture("graphics/images/lava.png"),
                new Texture("graphics/images/rock.png"),
                new Texture("graphics/images/grass.png"),
                new Texture("graphics/images/grass.png")
            );

        planeMat.uniforms.get("repeatUV").data = new Vector(7,7);

        Mesh plane = new Mesh(planeGeo, planeMat);
        plane.rotateX(-Math.PI/2, true);

        plane.scale(1, 6, 1, false);
        scene.add(plane);

        //Volcano creations 
        try
        {
            //First Volcano
            Geometry volcanoGeo = new OBJGeometry("graphics/models/FinalExam/Volcano.obj");
            Material volcanoMat = new TextureMaterial(new Texture("graphics/models/FinalExam/VolcanoTexture.png"));

            Mesh Volcano = new Mesh(volcanoGeo, volcanoMat);
            Volcano.setPosition( new Vector(-3, 2.2, -1.3) );
            scene.add(Volcano);

            //Second Volcano
            Geometry volcanoGeoTwo = new OBJGeometry("graphics/models/FinalExam/Volcano.obj");
            Material volcanoMatTwo = new TextureMaterial(new Texture("graphics/models/FinalExam/VolcanoTexture.png"));

            Mesh VolcanoTwo = new Mesh(volcanoGeoTwo, volcanoMatTwo);
            VolcanoTwo.setPosition( new Vector(45, 2.2, -1.3) );
            scene.add(VolcanoTwo);

            VolcanoTwo.scale(0.6, 0.6, 0.6, true); 
            VolcanoTwo.rotateY(90.0, true);

            //Third Volcano
            Geometry volcanoGeoThree = new OBJGeometry("graphics/models/FinalExam/Volcano.obj");
            Material volcanoMatThree = new TextureMaterial(new Texture("graphics/models/FinalExam/VolcanoTexture.png"));

            Mesh VolcanoThree = new Mesh(volcanoGeoThree, volcanoMatThree);
            VolcanoThree.setPosition( new Vector(-32, 2.2, 33) );
            scene.add(VolcanoThree);

            VolcanoThree.scale(0.75, 0.75, 0.75, true); 
            VolcanoThree.rotateY(180.0, true);

            //Fourth Volcano
            Geometry volcanoGeoFour = new OBJGeometry("graphics/models/FinalExam/Volcano.obj");
            Material volcanoMatFour = new TextureMaterial(new Texture("graphics/models/FinalExam/VolcanoTexture.png"));

            Mesh VolcanoFour = new Mesh(volcanoGeoFour, volcanoMatFour);
            VolcanoFour.setPosition( new Vector(-31, 2.2, -33) );
            scene.add(VolcanoFour);

            VolcanoFour.scale(0.69, 0.69, 0.69, true); 
            VolcanoFour.rotateY(270.0, true);

            
            //First Obsidian Rock
            Geometry rockGeoOne = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatOne = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockOne = new Mesh(rockGeoOne, rockMatOne);
            rockOne.setPosition( new Vector(-15, 4, -15) );
            scene.add(rockOne);

            rockOne.scale(0.69, 0.69, 0.69, true); 
            rockOne.rotateY(270.0, true);
            
            
            
            //Second Obsidian Rock
            Geometry rockGeoTwo = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatTwo = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockTwo = new Mesh(rockGeoTwo, rockMatTwo);
            rockTwo.setPosition( new Vector(-4, 2, 25) );
            scene.add(rockTwo);

            rockTwo.scale(1.6, 1.6, 1.6, true); 
            rockTwo.rotateY(90.0, true);
            rockTwo.rotateZ(90.0, true);
            
            
            
            //Third Obsidian Rock
            Geometry rockGeoThree = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatThree = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockThree = new Mesh(rockGeoThree, rockMatThree);
            rockThree.setPosition( new Vector(20, 2.5, 35) );
            scene.add(rockThree);

            rockThree.scale(1.4, 1.4, 1.4, true); 
            rockThree.rotateY(270.0, true);
            rockThree.rotateZ(90.0, true);
            
            
            
            
            //Fourth Obsidian Rock
            Geometry rockGeoFour = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatFour = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockFour = new Mesh(rockGeoFour, rockMatFour);
            rockFour.setPosition( new Vector(0, 2, -33) );
            scene.add(rockFour);

            rockFour.scale(1.4, 1.4, 1.4, true); 
            rockFour.rotateY(120.0, true);
            rockFour.rotateZ(90.0, true);
            
            
            
            
            
            //Fifth Obsidian Rock
            Geometry rockGeoFive = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatFive = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockFive = new Mesh(rockGeoFive, rockMatFive);
            rockFive.setPosition( new Vector(-44, 2, 2) );
            scene.add(rockFive);

            rockFive.scale(1.8, 1.8, 1.8, true); 
            rockFive.rotateY(220.0, true);
            rockFive.rotateZ(90.0, true);
            
            
            
            //Sixth Obsidian Rock
            Geometry rockGeoSix = new OBJGeometry("graphics/models/FinalExam/ObsidianRock.obj");
            Material rockMatSix = new TextureMaterial(new Texture("graphics/models/FinalExam/ObsidianTexture.jpg"));

            Mesh rockSix = new Mesh(rockGeoSix, rockMatSix);
            rockSix.setPosition( new Vector(32, 2, -25) );
            scene.add(rockSix);

            rockSix.scale(2, 2, 2, true); 
            rockSix.rotateY(310.0, true);
            rockSix.rotateZ(90.0, true);
            
            
            
            
            
            /*
            // create a bunch of volcanos at random positions.
            int volcanoCount = 40;
            for (int i = 0; i < volcanoCount; i++)
            {

            // set position to random x,z coordinates; must be at least 25 units
            //   away from the origin; maximum distance 75.
            double radius = 25 + 50 * Math.random();
            double angle  = 6.28 * Math.random();
            double x = radius * Math.cos(angle);
            double z = radius * Math.sin(angle);

            double rotAngle = 6.28 * Math.random();
            Volcano.rotateY( rotAngle, true );

            // random scaling factors, between 0.75 and 1.25
            double sx = 0.75 + 0.50 * Math.random();
            double sy = 0.75 + 0.50 * Math.random();
            double sz = 0.75 + 0.50 * Math.random();
            Volcano.scale(sx, sy, sz, true);

            Volcano.setPosition( new Vector( x, -2, z ) );
            scene.add(Volcano);

            }
             */
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        
        //Add axes under terrain for Volcano debugging
        Mesh XYZaxes = new AxesHelper(2, 8);
        XYZaxes.translate(0, 0.01, 0, true);
        scene.add(XYZaxes);

    }

    public void update()
    {
        rig.update(input, deltaTime);

        renderer.render(scene, camera);
    }
}