package com.practiceprogramming.designpatterns.examples;

class Singleton {

    private Singleton(){};

    //Untill the getInstance method is called this static inner class will not be loaded
    private static class SingletonHelper{
        private static final Singleton instance = new Singleton();
    }
    public static Singleton getInstance(){
        return SingletonHelper.instance;
    }
}
public class SingletonDemo {

    public static void main(String[] args){
        //new cannot be used to create object since Singleton class has private constructor
        Singleton firstinstance = Singleton.getInstance();
        System.out.println(firstinstance.hashCode());

        Singleton secondinstance = Singleton.getInstance();
        System.out.println(secondinstance.hashCode());

        //Both Objects will have same hashcode (both objects are same) 42121758
    }
}
