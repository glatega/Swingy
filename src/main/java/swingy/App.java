package swingy;

import swingy.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Coordinates coord = new Coordinates(1, 2);

        Entity enemy = new Entity("Goblin", 10, 15, 100, coord);

        Hero hero = new Barbarian("Bob", coord);

        hero.fight(enemy);

        System.out.println( "Bye World!" );
    }
}
