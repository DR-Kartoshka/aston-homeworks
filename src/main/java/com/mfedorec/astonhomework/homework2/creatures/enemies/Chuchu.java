package com.mfedorec.astonhomework.homework2.creatures.enemies;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Chuchu extends Enemy {

    private static final int BASE_DAMAGE = 1;
    private static final double resurrectChance = 0.5;

    public Chuchu(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if (this.isAlive()) {
            System.out.println("Чучу атакует!");
            hero.takeDamage(BASE_DAMAGE);
            if (hero.isAlive()) {
                System.out.println("Герой не умер!\n" + "Hero xp: " + hero.getHealth());
            }
        }
    }
    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);

        if (!isAlive()) {
            resurrect();
        }
    }

    // Особенность: возраждается

    private void resurrect() {
        if (Math.random() < resurrectChance) {
            setHealth(getMaxHealth()/2);
            System.out.println("Чучу возродился! :) ");
        } else {
            System.out.println("Чучу не смог возродиться. :( ");
        }
    }
}
