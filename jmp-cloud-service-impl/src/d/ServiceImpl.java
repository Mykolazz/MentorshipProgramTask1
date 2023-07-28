package d;

import c.Service;
import dto.*;
import java.util.List;
import java.util.Optional;

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

        return getAllFromJson(Subscription.class, "subscriptions.json");
        }
}
