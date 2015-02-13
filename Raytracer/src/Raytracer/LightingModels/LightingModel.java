package Raytracer.LightingModels;

import Raytracer.Core.Camera;
import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Core.Scene;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec2;

public abstract class LightingModel {
	
	protected Material bgMaterial;
	
	public LightingModel(Material mat){
		setBGMaterial(mat);
	}
	
	public abstract Color getColor(RaycastResult result, Scene scene, Camera camera, Vec2 screenCoords);

	public void setBGMaterial(Material mat) { bgMaterial = mat; }
	
	protected Material getBGMaterial(){
		return bgMaterial;
	}
}
