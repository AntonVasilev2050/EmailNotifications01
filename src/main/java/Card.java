import java.util.Date;

public class Card {
    private Customer customer;
    private long cardNumber;
    private Date dateOfIssue;
    private Date dateOfExpiration;
    private boolean status;

    public Card(Customer customer, long cardNumber, Date dateOfIssue, Date dateOfExpiration, boolean status) {
        this.customer = customer;
        this.cardNumber = cardNumber;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiration = dateOfExpiration;
        this.status = status;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(Date dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Card{" +
                "customer=" + customer +
                ", cardNumber=" + cardNumber +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfExpiration=" + dateOfExpiration +
                ", status=" + status +
                '}';
    }
}
