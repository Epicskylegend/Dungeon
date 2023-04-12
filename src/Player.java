import java.util.Random;

public class Player {
    Inventory inventory = new Inventory();
    // Variables for the player's stats. //
    int health = 100, maxHealth = 100;
    int attack = 7;
    int level = 1;
    int currentExp = 0, maxExp = 100;
    int defeatedEnemies = 0; // Keeps track of how many enemies the player has defeated. //
    double shieldCapacity = 25, shieldMaxCapacity = 25;
    boolean shieldActive;
    boolean openInventory;




    // Variables for the amount of exp the player will receive. //
    Random rand = new Random();
    int obtainedExp;



    // Method that will hold the values of the player's stats, so they can be displayed after each turn. //
    public void stats() {
        System.out.println("---------------------------");
        System.out.println("Your current health is " + health + "/" + maxHealth + ".\n");
        System.out.println("Your current shield capacity is " + shieldCapacity + "/" + shieldMaxCapacity + ".\n");
        System.out.println("Your current attack damage is " + attack + ".");
        System.out.println("Your current level is " + level + ".");
        System.out.println("You currently have " + currentExp + "/" + maxExp + " experience.");
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
        inventory.numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you for " + potion.healAmount + " health. You now have " + inventory.numHealthPotions + " health potion(s) remaining.\n");
    }
    public void shieldPotion () {
        if (shieldCapacity == shieldMaxCapacity) {
            System.out.println("Your shield is full. You cannot use shield potions at this time.\n");
        }
        else if(shieldCapacity + shieldMaxCapacity/2 > shieldMaxCapacity) {
            shieldCapacity = shieldMaxCapacity;
            System.out.println("You drink a shield potion bringing your shield capacity to " + shieldMaxCapacity + ".\n");
        }
        else
            shieldCapacity += shieldMaxCapacity/2;
    }

    // Method that will heal the player to their maximum health value. //
    public void healToMaxHealth(Player player) {
        player.health = player.maxHealth;
        inventory.numHealthPotions -= 1;
        System.out.println("You drink a health potion healing you to " + maxHealth + " health." + " You now have " + inventory.numHealthPotions + " health potion(s) remaining.\n");
    }


    // Method that will level up the player and increase their stats. //
    public void levelUp(Potion potion) {
        maxHealth += 25;
        inventory.maxNumHealthPotions += 1;
        attack += 5;
        level += 1;
        maxExp += 100;
        shieldMaxCapacity *= 1.2;
        potion.healAmount = maxHealth / 2;

        System.out.println("---------------------------");
        System.out.println("## You have leveled up to " + level + "! ##\n");
        System.out.println("Your max health has been increased by 25.\n");
        System.out.println("Your max shield capacity has been increased to " + shieldMaxCapacity + ".\n");
        System.out.println("Your attack has been increased by 5.");
        System.out.println("The max number of health potions you can hold increased to " + inventory.maxNumHealthPotions + ".");
        System.out.println("---------------------------");
    }



    public void getExp() {
        obtainedExp = rand.nextInt(50)+25;
        currentExp += obtainedExp;
        System.out.println("You received " + obtainedExp + " experience.\n");
    }
}
