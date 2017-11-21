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
    
    private int x,y;
    private int height;
    private double boundingBoxArea;
    
    private static int maxIndex;
    private static double maxArea;
    
    public int getX() {
        return x;
    }
    
    public int getY() {
        return y;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getMaxIndex() {
        return maxIndex;
    }
    
    public double getMaxArea() {
        return maxArea;
    }
    
    private Shape(int x, int y, int height, double boundingBoxArea) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.boundingBoxArea = boundingBoxArea;
    }
    
    public Shape makeShape(int x, int y, int height) {
        
        
        
        return new Shape(x,y,height,boundingBoxArea);   
    }
    
    public double calculateBBArea(int height) {
        return 0.0;
    }
}
