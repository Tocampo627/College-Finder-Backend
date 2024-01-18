package com.collegeFinder.CollegeFinderAPI.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StudentProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;
    String email;
    String firstName;
    String lastName;
    String privatePublic; //1 Public , 2 Private nonprofit, 3 Private for-profit
    String regionUsa; // range 0-9
    String locationSize; // city,town,rural, urban,
    int satScore;
    int maxCostOfAttendance;//
    boolean isActive = true;

    public StudentProfile(){}
    //using builder pattern (Design Pattern) --> MBC architecture, Builder Pattern, test driven developent(practice not pattern),



    public StudentProfile(Integer id, String firstName, String lastName, String privatePublic, String regionUsa, String locationSize, int satScore, int maxCostOfAttendance, boolean isActive) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.privatePublic = privatePublic;
        this.regionUsa = regionUsa;
        this.locationSize = locationSize;
        this.satScore = satScore;
        this.maxCostOfAttendance = maxCostOfAttendance;
        this.isActive = isActive;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPrivatePublic() {
        return privatePublic;
    }

    public void setPrivatePublic(String privatePublic) {
        this.privatePublic = privatePublic;
    }

    public String getRegionUsa() {
        return regionUsa;
    }

    public void setRegionUsa(String regionUsa) {
        this.regionUsa = regionUsa;
    }

    public String getLocationSize() {
        return locationSize;
    }

    public void setLocationSize(String locationSize) {
        this.locationSize = locationSize;
    }

    public Integer getSatScore() {
        return satScore;
    }

    public void setSatScore(Integer satScore) {
        this.satScore = satScore;
    }

    public Integer getMaxCostOfAttendance() {
        return maxCostOfAttendance;
    }

    public void setMaxCostOfAttendance(Integer maxCostOfAttendance) {
        this.maxCostOfAttendance = maxCostOfAttendance;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }


    public StudentProfile withId(Integer id){
        this.id = id;
        return this;
    }

    public StudentProfile withEmail(String email){
        this.email = email;
        return this;
    }
    public StudentProfile withFirstName(String firstName){
        this.firstName = firstName;
        //returns the student we are building (the class)
        return this;
    }
    public StudentProfile withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public StudentProfile withPrivatePublic(String privatePublic){
        this.privatePublic = privatePublic;
        return this;
    }
    public StudentProfile withRegionUsa(String regionUsa){
        this.regionUsa = regionUsa;
        return this;
    }
    public StudentProfile withLocationSize(String locationSize){
        this.locationSize = locationSize;
        return this;
    }
    public StudentProfile withSatScore(int satScore){
        this.satScore = satScore;
        return this;
    }
    public StudentProfile withMaxCostOfAttendance(int maxCostOfAttendance){
        this.maxCostOfAttendance = maxCostOfAttendance;
        return this;
    }

    public StudentProfile withIsActive(boolean isActive){
        this.isActive = isActive;
        return this;
    }

}
