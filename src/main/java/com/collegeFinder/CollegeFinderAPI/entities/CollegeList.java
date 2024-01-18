package com.collegeFinder.CollegeFinderAPI.entities;


import javax.persistence.*;

@Entity
public class CollegeList {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String userEmail;
    int schoolId;
    String schoolName;
    String schoolCity;
    String schoolState;
    int schoolTuition;
    int schoolSat;
    boolean isInterested = false;

    public CollegeList() {
    }

    public CollegeList(Integer id, String userEmail, int schoolId, String schoolName, String schoolCity, String schoolState, int schoolTuition, int schoolSat,boolean isInterested) {
        this.id = id;
        this.userEmail = userEmail;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.schoolCity = schoolCity;
        this.schoolState = schoolState;
        this.schoolTuition = schoolTuition;
        this.schoolSat = schoolSat;
        this.isInterested=isInterested;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolCity() {
        return schoolCity;
    }

    public void setSchoolCity(String schoolCity) {
        this.schoolCity = schoolCity;
    }

    public String getSchoolState() {
        return schoolState;
    }

    public void setSchoolState(String schoolState) {
        this.schoolState = schoolState;
    }

    public int getSchoolTuition() {
        return schoolTuition;
    }

    public void setSchoolTuition(int schoolTuition) {
        this.schoolTuition = schoolTuition;
    }

    public int getSchoolSat() {
        return schoolSat;
    }

    public void setSchoolSat(int schoolSat) {
        this.schoolSat = schoolSat;
    }

    public boolean isInterested() {
        return isInterested;
    }

    public void setIsInterested(boolean interested) {
        isInterested = interested;
    }

    public CollegeList withId(Integer id){
        this.id = id;
        return this;
    }
    public CollegeList withEmail(String email){
        this.userEmail = email;
        return this;
    }
    public CollegeList withSchoolId(Integer schoolId){
        this.schoolId = schoolId;
        return this;
    }

    public CollegeList withSchoolName(String schoolName ){
        this.schoolName = schoolName;
        return this;
    }

    public CollegeList withSchoolCity(String schoolCity){
        this.schoolCity = schoolCity;
        return this;
    }
    public CollegeList withSchoolState(String schoolState){
        this.schoolState = schoolState;
        return this;
    }

    public CollegeList withSchoolTuition(Integer schoolTuition){
        this.schoolTuition = schoolTuition;
        return this;
    }

    public CollegeList withSchoolSat(Integer schoolSat){
        this.schoolSat= schoolSat;
        return  this;
    }
public  CollegeList withIsInterested(Boolean isInterested){
        this.isInterested=isInterested;
        return this;
}
}