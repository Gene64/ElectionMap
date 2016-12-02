/**
 * Collaboration: (none)
 */

import java.util.Scanner;
import java.io.*;

public class Election {
	public static void main(String[] args) throws FileNotFoundException {
		String mapType = args[0];
		String mapColor = args[1];
		
		File txt = new File(mapType + ".txt");
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
		StdDraw.setXscale(minValues[0] - 5, maxValues[0] - 90);
		StdDraw.setYscale(minValues[1] + 90, maxValues[1] + 8);

		int numberOfSubRegions = myScanner.nextInt();

		if (mapType.equals("USA")) {
			while (myScanner.hasNext())
				drawUSA(myScanner, mapColor);
		}
		else if (mapType.equals("NC")) {
			drawNC();
		}
		else if (mapType.equals("CA")) {
			drawCA();
		}
	}

	public static void drawUSA(Scanner scanner, String style) throws FileNotFoundException {
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
		}
		else if (style.equals("RedBlue")) {
			// TODO: Add RedBlue functions
		}
		else if (style.equals("Purple")) {
			// TODO: Add Purple functions
		}
	}

	public static void drawNC() {
		// TODO: Implement this
	}

	public static void drawCA() {
		// TODO: Implement this
	}
}