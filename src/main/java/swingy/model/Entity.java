package swingy.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.concurrent.ThreadLocalRandom;

public class Entity {
    @NotNull(message = "Name cannot be null")
    @Size(min = 1, max = 16, message = "Name must be between 1 and 16 characters")
    public String name;

    @Min(value = 0, message = "Attack cannot be negative")
    public int atk;

    @Min(value = 0, message = "Defense cannot be negative")
    public int def;

    @Min(value = 0, message = "HP cannot be negative")
    public int hp;

    public int lvl;

    @NotNull(message = "An entity requires a coordinate")
    public Coordinates pos;

    public Entity(String name, int atk, int def, int hp, Coordinates pos) {
        this.name = name;
        this.atk = atk;
        this.def = def;
        this.hp = hp;
        this.pos = pos;
    }

    public void takeDmg(int dmg) {
        hp -= dmg;
    }

    public int calcDmg(int dmg) {
        int randomNum = ThreadLocalRandom.current().nextInt(75, 125 + 1);
        int val = (int)(dmg * ((100 - getDef())/100.0f));
        val = (int)(val * (randomNum/100.0f));
        return val;
    }

    public void attack(Entity enemy) {
        int dmg = enemy.calcDmg(getAtk());
        enemy.takeDmg(dmg);
        System.out.printf("%s attacked %s and dealt %d damage.\n", name, enemy.name, dmg);
    }

    public int getAtk() {
        return atk;
    }

    public int getDef() {
        return def;
    }
}