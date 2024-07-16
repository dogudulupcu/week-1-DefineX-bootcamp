package project.modelsKredi;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private String addressUrl;
    private long totalLoanApplications = 0;
    private long totalCreditCardApplications = 0;
    private List<Loan> loans = new ArrayList<Loan>();
    private List<CreditCard> creditCards = new ArrayList<CreditCard>();

    public Bank(String name, String addressUrl) {
        this.name = name;
        this.addressUrl = addressUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressUrl() {
        return addressUrl;
    }

    public void setAddressUrl(String addressUrl) {
        this.addressUrl = addressUrl;
    }

    public long getTotalLoanApplications() {
        return totalLoanApplications;
    }

    public void setTotalLoanApplications(long totalLoanApplications) {
        this.totalLoanApplications = totalLoanApplications;
    }

    public long getTotalCreditCardApplications() {
        return totalCreditCardApplications;
    }

    public void setTotalCreditCardApplications(long totalCreditCardApplications) {
        this.totalCreditCardApplications = totalCreditCardApplications;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void setLoans(List<Loan> loans) {
        this.loans = loans;
    }

    public void addLoan(Loan loan) {
        this.loans.add(loan);
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }

    public void addCreditCard(CreditCard creditCard) {
        this.creditCards.add(creditCard);
    }

   

}
