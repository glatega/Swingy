package swingy.model;

import java.util.ArrayList;
import java.util.List;

public class Hero extends Entity {

    public String className;

    public Hero(String name, String className, int atk, int def, int hp, Coordinates pos) {
        super(name, atk, def, hp, pos);
        this.className = className;
    }

    public boolean fight(Entity enemy) {
        while (hp > 0) {
            attack(enemy);
            if (enemy.hp > 0) {
                enemy.attack(this);
            } else {
                System.out.printf("%s killed %s.\n", name, enemy.name);
                return true;
            }
        }
        System.out.printf("%s killed %s.\n", enemy.name, name);
        return false;
    }
}