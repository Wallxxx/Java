package com.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class Users extends BaseEntity{

    @Version
    private long version;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "age")
    private Integer age;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

    @JsonIgnore
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Accounts> accounts;
}
