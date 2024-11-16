package com.mfedorec.astonhomework.homework1.payment.model;

public class Account {

    private static int generator = 1;

    private int id;
    private int money;

    public Account(int money) {
        this.money = money;
        this.id = generator++;
    }

    public void add(int money) { // положить деньги
        this.money+=money;
    }
    public boolean takeOff(int money) //снять деньги и вернуть значение операции (удачно/неудачно)
    {
        if (this.money >= money){
            this.money -= money;
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        return "Account{" +
                "id=" + id +
                ", money=" + money +
                '}';
    }
}
