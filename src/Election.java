/**
 * Collaboration: (none)
 */

import java.util.Scanner;
import java.io.*;

public class Election {
	public static void main(String[] args) throws FileNotFoundException {
		String mapArea = args[0];
		String mapType = args[1];
		
		File txt = new File(mapArea + ".txt");
		Scanner myScanner = new Scanner(txt);
		
		// set window size
		StdDraw.setCanvasSize(640, 512);
		
		double[] minValues = new double[2];
		double[] maxValues = new double[2];
		
		// get scale
		for (int i = 0; i < 2; i++) {
			minValues[i] = myScanner.nextDouble();
			maxValues[i] = myScanner.nextDouble();
		}
		
		// set scale
		if (mapArea.equals("USA")) {
			StdDraw.setXscale(minValues[0] - 5, maxValues[0] - 90);
			StdDraw.setYscale(minValues[1] + 90, maxValues[1] + 8);
		}
		else if (mapArea.equals("NC")) {
			StdDraw.setXscale(minValues[0] - 0.25, maxValues[0] - 109);
			StdDraw.setYscale(minValues[1] + 109, maxValues[1] + 2);
		}
		else if (mapArea.equals("CA")) {
			StdDraw.setXscale(minValues[0] - 3, maxValues[0] - 146);
			StdDraw.setYscale(minValues[1] + 146, maxValues[1] + 1);
		}

		int numberOfSubRegions = myScanner.nextInt();

		while (myScanner.hasNext())
			drawMap(myScanner, mapType);
	}

	private static void drawMap(Scanner scanner, String style) throws FileNotFoundException {
		String stateName = scanner.next();

		if (stateName.equals("District"))
			stateName += " of Columbia";

		scanner.nextLine();
		int republicanVotes = scanner.nextInt();
		int democratVotes = scanner.nextInt();
		int independentVotes = scanner.nextInt();
		int polygonPoints = scanner.nextInt();

		double[] xValues = new double[polygonPoints];
		double[] yValues = new double[polygonPoints];

		for (int i = 0; i < polygonPoints; i++) {
			xValues[i] = scanner.nextDouble();
			yValues[i] = scanner.nextDouble();
		}

		if (style.equals("White")) {
			StdDraw.polygon(xValues, yValues);
			return;
		}
		else if (style.equals("RedBlue")) {
			if (republicanVotes > democratVotes)
				StdDraw.setPenColor(StdDraw.RED);
			else if (democratVotes > republicanVotes)
				StdDraw.setPenColor(StdDraw.BLUE);
		}
		else if (style.equals("Purple")) {
			StdDraw.setPenColor(getRGBColor("R", republicanVotes, democratVotes, independentVotes), getRGBColor("G", republicanVotes, democratVotes, independentVotes), getRGBColor("B", republicanVotes, democratVotes, independentVotes));
		}
		StdDraw.filledPolygon(xValues, yValues);
	}
	
	private static int getRGBColor(String color, int republicanVotes, int democratVotes, int independentVotes) {
		if (color.equals("R"))
			return republicanVotes * 255 / (republicanVotes + democratVotes + independentVotes);
		else if (color.equals("G"))
			return independentVotes * 255 / (republicanVotes + democratVotes + independentVotes);
		else if (color.equals("B"))
			return democratVotes * 255 / (republicanVotes + democratVotes + independentVotes);
		return 0;
	}
}
