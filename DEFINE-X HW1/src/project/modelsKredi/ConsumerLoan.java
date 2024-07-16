package project.modelsKredi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import project.enums.LoanType;

public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;
    private List<Integer> installmentOptions = new ArrayList<>();

    public ConsumerLoan(BigDecimal amount, Integer installment, Bank bank, Double interestRate) {
        super(amount, installment, bank, interestRate);
        installmentOptions.add(installment);
    }

    @Override
    void calculate(BigDecimal amount, int installment) {
        // tc bul, maaşı bul
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public List<Integer> getInstallmentOptions() {
        return installmentOptions;
    }

    public void setInstallmentOptions(List<Integer> installmentOptions) {
        this.installmentOptions = installmentOptions;
    }

    @Override
    public String toString() {
        return "ConsumerLoan{" +
               "Bank=" + getBank().getName() +
                ", installmentOptions=" + installmentOptions +
                '}';
    }

}
