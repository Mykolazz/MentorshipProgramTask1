package a;

import api.Serialization;
import dto.BankCard;
import dto.BankCardType;
import dto.User;

public interface Bank extends Serialization {
    BankCard createBankCard (User user, BankCardType bankCardType);
}
