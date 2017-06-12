
package com.example.thear.ecampus20.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

public class Block implements Serializable {

    @SerializedName("blockChoiceWhomId")
    @Expose
    private long blockChoiceWhomId;
    @SerializedName("component")
    @Expose
    private Component component;
    @SerializedName("block")
    @Expose
    private Block_ block;
    @SerializedName("disciplineCount")
    @Expose
    private long disciplineCount;
    @SerializedName("blockDisc")
    @Expose
    private List<BlockDisc> blockDisc = null;

    public long getBlockChoiceWhomId() {
        return blockChoiceWhomId;
    }

    public void setBlockChoiceWhomId(long blockChoiceWhomId) {
        this.blockChoiceWhomId = blockChoiceWhomId;
    }

    public Component getComponent() {
        return component;
    }

    public void setComponent(Component component) {
        this.component = component;
    }

    public Block_ getBlock() {
        return block;
    }

    public void setBlock(Block_ block) {
        this.block = block;
    }

    public long getDisciplineCount() {
        return disciplineCount;
    }

    public void setDisciplineCount(long disciplineCount) {
        this.disciplineCount = disciplineCount;
    }

    public List<BlockDisc> getBlockDisc() {
        return blockDisc;
    }

    public void setBlockDisc(List<BlockDisc> blockDisc) {
        this.blockDisc = blockDisc;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
