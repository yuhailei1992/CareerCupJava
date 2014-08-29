package rectangles;

public class Line {
	double slope;
	double intercept;
	public Line (double k, double delta) {
		this.slope = k;
		this.intercept = delta;
	}
	
	public static boolean isEqual(double x, double y) {
		double epsilon = Math.max(Math.abs(x), Math.abs(y)) * 1E-15;
		return Math.abs(x-y) <= epsilon;
	}
	
	public Line getLine(Point a, Point b) {
		if (isEqual(a.getX(), b.getX()) && isEqual (a.getY(), b.getY())) {
			return null;//two points are the same
		}
		else if (isEqual(a.getX(), b.getX())) {
			return null;//the line is vertical
		}
		else {
			double k = (b.getY() - a.getY())/(b.getX() - a.getX());
			double delta = b.getY() - b.getX() * k;
			Line line1 = new Line(k, delta);
			return line1;
		}
	}
	
}
