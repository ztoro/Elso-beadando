/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape;

/**
 *
 * @author bhuztoro
 */
public class Triangle extends Shape {
    
    public Triangle(int x, int y, int side) {
        super(x,y,side,calculateBBArea(side));
    }
    
    private static double calculateBBArea(int side) {
        double area;
        area = side*side;
        return area;
    }
}
