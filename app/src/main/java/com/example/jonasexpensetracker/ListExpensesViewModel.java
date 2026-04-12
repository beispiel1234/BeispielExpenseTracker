package com.example.jonasexpensetracker;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class ListExpensesViewModel extends ViewModel {
    private ArrayList<String> expenses=new ArrayList<>();

    public void setExpenses(ArrayList<String> expenses) {
        this.expenses = expenses;
    }
    public ArrayList< String> getExpenses() {
        return expenses;
    }
}

