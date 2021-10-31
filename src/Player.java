public class Player {

    // Variables for the player's stats. //
    int health = 100;
    int maxHealth = 100;
    int attack = 7;
    int level = 1;
    int numHealthPotions = 3;

// Method that will hold the values of the player's stats, so they can be displayed after each turn. //
public void stats() {
    System.out.println("---------------------------");
    System.out.println("Your current health is " + health + "/" + maxHealth + ".\n");
    System.out.println("Your current attack damage is " + attack + ".");
    System.out.println("Your current level is " + level + ".");
    System.out.println("Your currently have " + numHealthPotions + " health potions.");
    System.out.println("---------------------------");
}

// Method that will allow you to damage the enemy. Includes enemy parameters, so our function can recognize variables from the "Enemy" class. //
    public void damage(Enemy enemy) {
        System.out.println("---------------------------");
        System.out.println("You strike the " + enemy.random + " for " + attack + " damage.\n");
        System.out.println("---------------------------");
        enemy.health -= attack;
    }

    // Method that allows the player to heal themselves. Include potion parameters, so our function can recognize variables from the "Potion" class. //
    public void heal(Potion potion) {
        health += potion.healAmount;
        numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you for " + potion.healAmount + " health. You now have " + numHealthPotions + " health potion(s) remaining.\n");
    }

    // Method that ends the game. //
    public void gameOver() {
        System.out.println("---------------------------");
        System.out.println("You have run out of health and crawl out of the dungeon.\n");
        System.out.println("GAME OVER.");
        System.out.println("---------------------------");

    }
    public void healToMaxHealth(Player player) {
        player.health = player.maxHealth;
        numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you to " + maxHealth + " health." + " You now have " + numHealthPotions + " health potion(s) remaining.\n");
    }
    public void levelUp(Player player) {
    maxHealth += 25;
    attack += 5;
    level += 1;
    System.out.println("## You have leveled up to " + level + "! ##\n");
    System.out.println("Your max health has been increased by 25.\n");
    System.out.println("Your attack has been increased by 5.\n");
    }
   }
