package com.urise.webapp.model;

import java.util.Objects;

public class WorkExperience {

    private WebLink companyName;
    private String workPeriod;
    private String position;
    private String description;

    public WorkExperience(WorkExperience experienceItem) {
        this(experienceItem.companyName, experienceItem.workPeriod, experienceItem.position, experienceItem.description);
    }

    public WorkExperience(WebLink companyName, String workPeriod, String position, String description) {
        Objects.requireNonNull(companyName, "companyName must be not null");
        Objects.requireNonNull(workPeriod, "workPeriod must be not null");
        Objects.requireNonNull(position, "position must be not null");
        Objects.requireNonNull(description, "description must be not null");
        this.companyName = companyName;
        this.workPeriod = workPeriod;
        this.position = position;
        this.description = description;
    }

    @Override
    public String toString() {
        return "WorkExperience{" +
                "companyName='" + companyName + '\'' +
                ", workPeriod='" + workPeriod + '\'' +
                ", position='" + position + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WorkExperience that = (WorkExperience) o;

        if (!companyName.equals(that.companyName)) return false;
        if (!workPeriod.equals(that.workPeriod)) return false;
        if (!position.equals(that.position)) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + workPeriod.hashCode();
        result = 31 * result + position.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
