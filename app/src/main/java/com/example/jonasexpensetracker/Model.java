package com.example.jonasexpensetracker;

public class Model {
    private int income;
private double totalExpenses;



public void addExpenses(double doub){
totalExpenses+=doub;
}
public double getCurrentBalance(double currentBalance){
   return currentBalance-totalExpenses;
}
public double getTotal(){
    return totalExpenses;
}



}
