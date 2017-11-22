/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.util.Scanner;

import shape.*;

/**
 *
 * @author bhuztoro
 */
public class Main {
    
    public static void read(String fileName) throws FileNotFoundException {
        Scanner sc = new Scanner(new BufferedReader(new FileReader(fileName)));
       
        int i=0;
        try {
            i = Integer.parseInt(sc.nextLine());
        } catch (Exception e) {
            System.out.println("Az első sorban számnak kell lennie!");
            System.exit(-1);
        }
        
        String line;
        
        int counter = 0;
        while(sc.hasNext() && counter < i) {
            line = sc.nextLine();
            if (test(line) == true) {
                String[] t = line.split(",");
                int x = Integer.parseInt(t[1]);
                int y = Integer.parseInt(t[2]);
                int size = Integer.parseInt(t[3]);
                if (t[0].equals("C")) {
                    Circle circle = new Circle(x,y,size);
                } else if (t[0].equals("T")) {
                    Triangle triangle = new Triangle(x,y,size);
                } else if (t[0].equals("S")) {
                    Square square = new Square(x,y,size);
                } else if (t[0].equals("H")) {
                    Hexagon hexagon = new Hexagon(x,y,size);
                }
            } else {
                System.out.println("Hibás sor száma: " + counter);
                counter++;
                continue;
            }
            counter++;
        }   
    }
    
    
    public static boolean test(String s) {
        String[] t = s.split(",");
        if (t.length != 4) {
            return false;
        }
        
        Symbols symbol;
        try {
            symbol = Symbols.valueOf(t[0]);
        } catch (Exception e) {
            return false;
        }

        try {
            int x = Integer.parseInt(t[1]);
        } catch (Exception e) {
            return false;
        }

        try {
            int y = Integer.parseInt(t[2]);
        } catch (Exception e) {
            return false;
        }
        
        try {
            int size = Integer.parseInt(t[3]);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("No input file set");
            System.exit(-1);
        }
        
        String inputFile = args[0];
        
        try {
            read(inputFile);
            System.out.println("A legnagyobb befoglaló téglalap sorszáma " + Shape.getMaxIndex() + " és területe " + Shape.getMaxArea());
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
            System.exit(-1);
        }
    }
    
}
