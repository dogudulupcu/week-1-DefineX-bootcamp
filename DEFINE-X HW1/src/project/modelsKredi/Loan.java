package project.modelsKredi;

import java.math.BigDecimal;

public abstract class Loan {

    private BigDecimal amount;
    private Integer installment;
    private Bank bank;
    private Double interestRate;

    public Loan(BigDecimal amount, Integer installment, Bank bank, Double interestRate) {
        this.amount = amount;
        this.installment = installment;
        this.bank = bank;
        this.interestRate = interestRate;
        bank.addLoan(this);
    }

    abstract void calculate(BigDecimal amount, int installment);

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Integer getInstallment() {
        return installment;
    }

    public void setInstallment(Integer installment) {
        this.installment = installment;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "amount=" + amount +
                ", installment=" + installment +
                ", bank=" + bank +
                ", interestRate=" + interestRate +
                '}';
    }
}
