package com.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Accounts")
public class Accounts extends BaseEntity{

    @Version
    private long version;

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user")
    private Users user;

    @Getter
    @Setter
    @Column(name = "number")
    private String number;

    @Getter
    @Setter
    @Column(name = "balance")
    private BigDecimal balance;

    @Getter
    @Setter
    @JsonIgnore
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Cards> cards;
}
