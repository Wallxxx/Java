package com.bootcamp.tables;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "patronymic")
    private String patronymic;
    @Column(name = "age")
    private int age;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    List<Accounts> accounts;

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
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Accounts> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Accounts> accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return age == users.age && Objects.equals(name, users.name) && Objects.equals(surname, users.surname) && Objects.equals(patronymic, users.patronymic) && Objects.equals(phone, users.phone) && Objects.equals(address, users.address);
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
