package project.modelsKredi;


public class Akbank extends Bank {
    private static Akbank instance;
    private double interestRate;
    private String API;

    private Akbank(String name, String addressUrl) {
        super(name, addressUrl);
        this.interestRate = 1.5;
    }

    public static Akbank getInstance() {
        if (instance == null) {
            instance = new Akbank("Akbank", "www.Akbank.com");
        }
        return instance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    

}
