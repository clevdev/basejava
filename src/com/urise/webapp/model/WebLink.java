package com.urise.webapp.model;

public class WebLink {

    private String caption;
    private String link;

    public WebLink(String caption, String link) {
        this.caption = caption;
        this.link = link;
    }

    public String getCaption() {
        return caption;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "WebLink{" +
                "caption='" + caption + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
