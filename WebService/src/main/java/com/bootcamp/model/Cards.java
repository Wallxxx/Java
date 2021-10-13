package com.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Cards")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Cards extends BaseEntity{

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "account")
    private Accounts account;

    @Column(name = "number")
    private String number;
}
