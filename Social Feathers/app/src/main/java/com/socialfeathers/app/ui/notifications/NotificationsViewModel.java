package com.socialfeathers.app.ui.notifications;

import com.socialfeathers.app.ui.home.CauseData;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NotificationsViewModel extends ViewModel {

    //TODO to be changed
    private MutableLiveData<List<NotificationsData>> titles;

    // ToDo: del
    String tempDets = "Shakespeare produced most of his known works between 1589 and 1613.";
    String tempDetsLong = "Shakespeare produced most of his known works between 1589 and 1613. His early plays were primarily comedies and histories and are regarded as some of the best work produced in these genres.";

    public NotificationsViewModel() {
        List<NotificationsData> titleList = new ArrayList();
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_2", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_2", "pic_3"));
        titleList.add(new NotificationsData(tempDetsLong, "pic_4", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDetsLong, "pic_2", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_2", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDetsLong, "pic_2", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_2", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_2", "pic_1"));
        titleList.add(new NotificationsData(tempDetsLong, "pic_2", "pic_3"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_1"));
        titleList.add(new NotificationsData(tempDets, "pic_4", "pic_3"));

        titles = new MutableLiveData<>(titleList);
    }

    public LiveData<List<NotificationsData>> getTitles(){
        return titles;
    }

}

//    private MutableLiveData<String> mText;
//
//    public NotificationsViewModel() {
//        mText = new MutableLiveData<>();
//        mText.setValue("This is notifications fragment");
//    }
//
//    public LiveData<String> getText() {
//        return mText;
//    }