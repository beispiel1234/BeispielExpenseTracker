package com.example.jonasexpensetracker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

  private final Model model;
    private final MutableLiveData<Integer>monthlyIncomeLiveData=new MutableLiveData<>(0);
    private final MutableLiveData<Integer>totalExpenseLiveData=new MutableLiveData<>(0);
    private final MutableLiveData<Integer>currentBalanceLiveData=new MutableLiveData<>(0);

    int inputNewExpense;
    public MainViewModel(Model model){
        super();
        this.model=model;
    }

    public LiveData<Integer>getMonthlyIncome(){
        return monthlyIncomeLiveData;
    }
    public LiveData<Integer> getTotalExpense(){
        return totalExpenseLiveData;
    }
    public LiveData<Integer>getCurrentBalance(){
        return currentBalanceLiveData;
    }

    public void getTotalExpenseFromModel(int amount){
        model.addExpenses(amount);
        totalExpenseLiveData.setValue(model.getTotal());
    }
    public void getCurrentBalanceFromModel(){
        currentBalanceLiveData.setValue(model.getCurrentBalance());
    }


    public void onInputAmountChanged(String string){
        if(!string.equals("")) {
            this.inputNewExpense = Integer.parseInt(string);
        }
    }
    public int getInputAmount(){
        return  inputNewExpense;
    }


}
