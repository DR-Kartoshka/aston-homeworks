package com.mfedorec.astonhomework.homework2.creatures.heroes;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Mage extends Hero {

    private static final int BASE_DAMAGE = 15;

    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attackEnemy(Enemy enemy) {
        if (this.isAlive()) {
            System.out.println("Maг " + getName() + " атакует!");
            enemy.takeDamage(BASE_DAMAGE);
            if (enemy.isAlive()) {
                System.out.println("Враг еще жив!\n" + "Enemy xp: " + enemy.getHealth());
            }
        }
    }


}
