package com.collegeFinder.CollegeFinderAPI.services;

import com.collegeFinder.CollegeFinderAPI.entities.StudentProfile;
import com.collegeFinder.CollegeFinderAPI.repositories.StudentProfileRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentProfileService {
    private StudentProfileRepository studentProfileRepository;

    public StudentProfileService(StudentProfileRepository studentProfileRepository){
        this.studentProfileRepository = studentProfileRepository;
    }

    public StudentProfile saveStudentProfileInfo(StudentProfile studentProfile) {
        return this.studentProfileRepository.save(studentProfile);
    }

    public List<StudentProfile> getAllStudentProfileInfo() {
        return this.studentProfileRepository.findAll();
    }

    public List<StudentProfile> getAllActiveStudentProfileInfo() {
        return this.studentProfileRepository.findAll()
                .stream()
                .filter(s->s.isActive())
                .collect(Collectors.toList());
    }

    public StudentProfile findStudentProfileById(Integer id) {
        return this.studentProfileRepository.findById(id).orElse(null);
    }


    public StudentProfile updateStudentProfileInfo(StudentProfile studentProfile) {
        return this.studentProfileRepository.save(studentProfile);
    }

    public StudentProfile deleteStudentProfile(StudentProfile studentProfile) {
        studentProfile.setActive(false);
        return this.studentProfileRepository.save(studentProfile);
    }
}
