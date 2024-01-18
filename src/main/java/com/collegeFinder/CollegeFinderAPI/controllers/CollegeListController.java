package com.collegeFinder.CollegeFinderAPI.controllers;

import com.collegeFinder.CollegeFinderAPI.entities.CollegeList;
import com.collegeFinder.CollegeFinderAPI.services.CollegeListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("collegelist")
public class CollegeListController {
    private CollegeListService collegeListService;

    public CollegeListController(CollegeListService collegeListService) {
        this.collegeListService = collegeListService;
    }

    @PostMapping("save")
    public CollegeList postCollegeSelectedByUser(@RequestBody CollegeList collegeList){
        return this.collegeListService.saveCollege(collegeList);
    }

    @GetMapping("all")
    public List<CollegeList> getAllColleges(){
        return this.collegeListService.getAllInterestedColleges();
    }

    //{useremail}
    @GetMapping("{id}")
    public ResponseEntity<CollegeList> getListByStudentProfile(@PathVariable Integer id){
        CollegeList collegeList = this.collegeListService.findSchoolInListByTransactionId(id);
        HttpStatus status;
        ResponseEntity response;

        if(collegeList != null){
            status = HttpStatus.OK;
            response = new ResponseEntity(collegeList,status);
        }else {
            status = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("College Entry not found",status);
        }
        return response;
    }
    @PutMapping("update")
    public ResponseEntity<CollegeList> putStudentProfileInfo(@RequestBody CollegeList collegeList){
        CollegeList foundCollege = this.collegeListService.findSchoolInListByTransactionId(collegeList.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundCollege != null){
            status = HttpStatus.OK;
            this.collegeListService.updateCollegeList(collegeList);
            response = new ResponseEntity(collegeList,status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("College was not found in User list",status);
        }

        return response;
    }
    @DeleteMapping("delete")
    public ResponseEntity<CollegeList> deleteCollegeEntry(@RequestBody CollegeList collegeList){
        CollegeList foundCollegeInUserList = this.collegeListService.findSchoolInListByTransactionId(collegeList.getId());
        HttpStatus status;
        ResponseEntity response;

        if(foundCollegeInUserList != null){
            status = HttpStatus.OK;
            this.collegeListService.deleteSchoolSelectedByUser(collegeList);
            response = new ResponseEntity("College was successfully deleted",status);
        }else{
            status  = HttpStatus.BAD_REQUEST;
            response = new ResponseEntity("College was not found in User list",status);
        }

        return response;
    }



//    @GetMapping("allCollegeIds")
//    public List<Integer> getAllCollegeIds(){
//        List<Integer> colIds= this.collegeListService.getAllColleges()
//                .stream()
//                .map(CollegeList::getSchoolId)
//                .collect(Collectors.toList());
//        HttpStatus status;
//        ResponseEntity response;
//        return colIds;
//    }






}
