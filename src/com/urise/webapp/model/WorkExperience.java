package com.urise.webapp.model;

public class WorkExperience {

    private WebLink companyName;
    private String workPeriod;
    private String position;
    private String description;

    public WorkExperience(WorkExperience experienceItem) {
        this.companyName = experienceItem.companyName;
        this.workPeriod = experienceItem.workPeriod;
        this.position = experienceItem.position;
        this.description = experienceItem.description;
    }

    public WorkExperience(WebLink companyName, String workPeriod, String position, String description) {
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


}
