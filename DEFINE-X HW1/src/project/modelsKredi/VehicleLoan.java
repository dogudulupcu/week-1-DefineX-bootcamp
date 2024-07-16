package project.modelsKredi;

import java.math.BigDecimal;

import project.enums.LoanType;

public class VehicleLoan extends Loan {
    private LoanType loanType = LoanType.ARAC_KREDISI;
    private String vehicleType;
    private String vehicleModel;
    private String vehicleYear;
    private double vehiclePrice;

    public VehicleLoan(BigDecimal amount, int installment, Bank bank, double interestRate, String vehicleType,
            String vehicleModel, String vehicleYear, double vehiclePrice) {
        super(amount, installment, bank, interestRate);
        this.vehicleType = vehicleType;
        this.vehicleModel = vehicleModel;
        this.vehicleYear = vehicleYear;
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        // tc bul, maaşı bul
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleModel() {
        return vehicleModel;
    }

    public void setVehicleModel(String vehicleModel) {
        this.vehicleModel = vehicleModel;
    }

    public String getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(String vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public double getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public String toString() {
        return  "VehicleLoan{" +
                "Bank= " + this.getBank().getName() +
                ", vehicleType='" + vehicleType + '\'' +
                ", vehicleModel='" + vehicleModel + '\'' +
                ", vehicleYear='" + vehicleYear + '\'' +
                ", vehiclePrice=" + vehiclePrice +
                '}';
    }

}
