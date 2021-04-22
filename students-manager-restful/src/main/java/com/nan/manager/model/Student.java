package com.nan.manager.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



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

    @Column(name = "gender")
    private String Gender;

    @Column(name = "birthdate")
    private String BirthDate;

    @Column(name = "nativePlace")
    private String NativePlace;

    @Column(name = "department")
    private String Department;

}
