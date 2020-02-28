package com.wd.room.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListValueViewModel extends ViewModel {
    private MutableLiveData<String> name = new MutableLiveData<>();

    public MutableLiveData<String> getName() {
        return name;
    }

    public void setName(String str) {
        this.name.setValue(str);
    }
}
