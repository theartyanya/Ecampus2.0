
package com.example.thear.ecampus20.model.rnp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RnpModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("specialization")
    @Expose
    private Specialization specialization;
    @SerializedName("studyingYear")
    @Expose
    private StudyingYear studyingYear;
    @SerializedName("studyForm")
    @Expose
    private StudyForm studyForm;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("actuality")
    @Expose
    private Boolean actuality;
    @SerializedName("changeDate")
    @Expose
    private String changeDate;
    @SerializedName("irFile")
    @Expose
    private IrFile irFile;
    @SerializedName("userAccount")
    @Expose
    private UserAccount userAccount;
    @SerializedName("qualification")
    @Expose
    private Qualification qualification;
    @SerializedName("studyTermYear")
    @Expose
    private Integer studyTermYear;
    @SerializedName("studyTermMonth")
    @Expose
    private Integer studyTermMonth;
    @SerializedName("okr")
    @Expose
    private Okr okr;
    @SerializedName("protocolNumber")
    @Expose
    private Object protocolNumber;
    @SerializedName("protocolDate")
    @Expose
    private Object protocolDate;
    @SerializedName("dean")
    @Expose
    private String dean;
    @SerializedName("headDepartment")
    @Expose
    private String headDepartment;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public StudyingYear getStudyingYear() {
        return studyingYear;
    }

    public void setStudyingYear(StudyingYear studyingYear) {
        this.studyingYear = studyingYear;
    }

    public StudyForm getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(StudyForm studyForm) {
        this.studyForm = studyForm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public IrFile getIrFile() {
        return irFile;
    }

    public void setIrFile(IrFile irFile) {
        this.irFile = irFile;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public Qualification getQualification() {
        return qualification;
    }

    public void setQualification(Qualification qualification) {
        this.qualification = qualification;
    }

    public Integer getStudyTermYear() {
        return studyTermYear;
    }

    public void setStudyTermYear(Integer studyTermYear) {
        this.studyTermYear = studyTermYear;
    }

    public Integer getStudyTermMonth() {
        return studyTermMonth;
    }

    public void setStudyTermMonth(Integer studyTermMonth) {
        this.studyTermMonth = studyTermMonth;
    }

    public Okr getOkr() {
        return okr;
    }

    public void setOkr(Okr okr) {
        this.okr = okr;
    }

    public Object getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(Object protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public Object getProtocolDate() {
        return protocolDate;
    }

    public void setProtocolDate(Object protocolDate) {
        this.protocolDate = protocolDate;
    }

    public String getDean() {
        return dean;
    }

    public void setDean(String dean) {
        this.dean = dean;
    }

    public String getHeadDepartment() {
        return headDepartment;
    }

    public void setHeadDepartment(String headDepartment) {
        this.headDepartment = headDepartment;
    }

}
