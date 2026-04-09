package com.example.jonasexpensetracker;

public class Model {
    private int income;
private int totalExpenses;
private int currentBalance;


public void addExpenses(int integer){
totalExpenses+=integer;
}
public int getCurrentBalance(){
   return currentBalance-totalExpenses;
}
public int getTotal(){
    return totalExpenses;
}



}
