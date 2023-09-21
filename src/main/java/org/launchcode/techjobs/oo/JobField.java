package org.launchcode.techjobs.oo;

import java.util.Objects;

public abstract class JobField {
    private static int id;
    private int nextId = 1;
    private String value;

    public JobField() {
        id = nextId;
        nextId++;
    }

    public JobField(String value) {
        this();
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object o) {  // Two objects are equal if they have the same id.
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o.getClass() != getClass()) {
            return false;
        }
        JobField jobField = (JobField) o;
        return JobField.getId() == getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public static int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

