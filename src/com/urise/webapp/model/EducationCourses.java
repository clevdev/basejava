package com.urise.webapp.model;

import java.util.Arrays;
import java.util.Objects;

public class EducationCourses {
    private WebLink companyName;
    private Course courses[];

    public EducationCourses(EducationCourses educationItem) {
        this(educationItem.companyName,educationItem.courses);
    }

    public EducationCourses(WebLink companyName, Course courses[]) {
        Objects.requireNonNull(companyName, "companyName must be not null");
        Objects.requireNonNull(courses, "courses must be not null");
        this.companyName = companyName;
        this.courses = courses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EducationCourses that = (EducationCourses) o;

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
        return "EducationCourses{" +
                "companyName=" + companyName +
                ", courses=" + Arrays.toString(courses) +
                '}';
    }
}
