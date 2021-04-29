package com.nan.batch.controller;


import com.nan.batch.model.Student;
import com.nan.batch.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@CrossOrigin
@RestController // This means that this class is a Controller
@RequestMapping(path="/manager") // This means URL's start with /demo (after Application path)
public class StudentController {

    private final StudentService studentService;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    public StudentController(StudentService service) {
        this.studentService = service;
    }


    @GetMapping("/")
    ResponseEntity<EntityModel<?>> Welcome(){
        return ResponseEntity.ok(
                new EntityModel<>(
                        linkTo(methodOn(StudentController.class).getAllStudents()).withRel("students"))
        );
    }

    @PostMapping(path="/students") // Map ONLY POST Requests
    public ResponseEntity<?> addNewStudent (Student student) {
        try{
            studentService.saveStudent(student);
            EntityModel<Student> studentResource = new EntityModel<>(student,
                    linkTo(methodOn(StudentController.class).selectStudentById(student.getId())).withSelfRel());

            return ResponseEntity
                    .created(new URI(studentResource.getRequiredLink(IanaLinkRelations.SELF).getHref()))
            .body(studentResource);

        } catch (URISyntaxException e) {
            return ResponseEntity.badRequest().body("Unable to create student " + student.getId());
        }

        //return studentService.saveStudent(student);
    }

    /**
     * Update existing employee then return a Location header.
     *
     * @param newStudent
     * @param id
     * @return
     */
    @PutMapping(path="/students/{id}")
    ResponseEntity<?> alterStudent(Student newStudent, @PathVariable Integer id){
        try{
            studentService.updateStudent(newStudent, id);
            Link newlyCreatedLink = linkTo(methodOn(StudentController.class).selectStudentById(id)).withSelfRel();

            return ResponseEntity.noContent().location(new URI(newlyCreatedLink.getHref())).build();
        }catch (URISyntaxException e){
            return ResponseEntity.badRequest().body(("Unable to update " + newStudent));
        }
    }

    /**
     * Look up a single {@link Student} and transform it into a REST resource. Then
     * return it through Spring Web's {@link ResponseEntity} fluent API.
     *
     * @param id
     */
    @GetMapping(path="/students/{id}")
    ResponseEntity<EntityModel<Student>>  selectStudentById(@PathVariable Integer id){
        return studentService.findStudentById(id)
                .map(student -> new EntityModel<>(student, //
                        linkTo(methodOn(StudentController.class).selectStudentById(student.getId())).withSelfRel(), //
                        linkTo(methodOn(StudentController.class).getAllStudents()).withRel("employees"))) //
                .map(ResponseEntity::ok) //
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping(path="/students/name/{name}")
    public  ResponseEntity<CollectionModel<EntityModel<Student>>> selectStudentByName(@PathVariable String name){
        List<EntityModel<Student>> students = StreamSupport.stream(studentService.findStudentByName(name).spliterator(), false)
                .map(student -> new EntityModel<>(student,
                        linkTo(methodOn(StudentController.class).selectStudentById(student.getId())).withSelfRel(),
                        linkTo(methodOn(StudentController.class).getAllStudents()).withRel("students")))
                .collect(Collectors.toList());

        return ResponseEntity.ok(
                new CollectionModel<>(students,
                        linkTo(methodOn(StudentController.class).selectStudentByName(name)).withSelfRel())
        );
        //return studentService.findStudentByName(name);
    }

    @DeleteMapping(path="/students/{id}")
    public ResponseEntity<EntityModel<?>> deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);

        return ResponseEntity.ok(
                new EntityModel<>(
                        linkTo(methodOn(StudentController.class).getAllStudents()).withRel("students"))
        );

        //return studentService.deleteStudent(student.getId());
    }

    /**
     * Look up all students, and transform them into a REST collection resource.
     * Then return them through Spring Web's {@link ResponseEntity} fluent API.
     */

    @GetMapping(path="/students")
    public ResponseEntity<CollectionModel<EntityModel<Student>>> getAllStudents() {
        List<EntityModel<Student>> students = StreamSupport.stream(studentService.findAllStudents().spliterator(), false)
                .map(student -> new EntityModel<>(student,
                        linkTo(methodOn(StudentController.class).selectStudentById(student.getId())).withSelfRel(),
                        linkTo( methodOn(StudentController.class).getAllStudents()).withRel("students")))
                .collect(Collectors.toList());
        CollectionModel<EntityModel<Student>>  CollectionModelStudents =   new CollectionModel<>(students,
                linkTo(methodOn(StudentController.class).getAllStudents()).withSelfRel());

        try{

            return ResponseEntity.ok(CollectionModelStudents);
        } catch (Exception e) {
            System.out.println("catch a exception");
            return ResponseEntity.badRequest().body((CollectionModelStudents));
        }

        //return studentService.findAllStudents();
    }

    // clear all cache using cache manager
    @DeleteMapping(path = "/cache")
    public @ResponseBody String clearCache() {
        for (String name : cacheManager.getCacheNames()) {
            cacheManager.getCache(name).clear();
        }

        return "clear cache successfully";
    }
}
