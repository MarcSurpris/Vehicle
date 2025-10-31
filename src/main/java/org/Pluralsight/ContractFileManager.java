package org.Pluralsight;

import java.io.*;

public class ContractFileManager {
    private static final String FILE_PATH = "contracts.csv";

    public void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            Vehicle v = contract.getVehicleSold();
            String common = (contract instanceof SalesContract ? "SALE" : "LEASE") + "|" +
                    contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|" +
                    v.getVin() + "|" + v.getYear() + "|" + v.getMake() + "|" + v.getModel() + "|" +
                    v.getVehicleType() + "|" + v.getColor()
        }
    }
}
