package com.project.JNest.DataGroup;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataGroup {
    
    Map<Object, List<List<Object>>> dataGroup = new HashMap<>();

    public void setData(Map<Object, List<List<Object>>> dataGroup) {
        this.dataGroup = dataGroup;
    }

    public void print() {
        for (Map.Entry<Object, List<List<Object>>> entry : dataGroup.entrySet()) {
            System.out.println("Department: " + entry.getKey());
            for (List<Object> row : entry.getValue()) {
                System.out.println(row);
            }
        }
    }

    public List<List<Object>> get(String name) {
        return dataGroup.get(name);
    }

}
