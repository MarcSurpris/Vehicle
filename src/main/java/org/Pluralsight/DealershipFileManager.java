package org.Pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class DealershipFileManager {
    private static final String FILE_NAME = "dealership.csv";

    public Dealership getDealership() {
        Dealership dealership = null;
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line = br.readLine();
            if (line != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 3) {
                    String name = parts[0];
                    String address = parts[1];
                }
            }
        }
    }
}
