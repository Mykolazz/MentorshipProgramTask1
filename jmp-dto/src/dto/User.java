package dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.time.LocalDate;

public class User implements Serializable {
   // @SerializedName("number")
    public String name;
   // @SerializedName("surname")
    public String surname;
   // @SerializedName("birthday")
    public LocalDate birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "User [ name: "+name+", surname: "+ surname+ ", birthday:" + birthday + " ]";
    }
}
