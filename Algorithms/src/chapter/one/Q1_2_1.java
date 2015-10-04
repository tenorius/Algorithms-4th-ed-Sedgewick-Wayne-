package chapter.one;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdRandom;

public class Q1_2_1 {

	public static void main(String[] args) {

		int x0 = Integer.parseInt(args[0]);
		int y0 = Integer.parseInt(args[1]);
		int N = Integer.parseInt(args[2]);

		StdDraw.setCanvasSize(800, 800);
		StdDraw.setXscale(0, 100);
		StdDraw.setYscale(0, 100);
		StdDraw.setPenRadius(.005);
		List<Point2D> points = new ArrayList<Point2D>();
		for (int i = 0; i < N; i++) {
			int x = StdRandom.uniform(100);
			int y = StdRandom.uniform(100);
			points.add(new Point2D(x, y));
			points.get(i).draw();
		}

		double start = System.currentTimeMillis();

		double minDist = Double.POSITIVE_INFINITY;

		Point2D[] pair = new Point2D[2];
		while(points.size()>1){
			Point2D p = points.remove(0);
			for(Point2D point: points){
				double distance = p.distanceTo(point);
				if (distance < minDist) {
					minDist = distance;
					pair[0] = p;
					pair[1] = point;
				}
			}
		}
		
		
		double end = System.currentTimeMillis();
		
		double time = end - start;
		
		StdDraw.text(60, 60, ""+time);

		StdDraw.setPenRadius();
		StdDraw.setPenColor(StdDraw.BLUE);
		pair[0].drawTo(pair[1]);
		
//		// draw p = (x0, x1) in red
//		Point2D p = new Point2D(x0, y0);
//		StdDraw.setPenColor(StdDraw.RED);
//		StdDraw.setPenRadius(.02);
//		p.draw();
//
//		// draw line segments from p to each point, one at a time, in polar
//		// order
//		StdDraw.setPenRadius();
//		StdDraw.setPenColor(StdDraw.BLUE);
//		Arrays.sort(points, p.polarOrder());
//		for (int i = 0; i < N; i++) {
//			p.drawTo(points[i]);
//			StdDraw.show(100);
//		}
	}

}
