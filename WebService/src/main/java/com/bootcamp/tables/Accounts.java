package com.bootcamp.tables;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="ACCOUNTS")
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String number;

    @JsonIgnore
    @JsonIgnoreProperties(value = "account", allowSetters = true)
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    Set<Cards> cards;

    public Set<Cards> getCards() {
        return cards;
    }

    public void setCards(Set<Cards> cards) {
        this.cards = cards;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    public Accounts() {

    }

    public Accounts(String number, int user) {
        if (number == null) throw new IllegalArgumentException("Неверный номер счёта");
        if (user < 1) throw new IllegalArgumentException("Неверный id пользователя");

        this.number = number;
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Accounts accounts = (Accounts) o;
        return number.equals(accounts.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", user=" +
                '}';
    }
}
