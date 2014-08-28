package Raytracer.Math;

/*
 * Class represents a quadratic equation.  Provide three coefficents to the constructor and
 * the class will attempt to solve the quadratic formula using those three coefficents for a single variable.
 * 
 * A quadratic equation takes the form: Ax^2 + Bx + C = 0
 * 
 * If the discriminant (b^2 - 4*a*c) is negative, the solvable field will be false
 */
public class QuadraticEquation {
	private boolean solvable;
	private double a, b, c;
	private double root1; // if we add the discrimant
	private double root2; // if we subract the discrimant
	
	public QuadraticEquation(double a, double b, double c){
		this.a = a;  this.b = b;  this.c = c;
		solve();
	}
	
	private void solve(){
		double b = -this.b;
		
		double disc = b*b - 4*a*c;

		if (disc < 0) {
			solvable = false;
			root1 = 0;  
			root2 = 0;
			return;
		}
		
		solvable = true;
		disc = Math.sqrt(disc);
		double a = 2*this.a;
		this.root1 = (b + disc)/a;
		this.root2 = (b - disc)/a;
	}
	
	public double getFirstRoot(){
		return root1;
	}
	
	public double getSecondRoot(){
		return root2;
	}
	
	public boolean isSolvable(){
		return solvable;
	}
}
