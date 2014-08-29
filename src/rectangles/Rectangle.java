package rectangles;

public class Rectangle {
	private	double x_1, x_2;
	private	double y_1, y_2;
	
	public Rectangle(double x_1, double y_1, double x_2, double y_2) {
		this.x_1=x_1;
		this.y_1=y_1;
		this.x_2=x_2;
		this.y_2=y_2;
	}
	
	public double getCenterX(){
		return (x_1+x_2)/2;
	}
	
	public double getCenterY(){
		return (y_1+y_2)/2;
	}
}
