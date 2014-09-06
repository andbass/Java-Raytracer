package Raytracer.Lights;

import Raytracer.Math.*;

public interface Light {
	
	public abstract Color 	getAmbient();
	public abstract Color 	getDiffuse();
	public abstract Color 	getSpecular();

	public abstract Vec3  	getDirToLight(Vec3 point);

	public abstract double 	getLambertTerm(Vec3 normal, Vec3 pointToLight);
	
}
