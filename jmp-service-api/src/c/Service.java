package c;

import api.Serialization;
import dto.BankCard;
import dto.Subscription;
import dto.User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

public interface Service extends Serialization {
    void subscribe (BankCard bankCard);

    Optional<Subscription> getSubscriptionByBankCardNumber (String cardNumber);

    List<User> getAllUsers();

    default double getAverageUsersAge(){
        OptionalDouble average = getAllUsers().stream().mapToLong(value ->
                value.getBirthday().until(LocalDate.now(), ChronoUnit.YEARS))
                .average();
        if (average.isPresent()) {
            return average.getAsDouble();
        }
        else {
            return 0;
        }
    }

    static boolean isPayableUser(User user){
        long age = user.getBirthday().until(LocalDate.now(), ChronoUnit.YEARS);
        return age >= 18;
    }
}
