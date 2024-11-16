package com.mfedorec.astonhomework.homework1.payment.logic;

import com.mfedorec.astonhomework.homework1.payment.model.Order;
import com.mfedorec.astonhomework.homework1.payment.model.Customer;
import com.mfedorec.astonhomework.homework1.payment.model.CreditCard;


public final class PaymentService {

    private PaymentService() {
    }

    public static boolean payForOrder(Customer client, Order order) { //клиент оплачивает заказ
        CreditCard card = client.getCard();
        double price = order.getPrice();

        if (card.getAmount() > price) {
            card.setAmount(card.getAmount() - price);
            return true;
        } else {
            System.out.println("Не хватает денег");
            return false;
        }
    }

    public static void blockCard(CreditCard card) { //блокировка карты
        if (card.isExpired()) {
            System.out.println("Карта заблокирована");
        }
    }


}
