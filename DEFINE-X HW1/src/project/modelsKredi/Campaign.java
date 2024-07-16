package project.modelsKredi;

import java.time.LocalDate;

public class Campaign {

    private String title;
    private CreditCard creditCard;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDate updateDate;

    public Campaign(String title, CreditCard creditCard, String description, LocalDate startDate, LocalDate endDate, LocalDate updateDate) {
        this.title = title;
        this.creditCard = creditCard;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.updateDate = updateDate;
        creditCard.addCampaign(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String content) {
        this.description = content;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "title='" + title + '\'' +
                ", creditCard=" + creditCard +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", updateDate=" + updateDate +
                '}';
    }

}
