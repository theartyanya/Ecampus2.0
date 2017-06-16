
package com.example.thear.ecampus20.model;

import com.example.thear.ecampus20.model.ComponentDiscipline;
import com.example.thear.ecampus20.model.Discipline;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisciplineModel {

    @SerializedName("rtDisciplineId")
    @Expose
    private Integer rtDisciplineId;
    @SerializedName("profTrainTotalId")
    @Expose
    private Object profTrainTotalId;
    @SerializedName("profTrainTotalSubdivisionId")
    @Expose
    private Object profTrainTotalSubdivisionId;
    @SerializedName("cycleId")
    @Expose
    private Object cycleId;
    @SerializedName("component")
    @Expose
    private ComponentDiscipline component;
    @SerializedName("loadId")
    @Expose
    private Object loadId;
    @SerializedName("discipline8")
    @Expose
    private Discipline discipline8;
    @SerializedName("shifr")
    @Expose
    private String shifr;
    @SerializedName("countHour")
    @Expose
    private Object countHour;
    @SerializedName("creditNational")
    @Expose
    private Object creditNational;
    @SerializedName("creditECTS")
    @Expose
    private Object creditECTS;
    @SerializedName("outCredit")
    @Expose
    private Boolean outCredit;
    @SerializedName("actuality")
    @Expose
    private Boolean actuality;
    @SerializedName("changeDate")
    @Expose
    private String changeDate;
    @SerializedName("status")
    @Expose
    private Boolean status;
    @SerializedName("statusDate")
    @Expose
    private String statusDate;
    @SerializedName("nameFull")
    @Expose
    private String nameFull;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("competence")
    @Expose
    private String competence;
    @SerializedName("knowledge")
    @Expose
    private String knowledge;
    @SerializedName("skill")
    @Expose
    private String skill;
    @SerializedName("userAccount")
    @Expose
    private Integer userAccount;
    @SerializedName("ip")
    @Expose
    private String ip;
    @SerializedName("dateIP")
    @Expose
    private Object dateIP;
    @SerializedName("dcSpecializationId")
    @Expose
    private Integer dcSpecializationId;

    public Integer getRtDisciplineId() {
        return rtDisciplineId;
    }

    public void setRtDisciplineId(Integer rtDisciplineId) {
        this.rtDisciplineId = rtDisciplineId;
    }

    public Object getProfTrainTotalId() {
        return profTrainTotalId;
    }

    public void setProfTrainTotalId(Object profTrainTotalId) {
        this.profTrainTotalId = profTrainTotalId;
    }

    public Object getProfTrainTotalSubdivisionId() {
        return profTrainTotalSubdivisionId;
    }

    public void setProfTrainTotalSubdivisionId(Object profTrainTotalSubdivisionId) {
        this.profTrainTotalSubdivisionId = profTrainTotalSubdivisionId;
    }

    public Object getCycleId() {
        return cycleId;
    }

    public void setCycleId(Object cycleId) {
        this.cycleId = cycleId;
    }

    public ComponentDiscipline getComponent() {
        return component;
    }

    public void setComponent(ComponentDiscipline component) {
        this.component = component;
    }

    public Object getLoadId() {
        return loadId;
    }

    public void setLoadId(Object loadId) {
        this.loadId = loadId;
    }

    public Discipline getDiscipline8() {
        return discipline8;
    }

    public void setDiscipline8(Discipline discipline8) {
        this.discipline8 = discipline8;
    }

    public String getShifr() {
        return shifr;
    }

    public void setShifr(String shifr) {
        this.shifr = shifr;
    }

    public Object getCountHour() {
        return countHour;
    }

    public void setCountHour(Object countHour) {
        this.countHour = countHour;
    }

    public Object getCreditNational() {
        return creditNational;
    }

    public void setCreditNational(Object creditNational) {
        this.creditNational = creditNational;
    }

    public Object getCreditECTS() {
        return creditECTS;
    }

    public void setCreditECTS(Object creditECTS) {
        this.creditECTS = creditECTS;
    }

    public Boolean getOutCredit() {
        return outCredit;
    }

    public void setOutCredit(Boolean outCredit) {
        this.outCredit = outCredit;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getStatusDate() {
        return statusDate;
    }

    public void setStatusDate(String statusDate) {
        this.statusDate = statusDate;
    }

    public String getNameFull() {
        return nameFull;
    }

    public void setNameFull(String nameFull) {
        this.nameFull = nameFull;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCompetence() {
        return competence;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public String getKnowledge() {
        return knowledge;
    }

    public void setKnowledge(String knowledge) {
        this.knowledge = knowledge;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Object getDateIP() {
        return dateIP;
    }

    public void setDateIP(Object dateIP) {
        this.dateIP = dateIP;
    }

    public Integer getDcSpecializationId() {
        return dcSpecializationId;
    }

    public void setDcSpecializationId(Integer dcSpecializationId) {
        this.dcSpecializationId = dcSpecializationId;
    }

}
