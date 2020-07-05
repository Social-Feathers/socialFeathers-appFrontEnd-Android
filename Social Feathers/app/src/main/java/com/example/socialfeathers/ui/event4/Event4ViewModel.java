package com.example.socialfeathers.ui.event4;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Event4ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Event4ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Event 4 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}