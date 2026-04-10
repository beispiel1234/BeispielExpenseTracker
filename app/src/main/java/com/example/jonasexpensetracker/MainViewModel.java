package com.example.jonasexpensetracker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.math.BigDecimal;

public class MainViewModel extends ViewModel {

  private final Model model;
    private final MutableLiveData<BigDecimal> monthlyIncomeLiveData = new MutableLiveData<>(new BigDecimal("0.00"));
    private final MutableLiveData<BigDecimal>totalExpenseLiveData=new MutableLiveData<>(new BigDecimal("0.00"));
    private final MutableLiveData<BigDecimal>currentBalanceLiveData=new MutableLiveData<>(new BigDecimal("0.00"));
    BigDecimal inputNewExpense;
    public MainViewModel(Model model){
        super();
        this.model=model;
    }

    public void setMonthlyIncome(BigDecimal bigdecimal){
        monthlyIncomeLiveData.setValue(bigdecimal);
    }


    public LiveData<BigDecimal>getMonthlyIncome(){
        return monthlyIncomeLiveData;
    }
    public LiveData<BigDecimal> getTotalExpense(){
        return totalExpenseLiveData;
    }
    public LiveData<BigDecimal>getCurrentBalance(){
        return currentBalanceLiveData;
    }

    public void getTotalExpenseFromModel(BigDecimal amount){
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
            this.inputNewExpense = BigDecimal.valueOf(Double.parseDouble(string));
        }
    }
    public BigDecimal getInputAmount(){
        return  inputNewExpense;
    }


}
