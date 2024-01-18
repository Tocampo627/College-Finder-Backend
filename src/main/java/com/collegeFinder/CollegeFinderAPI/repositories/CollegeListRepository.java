package com.collegeFinder.CollegeFinderAPI.repositories;

import com.collegeFinder.CollegeFinderAPI.entities.CollegeList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeListRepository extends JpaRepository<CollegeList, Integer> {

}
