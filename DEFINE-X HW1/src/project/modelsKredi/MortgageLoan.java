package project.modelsKredi;

import java.math.BigDecimal;

import project.enums.LoanType;

public class MortgageLoan extends Loan {
    private LoanType loanType = LoanType.KONUT_KREDISI;
    private String propertyAddress;

    public MortgageLoan(BigDecimal amount, Integer installment, Bank bank, Double interestRate,
            String propertyAddress) {
        super(amount, installment, bank, interestRate);
        this.propertyAddress = propertyAddress;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        // tc bul, maaşı bul
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    @Override
    public String toString() {
        return "MortgageLoan{" +
                "Bank=" + getBank().getName() +
                ", propertyAddress='" + propertyAddress + '\'' +
                '}';
    }

}
