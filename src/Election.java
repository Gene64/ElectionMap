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
	  
	
    double[] minValues = new double[2];
    double[] maxValues = new double[2];

    for (int i = 0; i < 2; i++) {
    	minValues[i] = myScanner.nextDouble();
    	maxValues[i] = myScanner.nextDouble();
    }
    
    // set scale
    StdDraw.setXscale(minValues[0], maxValues[0]);
    StdDraw.setYscale(minValues[1], maxValues[1]);
    
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
	  
	  if (style.equals("RedBlue")) {
		  // TODO: Add RedBlue functions
	  }
	  else if (style.equals("Purple")) {
		  // TODO: Add Purple functions
	  }
	    
	  StdDraw.filledPolygon(xValues, yValues);
  }
  
  public static void drawNC() {
	  // TODO: Implement this
  }
  
  public static void drawCA() {
	  // TODO: Implement this
  }
}