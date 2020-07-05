package com.example.socialfeathers.ui.event5;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class Event5ViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public Event5ViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Event 5 fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}