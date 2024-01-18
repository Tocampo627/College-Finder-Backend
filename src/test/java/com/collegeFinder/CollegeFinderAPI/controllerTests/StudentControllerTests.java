package com.collegeFinder.CollegeFinderAPI.controllerTests;


import com.collegeFinder.CollegeFinderAPI.services.StudentProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


@WebMvcTest
public class StudentControllerTests {

    @MockBean
     private StudentProfileService studentProfileService;

    @Autowired
    MockMvc mockMvc;



}
