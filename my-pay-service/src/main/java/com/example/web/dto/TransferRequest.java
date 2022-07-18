package com.example.web.dto;

import lombok.Data;

@Data
public class TransferRequest {

    private String sourceAccount;
    private String destinationAccount;
    private double amount;

}
