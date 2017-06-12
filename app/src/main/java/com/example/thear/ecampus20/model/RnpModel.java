package com.example.thear.ecampus20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RnpModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("yearRnp")
    @Expose
    private String yearRnp;
    @SerializedName("protocolNumber")
    @Expose
    private String protocolNumber;
    @SerializedName("course")
    @Expose
    private Integer course;
    @SerializedName("speciality")
    @Expose
    private String speciality;
    @SerializedName("okr")
    @Expose
    private String okr;
    @SerializedName("studyForm")
    @Expose
    private String studyForm;
    @SerializedName("actuality")
    @Expose
    private Boolean actuality;
    @SerializedName("changeDate")
    @Expose
    private String changeDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYearRnp() {
        return yearRnp;
    }

    public void setYearRnp(String yearRnp) {
        this.yearRnp = yearRnp;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(String protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getOkr() {
        return okr;
    }

    public void setOkr(String okr) {
        this.okr = okr;
    }

    public String getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(String studyForm) {
        this.studyForm = studyForm;
    }

    public Boolean getActuality() {
        return actuality;
    }

    public void setActuality(Boolean actuality) {
        this.actuality = actuality;
    }

    public String getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(String changeDate) {
        this.changeDate = changeDate;
    }

}
