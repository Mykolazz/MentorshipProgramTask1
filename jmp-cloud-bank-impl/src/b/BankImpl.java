package b;

import a.Bank;
import dto.*;
import java.util.ArrayList;
import java.util.List;

public class BankImpl implements Bank {
    private static List<String> listOfNumbers = new ArrayList<>();
    private static Long lastNumber = 0L;


    public String generateNumber() {
        lastNumber+=1;
        return lastNumber.toString();
    }

    @Override
    public BankCard createBankCard(User user, BankCardType bankCardType) {
        BankCard bankCard;
        if (bankCardType.equals(BankCardType.CREDIT)){
            bankCard = new CreditBankCard();
            bankCard.setUser(user);
            bankCard.setNumber(generateNumber());
            serialize(bankCard, "bankCards.json");
            return bankCard;
        } else if (bankCardType.equals(BankCardType.DEBIT)) {
            bankCard = new DebitBankCard();
            bankCard.setUser(user);
            serialize(bankCard, "bankCards.json");
            return bankCard;
        } else throw new IllegalArgumentException("Please define card type");
    }
}
