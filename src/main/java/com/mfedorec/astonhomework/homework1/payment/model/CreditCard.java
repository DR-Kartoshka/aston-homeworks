package com.mfedorec.astonhomework.homework1.payment.model;

public class CreditCard {
    private final String number;
    private double amount;
    private boolean expired; //карта истекла или нет

public CreditCard (String number, double amount){
    this.number = number;
    this.amount = amount;
}

    public String getNumber() {
        return number;
    }
    public double getAmount(){
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    public boolean isExpired(){
    return expired;
    }
}