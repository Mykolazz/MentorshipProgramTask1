package dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;

public class Subscription implements Serializable {
    @SerializedName("bankCardNumber")
    public final String bankCardNumber;
    @SerializedName("startDate")
    public final LocalDate startDate;

    public Subscription(BankCard bankCard) {
        this.bankCardNumber = bankCard.getNumber();
        // check about default time zone
        this.startDate = LocalDate.now();
    }

    public String getBankCardNumber() {
        return bankCardNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String toString() {
        return "Subscription [ bankCardNumber: "+bankCardNumber+", startDate: "+ startDate+ " ]";
    }
}
