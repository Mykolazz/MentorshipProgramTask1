package d;

import c.Service;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import dto.*;

import java.io.*;
import java.util.List;
import java.util.Optional;

import com.google.gson.Gson;

public class ServiceImpl implements Service {

    @Override
    public void subscribe(BankCard bankCard) {
        //покласти в бд одразу в методі чи все таки не войд має бути?
        serialize(new Subscription(bankCard), "subscriptions.json");
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {
       return getAllSubscriptions().stream()
                .filter(subscription -> subscription.getBankCardNumber().equals(cardNumber))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        return getAllFromJson(User.class,"users.json");
    }

    public List<Subscription> getAllSubscriptions() {
        /*
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            return gson.fromJson(new FileReader("subscriptions.json"), new TypeToken<List<Subscription>>() {
                }.getType());
        } catch (FileNotFoundException e) {
                // тут можна використати Optional
                e.printStackTrace();
                return null;
            }

         */

        return getAllFromJson(Subscription.class, "subscriptions.json");
        }
}
