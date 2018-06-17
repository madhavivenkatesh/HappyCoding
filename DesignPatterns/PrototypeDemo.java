package com.practiceprogramming.designpatterns.creational;

import java.util.ArrayList;
import java.util.List;

class Grocery implements Cloneable{

    List<String> grocerylist ;

    public Grocery(){
        this.grocerylist = new ArrayList<String>();
    }

    public Grocery(List<String> grocerylist){
        this.grocerylist = grocerylist;
    }

    public void loadList(){
        this.grocerylist.add("Rice");
        this.grocerylist.add("Vegetables");
        this.grocerylist.add("Fruits");
    }

    public List<String> getGrocerylist(){
        return this.grocerylist;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        List<String> temp = new ArrayList<String>();
        for(String items:this.grocerylist)
            temp.add(items);

        return new Grocery(temp);
    }
}

public class PrototypeDemo {

    public static void main(String[] args){

        Grocery orignalobj = new Grocery();
        orignalobj.loadList();

        Grocery newobj = null;
        try {
            newobj = (Grocery) orignalobj.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        List<String> newlist = newobj.getGrocerylist();
        newlist.add("Oil");
        System.out.println(newobj.getGrocerylist());

    }
}
