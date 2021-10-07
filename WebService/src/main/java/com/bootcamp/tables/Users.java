package com.bootcamp.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private String patronymic;
    private int age;
    private String phone;
    private String address;

    public Users() {
    }

    public Users (String name, String surname, String patronymic, int age, String phone, String address) {
        if (name == null) throw new IllegalArgumentException("Не введено имя");
        if (surname == null) throw new IllegalArgumentException("Не введена фамилия");
        if (patronymic == null) throw new IllegalArgumentException("Не ведён номер");
        if (address == null) throw new IllegalArgumentException("Не введён адрес");
        if (age < 18 || age > 150) throw new IllegalArgumentException("Указан неверный возраст");

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.phone = phone;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public int getAge() {
        return age;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (this == o) return true;
        Users temp = (Users)o;
        return name.equals(temp.name) && surname.equals(temp.surname) && patronymic.equals(temp.patronymic)
                && age == temp.age && phone.equals(temp.phone) && address.equals(temp.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, age, phone, address);
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
