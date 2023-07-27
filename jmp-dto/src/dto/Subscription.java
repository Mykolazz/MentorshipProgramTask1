package dto;

import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
    public final String bankCard;
    public final LocalDate startDate;

    public Subscription(BankCard bankCard) {
        this.bankCard = bankCard.getNumber();
        // check about default time zone
        this.startDate = LocalDate.now();
    }

    public String getBankCard() {
        return bankCard;
    }

    public LocalDate getStartDate() {
        return startDate;
    }
}
