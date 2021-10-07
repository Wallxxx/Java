package com.bootcamp.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_card;
    private int id_user;
    private String number;
    private int balance;

    public Cards() {

    }

    public Cards(int id_user, String number, int balance) {
        if (number == null) throw new IllegalArgumentException("Не указан номер карты");
        if (id_user < 1) throw new IllegalArgumentException("Неверный id пользователя");
        if (balance < 0) throw new IllegalArgumentException("Отрицательный баланс");

        this.id_user = id_user;
        this.number = number;
        this.balance = balance;
    }

    public int getId_card() {
        return id_card;
    }

    public int getId_user() {
        return id_user;
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
        return id_card == cards.id_card && id_user == cards.id_user && balance == cards.balance && number.equals(cards.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_card, id_user, number, balance);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id_card=" + id_card +
                ", id_user=" + id_user +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
