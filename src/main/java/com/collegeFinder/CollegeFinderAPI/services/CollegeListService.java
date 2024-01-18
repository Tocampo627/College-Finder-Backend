package com.collegeFinder.CollegeFinderAPI.services;

import com.collegeFinder.CollegeFinderAPI.entities.CollegeList;
import com.collegeFinder.CollegeFinderAPI.repositories.CollegeListRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CollegeListService {

   private CollegeListRepository collegeListRepository;
   private CollegeListService(CollegeListRepository collegeListRepository){
       this.collegeListRepository = collegeListRepository;
   }

    public CollegeList saveCollege(CollegeList collegeList) {
       collegeList.setIsInterested(true);
       return this.collegeListRepository.save(collegeList);
    }


    public List<CollegeList> getAllColleges() {
       return this.collegeListRepository.findAll();
    }

    public List<CollegeList> getAllInterestedColleges() {
        return this.collegeListRepository.findAll().stream().filter(c->c.isInterested()).collect(Collectors.toList());
    }
    public CollegeList findSchoolInListByTransactionId(Integer id){
       return this.collegeListRepository.findById(id).orElse(null);
    }
    public CollegeList findSchoolInListBySchoolId(Integer schoolId){
        return this.collegeListRepository.findById(schoolId).orElse(null);
    }
//update that receives the whole thing
    public CollegeList updateCollegeList(@NotNull CollegeList collegeList) {
        collegeList.setIsInterested(false);
       return this.collegeListRepository.save(collegeList);
    }
//    public void updateCollegeList(CollegeList collegeList) {
//        collegeList.setIsInterested(false);
//        return this.collegeListRepository.save(collegeList);
//    }

    public CollegeList deleteSchoolSelectedByUser(CollegeList collegeList){
        return this.collegeListRepository.save(collegeList);
    }


}

