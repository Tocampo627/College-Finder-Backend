package com.collegeFinder.CollegeFinderAPI.serviceTests;

import com.collegeFinder.CollegeFinderAPI.entities.StudentProfile;
import com.collegeFinder.CollegeFinderAPI.repositories.StudentProfileRepository;
import com.collegeFinder.CollegeFinderAPI.services.StudentProfileService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
public class StudentProfileServiceTests {
    @Mock
    StudentProfileRepository studentProfileRepository;

    @InjectMocks
    StudentProfileService studentProfileService;

    List<StudentProfile> studentProfile = Arrays.asList(
                new StudentProfile()
                    .withFirstName("Tanya").withLastName("Ocampo")
                    .withPrivatePublic("Public").withRegionUsa("South East")
                    .withLocationSize("Large City")
                    .withSatScore(1500).withMaxCostOfAttendance(20000),
                new StudentProfile()
                    .withFirstName("Nader").withLastName("Alnatsheh")
                    .withPrivatePublic("Private").withRegionUsa("Great Lakes")
                    .withLocationSize("Large City")
                    .withSatScore(1500).withMaxCostOfAttendance(20000),
                new StudentProfile()
                        .withFirstName("Emily").withLastName("Delgado")
                        .withPrivatePublic("Public").withRegionUsa("South East")
                        .withLocationSize("Large City")
                        .withSatScore(1500).withMaxCostOfAttendance(20000).withIsActive(false),
                new StudentProfile()
                        .withFirstName("Jonathan").withLastName("Ortiz")
                        .withPrivatePublic("Public").withRegionUsa("South East")
                        .withLocationSize("Large City")
                        .withSatScore(1500).withMaxCostOfAttendance(20000).withIsActive(false));

    @Test
    public void saveStudent_callsRepoSave(){
        //arrange
        //style of chaining methods together = fluent API
        StudentProfile studentProfile = new StudentProfile()
                .withFirstName("Alondra").withLastName("Ocampo")
                .withPrivatePublic("Public").withRegionUsa("Great Lakes")
                .withLocationSize("Large City")
                .withSatScore(1500).withMaxCostOfAttendance(20000);
        //act --> calls the method under test
        studentProfileService.saveStudentProfileInfo(studentProfile);
        //assert -> verify that the student repo was called  and the save method
        verify(studentProfileRepository,times(1)).save(studentProfile);
    }

    @Test
    public void getAllActiveStudents_returnsOnlyActive(){
        //arrange
        when(studentProfileRepository.findAll()).thenReturn(studentProfile);

        //act
        List<StudentProfile> activeStudentProfiles = studentProfileService.getAllActiveStudentProfileInfo();
        //assert
        System.out.println(("Num of active students "+ activeStudentProfiles.size()));
        assertEquals(2, activeStudentProfiles.size());
        activeStudentProfiles.forEach(student -> assertTrue(student.isActive()));
    }

}
