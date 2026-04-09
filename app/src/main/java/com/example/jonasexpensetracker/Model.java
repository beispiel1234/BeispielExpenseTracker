package com.example.jonasexpensetracker;

public class Model {
    private int income;
private double totalExpenses;
private int currentBalance;


public void addExpenses(double doub){
totalExpenses+=doub;
}
public double getCurrentBalance(){
   return currentBalance-totalExpenses;
}
public double getTotal(){
    return totalExpenses;
}



}
