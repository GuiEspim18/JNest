package com.project.JNest.DataNest;

import com.project.JNest.Column.Column;

import java.util.*;

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

    public Column getColumn(String name) {
        Column column = new Column();
        Integer index = headerMap.get(name);
        if (index == null) {
            throw new RuntimeException("Column " + name + " Does not exists!");
        }
        List<Object> col = new ArrayList<>();
        for (List<Object> row : dataNest) {
            if (row.size() > index) {
                col.add(row.get(index));
            } else {
                col.add(null);
            }
        }
        column.setColumn(col, name);
        return column;
    }

    public DataNest filter(String column, Object value) {
        DataNest filteredRows = new DataNest();
        Integer index = headerMap.get(column);
        if (index == null) {
            throw new RuntimeException("Column " + column + " Does not exists!");
        }
        int rowCount = 0;
        for (List<Object> row : dataNest) {
            if (row.size() > index && row.get(index).equals(value)) {
                if (rowCount == 0) {
                    filteredRows.setHeader(row);
                }
                filteredRows.addRow(row);
            }
            rowCount++;
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

    public int countColumns() {
        if (dataNest.isEmpty()) {
            return 0;
        }
        return dataNest.get(0).size();
    }

    public void addColumn(String columnName, Object data) {
        headerMap.put(columnName, headerMap.size());
        for (List<Object> objects : dataNest) {
            objects.add(data);
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

    public void print() {
        for (List<Object> row : dataNest) {
            String rowLine = "";
            for (Object cell : row) {
                rowLine += " " + cell;
            }
            System.out.println(rowLine);
        }
    }

}
