package com.mfedorec.astonhomework.homework2.creatures.heroes;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Warrior extends Hero {

    private static final int BASE_DAMAGE = 20;

    public Warrior(String name, int health) {
        super(name,health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (this.isAlive()) {
            System.out.println("Воин " + getName() + " атакует!");
            enemy.takeDamage(BASE_DAMAGE);
            if (enemy.isAlive()) {
                System.out.println("Враг еще жив!\n" + "Enemy xp: " + enemy.getHealth());
            }
        }
    }

    //критует на 1.5 от основного урона 50/50
}
