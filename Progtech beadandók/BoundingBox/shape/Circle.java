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
public class Circle extends Shape {
    
    public Circle(int x, int y, int radius) {
        super(x,y,radius,calculateBBArea(radius));
    }
    
    private static double calculateBBArea(int radius) {
        double area;
        area = Math.pow(radius*2, 2);
        return area;
    }
}
