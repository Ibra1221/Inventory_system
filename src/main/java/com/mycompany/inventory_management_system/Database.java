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
            System.out.println("✅Successfully read records from file: " + filename);
        } catch (Exception e) {
            System.out.println("❌Failed to read from file: " + filename);
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
                System.out.println("✅Record found for key: " + key);
                return records.get(i);
            }
        }
        System.out.println("Record not found for key: " + key);
        return null;
    }

    public ArrayList<D> returnAllRecords() {
        return records;
    }

    public abstract void insertRecord(D record);

    public void deleteRecord(String key) {
        boolean deleted = false;
        for (int i = 0; i < records.size(); i++) {
            if (getKey(records.get(i)).equals(key)) {
                records.remove(i);
                deleted = true;
                i--;
            }
        }
        if (deleted) {
            System.out.println("Successfully deleted record with key: " + key);
        } else {
            System.out.println("No record found to delete with key: " + key);
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
            System.out.println("Successfully saved records to file: " + filename);
        } catch (IOException e) {
            System.out.println("Failed to save records to file: " + filename);
            System.out.println(e);
        }
    }
}
