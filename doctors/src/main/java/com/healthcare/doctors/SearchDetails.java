package com.healthcare.doctors;

/**
  * @author SaiRam
  * POJO class to hold the input details to filter the similar doctors
  *
  */
public class SearchDetails {

     private String specialty;
     private String area;
     private int reviewScore;
     private String resultOrder;
     /**
      * @return the specialty
      */
     public String getSpecialty() {
         return specialty;
     }
     /**
      * @param speciality the specialty to set
      */
     public void setSpecialty(String specialty) {
         this.specialty = specialty;
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
      * @return the reviewScore
      */
     public int getReviewScore() {
         return reviewScore;
     }
     /**
      * @param reviewScore the reviewScore to set
      */
     public void setReviewScore(int reviewScore) {
         this.reviewScore = reviewScore;
     }
     /**
      * @return the resultOrder
      */
     public String getResultOrder() {
         return resultOrder;
     }
     /**
      * @param resultOrder the resultOrder to set
      */
     public void setResultOrder(String resultOrder) {
         this.resultOrder = resultOrder;
     }
}