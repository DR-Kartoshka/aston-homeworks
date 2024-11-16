package com.mfedorec.astonhomework.homework1.payment.model;

import com.sun.org.apache.xpath.internal.operations.Or;

public class Order {
    private final double price;
    public Order(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

