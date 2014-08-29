package Raytracer.Shaders;

import Raytracer.RaycastResult;
import Raytracer.Scene;
import Raytracer.Math.Color;

public interface Shader {
	public Color shade(Scene scene, RaycastResult result, double x, double y);
}
