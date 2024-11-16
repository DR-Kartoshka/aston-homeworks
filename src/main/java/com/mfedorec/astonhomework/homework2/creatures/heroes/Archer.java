package com.mfedorec.astonhomework.homework2.creatures.heroes;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Archer extends Hero {

    private static final int BASE_DAMAGE = 10;

    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (this.isAlive()) {
            System.out.println("Лучник " + getName() + " атакует!");
            enemy.takeDamage(BASE_DAMAGE);
            if (enemy.isAlive()) {
                System.out.println("Враг еще жив!\n" + "Enemy xp: " + enemy.getHealth());
            }
        }
    }
}

