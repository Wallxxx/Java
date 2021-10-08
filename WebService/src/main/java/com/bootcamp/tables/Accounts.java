package com.bootcamp.tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="ACCOUNTS")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private int user;

    public Accounts() {

    }

    public Accounts(String number, int user) {
        if (number == null) throw new IllegalArgumentException("Неверный номер счёта");
        if (user < 1) throw new IllegalArgumentException("Неверный id пользователя");

        this.number = number;
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public int getUser() {
        return user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return user == accounts.user && number.equals(accounts.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, user);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" + user +
                '}';
    }
}
