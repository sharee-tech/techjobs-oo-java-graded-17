package org.launchcode.techjobs.oo;

import static org.junit.Assert.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;



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

}
