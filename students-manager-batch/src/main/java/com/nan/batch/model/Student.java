package com.nan.batch.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity
@Table(name = "student")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student implements Serializable{



    @Id
    @Column(name="id")
    private Integer id;

    @Column(name = "name")
    private String Name;

    @Column(name = "major")
    private String Major;

    @Column(name = "phone")
    private String PhoneNumber;

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getMajor() {
        return Major;
    }

    public String getName() {
        return Name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMajor(String major) {
        Major = major;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
