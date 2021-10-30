public class Player {


    int start; // condition to run the program. //

    // Variables for the player's stats. //
    int playerHealth = 100;
    int maxPlayerHealth = 100;
    int playerAttackDamage = 7;
    int playerLevel = 1;
    int playerHealthPotions = 3;
    int damageTaken;

// Method that will hold the values of the player's stats, so they can be displayed after each turn. //
public void playerStats() {
    System.out.println("---------------------------");
    System.out.println("Your current health is " + playerHealth + ".");
    System.out.println("Your current attack damage is " + playerAttackDamage + ".");
    System.out.println("Your current level is " + playerLevel + ".");
    System.out.println("Your currently have " + playerHealthPotions + " health potions.");
    System.out.println("---------------------------");
}

// Method that will allow you to damage the enemy. Includes enemy parameters, so our function can recognize variables from the "Enemy" class. //
    public void damagingEnemy(Enemy enemy) {
        System.out.println("---------------------------");
        System.out.println("You strike the " + enemy.randomEnemy + " for " + playerAttackDamage + " damage.\n");
        System.out.println("---------------------------");
        enemy.enemyHealth -= playerAttackDamage;
    }

    // Method that allows the player to heal themselves. Include potion parameters, so our function can recognize variables from the "Potion" class. //
    public void playerHealing(Potion potion) {
        playerHealth += potion.potionHealAmount;
        playerHealthPotions -= 1;
        System.out.println("You drank a health potion healing you for " + potion.potionHealAmount + " health. You now have " + playerHealthPotions + " health potions remaining.\n");
    }

    // Method that ends the game. //
    public void gameOver() {
        System.out.println("---------------------------");
        System.out.println("You have run out of health and crawl out of the dungeon.\n");
        System.out.println("GAME OVER.");
        System.out.println("---------------------------");

    }
    public void healToMaxHealth(Player player) {
        player.playerHealth = player.maxPlayerHealth;
        playerHealthPotions -= 1;
        System.out.println("You drink a health potion healing you to " + maxPlayerHealth + " health.\n");
    }
   }
