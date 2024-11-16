package com.mfedorec.astonhomework.homework2.creatures.enemies;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;

public class Ganon extends Enemy {

    private static final int BASE_DAMAGE = 50;
    private static final double resurrectChance = 0.5;

    public Ganon(int health) {
        super(health);
    }

    @Override
    public void attackHero(Hero hero) {
        if (this.isAlive()) {
            System.out.println("Ганон атакует!");
            hero.takeDamage(BASE_DAMAGE);
            if (hero.isAlive()) {
                System.out.println("Герой не умер!\n" + "Hero xp: " + hero.getHealth());
            }
        }
    }

    //Особенность - критует
    public void critAttack(Hero hero) {
        if (Math.random() < resurrectChance) {
            hero.takeDamage(BASE_DAMAGE*2);
            System.out.println("Ганон наносит критический удар!");
        } else {
            System.out.println("Промах!");
        }
    }
}
