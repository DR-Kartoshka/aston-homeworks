package com.mfedorec.astonhomework.homework1.payment.model;


public class Customer {
    private final int id;
    private final Account account;
    private final CreditCard card;

    public Customer(int id, Account account, CreditCard card) {
        this.id = id;
        this.account = account;
        this.card = card;
    }

    public int getId()
    {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public CreditCard getCard() {
        return card;
    }
}
