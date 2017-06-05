package com.example.thear.ecampus20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StudentInfo {
    @SerializedName("studyGroupId")
    @Expose
    private String studyGroupId;
    @SerializedName("studyGroupName")
    @Expose
    private String studyGroupName;
    @SerializedName("studyCourse")
    @Expose
    private String studyCourse;
    @SerializedName("dcStudyGroupId")
    @Expose
    private String dcStudyGroupId;
    @SerializedName("proftraintotalId")
    @Expose
    private String proftraintotalId;
    @SerializedName("proftrain")
    @Expose
    private String proftrain;
    @SerializedName("totalShifr")
    @Expose
    private String totalShifr;
    @SerializedName("okrId")
    @Expose
    private String okrId;
    @SerializedName("okr")
    @Expose
    private String okr;
    @SerializedName("cathedraId")
    @Expose
    private String cathedraId;
    @SerializedName("cathedra")
    @Expose
    private String cathedra;
    @SerializedName("dcStudyFormId")
    @Expose
    private String dcStudyFormId;
    @SerializedName("studyformname")
    @Expose
    private String studyformname;
    @SerializedName("yearIntake")
    @Expose
    private String yearIntake;

    public String getStudyGroupId() {
        return studyGroupId;
    }

    public void setStudyGroupId(String studyGroupId) {
        this.studyGroupId = studyGroupId;
    }

    public String getStudyGroupName() {
        return studyGroupName;
    }

    public void setStudyGroupName(String studyGroupName) {
        this.studyGroupName = studyGroupName;
    }

    public String getStudyCourse() {
        return studyCourse;
    }

    public void setStudyCourse(String studyCourse) {
        this.studyCourse = studyCourse;
    }

    public String getDcStudyGroupId() {
        return dcStudyGroupId;
    }

    public void setDcStudyGroupId(String dcStudyGroupId) {
        this.dcStudyGroupId = dcStudyGroupId;
    }

    public String getProftraintotalId() {
        return proftraintotalId;
    }

    public void setProftraintotalId(String proftraintotalId) {
        this.proftraintotalId = proftraintotalId;
    }

    public String getProftrain() {
        return proftrain;
    }

    public void setProftrain(String proftrain) {
        this.proftrain = proftrain;
    }

    public String getTotalShifr() {
        return totalShifr;
    }

    public void setTotalShifr(String totalShifr) {
        this.totalShifr = totalShifr;
    }

    public String getOkrId() {
        return okrId;
    }

    public void setOkrId(String okrId) {
        this.okrId = okrId;
    }

    public String getOkr() {
        return okr;
    }

    public void setOkr(String okr) {
        this.okr = okr;
    }

    public String getCathedraId() {
        return cathedraId;
    }

    public void setCathedraId(String cathedraId) {
        this.cathedraId = cathedraId;
    }

    public String getCathedra() {
        return cathedra;
    }

    public void setCathedra(String cathedra) {
        this.cathedra = cathedra;
    }

    public String getDcStudyFormId() {
        return dcStudyFormId;
    }

    public void setDcStudyFormId(String dcStudyFormId) {
        this.dcStudyFormId = dcStudyFormId;
    }

    public String getStudyformname() {
        return studyformname;
    }

    public void setStudyformname(String studyformname) {
        this.studyformname = studyformname;
    }

    public String getYearIntake() {
        return yearIntake;
    }

    public void setYearIntake(String yearIntake) {
        this.yearIntake = yearIntake;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
