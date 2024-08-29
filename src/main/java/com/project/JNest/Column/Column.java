package com.project.JNest.Column;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Column {

    private List<Object> column = new ArrayList<>();
    private String name = "Unnamed";

    public void setColumn(List<Object> column) {
        this.column = column;
    }

    public void setColumn(List<Object> column, String name) {
        this.column = column;
        this.name = name;
    }

    public void print() {
        if(column.isEmpty()) {
            throw new RuntimeException("Column " + name + " Does not exists!");
        }
        if (column.size() > 10) {
            for (int i = 0; i < Math.min(5, column.size()); i++) {
                System.out.println(column.get(i));
            }
            System.out.println("...");
            for (int i = Math.max(0, column.size() - 5); i < column.size(); i++) {
                System.out.println(column.get(i));
            }
        } else {
            for (Object o : column) {
                System.out.println(o);
            }
        }
    }

    public int count() {
        return column.size();
    }

    public int countIf(Object value) {
        return column.stream().filter(v -> v.equals(value)).collect(Collectors.toList()).size();
    }

    public int countIfNot(Object value) {
        return column.stream().filter(v -> !v.equals(value)).collect(Collectors.toList()).size();
    }

    public Column filter(Object value) {
        Column col = new Column();
        col.setColumn(column.stream().filter(v -> v.equals(value)).collect(Collectors.toList()), name);
        return col;
    }

}
