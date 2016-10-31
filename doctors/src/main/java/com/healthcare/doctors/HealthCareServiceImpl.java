package com.healthcare.doctors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
  * @author SaiRam
  * Service class to find the similar doctors based on the matching
input search criteria
  *
  */
public class HealthCareServiceImpl {

     /**
      * List holding all the doctor details used to find the matching
records
      */
     private List<DoctorDetails> doctorDetails = new
ArrayList<DoctorDetails>();

     /**
      * Constructor to load the doctor details from in memory(Testing setup)
      * Generally we load these details from data source like Data base
and put into some in memory cache and used these for filtering
      */
     public HealthCareServiceImpl() {
         loadDoctorDetails();
     }

     /**
      * Method to find the similar doctor records based on the input
search criteria
      * @param searchDetails contains input data like specialty, area
etc to filter the doctors
      * @return similar doctors
      */
     public List<DoctorDetails> findSimilarDoctors(SearchDetails
searchDetails) {
         //Input data Validation
         if (searchDetails == null || (searchDetails.getArea() == null
&& searchDetails.getReviewScore() == 0 && searchDetails.getSpecialty()
== null)) {
             return null;
         }
         List<DoctorDetails> similarDoctors = new
ArrayList<DoctorDetails>();
         //Filter records
         for (DoctorDetails details : doctorDetails) {
             if (searchDetails.getSpecialty() != null &&
!searchDetails.getSpecialty().equalsIgnoreCase(details.getSpecialty())) {
                 continue;
             }
             if (searchDetails.getArea() != null &&
!searchDetails.getArea().equalsIgnoreCase(details.getArea())) {
                 continue;
             }
             if (searchDetails.getReviewScore() != 0 &&
searchDetails.getReviewScore() >= details.getRating()) {
                 continue;
             }
             similarDoctors.add(details);
         }
         //Sort records in descending order based on the result order input data
         if
("ReviewScore".equalsIgnoreCase(searchDetails.getResultOrder())) {
             Collections.sort(similarDoctors,
DoctorDetails.ratingCompartor);
         } else if
("Experience".equalsIgnoreCase(searchDetails.getResultOrder())) {
                 Collections.sort(similarDoctors,
DoctorDetails.experienceCompartor);
         }
         return similarDoctors;
     }

     /**
      *  load the doctor details from in memory(Testing setup)
      */
     private void loadDoctorDetails() {
         DoctorDetails doctorShan = new DoctorDetails();
         doctorShan.setName("Shan Marsh");
         doctorShan.setRating(3);
         doctorShan.setSpecialty("Dentist");
         doctorShan.setContactNo(999999999L);
         doctorShan.setArea("Texas");
         doctorShan.setExperience(5);
         doctorDetails.add(doctorShan);

         DoctorDetails doctorJohn = new DoctorDetails();
         doctorJohn.setName("John Miller");
         doctorJohn.setRating(5);
         doctorJohn.setSpecialty("Dentist");
         doctorJohn.setContactNo(88888888L);
         doctorJohn.setArea("Texas");
         doctorJohn.setExperience(15);
         doctorDetails.add(doctorJohn);

         DoctorDetails doctorLynda = new DoctorDetails();
         doctorLynda.setName("Lynda Stones");
         doctorLynda.setRating(2);
         doctorLynda.setSpecialty("Physician");
         doctorLynda.setContactNo(7777777777L);
         doctorLynda.setArea("Texas");
         doctorLynda.setExperience(3);
         doctorDetails.add(doctorLynda);
         //We can add more doctor details here
     }
}