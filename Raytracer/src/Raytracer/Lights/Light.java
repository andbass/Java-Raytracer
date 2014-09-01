package Raytracer.Lights;

import Raytracer.Math.*;

public interface Light {
	
	public abstract Color 	getAmbient();
	public abstract Color 	getDiffuse();
	public abstract Color 	getSpecular();

	public abstract Vec3  	getDir(Vec3 point);
	public abstract Vec3 	getPos();

}
