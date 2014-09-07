package Raytracer.Geometry;

import Raytracer.Core.Ray;
import Raytracer.Core.RaycastResult;
import Raytracer.Materials.Material;
import Raytracer.Math.Color;
import Raytracer.Math.Vec3;

import java.io.Serializable;

public class Triangle extends Geometry implements Serializable {

	private Vec3 a, b, c;
	private Vec3 normal;

	public Triangle(Vec3 a, Vec3 b, Vec3 c, Material mat){
		super(mat);
		
		setVertices(a, b, c);
	}
	
	public void setVertices(Vec3 a, Vec3 b, Vec3 c) {
		this.a = a;  this.b = b;  this.c = c;
		
		Vec3 bToA = b.sub(a);
		Vec3 bToC = b.sub(c);
		
		this.normal = bToA.cross(bToC).normalize();

	}

	public RaycastResult collide(Ray ray) {
		return null;
	}

	public Color getDiffuse(Vec3 point) {

		return null;
	}

	public Color getAmbient(Vec3 point) {

		return null;
	}

	public Color getSpecular(Vec3 point) {

		return null;
	}

	public Vec3 getNormal(Vec3 point) {
		return normal;
	}

}
