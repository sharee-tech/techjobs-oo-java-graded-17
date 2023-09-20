package org.launchcode.techjobs.oo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

import java.lang.reflect.Field;


public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        String msg = "Tests that the ID of two objects are unique";
        assertNotEquals(msg, job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {

        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String name = aJob.getName();
        Employer employer = aJob.getEmployer();
        Location location = aJob.getLocation();
        PositionType positionType = aJob.getPositionType();
        CoreCompetency coreCompetency = aJob.getCoreCompetency();
        String msg1 = "Constructor should assign the class of each field correctly";
        assertTrue(msg1, name instanceof String);
        assertTrue(msg1, employer instanceof Employer);
        assertTrue(msg1, location instanceof Location);
        assertTrue(msg1, positionType instanceof PositionType);
        assertTrue(msg1, coreCompetency instanceof CoreCompetency);

        String msg2 = "Constructor should assign the value of each field correctly";
        assertEquals(msg2, "Product tester", name);
        assertEquals(msg2, "ACME", employer.getValue());
        assertEquals(msg2, "Desert", location.getValue());
        assertEquals(msg2, "Quality control", positionType.getValue());
        assertEquals(msg2, "Persistence", coreCompetency.getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Systems Test Engineer", new Employer("Garmin"), new Location("Olathe"), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));
        Job job2 = new Job("Systems Test Engineer", new Employer("Garmin"), new Location("Olathe"), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        String msg = "When passed a Job object, it should return a string that contains a blank line before and after the job information.";
        String newLine = System.lineSeparator();
        Job aJob = new Job("Systems Test Engineer", new Employer("Garmin"), new Location("Olathe"), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));
        String result = aJob.toString();
       // String expected = newLine;
        assertEquals(msg, true, result.startsWith(newLine));
        assertEquals(msg, true, result.endsWith(newLine));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        String msg = "The string should contain a label for each field, followed by the data stored in that field. Each field should be on its own line.";
        String newLine = System.lineSeparator();
        Job aJob = new Job("Systems Test Engineer", new Employer("Garmin"), new Location("Olathe"), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));
        String result = aJob.toString();
        String substring = "ID: " + aJob.getId() + newLine +
                "Name: " + aJob.getName() + newLine +
                "Employer: " + aJob.getEmployer().getValue() + newLine +
                "Location: " + aJob.getLocation().getValue() + newLine +
                "Position Type: " + aJob.getPositionType().getValue() + newLine +
                "Core Competency: " + aJob.getCoreCompetency().getValue();
        boolean expected = result.contains(substring);
//        System.out.println(result);
//        System.out.println(substring);
        assertTrue(msg, expected);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String msg = "If a field is empty, the method should add, “Data not available” after the label.";
        String newLine = System.lineSeparator();
        String nullMsg = "Data not available";
        Job aJob = new Job("Systems Test Engineer", new Employer("Garmin"), new Location(), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));
        String result = newLine + "ID: " + (aJob.getId() != 0 ? aJob.getId() : nullMsg) + newLine +
                "Name: " + (aJob.getName() != null ? aJob.getName() : nullMsg) + newLine +
                "Employer: " + (aJob.getEmployer().getValue() != null ? aJob.getEmployer() : nullMsg) + newLine +
                "Location: " + (aJob.getLocation().getValue() != null ? aJob.getLocation() : nullMsg) + newLine +
                "Position Type: " + (aJob.getPositionType().getValue() != null ? aJob.getPositionType() : nullMsg) + newLine +
                "Core Competency: " + (aJob.getCoreCompetency().getValue() != null ? aJob.getCoreCompetency() : nullMsg) + newLine;
//        System.out.println(result);
        String actual = aJob.toString();
        assertEquals(msg, result, actual);
    }
}
