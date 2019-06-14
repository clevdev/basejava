package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListSection<V> extends AbstractSection {

    private List<V> textList;

    public ListSection(List<V> list) {
        this.textList = new ArrayList<>(list);
    }

    public List<V> getTextList() {
        return textList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListSection that = (ListSection) o;
        return textList.equals(that.textList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(textList);
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "textList=" + textList +
                '}';
    }
}
