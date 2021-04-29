package com.nan.batch.service;

import com.nan.batch.model.Student;
import com.nan.batch.respository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository repository){
        studentRepository = repository;
    }

    @Transactional//(readOnly = true)
    @Cacheable(value = "students", key = "#ID")
    public Optional<Student> findStudentById(Integer ID){
        return studentRepository.findById(ID);
    }

    @Transactional//(readOnly = true)
    @Cacheable(value = "students", key = "#name")
    public Iterable<Student> findStudentByName(String name) {
        return studentRepository.findStudentByName(name);
    }

    @Transactional//(readOnly = true)
    @Cacheable(value = "students")
    public Iterable<Student> findAllStudents(){
        return studentRepository.findAll();
    }

    @Transactional
    @CacheEvict(value = "students", allEntries = true)
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Transactional
    @CacheEvict(value = "students", allEntries = true)
    public String deleteStudent(Integer id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return "delete student " +id + " successfully";
        }
        return "student " + id + " is not exist";
    }

    @Transactional
    @CacheEvict(value = "students", allEntries = true)
    public Student updateStudent(Student newStudent, Integer id) {
        if(studentRepository.existsById(newStudent.getId())){
            studentRepository.deleteById(newStudent.getId());
            return studentRepository.save(newStudent);
        }
        return studentRepository.findById(id)
                .map(student -> {
                    studentRepository.deleteById(id);
                    return studentRepository.save(newStudent);
                }).orElseGet(()->{
                   newStudent.setId(id);
                   return studentRepository.save(newStudent);
                });
    }
}

