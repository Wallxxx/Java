package com.bootcamp.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="CARDS")
public class Cards {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;
    private int balance;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account")
    private Accounts account;

    public Cards() {
    }

    public Cards(Accounts account, String number, int balance) {
        if (number == null) throw new IllegalArgumentException("Не указан номер карты");
        if (account == null) throw new IllegalArgumentException("Неверный номер счёта");
        if (balance < 0) throw new IllegalArgumentException("Отрицательный баланс");

        this.account = account;
        this.number = number;
        this.balance = balance;
    }

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards cards = (Cards) o;
        return balance == cards.balance && Objects.equals(number, cards.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, balance);
    }

    @Override
    public String toString() {
        return "Cards{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", balance=" + balance +
                '}';
    }
}
