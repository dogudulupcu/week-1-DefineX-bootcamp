package project.modelsKredi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankRepository {
    private static BankRepository instance;
    Halkbank halkbank = Halkbank.getInstance();
    Ziraatbank ziraatbank = Ziraatbank.getInstance();
    Akbank akbank = Akbank.getInstance();

    private BankRepository() {
    }

    public static BankRepository getInstance() {
        if (instance == null) {
            instance = new BankRepository();
        }
        return instance;
    }
    /*
     * public Map<CreditCard, Integer> getCreditCardCampaignDescendingOrder() {
     * Map<CreditCard, Integer> creditCardCampaignSize = new HashMap<>();
     * 
     * for (CreditCard creditCard : halkbank.getCreditCards()) {
     * creditCardCampaignSize.put(creditCard, creditCard.getCampignSize());
     * }
     * 
     * for (CreditCard creditCard : ziraatbank.getCreditCards()) {
     * creditCardCampaignSize.put(creditCard, creditCard.getCampignSize());
     * }
     * 
     * for (CreditCard creditCard : akbank.getCreditCards()) {
     * creditCardCampaignSize.put(creditCard, creditCard.getCampignSize());
     * }
     * 
     * creditCardCampaignSize = creditCardCampaignSize.entrySet().stream()
     * .sorted((i1, i2) -> i2.getValue().compareTo(
     * i1.getValue()))
     * .collect(Collectors.toMap(
     * Map.Entry::getKey,
     * Map.Entry::getValue,
     * (e1, e2) -> e1, LinkedHashMap::new));
     * 
     * return creditCardCampaignSize;
     * 
     * }
     */

    public List<CreditCard> getCreditCardCampaignDescendingOrder() {
        List<CreditCard> creditCards = new ArrayList<>();
        creditCards.addAll(halkbank.getCreditCards());
        creditCards.addAll(ziraatbank.getCreditCards());
        creditCards.addAll(akbank.getCreditCards());

        Collections.sort(creditCards, (i1, i2) -> i2.getCampaignSize().compareTo(i1.getCampaignSize()));

        return creditCards;

    }

}
