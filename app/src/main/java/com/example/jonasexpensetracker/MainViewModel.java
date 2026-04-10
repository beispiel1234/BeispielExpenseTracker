package com.example.jonasexpensetracker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

  private final Model model;
    private final MutableLiveData<Double> monthlyIncomeLiveData = new MutableLiveData<>(0.0);
    private final MutableLiveData<Double>totalExpenseLiveData=new MutableLiveData<>(0.0);
    private final MutableLiveData<Double>currentBalanceLiveData=new MutableLiveData<>(0.0);
    double inputNewExpense;
    public MainViewModel(Model model){
        super();
        this.model=model;
    }

    public void setMonthlyIncome(double doub){
        monthlyIncomeLiveData.setValue(doub);
    }


    public LiveData<Double>getMonthlyIncome(){
        return monthlyIncomeLiveData;
    }
    public LiveData<Double> getTotalExpense(){
        return totalExpenseLiveData;
    }
    public LiveData<Double>getCurrentBalance(){
        return currentBalanceLiveData;
    }

    public void getTotalExpenseFromModel(double amount){
        model.addExpenses(amount);
        totalExpenseLiveData.setValue(model.getTotal());
    }
    public void setCurrentBalanceLiveDataInitially(){
        currentBalanceLiveData.setValue(monthlyIncomeLiveData.getValue());
    }
    public void getCurrentBalanceFromModel(){
        currentBalanceLiveData.setValue(model.getCurrentBalance(currentBalanceLiveData.getValue()));
    }


    public void onInputAmountChanged(String string){
        if(!string.equals("")) {
            this.inputNewExpense = Double.parseDouble(string);
        }
    }
    public double getInputAmount(){
        return  inputNewExpense;
    }


}
