package com.healthcare.doctors;

import java.util.Comparator;
import java.util.Date;

/**
  * @author SiaRam
  * POJO class to hold the Similar doctor result details
  *
  */
public class DoctorDetails {

     private String name;
     private String specialty;
     private int rating;
     private Date availability;
     private String area;
     private Long contactNo;
     private int experience;

     /**
      * Comparator to sort the results in descending order based on the
doctors rating
      */
     public static Comparator<DoctorDetails> ratingCompartor = new
Comparator<DoctorDetails>() {
         public int compare(DoctorDetails o1, DoctorDetails o2) {
             return
Integer.valueOf(o2.getRating()).compareTo(o1.getRating());
         }
     };

     /**
      * Comparator to sort the results in descending order based on the
experince
      */
     public static Comparator<DoctorDetails> experienceCompartor = new
Comparator<DoctorDetails>() {
         public int compare(DoctorDetails o1, DoctorDetails o2) {
             return
Integer.valueOf(o2.getExperience()).compareTo(o1.getExperience());
         }
     };

     /**
      * @return the name
      */
     public String getName() {
         return name;
     }


     /**
      * @param name the name to set
      */
     public void setName(String name) {
         this.name = name;
     }


     /**
      * @return the specialty
      */
     public String getSpecialty() {
         return specialty;
     }


     /**
      * @param specialty the specialty to set
      */
     public void setSpecialty(String specialty) {
         this.specialty = specialty;
     }


     /**
      * @return the rating
      */
     public int getRating() {
         return rating;
     }


     /**
      * @param rating the rating to set
      */
     public void setRating(int rating) {
         this.rating = rating;
     }


     /**
      * @return the availability
      */
     public Date getAvailability() {
         return availability;
     }


     /**
      * @param availability the availability to set
      */
     public void setAvailability(Date availability) {
         this.availability = availability;
     }


     /**
      * @return the area
      */
     public String getArea() {
         return area;
     }


     /**
      * @param area the area to set
      */
     public void setArea(String area) {
         this.area = area;
     }


     /**
      * @return the contactNo
      */
     public Long getContactNo() {
         return contactNo;
     }


     /**
      * @param contactNo the contactNo to set
      */
     public void setContactNo(Long contactNo) {
         this.contactNo = contactNo;
     }


     /**
      * @return the experience
      */
     public int getExperience() {
         return experience;
     }


     /**
      * @param experience the experience to set
      */
     public void setExperience(int experience) {
         this.experience = experience;
     }
}