package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

public class Plane extends Geometry {

	public Plane(Material mat){
		super.setMaterial(mat);
	}
	
	public RaycastResult collide(Ray ray) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getDiffuse(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getAmbient(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	public Color getSpecular(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}

	public Vec3 getNormal(Vec3 point) {
		// TODO Auto-generated method stub
		return null;
	}

}
