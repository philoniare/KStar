package com.example.philoniare.kstar;

/**
 * Created by philoniare on 3/1/16.
 */
public class GridItem {
    private String imageURL;
    private String title;

    public GridItem() {
        super();
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
