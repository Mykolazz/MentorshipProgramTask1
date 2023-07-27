package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

public interface Serialization {

    default void serialize(Serializable obj, String fileName){
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter())
                .create();
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(gson.toJson(obj));
            writer.close();
        } catch (IOException e) {
            System.out.println("Object serializing error");
            e.printStackTrace();
        }
    };

    default <T>List<T> getAllFromJson(Class<T> clazz, String fileName) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        try {
            return gson.fromJson(new FileReader(fileName), new TypeToken<List<T>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            // тут можна викорастати Optional
            return null;
        }
    }
}
