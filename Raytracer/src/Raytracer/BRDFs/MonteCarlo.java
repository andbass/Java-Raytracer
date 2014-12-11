package Raytracer.BRDFs;

import java.util.Random;

import Raytracer.BasicMaterials.FlatColor;
import Raytracer.BasicMaterials.Material;
import Raytracer.Core.Camera;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Geometry.Geometry;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;
import Raytracer.Math.Vec3;
import Raytracer.MonteMaterials.MonteMaterial;

// Basically, for each point we know is on a surface, cast out a ray to capture
// the incoming light.  You do this for n samples, and then average the result.
// Its a form of Monte Carlo integration.  There's no way in hell you're going
// to calculate all of the incoming light, so just do n number of samples and hope
// you capture enough.  You can also use this to get easy soft shadows, global illumination,
// and more.  This write up will help me, hopefully.
public class MonteCarlo extends BRDF {

	public int numLevels;
	
	public MonteCarlo(int numLevels) { super(FlatColor.BLACK); this.numLevels = numLevels;  }
	
	public MonteCarlo(Material mat) {
		super(mat);

	}

	
	//TODO this whole damn thing
	public Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords) {
		if (!result.hit) return bgMaterial.getDiffuse(screenCoords);
		
		Color finalColor = trace(result, scene, numLevels);
		finalColor.descale(numLevels); // is this correct????
		
		return null;
	}

	private Color trace(RaycastResult result, Scene scene, int depth) {
		if (depth == 0 || !result.hit) return Color.BLACK;
		Geometry object = result.hitObject;
		MonteMaterial mat = (MonteMaterial)object.getMaterial();
		
		
		return null;
	}
	
	private Vec3 randomVecInHemisphere(Vec3 normal){
		Random rand = new Random();
		double u1 = rand.nextDouble(), u2 = rand.nextDouble();
		
		double r = Math.sqrt(u1);
		double theta = 6.28318530718 * u2;
		
		double x = r * Math.cos(theta);
		double y = r * Math.sin(theta);
		double w = Math.sqrt(Math.max(0, 1 - u1));
		
		Vec3 axis = null;
		if (normal.x < normal.y && normal.x < normal.z){
			axis = Vec3.RIGHT;
		} else if (normal.y < normal.z){
			axis = Vec3.UP;
		} else {
			axis = Vec3.FORWARD;
		}
		
		Vec3 xAxis = normal.cross(axis).normalize();
		Vec3 yAxis = normal.cross(xAxis);
		
		return xAxis.scale(x).add(yAxis.scale(y)).add(normal.scale(w));
	}

}
