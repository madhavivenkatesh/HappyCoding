package com.practiceprogramming.designpatterns.structural;
/*
Composite pattern is used to represent whole part relationship. java.awt.container addcomponent method is an example of
this pattern.*/

import java.util.ArrayList;
import java.util.List;

interface Shape{
  public void draw(String fillcolor);
}

class Square implements Shape{
    @Override
    public void draw(String fillcolor){
        System.out.println("Drawing Square and filling "+fillcolor);
    }
}

class Circle implements Shape{
    @Override
    public void draw(String fillcolor) {
       System.out.println("Drawing Circle and filling "+fillcolor);
    }
}

class Drawing implements Shape{

    List<Shape> shapesList = new ArrayList<>();

    @Override
    public void draw(String fillcolor){
        for(Shape s:shapesList)
            s.draw(fillcolor);
    }

    public void addShape(Shape newShape){
        shapesList.add(newShape);
    }

    public List<Shape> getShapesList(){
        return shapesList;
    }
}
public class Composite {
    public static void main(String[] args){
        Shape sqr1 = new Square();
        Shape circ1 = new Circle();

        Drawing draw1 = new Drawing();
        draw1.addShape(sqr1);
        draw1.addShape(circ1);

        draw1.draw("Red");

    }
}
