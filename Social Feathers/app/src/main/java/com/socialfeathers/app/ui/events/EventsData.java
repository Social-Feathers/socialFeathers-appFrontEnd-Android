package com.socialfeathers.app.ui.events;

public class EventsData {

    private String title;
    private String details;

    // ToDo: change to bitmap
    private String previewImage;

    public EventsData(String title, String details,String previewImage) {
        this.title = title;
        this.details = details;
        this.previewImage = previewImage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPreviewImage() {
        return previewImage;
    }

    public void setPreviewImage(String previewImage) {
        this.previewImage = previewImage;
    }
}
