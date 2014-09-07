package Raytracer.Math;

import java.io.Serializable;

public class Color implements Serializable {

	public static final Color RED = new Color(220, 0, 0);
	public static final Color GREEN = new Color(0, 220, 0);
	public static final Color BLUE = new Color(0, 0, 220);
	public static final Color DARK_BLUE = new Color(0, 30, 65);
	public static final Color YELLOW = new Color(220, 220, 0);
	public static final Color ORANGE = new Color(175, 95, 0);
	public static final Color MAGNETA = new Color(220, 0, 200);
	public static final Color WHITE = new Color(255, 255, 255);
	public static final Color GREY = new Color(128, 128, 128);
	public static final Color LIGHT_GREY = new Color(200, 200, 200);
	public static final Color DARK_GREY = new Color(64, 64, 64);
	public static final Color BLACK = new Color(0, 0, 0);
	public static final Color OFF_WHITE = new Color(210, 200, 190);

	public double r, g, b;

	public Color(double r, double g, double b) {
		this.r = r;
		this.g = g;
		this.b = b;
	}

	public Color(String hex) {
		this(Integer.valueOf(hex.substring(1, 3), 16),
			 Integer.valueOf(hex.substring(3, 5), 16),
			 Integer.valueOf(hex.substring(5, 7), 16));
	}

	public Color(int rgb){
		double r = (rgb >> 16) & 0xFF;
		double g = (rgb >> 8) & 0xFF;
		double b = rgb & 0xFF;
		
		this.r = r;  this.g = g;  this.b = b;
	}
	
	public Color(int[] rgbArray){
		this(rgbArray[0], rgbArray[1], rgbArray[2]);
	}
	
	public Color(java.awt.Color color) {
		this.r = color.getRed();
		this.g = color.getGreen();
		this.b = color.getBlue();
	}

	public Color add(Color color) {
		return new Color(this.r + color.r, this.g + color.g, this.b + color.b);
	}

	public Color sub(Color color) {
		return new Color(this.r - color.r, this.g - color.g, this.b - color.b);
	}

	public Color scale(double number) {
		return new Color(r * number, g * number, b * number);
	}

	public Color descale(double number) {
		return new Color(r / number, g / number, b / number);
	}

	public Color mul(Color col) {
		return new Color(this.r * col.r, this.g * col.g, this.b * col.b);
	}

	public Color div(Color col) {
		return new Color(r / col.r, g / col.g, b / col.b);
	}

	/**
	 * Returns a color with every r, g, and b value limited to 0 - 255
	 */
	public Color restrictRange() {
		double r = Math.min(Math.max(this.r, 0), 255);
		double g = Math.min(Math.max(this.g, 0), 255);
		double b = Math.min(Math.max(this.b, 0), 255);
		return new Color(r, g, b);
	}

	public int getRGB() {
		int r = Math.min(255, Math.max((int) this.r, 0));
		int g = Math.min(255, Math.max((int) this.g, 0));
		int b = Math.min(255, Math.max((int) this.b, 0));
		return ((int) r << 16) | ((int) g << 8) | (int) b;
	}

	public java.awt.Color toAwtColor() {
		Color restrictedColor = this.restrictRange();
		return new java.awt.Color((int) restrictedColor.r, (int) restrictedColor.g, (int) restrictedColor.b);
	}

	public String toString() {
		return "(" + r + ',' + g + ',' + b + ')';
	}

}
