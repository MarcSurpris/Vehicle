package org.Pluralsight;

public abstract class Contract {
    private String date;
    private String customerName;
    private String customerEmail;
    private Vehicle vehicleSold;
    private double totalPrice;
    private double monthlyPayment;

    public Contract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        this.date = date;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.vehicleSold = vehicleSold;
    }

    // Getters and setters for date, customerName, customerEmail, vehicleSold

    public abstract double getTotalPrice();
    public abstract double getMonthlyPayment();

}
