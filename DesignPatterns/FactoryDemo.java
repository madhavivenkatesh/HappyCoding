package com.practiceprogramming.designpatterns.examples;
/*
@override annotation takes advantage of the compiler checking to make sure you actually are overriding a method when you think you are.
This way, if you make a common mistake of misspelling a method name or not correctly matching the parameters,
you will be warned that you method does not actually override as you think it does.
Secondly, it makes your code easier to understand because it is more obvious when methods are overwritten.
 */

abstract class Vehicle {

    public abstract String getColor();
    public abstract int getVehicleNumber();

    @Override
    public String toString(){
        return this.getColor()+" "+this.getVehicleNumber();
    }
}

class Car extends Vehicle{

    String color;
    int vehiclenum;

    public Car(String color,int vehiclenum){
        this.color = color;
        this.vehiclenum = vehiclenum;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getVehicleNumber() {
        return this.vehiclenum;
    }

}

class Bike extends Vehicle{

    String color;
    int vehiclenum;

    public Bike(String color,int vehiclenum){
        this.color = color;
        this.vehiclenum = vehiclenum;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public int getVehicleNumber() {
        return this.vehiclenum;
    }
}

class VehicleFactory {

    public static Vehicle createVehicle(String type,String color,int num){

        if (type.equalsIgnoreCase("car")){
            return new Car(color,num);
        }else if(type.equalsIgnoreCase("bike")){
            return new Bike(color,num);
        }

        return null;
    }
}


public class FactoryDemo {

    public static void main(String[] args){
        Vehicle carobj = VehicleFactory.createVehicle("car","Brown",1786);
        System.out.println(carobj.toString());

    }
}
