import java.io.Serializable;
import java.time.LocalDate;

public class Card  implements Serializable {
    private long cardNumber;
    private Customer customer;
    private LocalDate IssueDate;
    private LocalDate ExpirationDate;
    private boolean active;

    public Card( long cardNumber,Customer customer, LocalDate IssueDate, LocalDate ExpirationDate, boolean active) {
        this.customer = customer;
        this.cardNumber = cardNumber;
        this.IssueDate = IssueDate;
        this.ExpirationDate = ExpirationDate;
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

    public LocalDate getIssueDate() {
        return IssueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.IssueDate = issueDate;
    }

    public LocalDate getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.ExpirationDate = expirationDate;
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
                ", Issue Date=" + IssueDate +
                ", Expiration Date=" + ExpirationDate +
                ", status=" + active +
                '}';
    }
}
