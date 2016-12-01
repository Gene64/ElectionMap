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
    
    int numberOfSubRegions = myScanner.nextInt();
    
    while (myScanner.hasNext())
    	drawUSA(myScanner);
  }
  
  public static void drawUSA(Scanner scanner) throws FileNotFoundException {
	  System.out.println("debug1");
	  String stateName = scanner.next();
	  
	  if (stateName.equals("District"))
		  stateName += " of Columbia";
	  
	  scanner.nextLine();
	  int republicanVotes = scanner.nextInt();
	  int democratVotes = scanner.nextInt();
	  int independentVotes = scanner.nextInt();
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