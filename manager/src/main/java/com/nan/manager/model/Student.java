package com.nan.manager.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Student {

    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @NotNull
    @Column(name="id")
    private Integer ID;

    //private String StudentID;

    private String Name;

    private String Sex;

    private String BirthDate;

    private String NativePlace;

    private String Department;

    public Integer getId() {
        return ID;
    }

    public void setId(Integer id) {
        this.ID = id;
    }

//    public String getStudentID() {
//        return StudentID;
//    }
//
//    public void setStudentID(String studentID) {
//        this.StudentID = studentID;
//    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getSex() {
        return Sex;
    }

    public void setSex(String sex) {
        this.Sex = sex;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        this.BirthDate = birthDate;
    }

    public String getNativePlace() {
        return NativePlace;
    }

    public void setNativePlace(String nativePlace) {
        this.NativePlace = nativePlace;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        this.Department = department;
    }
}

