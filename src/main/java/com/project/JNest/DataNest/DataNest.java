package com.project.JNest.DataNest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataNest {

    private List<List<Object>> dataNest = new ArrayList();
    private Map<String, Integer> headerMap = new HashMap<>();

    public void setHeader(List<Object> header) {
        for (int i = 0; i < header.size(); i++) {
            headerMap.put(header.get(i).toString(), i);
        }
    }

    public void addRow(List<Object> row) {
        dataNest.add(row);
    }

    public List<List<Object>> get() {
        return dataNest;
    }

    public List<Object> getColumn(int index) {
        List<Object> column = new ArrayList<>();
        for (List<Object> row : dataNest) {
            if (row.size() > index) {
                column.add(row.get(index));
            } else {
                column.add(null);
            }
        }
        return column;
    }

    public List<Object> getColumn(String name) {
        List<Object> column = new ArrayList<>();
        Integer index = headerMap.get(name);
        if (index == null) {
            throw new RuntimeException("Column " + name + " Does not exists!");
        }
        for (List<Object> row : dataNest) {
            if (row.size() > index) {
                column.add(row.get(index));
            } else {
                column.add(null);
            }
        }
        return column;
    }

    public void printColumn(String name) {
        List<Object> column = getColumn(name);
        if(column.isEmpty()) {
            throw new RuntimeException("Column " + name + " Does not exists!");
        }
        for (int i = 0; i < Math.min(5, column.size()); i++) {
            System.out.println(column.get(i));
        }
        System.out.println("...");
        for (int i = Math.max(0, column.size() - 5); i < column.size(); i++) {
            System.out.println(column.get(i));
        }
    }

    public List<List<Object>> filterRows(String column, Object value) {
        List<List<Object>> filteredRows = new ArrayList<>();
        Integer index = headerMap.get(column);
        if (index == null) {
            throw new RuntimeException("Column " + column + " Does not exists!");
        }
        for (List<Object> row : dataNest) {
            if (row.size() > index && row.get(index).equals(value)) {
                filteredRows.add(row);
            }
        }
        return filteredRows;
    }

    public List<Object> getRow(int index) {
        if (index >= 0 && index < dataNest.size()) {
            return dataNest.get(index);
        } else {
            return null;
        }
    }

    public void removeRow(int index) {
        if (index >= 0 && index < dataNest.size()) {
            dataNest.remove(index);
        } else {
            System.out.println("Índice fora do intervalo.");
        }
    }

    public int count() {
        return dataNest.size();
    }

    public int countColumn() {
        if (dataNest.isEmpty()) {
            return 0;
        }
        return dataNest.get(0).size();
    }

    public void addColumn(String columnName, Object data) {
        headerMap.put(columnName, headerMap.size());
        for (int i = 0; i < dataNest.size(); i++) {
            dataNest.get(i).add(data);
        }
    }

    public void addColumn(String columnName, List<Object> columnData) {
        if (dataNest.size() != columnData.size()) {
            throw new RuntimeException("The quantity of lines does not correspond of the DataFrame quantity of lines!");
        }
        headerMap.put(columnName, headerMap.size());
        for (int i = 0; i < dataNest.size(); i++) {
            dataNest.get(i).add(columnData.get(i));
        }
    }

}
