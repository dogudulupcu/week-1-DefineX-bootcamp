package project.modelsKredi;

import project.enums.ApplicationStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Application {

    private Loan loan;
    private BigDecimal loanAmount;
    private CreditCard creditCard;
    private User user;
    private LocalDate localDateTime;
    private ApplicationStatus applicationStatus;

    public Application(Loan loan,BigDecimal loanAmount, User user, LocalDate localDateTime) {
        this.loan = loan;
        this.loanAmount = loanAmount;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        this.user.addApplication(this);
    }

    public Application(CreditCard creditCard, User user, LocalDate localDateTime) {
        this.creditCard = creditCard;
        this.user = user;
        this.localDateTime = localDateTime;
        this.applicationStatus = ApplicationStatus.INITIAL;
        this.user.addApplication(this);
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDate getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDate localDateTime) {
        this.localDateTime = localDateTime;
    }

    public ApplicationStatus getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(ApplicationStatus applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public String toString() {
        if (loan != null) {
            return "Application{" +
                    "loan=" + loan +
                    ", loanAmount=" + loanAmount +
                    ", user=" + user +
                    ", localDateTime=" + localDateTime +
                    ", applicationStatus=" + applicationStatus +
                    '}';
        }
        return "Application{" +
                "creditCard=" + creditCard +
                ", user=" + user +
                ", localDateTime=" + localDateTime +
                ", applicationStatus=" + applicationStatus +
                '}';
    }
}
