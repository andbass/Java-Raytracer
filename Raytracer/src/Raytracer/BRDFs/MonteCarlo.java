package Raytracer.BRDFs;

import Raytracer.Core.Camera;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Materials.FlatColor;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;

public class MonteCarlo extends BRDF {

	public MonteCarlo() { super(FlatColor.BLACK); }
	
	public MonteCarlo(Material mat) {
		super(mat);

	}

	public Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords) {
		// TODO Auto-generated method stub
		return null;
	}

}
