package com.pixfar.firebaseofflinedatabse;

public class UserInfo {

    public String imageName;
    public String imageURL;

    public UserInfo() {
    }

    public UserInfo(String imageName, String imageURL) {
        this.imageName = imageName;
        this.imageURL = imageURL;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getImageName() {
        return imageName;
    }

    public String getImageURL() {
        return imageURL;
    }
}
