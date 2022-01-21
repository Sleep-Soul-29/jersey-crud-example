//Data Model - Student (Class)
package com.java.jersey.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
     private long no;
     private String name;
     private Date dob;
     private Date doj;
 
     public Student() {
  
     }
 
 
     public Student(long no, String name, Date dob, Date doj) {
         super();
         this.no = no;
         this.name = name;
         this.dob = dob;
	 this.doj = doj;
     }
     public long getNo() {
         return no;
     }
     public void setNo(long no) {
         this.no = no;
     }
     public String getName() {
         return name;
     }
     public void setName(String name) {
         this.name = name;
     }
     public Date getDob() {
         return dob;
     }
     public void setDob(Date dob) {
         this.dob = dob;
     }
     public Date getDoj() {
         return doj;
     }
     public void setDoj(Date doj) {
         this.doj = doj;
     }
}