package com.project;

import com.project.JNest.DataGroup.DataGroup;
import com.project.JNest.DataNest.DataNest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
        DataNest dataNest = new DataNest();
        
        List<Object> header = Arrays.asList("Name", "Age", "Department");
        dataNest.setHeader(header);
        
        dataNest.addRow(Arrays.asList("Alice", 30, "HR"));
        dataNest.addRow(Arrays.asList("Bob", 25, "Engineering"));
        dataNest.addRow(Arrays.asList("Charlie", 35, "HR"));
        dataNest.addRow(Arrays.asList("David", 28, "Engineering"));
        
        DataGroup groupedData = dataNest.groupBy("Department");
    }
}
