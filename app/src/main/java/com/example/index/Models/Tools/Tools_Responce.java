package com.example.index.Models.Tools;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Tools_Responce {
    private int code;
    private String desc;
    @SerializedName("value")
    private List<Tool> toolList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public List<Tool> getToolList() {
        return toolList;
    }

    public void setToolList(List<Tool> toolList) {
        this.toolList = toolList;
    }

    @Override
    public String toString() {
        return "Tools_Responce{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                ", toolList=" + toolList +
                '}';
    }
}
