package b;

import a.Bank;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankImpl implements Bank {
    private static List<String> listOfNumbers = new ArrayList<>();
    private static Long lastNumber = 0l;


    public String generateNumber() {
        lastNumber+=1;
        return lastNumber.toString();
    }

    private static void serialize(Serializable obj){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
        try {
            FileWriter writer = new FileWriter("bankCards.json");
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            System.out.println("Object serializing error");
            e.printStackTrace();
        }
    }

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        BankCard bankCard;
        if (bankCardType.equals(BankCardType.CREDIT)){
            bankCard = new CreditBankCard();
            bankCard.setUser(user);
            bankCard.setNumber(generateNumber());
            serialize(bankCard);
            return bankCard;
        } else if (bankCardType.equals(BankCardType.DEBIT)) {
            bankCard = new DebitBankCard();
            bankCard.setUser(user);
            serialize(bankCard);
            return bankCard;
        } else throw new IllegalArgumentException("Please define card type");
    }
}
