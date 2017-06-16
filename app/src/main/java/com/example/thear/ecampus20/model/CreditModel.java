package com.example.thear.ecampus20.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreditModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("nameFull")
    @Expose
    private String nameFull;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("nameShort")
    @Expose
    private String nameShort;
    @SerializedName("competence")
    @Expose
    private String competence;
    @SerializedName("skill")
    @Expose
    private String skill;
    @SerializedName("knowledge")
    @Expose
    private String knowledge;
    @SerializedName("rtCMProposition8Id")
    @Expose
    private Object rtCMProposition8Id;
    @SerializedName("readWhomId")
    @Expose
    private Integer readWhomId;
    @SerializedName("readWhomName")
    @Expose
    private String readWhomName;
    @SerializedName("specialtyOne")
    @Expose
    private String specialtyOne;
    @SerializedName("whomRead")
    @Expose
    private String whomRead;
    @SerializedName("okr")
    @Expose
    private String okr;
    @SerializedName("specialtyTwo")
    @Expose
    private String specialtyTwo;
    @SerializedName("specialization")
    @Expose
    private String specialization;
    @SerializedName("actuality")
    @Expose
    private Boolean actuality;
    @SerializedName("changeDate")
    @Expose
    private String changeDate;
    @SerializedName("disciplineWhoRead")
    @Expose
    private List<DisciplineWhoRead> disciplineWhoRead = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameShort() {
        return nameShort;
    }

    public void setNameShort(String nameShort) {
        this.nameShort = nameShort;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public Object getRtCMProposition8Id() {
        return rtCMProposition8Id;
    }

    public void setRtCMProposition8Id(Object rtCMProposition8Id) {
        this.rtCMProposition8Id = rtCMProposition8Id;
    }

    public Integer getReadWhomId() {
        return readWhomId;
    }

    public void setReadWhomId(Integer readWhomId) {
        this.readWhomId = readWhomId;
    }

    public String getReadWhomName() {
        return readWhomName;
    }

    public void setReadWhomName(String readWhomName) {
        this.readWhomName = readWhomName;
    }

    public String getSpecialtyOne() {
        return specialtyOne;
    }

    public void setSpecialtyOne(String specialtyOne) {
        this.specialtyOne = specialtyOne;
    }

    public String getWhomRead() {
        return whomRead;
    }

    public void setWhomRead(String whomRead) {
        this.whomRead = whomRead;
    }

    public String getOkr() {
        return okr;
    }

    public void setOkr(String okr) {
        this.okr = okr;
    }

    public String getSpecialtyTwo() {
        return specialtyTwo;
    }

    public void setSpecialtyTwo(String specialtyTwo) {
        this.specialtyTwo = specialtyTwo;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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

    public List<DisciplineWhoRead> getDisciplineWhoRead() {
        return disciplineWhoRead;
    }

    public void setDisciplineWhoRead(List<DisciplineWhoRead> disciplineWhoRead) {
        this.disciplineWhoRead = disciplineWhoRead;
    }

}
