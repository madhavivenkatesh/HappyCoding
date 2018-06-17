package com.practiceprogramming.designpatterns.creational;
/*
First of all you need to create a static nested class and then copy all the arguments from the outer class to the
Builder class. We should follow the naming convention and if the class name is Computer then builder class should
be named as ComputerBuilder.
Java Builder class should have a public constructor with all the required attributes as parameters.
Java Builder class should have methods to set the optional parameters and it should return the same Builder
object after setting the optional attribute.
The final step is to provide a build() method in the builder class that will return the Object
needed by client program. For this we need to have a private constructor in the Class with Builder class as argument.
 */

class Employee {
    //Mandatory params
    private int empId;
    private String empName;
    private String title; //Optional params

    public int getEmpId() {
        return empId;
    }

    public String getEmpName() {
        return empName;
    }

    public String getTitle() {
        return title;
    }

    private Employee(EmployeeConstructHelper e){
        this.empId = e.empId;
        this.empName = e.empName;
        this.title = e.title;
    }

    public static class EmployeeConstructHelper{

        private int empId;
        private String empName;
        private String title; //Optional params

        public EmployeeConstructHelper(int empId,String empName){
            this.empId = empId;
            this.empName = empName;
        }

        public EmployeeConstructHelper setTitle(String title){
            this.title = title;
            return this;
        }

        public Employee build(){
            return new Employee(this);
        }
    }
}

public class BuilderDemo {

    public static void main(String[] args){
        Employee emp1;
        emp1 = new Employee.EmployeeConstructHelper(123,"Rose Lilly").build();

        System.out.println(emp1.getEmpId()+" "+emp1.getEmpName());

    }
}
