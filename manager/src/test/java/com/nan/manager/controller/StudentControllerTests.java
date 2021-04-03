//package com.nan.manager.controller;
//
//import com.nan.manager.model.Student;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.web.client.TestRestTemplate;
//import org.springframework.boot.web.server.LocalServerPort;
//import org.springframework.format.support.FormattingConversionServiceFactoryBean;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//import org.springframework.web.context.WebApplicationContext;
//
//
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
//import static org.mockito.BDDMockito.given;
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
///**
// *Test  class for the{@link StudentController}
// *
// * @author Mr.Nan
// */
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//public class StudentControllerTests {
//    private static final Integer TEST_STUDENT_ID = 171860642;
//    private static final String TEST_STUDENT_NAME = "宋超群";
//
//    private static final Integer TEST_NEW_STUDENT_ID = 171860643;
//    private static final String TEST_NEW_STUDENT_NAME = "Mr.Nan";
//    private static final String URI = "http://localhost:8080/manager/";
//
//    Student st = new Student();
//
//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    private TestRestTemplate restTemplate;
//
//    @Autowired
//    private WebApplicationContext wac;
//
//    @Autowired
//    private StudentController studentController;
//
//
//    @BeforeEach
//    void setup() {
//        st.setId(TEST_NEW_STUDENT_ID);
//        st.setName(TEST_NEW_STUDENT_NAME);
//        st.setBirthDate("1999-05");
//        st.setDepartment("计算机科学与技术系");
//        st.setSex("男");
//        st.setNativePlace("江苏南京");
//
////        given(this.studentController
////                .selectStudentById(TEST_STUDENT_ID))
////                .willReturn((Iterable<Student>) new Student());
////        given(this.studentController.selectStudentByName(TEST_STUDENT_NAME)).willReturn((Iterable<Student>) new Student());
////        given(this.studentController.getAllStudents()).willReturn((Iterable<Student>) new Student());
//    }
//
//    @Test
//    void testAddNewStudent() throws Exception{
//        System.out.println(this.restTemplate.postForLocation(URI + "add", st));
////        assertThat(this.restTemplate.postForLocation(URI + "add", st).equals("redirect:/students/"+ TEST_NEW_STUDENT_ID));
////
////        assertThat(this.restTemplate.getForObject(URI + "add")).contains("redirect:/students/"+ TEST_NEW_STUDENT_ID);
////
////        mockMvc.perform(get(URI + "add",st))
////                .andExpect(status().is3xxRedirection())
////                .andExpect(view().name("redirect:/students/"+ TEST_NEW_STUDENT_ID));
//    }
//}
