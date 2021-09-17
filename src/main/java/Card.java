import java.io.Serializable;
import java.time.LocalDate;

public class Card  implements Serializable {
    private long cardNumber;
    private Customer customer;
    private LocalDate dateOfIssue;
    private LocalDate dateOfExpiration;
    private boolean active;

    public Card( long cardNumber,Customer customer, LocalDate dateOfIssue, LocalDate dateOfExpiration, boolean active) {
        this.customer = customer;
        this.cardNumber = cardNumber;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpiration = dateOfExpiration;
        this.active = active;
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public LocalDate getDateOfExpiration() {
        return dateOfExpiration;
    }

    public void setDateOfExpiration(LocalDate dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Card{" +
                "customer=" + customer +
                ", cardNumber=" + cardNumber +
                ", dateOfIssue=" + dateOfIssue +
                ", dateOfExpiration=" + dateOfExpiration +
                ", status=" + active +
                '}';
    }
}
