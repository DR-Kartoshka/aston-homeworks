package com.mfedorec.astonhomework.homework2.creatures;

import com.mfedorec.astonhomework.homework2.interfaces.Mortal;

public abstract class Enemy implements Mortal {

    private int health;
    private int maxHealth;

    public Enemy(int health){
        this.health = health;
        this.maxHealth = health;

    }

    public abstract void attackHero(Hero hero);

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void takeDamage(int damage){
        health = health - damage;
        if (!this.isAlive()) {
            System.out.println("Враг мертв !");
        }else{
            System.out.println("Враг получает " + damage + " урона, текущее здоровье врага: " + health);
        }
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }



}
