package com.urise.webapp.model;

public enum ContactType {
    PHONE("Тел."),
    SKYPE("Skype"),
    EMAIL("Почта"),
    LINCKEDIN("Профиль LinkedIn"),
    GITHUB("Профиль GitHub"),
    STACKOVERFLOW("Профиль Stackoverflow"),
    HOMEPAGE("Домашняя страница");

    private String title;

    ContactType(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
