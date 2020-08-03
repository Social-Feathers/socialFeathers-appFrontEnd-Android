package com.example.socialfeathers.ui.home;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HomeViewModel extends ViewModel {

    //TODO to be changed
    private MutableLiveData<List<String>> titles;


    public HomeViewModel() {
        List<String> titleList = new ArrayList();
        titleList.add("Title 1 but this is going to be a really long title.");
        titleList.add("Title 2");
        titleList.add("Title 3");
        titleList.add("Title 4");

        titles = new MutableLiveData<>(titleList);
//        mText = new MutableLiveData<>();
//        mText.setValue("This is home fragment");
    }


//    public   LiveData<String> getText() {
//        return mText;
//    }

    public LiveData<List<String>> getTitles(){
        return titles;
    }
}