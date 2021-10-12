package com.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Accounts")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Accounts extends BaseEntity{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "user")
    private Users user;

    @Column(name = "number")
    private String number;

    @Column(name = "balance")
    private BigDecimal balance;

    @JsonIgnore
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Cards> cards;
}
