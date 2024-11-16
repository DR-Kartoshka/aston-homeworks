package com.mfedorec.astonhomework.homework2.creatures.enemies;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Goblin extends Enemy {

    private static final int BASE_DAMAGE = 10;

    public Goblin (int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if (this.isAlive()) {
            System.out.println("Гоблин атакует!");
            hero.takeDamage(BASE_DAMAGE);
            if (hero.isAlive()) {
                System.out.println("Герой не умер!\n" + "Hero xp: " + hero.getHealth());
            }
        }
    }

}
