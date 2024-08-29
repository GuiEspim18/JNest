package com.project;

import com.project.JNest.DataGroup.DataGroup;
import com.project.JNest.DataNest.DataNest;
import com.project.JNest.JNest;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class App {
    public static void main( String[] args ) {
//        DataNest dataNest = new DataNest();
//
//        List<Object> header = Arrays.asList("Name", "Age", "Department");
//        dataNest.setHeader(header);
//
//        dataNest.addRow(Arrays.asList("Alice", 30, "HR"));
//        dataNest.addRow(Arrays.asList("Bob", 25, "Engineering"));
//        dataNest.addRow(Arrays.asList("Charlie", 35, "HR"));
//        dataNest.addRow(Arrays.asList("David", 28, "Engineering"));
//
//        dataNest.filter("Department", "HR");
//
//        dataNest.print();

        DataNest dn = JNest.read("src/main/resources/editais-covid19.xlsx");

        System.out.println("Situação lote de vaicnação covid-19");
        System.out.println("Deserto (encerrado) " + dn.countIf("situacaoLote", "Deserto (encerrado)"));
        System.out.println("Encerrado " + dn.countIf("situacaoLote", "Encerrado"));
        System.out.println("Suspenso " + dn.countIf("situacaoLote", "Suspenso"));
        System.out.println("Cancelado " + dn.countIf("situacaoLote", "Cancelado"));
        System.out.println("Adjudicado " + dn.countIf("situacaoLote", "Adjudicado"));
    }
}
