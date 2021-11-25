/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author:
 *
 *************************************************************************/

public class Sierpinski {

static final double rootThree = (Math.sqrt(3)/2);

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
        return (rootThree) *length;
	// WRITE YOUR CODE HERE
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double [] xcor = {x, x+(length/2), x-(length/2)};
        double height = height(length);
        double [] ycor = {y, y +height, y+ height};
        StdDraw.filledPolygon(xcor, ycor);
	// WRITE YOUR CODE HERE
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if(n <= 1)
        {
            filledTriangle(x, y, length);
        }
        else{

            filledTriangle(x, y, length);
            sierpinski(n-1, x - (length/2), y, length/2);
            sierpinski(n-1, x + (length/2), y, length/2);
            sierpinski(n-1, x, y + height(length) , length/2);
        }
	// WRITE YOUR CODE HERE
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        double [] x = {0, 1, 0.5};
        double [] y = {0,0, height(1)};
        StdDraw.polygon(x, y);
        sierpinski(n, 0.5, 0, 0.5);
	// WRITE YOUR CODE HERE 
    }
}
