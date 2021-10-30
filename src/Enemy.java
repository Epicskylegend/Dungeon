import java.util.Random;

public class Enemy {
    Random rand = new Random();

    String[] enemyType = {"Zombie", "Skeleton", "Ghost", "Spider"}; // String array that stores the names of enemies. //

    // Variables for enemy stats. //
    int enemyHealth = 10;
    int randomDamage = 10;
    int[] enemyDamage = {25, 20, 15, 10};

    // Variable for the random enemy that spawns out of the "enemyType" array. //
    String randomEnemy;


// Method that will spawn in a new random enemy. //
    public void randomizeEnemy() {
        System.out.println("You run away from the " + randomEnemy + ".\n");
        randomEnemy = enemyType[rand.nextInt(enemyType.length)];
        System.out.println("# A " + randomEnemy + " appears! #");
        enemyHealth = 10;
    }
    // Method that will spawn in a new enemy if the current enemy has been defeated. //
    public void enemyDefeated() {
        System.out.println("The " + randomEnemy + " has been defeated.\n");
        randomEnemy = enemyType[rand.nextInt(enemyType.length)];
        System.out.println("# A " + randomEnemy + " appears! #");
        enemyHealth = 10;
    }
    // Method that allows the enemy to attack the player. //
    public void enemyRetaliation(Player player) {
        System.out.println("---------------------------");
        System.out.println("The " + randomEnemy + " strikes you for " + randomDamage + " damage.\n");
        player.playerHealth -= randomDamage;
        System.out.println("The " + randomEnemy + " has " + enemyHealth + " health remaining.\n");
        System.out.println("---------------------------");
    }

}
