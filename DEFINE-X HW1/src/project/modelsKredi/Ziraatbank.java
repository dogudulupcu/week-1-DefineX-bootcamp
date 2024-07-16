package project.modelsKredi;

public class Ziraatbank extends Bank {

    private static Ziraatbank instance;
    private double interestRate;
    private String API;

    private Ziraatbank(String name, String addressUrl) {
        super(name, addressUrl);
        this.interestRate = 0.5;

    }

    public static Ziraatbank getInstance() {
        if (instance == null) {
            instance = new Ziraatbank("ZiraatBank", "www.ziraatbank.com");
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
