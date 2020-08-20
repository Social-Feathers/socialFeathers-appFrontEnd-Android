package com.socialfeathers.app.ui.home;

public class CauseData {

    private String username;
    private String tag;
    private String title;
    private String address;
    private String details;

    // ToDo: change to date
    private String date;

    // ToDo: change to bitmap
    private String userPic;
    private String previewImage;

    public CauseData(String username, String tag, String title, String address, String details, String date,String userPic,String previewImage) {
        this.username = username;
        this.tag = tag;
        this.title = title;
        this.address = address;
        this.details = details;
        this.date = date;
        this.userPic = userPic;
        this.previewImage = previewImage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }
}
