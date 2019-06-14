package com.urise.webapp.model;

import java.util.Arrays;

public class EducationCourse {
    private WebLink companyName;
    private Course courses[];

    public EducationCourse(EducationCourse educationItem) {
        this.companyName = educationItem.companyName;
        this.courses = educationItem.courses;
    }

    public EducationCourse(WebLink companyName, Course courses[]) {
        this.companyName = companyName;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationCourse that = (EducationCourse) o;

        if (!companyName.equals(that.companyName)) return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(courses, that.courses);
    }

    @Override
    public int hashCode() {
        int result = companyName.hashCode();
        result = 31 * result + Arrays.hashCode(courses);
        return result;
    }

    @Override
    public String toString() {
        return "EducationCourse{" +
                "companyName=" + companyName +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
