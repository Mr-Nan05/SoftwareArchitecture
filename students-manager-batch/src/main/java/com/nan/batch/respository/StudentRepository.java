package com.nan.batch.respository;

import com.nan.batch.model.Student;
import org.springframework.data.jpa.repository.Query;
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

