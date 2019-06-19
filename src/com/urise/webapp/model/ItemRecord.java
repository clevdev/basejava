package com.urise.webapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class ItemRecord {

    private String position;
    private LocalDate startDate;
    private LocalDate endDate;
    private String description;

    public ItemRecord(String position, LocalDate startDate, LocalDate endDate, String description) {
        Objects.requireNonNull(startDate, "startDate must be not null");
        Objects.requireNonNull(description, "description must be not null");
        this.position = position;
        this.startDate = startDate;
        this.endDate = endDate;
        this.description = description;
    }

    public String getPosition() {
        return position;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ItemRecord that = (ItemRecord) o;

        if (position != null ? !position.equals(that.position) : that.position != null) return false;
        if (!startDate.equals(that.startDate)) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        return description.equals(that.description);
    }

    @Override
    public int hashCode() {
        int result = position != null ? position.hashCode() : 0;
        result = 31 * result + startDate.hashCode();
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + description.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ItemRecord{" +
                "position='" + position + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", description='" + description + '\'' +
                '}';
    }
}
