import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import rectangles.Rectangle;
import rectangles.Point;

public class CC7 {
	public static void CC7_5(){
		Rectangle rec1 = new Rectangle(3, 4, 7, 1);
		Rectangle rec2 = new Rectangle(6, 7, 12, 1);
		if (rec1.getCenterX() == rec2.getCenterX() && 
				rec1.getCenterY() == rec2.getCenterY()){
			System.out.println ("The two rectangles have same center");
		}
		else if (rec1.getCenterX() == rec2.getCenterX()) {
			System.out.println ("The line is perpendicular to x-axis");
		}
		else {
			double slope = (rec2.getCenterY() - rec1.getCenterY())/
					(rec2.getCenterX() - rec1.getCenterX());
			double intercept = rec2.getCenterY() - slope * rec2.getCenterX();
			System.out.println ("The line can be described as: ");
			System.out.println ("y=" + slope + " * x + " + intercept);
		}
	}
	
	public static void CC7_6() {
		Point p1 = new Point(3, 4);
		Point p2 = new Point(4, 5);
		Point p3 = new Point(5, 6);
		Point p4 = new Point(6, 7);
		Point p5 = new Point(4, 3);
		Point p6 = new Point(3, 3);
		List I = new ArrayList();
		I.add(p1);
		I.add(p2);
		I.add(p3);
		I.add(p4);
		I.add(p5);
		I.add(p6);
		double[][] mat = new double[6][6];
		
		for (Iterator iter = I.iterator(); iter.hasNext();) {
			
		}
	}
}
