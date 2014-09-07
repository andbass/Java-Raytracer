package Raytracer.BRDFs;

import Raytracer.Core.Camera;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;

import java.io.Serializable;

public abstract class BRDF {
	
	protected Material bgMaterial;
	
	public BRDF(Material mat){
		setBGMaterial(mat);
	}
	
	public abstract Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords);

	public void setBGMaterial(Material mat) { bgMaterial = mat; }
	
	protected Material getBGMaterial(){
		return bgMaterial;
	}
}
