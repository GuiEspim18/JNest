package com.project;

import com.project.JNest.JNest;
import com.project.JNest.DataGroup.DataGroup;
import com.project.JNest.DataNest.DataNest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {

        DataNest dn = JNest.read("C:/Users/6128094/OneDrive - Thomson Reuters Incorporated/Desktop/format-table/to-convert/HC_08_2024.xlsx");

        dn.printFirstN(1);
    }
}
