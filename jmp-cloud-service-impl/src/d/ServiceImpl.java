package d;

import c.Service;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import dto.*;

import java.io.*;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import com.google.gson.Gson;

public class ServiceImpl implements Service {

    private static void serialize(Serializable obj){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter writer = new FileWriter("subscriptions.json");
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            System.out.println("Object serializing error");
            e.printStackTrace();
        }
    }

    @Override
    public void subscribe(BankCard bankCard) {
        //покласти в бд одразу в методі чи все таки не войд має бути хз
        serialize(new Subscription(bankCard));
    }

    @Override
    public Optional<Subscription> getSubscriptionByBankCardNumber(String cardNumber) {

       return getAllSubscriptions().stream()
                .filter(subscription -> subscription.getBankCard().equals(cardNumber))
                .findFirst();
    }

    @Override
    public List<User> getAllUsers() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            return gson.fromJson(new FileReader("users.json"), new TypeToken<List<User>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

        public List<Subscription> getAllSubscriptions() {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();

            try {
                return gson.fromJson(new FileReader("subscriptions.json"), new TypeToken<List<Subscription>>() {
                }.getType());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        }
}
