package dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

// add constructor, think about setters
public class BankCard implements Serializable {

   // @SerializedName("number")
    public String number;

   // @SerializedName("user")
    public User user;

    private static List<String> listOfNumbers = new ArrayList<>();
    private static Long lastNumber;

    public BankCard() {
    }

    public BankCard(String number, User user) {
        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        boolean isEmpty = listOfNumbers.stream()
                .filter(n -> n.equals(number)).findFirst().isEmpty();
        if (isEmpty){
            this.number = number;
        } else throw new IllegalArgumentException();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String toString() {
        return "BankCard [ number: "+number+", user: "+ user+ " ]";
    }
}
