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
                    String phone = parts[2];
                    dealership = new Dealership(name, address, phone);
                }
            }
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length >= 8 && dealership != null) {
                    int vin = Integer.parseInt(parts[0]);
                    int year = Integer.parseInt(parts[1]);
                    String make = parts[2];
                    String model = parts[3];
                    String vehicleType = parts[4];
                    String color = parts[5];
                    int odometer = Integer.parseInt(parts[6]);
                    double price = Double.parseDouble(parts[7]);
                    Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
                    dealership.addVehicle(vehicle);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
        return dealership;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
            for (Vehicle vehicle : dealership.getInventory()) {
                bw.write(vehicle.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}