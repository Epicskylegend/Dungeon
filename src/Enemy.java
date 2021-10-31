import java.util.Random;

public class Enemy {
    Random rand = new Random();

    String[] type = {"Zombie", "Skeleton", "Ghost", "Spider"}; // String array that stores the names of enemies. //

    // Variables for enemy stats. //
    int health = 10;
    int damage = 10;
    int[] enemyDamage = {25, 20, 15, 10};

    // Variable for the random enemy that spawns out of the "enemyType" array. //
    String random;


// Method that will spawn in a new random enemy. //
    public void randomizeEnemy() {
        System.out.println("You run away from the " + random + ".\n");
        random = type[rand.nextInt(type.length)];
        System.out.println("# A " + random + " appears! #");
        health = 10;
    }
    // Method that will spawn in a new enemy if the current enemy has been defeated. //
    public void defeated() {
        System.out.println("The " + random + " has been defeated.\n");
        random = type[rand.nextInt(type.length)];
        System.out.println("# A " + random + " appears! #");
        health = 10;
    }
    // Method that allows the enemy to attack the player. //
    public void retaliation(Player player) {
        System.out.println("---------------------------");
        System.out.println("The " + random + " strikes you for " + damage + " damage.\n");
        player.health -= damage;
        System.out.println("The " + random + " has " + health + " health remaining.\n");
        System.out.println("---------------------------");
    }

}
