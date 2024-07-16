package project.modelsKredi;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CreditCard {
    private String cardName;
    private Bank bank;
    private BigDecimal cardFee;
    private List<Campaign> campaignList=new ArrayList<>();

    public CreditCard(String cardName,Bank bank, BigDecimal cardFee) {
        this.cardName=cardName;
        this.bank = bank;
        this.cardFee = cardFee;
        bank.addCreditCard(this);

    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    public Bank getBank() {
        return bank;
    }

    public BigDecimal getCardFee() {
        return cardFee;
    }

    public List<Campaign> getCampaignList() {
        return campaignList;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public void setCardFee(BigDecimal cardFee) {
        this.cardFee = cardFee;
    }

    public void setCampaignList(List<Campaign> campaignList) {
        this.campaignList = campaignList;
    }

    public void addCampaign(Campaign campaign){
        campaignList.add(campaign);
    }

    public Integer getCampaignSize(){
        return campaignList.size();

    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardName='" + cardName + '\'' +
                ", bank=" + bank.getName() +
                ", cardFee=" + cardFee +
                '}';
    }

}
