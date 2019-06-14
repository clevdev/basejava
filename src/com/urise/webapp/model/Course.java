package com.urise.webapp.model;

public class Course {

    private String period;
    private String description;

    public Course(String period, String description) {
        this.period = period;
        this.description = description;
    }

    public String getPeriod() {
        return period;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "period='" + period + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (!period.equals(course.period)) return false;
        return description.equals(course.description);
    }

    @Override
    public int hashCode() {
        int result = period.hashCode();
        result = 31 * result + description.hashCode();
        return result;
    }
}
