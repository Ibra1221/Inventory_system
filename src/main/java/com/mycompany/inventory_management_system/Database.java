/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventory_management_system;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 *
 * @author pola-nasser13
 * @param <D>
 */
public abstract class Database<D extends Info> {

    protected ArrayList<D> records;
    protected String filename;

    public Database(String filename) {
        this.filename = filename;
        this.records = new ArrayList<D>();
    }

    protected abstract D createRecordFrom(String line);

    protected String getKey(D record) {
        return record.getSearchKey();
    }

    public void readFromFile() {
        records.clear();
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (!line.isEmpty()) {
                    records.add(createRecordFrom(line));
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean contains(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (getKey(records.get(i)).equals(key)) {
                return true;
            }
        }
        return false;
    }

    public D getRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (getKey(records.get(i)).equals(key)) {
                return records.get(i);
            }
        }
        return null;
    }

    public ArrayList<D> returnAllRecords() {
        return records;
    }

    public void insertRecord(D record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            if (getKey(records.get(i)).equals(key)) {
                records.remove(i);
                i--;
            }
        }
    }

    protected String recordToLine(D record) {
        return record.lineRepresentation();
    }

    public void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (int i = 0; i < records.size(); i++) {
                pw.println(recordToLine(records.get(i)));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
