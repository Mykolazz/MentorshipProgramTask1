package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public interface Serialization {

    default void serialize(Serializable obj, String fileName){
        //TypeAdapters можна використувувати через анотацію @JsonAdapter(<T>.class),
        // а адаптери винести або в окремий пакет в модулі jmp-dto або в окремий модуль.
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            // або зробити кастомний ексепшн або тут реалізувати деталізацію повідомлення
            System.out.println("Object serializing error");
            e.printStackTrace();
        }
    }
    // хотів типізувати метод
    default <T>List<T> getAllFromJson(Class<T> clazz, String fileName) {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                    .create();
            FileReader reader = new FileReader(fileName);
            List<T> objects = gson.fromJson(reader, new TypeToken<List<T>>() {}.getType());
            reader.close();
            return objects;
            // спочатку тут було FileNotFoundException
            // чи коректна ця заміна?
        } catch (IOException e) {
            // тут можна використати Optional
            e.printStackTrace();
            return null;
        }
    }
}
