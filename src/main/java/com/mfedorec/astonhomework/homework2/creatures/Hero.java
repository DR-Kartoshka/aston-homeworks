package com.mfedorec.astonhomework.homework2.creatures;

import com.mfedorec.astonhomework.homework2.interfaces.Mortal;

public abstract class Hero implements Mortal {
    private String name;
    private int health;

    public Hero(String name, int health){
        this.name = name;
        this.health = health;
    }

    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public abstract void attackEnemy(Enemy enemy);


    public void takeDamage(int damage){
        health = health - damage;
        if (!this.isAlive()) {
            System.out.println("Герой мертв !");
        }else{
            System.out.println(name + " получает " + damage + " урона, текущее здоровье героя: " + health);
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }
}
