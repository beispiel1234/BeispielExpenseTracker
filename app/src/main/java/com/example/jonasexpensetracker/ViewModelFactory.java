package com.example.jonasexpensetracker;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class ViewModelFactory implements ViewModelProvider.Factory {

    public ViewModelFactory(){
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass){
        if(!modelClass.isAssignableFrom(MainViewModel.class)) {
            throw new IllegalArgumentException("Unknown ViewModelClass");
        }
        else{
            Model model=new Model();
            return (T) new MainViewModel(model);
        }
    }
}
