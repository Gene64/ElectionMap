import java.util.Scanner;
import java.io.*;

public class Election {
  public static void main(String[] args) throws FileNotFoundException {
    
	File txt = new File("USA.txt");
	Scanner myScanner = new Scanner(txt);
    
    double[] minValues = new double[2];
    double[] maxValues = new double[2];

    for (int i = 0; i < 2; i++) {
      maxValues[i] = myScanner.nextDouble();
      minValues[i] = myScanner.nextDouble();
    }
    
    // set scale
    StdDraw.setXscale(minValues[0], maxValues[0]);
    StdDraw.setYscale(minValues[1], maxValues[1]);
    
    //double[] xValues = {0.9, 0.5, 0.1, 0.5};
    //double[] yValues = {0.5, 0.9, 0.5, 0.1};
    //StdDraw.setPenColor(StdDraw.BLUE);
    //StdDraw.filledPolygon(xValues, yValues);
    
    int numberOfSubRegions = myScanner.nextInt();
    System.out.println("debug");
    
    while (myScanner.hasNext())
    	drawUSA(myScanner);
  }
  
  public static void drawUSA(Scanner scanner) throws FileNotFoundException {
	  File txt = new File("USA.txt");
	  //Scanner myScanner = new Scanner(txt);
	  System.out.println("debug1");
	  String stateName = scanner.next();
	  if (stateName.equals("District"))
		  stateName = "Disctruct of Columbia";
	  scanner.nextLine();
	  System.out.println("debug3: " + stateName);
	  int republicanVotes = scanner.nextInt();
	  int democratVotes = scanner.nextInt();
	  int independentVotes = scanner.nextInt();
	  System.out.println("debug2");
	  int polygonPoints = scanner.nextInt();
	    
	  System.out.println(polygonPoints);
	    
	  double[] xValues = new double[polygonPoints];
	  double[] yValues = new double[polygonPoints];
	    
	  for (int i = 0; i < polygonPoints; i++) {
		  xValues[i] = scanner.nextDouble();
		  yValues[i] = scanner.nextDouble();
	    }
	    
	  StdDraw.filledPolygon(xValues, yValues);
  }
}