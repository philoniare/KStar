package com.example.philoniare.kstar;

import java.util.List;

/**
 * Created by philoniare on 3/1/16.
 */
public class GridItem {
    private String imageURL;
    private String title;
    private String profileText;
    private List<String> images;
    private List<String> videos;

    public GridItem() {
        super();
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setProfileText(String profileText) {
        this.profileText = profileText;
    }
    public String getProfileText() {return this.profileText;}
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {return this.images;}

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<String> getVideos() {return this.videos;}
    public void setVideos(List<String> videos) {
        this.videos = videos;
    }
}
