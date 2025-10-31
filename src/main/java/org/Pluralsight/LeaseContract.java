public class LeaseContract extends Contract {
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(date, customerName, customerEmail, vehicleSold);
        this.expectedEndingValue = vehicleSold.getPrice() * 0.5;
        this.leaseFee = vehicleSold.getPrice() * 0.07;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold.getPrice() + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        double principal = new getVehicleSold().getPrice - expectedEndingValue;
        double rate = 0.04;
        int months = 36;
        double monthlyRate = rate / 12;
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months)) + (leaseFee / months);
    }
}
