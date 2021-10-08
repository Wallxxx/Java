package com.bootcamp.tables;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="CARDS")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int account;
    private String number;
    private int balance;

    public Cards() {
    }

    public Cards(int account, String number, int balance) {
        if (number == null) throw new IllegalArgumentException("Не указан номер карты");
        if (account < 1) throw new IllegalArgumentException("Неверный номер счёта");
        if (balance < 0) throw new IllegalArgumentException("Отрицательный баланс");

        this.account = account;
        this.number = number;
        this.balance = balance;
    }

    public int getAccount() {
        return account;
    }

    public String getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return account == cards.account && balance == cards.balance && Objects.equals(number, cards.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(account, number, balance);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", account=" + account +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
