package com.healthcare.doctors;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
  * @author SaiRam
  * Test class for HealthCareService
  *
  */
public class HealthCareServiceTest {

     private HealthCareServiceImpl healthCareServiceImpl;

     /**
      * Constructs the service class
      */
     @Before
     public void setUp() {
          healthCareServiceImpl = new HealthCareServiceImpl();
     }

     /**
      * Positive test case to check similar doctors by specialty
      */
     @Test
     public void findSimilarDoctorsBySpecialty() {
         SearchDetails searchDetails = new SearchDetails();
         searchDetails.setSpecialty("Dentist");
         List<DoctorDetails> similarDoctors =
healthCareServiceImpl.findSimilarDoctors(searchDetails);
         if (similarDoctors != null && !similarDoctors.isEmpty()) {
             for (DoctorDetails details : similarDoctors) {
                 if (!"Dentist".equalsIgnoreCase(details.getSpecialty())) {
                     Assert.assertFalse(true);
                 }
             }
         } else {
             Assert.assertFalse(true);
         }
         Assert.assertTrue(true);
     }

     /**
      * Positive test case to check similar doctors by specialty and
prioritized order
      */
     @Test
     public void findSimilarDoctorsBySpecialtyWithOrdering() {
         SearchDetails searchDetails = new SearchDetails();
         searchDetails.setSpecialty("Dentist");
         searchDetails.setResultOrder("ReviewScore");
         List<DoctorDetails> similarDoctors =
healthCareServiceImpl.findSimilarDoctors(searchDetails);
         if (similarDoctors != null && !similarDoctors.isEmpty()) {
             int previosRating = -1;
             for (DoctorDetails details : similarDoctors) {
                 if (!"Dentist".equalsIgnoreCase(details.getSpecialty())) {
                     Assert.assertFalse(true);
                 } else if  (previosRating != -1 && previosRating <
details.getRating()) {
                     Assert.assertFalse(true);
                 }
                 previosRating = details.getRating();
             }
         } else {
             Assert.assertFalse(true);
         }
         Assert.assertTrue(true);
     }

     /**
      * Negative test case to check similar doctors without search criteria
      */
     @Test
     public void findSimilarDoctorsEmptyInput() {
         SearchDetails searchDetails = new SearchDetails();
         List<DoctorDetails> similarDoctors =
healthCareServiceImpl.findSimilarDoctors(searchDetails);
         if (similarDoctors != null && !similarDoctors.isEmpty()) {
             Assert.assertFalse(true);
         } else {
             Assert.assertTrue(true);
         }
     }

     /**
      * Negative test case to check similar doctors with invalid input
      */
     @Test
     public void findSimilarDoctorsWithInvalidInput() {
         SearchDetails searchDetails = new SearchDetails();
         searchDetails.setSpecialty("Kalyan");
         List<DoctorDetails> similarDoctors =
healthCareServiceImpl.findSimilarDoctors(searchDetails);
         if (similarDoctors != null && !similarDoctors.isEmpty()) {
             Assert.assertFalse(true);
         } else {
             Assert.assertTrue(true);
         }
     }

}