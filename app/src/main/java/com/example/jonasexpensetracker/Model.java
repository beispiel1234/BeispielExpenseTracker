package com.example.jonasexpensetracker;

import java.math.BigDecimal;

public class Model {
private BigDecimal totalExpenses=new BigDecimal(0);

private BigDecimal inputExpense=new BigDecimal(0);



public void addExpenses(BigDecimal bigDecimal){
    inputExpense=bigDecimal;
    totalExpenses=totalExpenses.add(bigDecimal);
}
public BigDecimal getCurrentBalance(BigDecimal currentBalance){
   return currentBalance.subtract(inputExpense);
}
public BigDecimal getTotal(){
    return totalExpenses;
}



}
