package com.collegeFinder.CollegeFinderAPI.repositories;

import com.collegeFinder.CollegeFinderAPI.entities.StudentProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentProfileRepository extends JpaRepository<StudentProfile, Integer> {

}
