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
public class Shape {
    
    private Symbols symbol;
    private int x,y;
    private int size;
    private double boundingBoxArea;
    
    private static int index = 0;
    private static int maxIndex;
    private static double maxArea = 0;
    
    public int getSize() {
        return size;
    }
    
    public static int getMaxIndex() {
        return maxIndex;
    }
    
    public static double getMaxArea() {
        return maxArea;
    }
    
    public void setMaxArea(double max) {
        maxArea = max;
    }
    
    public void setMaxIndex(int index) {
        maxIndex = index;
    }
   
    
    Shape(int x, int y, int size, double boundingBoxArea) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.boundingBoxArea = boundingBoxArea;
        Shape.index++;
        if (boundingBoxArea > getMaxArea()) {
            setMaxArea(boundingBoxArea);
            setMaxIndex(index);
        }
    }
}
