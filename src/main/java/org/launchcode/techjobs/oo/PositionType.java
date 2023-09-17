package org.launchcode.techjobs.oo;

import javax.swing.text.Position;
import java.util.Objects;

public class PositionType {

    private int id;
    private static int nextId = 1;
    private String value;

    public PositionType() {
        id = nextId;
        nextId++;
    }

    public PositionType(String value) {
        this();
        this.value = value;
    }

    // TODO: Add a custom toString() method that returns the data stored in 'value'.
    @Override
    public String toString() {
        return value;
    }





    // Getters and Setters:

    public int getId() {
        return id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // TODO: Add custom equals and hashCode methods. Consider two PositionType objects "equal" when
    //  their id fields match.

//    @Override
//    public int hashCode() {
//        return Objects.hash(PositionType.getId());
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof PositionType)) return false; // Check if the object is an instance of ChildEmployer
//        PositionType positionType = (PositionType) o; // Cast the object to ChildEmployer
//        return getId()  == PositionType.getId(); // Compare the IDs
//    }

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
        PositionType positionType = (PositionType) o;
        return positionType.getId() == getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


}
