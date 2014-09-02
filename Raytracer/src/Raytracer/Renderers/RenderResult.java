package Raytracer.Renderers;

import Raytracer.Math.Color;

/**
 * A class returned by RenderTask.  Contains an array of colors and the 
 * row of the image they correspond to. Use this to apply the RenderTask's results
 * to an image.
 */
public class RenderResult {

	public Color[] rowColors;
	public int row;
	
	public RenderResult(int row, Color[] rowColors){
		
	}
}
