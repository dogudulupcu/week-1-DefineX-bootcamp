package project.modelsKredi;

public class Halkbank extends Bank {
    private static Halkbank instance;
    private double interestRate;
    private String API;

    private Halkbank(String name, String addressUrl) {
        super(name, addressUrl);
        this.interestRate = 2.5;
    }

    public static Halkbank getInstance() {
        if (instance == null) {
            instance = new Halkbank("Halkbank", "www.Halkbank.com");
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
