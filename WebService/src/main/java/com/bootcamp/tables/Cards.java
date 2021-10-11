package com.bootcamp.tables;

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

    @ManyToOne
    @JoinColumn(name = "account")
    private Accounts account;

    public Cards() {
    }

    public Cards(int account, String number, int balance) {
        if (number == null) throw new IllegalArgumentException("Не указан номер карты");
        if (account < 1) throw new IllegalArgumentException("Неверный номер счёта");
        if (balance < 0) throw new IllegalArgumentException("Отрицательный баланс");

        this.number = number;
        this.balance = balance;
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

    public Accounts getAccount() {
        return account;
    }

    public void setAccount(Accounts account) {
        this.account = account;
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
