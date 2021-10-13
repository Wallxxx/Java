package com.bootcamp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Cards")
public class Cards extends BaseEntity{

    @Version
    private long version;

    public Cards() {

    }

    public Cards(Accounts account, String number) {
        this.account = account;
        this.number = number;
    }

    @Getter
    @Setter
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account")
    private Accounts account;

    @Getter
    @Setter
    @Column(name = "number")
    private String number;
}
