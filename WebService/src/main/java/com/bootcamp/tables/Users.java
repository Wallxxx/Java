package com.bootcamp.tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="USERS")
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
    private String account;

    public Users() {
    }

    public Users (String name, String surname, String patronymic, int age, String phone, String address, String account) {
        if (name == null) throw new IllegalArgumentException("Не введено имя");
        if (surname == null) throw new IllegalArgumentException("Не введена фамилия");
        if (patronymic == null) throw new IllegalArgumentException("Не ведён номер");
        if (address == null) throw new IllegalArgumentException("Не введён адрес");
        if (account == null) throw new IllegalArgumentException("Не указан номер счёта");
        if (age < 18 || age > 150) throw new IllegalArgumentException("Указан неверный возраст");

        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;
        this.age = age;
        this.phone = phone;
        this.address = address;
        this.account = account;
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

    public String getAccount() {
        return account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age && Objects.equals(name, users.name) && Objects.equals(surname, users.surname) && Objects.equals(patronymic, users.patronymic) && Objects.equals(phone, users.phone) && Objects.equals(address, users.address) && Objects.equals(account, users.account);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, patronymic, age, phone, address, account);
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
                ", account='" + account + '\'' +
                '}';
    }
}
