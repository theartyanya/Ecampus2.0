
package com.example.thear.ecampus20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DisciplineWhoRead {

    @SerializedName("cRNPRow8Id")
    @Expose
    private Integer cRNPRow8Id;
    @SerializedName("cRNP8Id")
    @Expose
    private Integer cRNP8Id;
    @SerializedName("whoRead")
    @Expose
    private String whoRead;
    @SerializedName("name")
    @Expose
    private String name;

    public Integer getCRNPRow8Id() {
        return cRNPRow8Id;
    }

    public void setCRNPRow8Id(Integer cRNPRow8Id) {
        this.cRNPRow8Id = cRNPRow8Id;
    }

    public Integer getCRNP8Id() {
        return cRNP8Id;
    }

    public void setCRNP8Id(Integer cRNP8Id) {
        this.cRNP8Id = cRNP8Id;
    }

    public String getWhoRead() {
        return whoRead;
    }

    public void setWhoRead(String whoRead) {
        this.whoRead = whoRead;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
