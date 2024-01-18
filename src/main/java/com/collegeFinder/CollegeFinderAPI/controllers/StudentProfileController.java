package com.collegeFinder.CollegeFinderAPI.controllers;


import com.collegeFinder.CollegeFinderAPI.entities.StudentProfile;
import com.collegeFinder.CollegeFinderAPI.services.StudentProfileService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("studentProfiles")

public class StudentProfileController {

    private StudentProfileService studentProfileService;

    public StudentProfileController(StudentProfileService studentProfileService) {
        this.studentProfileService = studentProfileService;
    }
  @PreAuthorize("permitAll()")
    @PostMapping("save")
    public StudentProfile postStudentProfileInfo(@RequestBody StudentProfile studentProfile){
        return this.studentProfileService.saveStudentProfileInfo(studentProfile);
    }

    @GetMapping("all")
    public List<StudentProfile> getAllStudentProfileInfo(){

        return this.studentProfileService.getAllActiveStudentProfileInfo();
    }


    @GetMapping("{id}")
    public ResponseEntity<StudentProfile> getStudentProfileById(@PathVariable Integer id){
        StudentProfile studentProfile = this.studentProfileService.findStudentProfileById(id);
        HttpStatus status;
        ResponseEntity response;

        if(studentProfile != null ){
            status = HttpStatus.OK;
            response = new ResponseEntity(studentProfile,status);
        }else{
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Student not found", status);
        }
        return response;
    }



    @PutMapping("update")
    public ResponseEntity<StudentProfile> putStudentProfileInfo(@RequestBody StudentProfile studentProfile){
        StudentProfile foundStudentProfile = this.studentProfileService.findStudentProfileById(studentProfile.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundStudentProfile != null){
            status = HttpStatus.OK;
            this.studentProfileService.updateStudentProfileInfo(studentProfile);
            response = new ResponseEntity(studentProfile,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Student not found",status);
        }

        return response;
    }

    @DeleteMapping("delete")
    public ResponseEntity<String> deleteStudentProfile(@RequestBody StudentProfile studentProfile){
        StudentProfile foundStudentProfile = this.studentProfileService.findStudentProfileById(studentProfile.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundStudentProfile != null){
            status = HttpStatus.OK;
            this.studentProfileService.deleteStudentProfile(studentProfile);
            response = new ResponseEntity("Student was successfully deleted",status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("Student not found",status);
        }

        return response;
    }

}
