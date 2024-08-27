package com.project;

import com.project.JNest.DataNest.DataNest;

import java.util.Arrays;

public class App {
    public static void main( String[] args ) {
        DataNest dn = new DataNest();

        dn.setHeader(Arrays.asList("Nome", "Idade", "Data"));

        dn.addRow(Arrays.asList("Alice", 30, "01/01/1990"));
        dn.addRow(Arrays.asList("Bob", 35, "15/05/1985"));
        dn.addRow(Arrays.asList("Bob", 25, "15/05/1995"));
        dn.addRow(Arrays.asList("Charlie", 35, "20/10/1985"));
        dn.addRow(Arrays.asList("Charlie", 40, "20/10/1980"));


        dn.print();

    }
}
