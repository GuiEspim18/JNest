package com.project.JNest.DataNest;

import com.project.JNest.Column.Column;
import com.project.JNest.DataGroup.DataGroup;
import com.project.JNest.Utils.SortType;

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

    public Column getColumn(int index) {
        Column column = new Column();
        List<Object> col = new ArrayList<>();
        for (List<Object> row : dataNest) {
            if (row.size() > index) {
                col.add(row.get(index));
            } else {
                col.add(null);
            }
        }
        column.setColumn(col);
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

    public void filter(String column, Object value) {
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
        dataNest = filteredRows;
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

    public int countIf(String column, Object value) {
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
        return filteredRows.size();
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

    public void sort(String column) {
        Integer index = headerMap.get(column);
        if (index == null) {
            throw new RuntimeException("Column " + column + " does not exist!");
        }

        dataNest.sort((row1, row2) -> {
            Object value1 = row1.get(index);
            Object value2 = row2.get(index);

            if (value1 == null && value2 == null) {
                return 0;
            } else if (value1 == null) {
                return 1;
            } else if (value2 == null) {
                return -1;
            }

            if (value1 instanceof Comparable && value2 instanceof Comparable) {
                int comparison = ((Comparable<Object>) value1).compareTo(value2);
                return comparison;
            } else {
                throw new IllegalArgumentException("Column values are not comparable.");
            }
        });
    }

    public void sort(String column, Integer sort) {
        Integer index = headerMap.get(column);
        if (index == null) {
            throw new RuntimeException("Column " + column + " does not exist!");
        }

        dataNest.sort((row1, row2) -> {
            Object value1 = row1.get(index);
            Object value2 = row2.get(index);

            if (value1 == null && value2 == null) {
                return 0;
            } else if (value1 == null) {
                return sort.equals(SortType.ASC) ? -1 : 1;
            } else if (value2 == null) {
                return sort.equals(SortType.ASC) ? 1 : -1;
            }

            if (value1 instanceof Comparable && value2 instanceof Comparable) {
                @SuppressWarnings("unchecked")
                int comparison = ((Comparable<Object>) value1).compareTo(value2);
                return sort.equals(SortType.ASC) ? comparison : -comparison;
            } else {
                throw new IllegalArgumentException("Column values are not comparable.");
            }
        });
    }

    public DataGroup groupBy(String columnName) {
        Integer index = headerMap.get(columnName);
        if (index == null) {
            throw new RuntimeException("Column " + columnName + " does not exist!");
        }

        Map<Object, List<List<Object>>> groupedData = new HashMap<>();

        for (List<Object> row : dataNest) {
            Object key = row.get(index);
            groupedData.computeIfAbsent(key, k -> new ArrayList<>()).add(row);
        }

        DataGroup dg = new DataGroup();
        dg.setData(groupedData);

        return dg;
    }

    public DataNest merge(DataNest other, String onColumn) {
        Integer indexThis = headerMap.get(onColumn);
        Integer indexOther = other.headerMap.get(onColumn);

        if (indexThis == null || indexOther == null) {
            throw new RuntimeException("Column " + onColumn + " does not exist in one of the DataNests!");
        }

        // Criar um novo DataNest para armazenar o resultado da mesclagem
        DataNest mergedDataNest = new DataNest();

        // Combinar os cabeçalhos das duas tabelas, cuidando para evitar duplicatas
        List<Object> mergedHeader = new ArrayList<>(headerMap.keySet());
        for (String header : other.headerMap.keySet()) {
            if (!mergedHeader.contains(header)) {
                mergedHeader.add(header);
            }
        }
        mergedDataNest.setHeader(mergedHeader);

        // Mapa para armazenar as linhas do "other" DataNest por valor da chave
        Map<Object, List<Object>> otherRowsMap = new HashMap<>();
        for (List<Object> row : other.dataNest) {
            Object key = row.get(indexOther);
            otherRowsMap.put(key, row);
        }

        // Iterar pelas linhas do DataNest atual e mesclar com o "other" DataNest
        for (List<Object> row : dataNest) {
            Object key = row.get(indexThis);
            List<Object> otherRow = otherRowsMap.get(key);

            if (otherRow != null) {
                List<Object> mergedRow = new ArrayList<>(row);

                // Adicionar colunas do otherRow, evitando duplicatas
                for (int i = 0; i < otherRow.size(); i++) {
                    if (i != indexOther) {
                        mergedRow.add(otherRow.get(i));
                    }
                }

                mergedDataNest.addRow(mergedRow);
            }
        }

        return mergedDataNest;
    }

    public List<String> getColumns() {
        return new ArrayList<>(headerMap.keySet());
    }

}
