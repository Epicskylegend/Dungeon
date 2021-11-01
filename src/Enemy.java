import java.util.Random;

public class Enemy {
    Random rand = new Random();

    String[] type = {"Zombie", "Skeleton", "Ghost", "Spider"}; // String array that stores the names of enemies. //

    // Variables for enemy stats. //
    int health = 10;
    int maxHealth = 10;
    int damage = 10;
    int level = 1;
    int[] enemyDamage = {25, 20, 15, 10};

    // Variable for the random enemy that spawns out of the "ype" array. //
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


    }
    // Method that allows the enemy to attack the player. //
    public void retaliation(Player player) {
        System.out.println("---------------------------");
        System.out.println("The " + random + " strikes you for " + damage + " damage.\n");
        player.health -= damage;
        System.out.println("The " + random + " has " + health + " health remaining.\n");
        System.out.println("---------------------------");
    }
    public void potionDropChance(Potion potion, Player player) {
        potion.dropChance = rand.nextInt(5) == 0; // Method that gives enemies a 20% chance to drop health potions when they are defeated. //
        if(potion.dropChance == true ) {
            player.numHealthPotions += 1;
            System.out.println("The " + random + " dropped a health potion! You now have " + player.numHealthPotions + " health potions.\n");
        }
    }
    public void levelUp () {
        maxHealth += 20;
        damage += 3;
        level += 1;
    }


}
