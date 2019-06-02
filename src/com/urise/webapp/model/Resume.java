package com.urise.webapp.model;

import java.util.Objects;
import java.util.UUID;

/**
 * Initial resume class
 */
public class Resume {

    // Unique identifier
    private String uuid;
    private String fullName;

//    //public Resume() {
//        this(UUID.randomUUID().toString(), "");
//    }

    public Resume(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public Resume(String uuid, String fullName) {
        Objects.requireNonNull(uuid, "uuid must be not null");
        Objects.requireNonNull(fullName, "fullName must be not null");
        this.uuid = uuid;
        this.fullName = fullName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Resume resume = (Resume) object;
        return uuid.equals(resume.getUuid()) && fullName.equals(resume.getFullName());
    }

    @Override
    public int hashCode() {
        return 31 * uuid.hashCode() + ((fullName == null) ? 0 : fullName.hashCode());
    }

    @Override
    public String toString() {
        return uuid + "(" + fullName + ")";
    }

}
