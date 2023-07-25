package com.java.jep409;

public non-sealed class Debit extends PaymentMethod {

    private String name;

    private Debit(String payerName) {
        super(payerName);
    }
}
