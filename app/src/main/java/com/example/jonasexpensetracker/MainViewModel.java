package com.example.jonasexpensetracker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

  private final Model model;
    private final MutableLiveData<Integer>totalAmountLiveData=new MutableLiveData<>(0);
    private int currentTotal=0;
    int currentAmountSpend;
    int inputAmount;
    int monthlyAmountSpend;
    public MainViewModel(Model model){
        super();
        this.model=model;
    }

    public LiveData<Integer> getTotalAmount(){
        return totalAmountLiveData;
    }
    public void addExpense(int amount){
        model.add(amount);
        int total=model.getTotal();
        totalAmountLiveData.setValue(total);
    }

    public void onInputAmountChanged(String string){
        if(!string.equals("")) {
            this.inputAmount = Integer.parseInt(string);
        }
    }
    public int getInputAmount(){
        return  inputAmount;
    }


}
