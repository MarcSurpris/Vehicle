public class SalesContract extends Contract {
    private static final double SALES_TAX_RATE = 0.05;
    private static final double RECORDING_FEE = 100.0;
    private double processingFee;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, Vehicle vehicleSold, boolean finance) {
        super(date, customerName, customerEmail, vehicleSold);
        this.saleTaxAmount = vehicleSold.getPrice() * SALES_TAX_RATE;
        this.processingFee = (vehicleSold.getPrice() < 10000) ? 295.0 : 495.0;
        this.finance = finance;
    }

    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmmount + RECORDING_FEE + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        if (!finance) return 0.0;
        double principal = getTotalPrice();
        double rate = (getVehicleSold().getPrice() >= 10000) ? 0.0425 : 0.525;
        int months = (getVehicleSold().getPrice() >= 10000) ? 48 : 24;
        double monthlyRate = rate / 12;
        return (principal * monthlyRate) / (1 - Math.pow(1 + monthlyRate, -months));
    }
}


