package com.socialfeathers.app.ui.notifications;

public class NotificationsData {

    private String details;

    // ToDo: change to bitmap
    private String userPic;
    private String previewImage;

    public NotificationsData(String details, String userPic, String previewImage) {
        this.details = details;
        this.userPic = userPic;
        this.previewImage = previewImage;
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
