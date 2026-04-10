package com.example.jonasexpensetracker;

public class Model {
private double totalExpenses;

private double inputExpense;



public void addExpenses(double doub){
    inputExpense=doub;
totalExpenses+=doub;
}
public double getCurrentBalance(double currentBalance){
   return currentBalance-inputExpense;
}
public double getTotal(){
    return totalExpenses;
}



}
