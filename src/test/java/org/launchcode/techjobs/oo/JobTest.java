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

//        Job aJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
//
//        String msg1 = "Constructor should assign the class of each field correctly";
//        assertTrue(msg1, "Product tester" instanceof String);
//        assertTrue(msg1, "ACME" instanceof Employer);
//        assertTrue(msg1, "Desert" instanceof Location);
//        assertTrue(msg1, "Quality Control" instanceof PositionType);
//        assertTrue(msg1, "Persistence" instanceof CoreCompetency);
//
//        String msg2 = "Constructor should assign the value of each field correctly";
//        assertEquals(msg2, "Product tester", aJob.getName());
//        assertEquals(msg2, "ACME", aJob.getEmployer());
//        assertEquals(msg2, "Desert", aJob.getLocation());
//        assertEquals(msg2, "Quality Control", aJob.getPositionType());
//        assertEquals(msg2, "Persistence", aJob.getCoreCompetency());
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
                "Employer: " + aJob.getEmployer() + newLine +
                "Location: " + aJob.getLocation() + newLine +
                "Position Type: " + aJob.getPositionType() + newLine +
                "Core Competency: " + aJob.getCoreCompetency();
        boolean expected = result.contains(substring);
        assertTrue(msg, expected);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        String msg = "If a field is empty, the method should add, “Data not available” after the label.";
        String newLine = System.lineSeparator();
        Job aJob = new Job("Systems Test Engineer", new Employer("Garmin"), new Location(null), new PositionType("Testing support"), new CoreCompetency("Troubleshooting"));
        String result = aJob.toString();
        String substring = "ID: " + aJob.getId() + newLine +
                "Name: " + aJob.getName() + newLine +
                "Employer: " + aJob.getEmployer() + newLine +
                "Location: " + aJob.getLocation() + newLine +
                "Position Type: " + aJob.getPositionType() + newLine +
                "Core Competency: " + aJob.getCoreCompetency();
        Field[] fields = aJob.getClass().getDeclaredFields();
        for (Field item: fields) {
            Object v = item.get(aJob);
            if (v == null) {
                System.out.println("Data not available");
            }

        }
        boolean expected = result.
    }

//    ClasWithStuff myStuff = new ClassWithStuff();
//    Field[] fields = myStuff.getClass().getDeclaredFields();
//    for(Field f : fields){
//      Class t = f.getType();
//      Object v = f.get(myStuff);
//      if(t == boolean.class && Boolean.FALSE.equals(v))
//     // found default value
//      else if(t.isPrimitive() && ((Number) v).doubleValue() == 0)
//     // found default value
//      else if(!t.isPrimitive() && v == null)
//     // found default value
//}



}
