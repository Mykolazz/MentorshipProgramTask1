package m;

import a.Bank;
import b.BankImpl;
import c.Service;
import d.ServiceImpl;
import dto.BankCard;
import dto.BankCardType;
import dto.User;


public class Main {
    public static void main(String[] args) {
        Bank bank = new BankImpl();
        User user = new User();
        BankCard creditBankCard = bank.createBankCard(user, BankCardType.CREDIT);
        BankCard debitBankCard = bank.createBankCard(user, BankCardType.DEBIT);
        Service service = new ServiceImpl();
        service.subscribe(creditBankCard);
        service.subscribe(debitBankCard);
        // System.out.println("SubscriptionByBankCardNumber: " + service.getSubscriptionByBankCardNumber("1"));
        // System.out.println("All users: " + service.getAllUsers());
        // System.out.println("Average age of users: " + service.getAverageUsersAge());

    }
}
