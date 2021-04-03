package com.nan.manager.repository;

import com.nan.manager.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentRepository extends CrudRepository<Student, Integer> {
    //@Modifying
    //通过name查询
    @Query("select st from Student st where st.Name = ?1")
    Iterable<Student> findStudentByName(String name);
}
