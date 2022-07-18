package com.example.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name="accounts")
public class Account {

    @Id
    private String number;
    private double balance;

}
