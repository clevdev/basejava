package com.urise.webapp.model;

import java.util.List;

public class SectionItem {

    private WebLink url;
    private List<ItemRecord> records;

    public SectionItem(WebLink url, List records) {
        this.url = url;
        this.records = records;
    }

    public WebLink getUrl() {
        return url;
    }

    public List<ItemRecord> getRecords() {
        return records;
    }

    @Override
    public String toString() {
        return "SectionItem{" +
                "url=" + url +
                ", records=" + records +
                '}';
    }
}
