package com.urise.webapp.model;

import java.util.Objects;

public class SimpleTextSection extends AbstractSection {
    private String text;

    public SimpleTextSection(String text) {
        Objects.requireNonNull(text, "text must be not null");
        this.text = text;
    }


    public String getText() {
        return text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleTextSection that = (SimpleTextSection) o;
        return text.equals(that.text);
    }

    @Override
    public String toString() {
        return text;
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
