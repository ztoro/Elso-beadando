/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shape.shapes;

/**
 *
 * @author bhuztoro
 */
public class Circle extends shape.Shape {
    super();
    
    @Override
    public double calculateBBArea(int height) {
        double area;
        area = height*height;
        return area;
    }
}
