
package com.example.thear.ecampus20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;

public class BlockDisc implements Serializable {

    @SerializedName("cDisciplineBlockYear8Id")
    @Expose
    private long cDisciplineBlockYear8Id;
    @SerializedName("subdivision")
    @Expose
    private String subdivision;
    @SerializedName("nameUkr")
    @Expose
    private String nameUkr;
    @SerializedName("competence")
    @Expose
    private String competence;
    @SerializedName("knowledge")
    @Expose
    private String knowledge;
    @SerializedName("skill")
    @Expose
    private String skill;
    @SerializedName("nameEng")
    @Expose
    private String nameEng;
    @SerializedName("annotationEng")
    @Expose
    private String annotationEng;
    @SerializedName("pic")
    @Expose
    private Object pic;
    @SerializedName("maxCountStudent")
    @Expose
    private long maxCountStudent;
    @SerializedName("studentCount")
    @Expose
    private long studentCount;
    private boolean isChecked = false;

    public long getCDisciplineBlockYear8Id() {
        return cDisciplineBlockYear8Id;
    }

    public void setCDisciplineBlockYear8Id(long cDisciplineBlockYear8Id) {
        this.cDisciplineBlockYear8Id = cDisciplineBlockYear8Id;
    }

    public String getSubdivision() {
        return subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    public String getNameUkr() {
        return nameUkr;
    }

    public void setNameUkr(String nameUkr) {
        this.nameUkr = nameUkr;
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

    public String getNameEng() {
        return nameEng;
    }

    public void setNameEng(String nameEng) {
        this.nameEng = nameEng;
    }

    public String getAnnotationEng() {
        return annotationEng;
    }

    public void setAnnotationEng(String annotationEng) {
        this.annotationEng = annotationEng;
    }

    public Object getPic() {
        return pic;
    }

    public void setPic(Object pic) {
        this.pic = pic;
    }

    public long getMaxCountStudent() {
        return maxCountStudent;
    }

    public void setMaxCountStudent(long maxCountStudent) {
        this.maxCountStudent = maxCountStudent;
    }

    public long getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(long studentCount) {
        this.studentCount = studentCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
