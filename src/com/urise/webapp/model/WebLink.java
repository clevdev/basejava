package com.urise.webapp.model;

import java.util.Objects;

public class WebLink {

    private String caption;
    private String link;

    public WebLink(String caption, String link) {
        Objects.requireNonNull(caption, "caption must be not null");
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
