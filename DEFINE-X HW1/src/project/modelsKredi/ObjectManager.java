package project.modelsKredi;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ObjectManager {

    private static ObjectManager instance;

    private ObjectManager() {

    }

    public static ObjectManager getInstance() {
        if (instance == null) {
            instance = new ObjectManager();
        }
        return instance;
    }

    public CreditCard createCreditCard(String cardName,Bank bank, BigDecimal cardFee) {

        return new CreditCard(cardName,bank, cardFee);
    }

    public Halkbank createInstanceHalkbank() {
        return Halkbank.getInstance();
    }

    public Ziraatbank createInstanceZiraatbank() {
        return Ziraatbank.getInstance();
    }

    public Akbank createInstanceAkbank() {
        return Akbank.getInstance();
    }

    public LoanFactory createLoanFactory() {
        return LoanFactory.getInstance();
    }

    public User createUser(String name, String surname, String email, String password, String phoneNumber,
            String address, LocalDate ageDate, Boolean isActive) {
        return new User(name, surname, email, password, phoneNumber, address, ageDate, isActive);
    }

    public Application createLoanApplication(Loan loan,BigDecimal loanAmount, User user, LocalDate applicationDate) {
        return new Application(loan, loanAmount, user, applicationDate);
    }

    public Application createCreditCardApplication(CreditCard creditCard, User user, LocalDate applicationDate) {
        return new Application(creditCard, user, applicationDate);
    }

    public UserRepository createUserRepository() {
        return UserRepository.getInstance();
    }

    public Campaign createCampaign(String title, CreditCard creditCard, String description, LocalDate startDate, LocalDate endDate, LocalDate updateDate) {
        return new Campaign(title, creditCard, description, startDate, endDate,updateDate);
    }

}
