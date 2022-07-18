package com.example.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name="transactions")
public class Transaction {

    @Id
    @GeneratedValue
    private int id;
    private double amount;
    private Date date;
    @Enumerated(EnumType.STRING)
    private TxnType type;

    @ManyToOne
    @JoinColumn(name="acc_number")
    private Account account;

}
