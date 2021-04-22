package com.nan.manager.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.nan.manager.model.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface StudentRepository extends CrudRepository<Student, Integer> {
    //@Modifying
    //通过name查询
    @Query("select st from Student st where st.Name = ?1")
    Iterable<Student> findStudentByName(String name);
}

