package com.mfedorec.astonhomework.homework2.buttlegrounds;

import com.mfedorec.astonhomework.homework2.creatures.Enemy;
import com.mfedorec.astonhomework.homework2.creatures.Hero;
import com.mfedorec.astonhomework.homework2.creatures.enemies.Chuchu;
import com.mfedorec.astonhomework.homework2.creatures.enemies.Ganon;
import com.mfedorec.astonhomework.homework2.creatures.enemies.Goblin;
import com.mfedorec.astonhomework.homework2.creatures.heroes.Archer;
import com.mfedorec.astonhomework.homework2.creatures.heroes.Mage;
import com.mfedorec.astonhomework.homework2.creatures.heroes.Warrior;

public class BattleGround {
    public static void main(String[] args) {

        //маг и арчер сражается с Ганоном

        Hero gendalf = new Mage("Gendalf", 200);
        Hero legolas = new Archer("Legolas", 70);
        Ganon ganondorf = new Ganon(100);

        gendalf.attackEnemy(ganondorf);
        legolas.attackEnemy(ganondorf);
        ganondorf.attackHero(gendalf);
        legolas.attackEnemy(ganondorf);
        ganondorf.critAttack(gendalf);

        //воин сражается с гоблином и чучей

        Hero torin = new Warrior("Torin", 100);
        Goblin tupichok = new Goblin(50);
        Chuchu chuchu = new Chuchu(10);

        tupichok.attackHero(torin);
        torin.attackEnemy(tupichok);
        chuchu.attackHero(torin);
        torin.attackEnemy(chuchu);


    }
}
