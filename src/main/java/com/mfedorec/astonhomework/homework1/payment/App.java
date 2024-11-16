package com.mfedorec.astonhomework.homework1.payment;

import com.mfedorec.astonhomework.homework1.payment.logic.PaymentService;
import com.mfedorec.astonhomework.homework1.payment.model.Customer;
import com.mfedorec.astonhomework.homework1.payment.model.CreditCard;
import com.mfedorec.astonhomework.homework1.payment.model.Order;
import com.mfedorec.astonhomework.homework1.payment.model.Account;



public class App {
    public static void main(String[] args){
            Customer client = new Customer(1, new Account(100), new CreditCard("1-1-1-1", 500.0));
            Order order = new Order(50.0);

            PaymentService.payForOrder(client, order);
    }
}
