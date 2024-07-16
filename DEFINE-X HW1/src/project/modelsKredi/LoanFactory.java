package project.modelsKredi;

import java.math.BigDecimal;

public class LoanFactory {

    private static LoanFactory instance;

    private LoanFactory() {
    }

    public static LoanFactory getInstance() {
        if (instance == null) {
            instance = new LoanFactory();
        }
        return instance;
    }

    public Loan createLoan(String loanType, BigDecimal amount, int installment, Bank bank, double interestRate,
            String... args) {

        if (loanType.equalsIgnoreCase("consumer"))
            return createConsumerLoan(amount, installment, bank, interestRate);

        else if (loanType.equalsIgnoreCase("mortgage"))
            return createMortgageLoan(amount, installment, bank, interestRate, args[0]);

        else if (loanType.equalsIgnoreCase("vehicle"))
            return createVehicleLoan(amount, installment, bank, interestRate, args[0], args[1], args[2],
                    Double.parseDouble(args[3]));

        else
            return null;

    }

    private ConsumerLoan createConsumerLoan(BigDecimal amount, int installment, Bank bank, double interestRate) {
        return new ConsumerLoan(amount, installment, bank, interestRate);
    }

    private MortgageLoan createMortgageLoan(BigDecimal amount, int installment, Bank bank, double interestRate,
            String propertyAddress) {
        return new MortgageLoan(amount, installment, bank, interestRate, propertyAddress);
    }

    private VehicleLoan createVehicleLoan(BigDecimal amount, int installment, Bank bank, double interestRate,
            String vehicleType, String vehicleModel, String vehicleYear, double vehiclePrice) {
        return new VehicleLoan(amount, installment, bank, interestRate, vehicleType, vehicleModel, vehicleYear,
                vehiclePrice);
    }
}
