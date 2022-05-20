import java.util.Random;

public class Enemy  {
    Random rand = new Random();

    String[] type = {"Zombie", "Skeleton", "Ghost", "Spider"}; // String array that stores the names of enemies. //

    // Variables for enemy stats. //
    public int health = 10;
    public int maxHealth = 10;
    int damage = 10;
    int level = 1;
    double overkillDamage;


    // Variable for the random enemy that spawns out of the "ype" array. //
    String random;


// Method that will spawn in a new random enemy. //
    public void randomizeEnemy() {
        random = type[rand.nextInt(type.length)];
        health = maxHealth;
        System.out.println("# A level " + level + " " + random + " with " + health + "/" + maxHealth + " health appears!\n");
        System.out.println("---------------------------");
    }


    // Method that allows the enemy to attack the player. //
    public void retaliation(Player player) {


        if (player.shieldHealth < damage && player.shieldActive) {
            overkillDamage = damage - player.shieldHealth;
            player.shieldHealth = 0;
            player.health -= overkillDamage;
            System.out.println("---------------------------");
            System.out.println("The " + random + " breaks through your shield and hits you for " + overkillDamage + " damage.\n");
            System.out.println("The " + random + " has " + health + "/" + maxHealth + " health remaining.\n");
            System.out.println("---------------------------");
        }
        else
            if(player.shieldHealth >= damage && player.shieldActive) {
                player.shieldHealth -= damage;
                System.out.println("---------------------------");
                System.out.println("The " + random + " strikes your shield for " + damage + " damage.\n");
                System.out.println("The " + random + " has " + health + "/" + maxHealth + " health remaining.\n");
                System.out.println("---------------------------");
            }

    }


    public void potionDropChance(Potion potion, Player player) {
        potion.drop = rand.nextInt(4) == 0; // Method that gives enemies a 25% chance to drop health potions when they are defeated. //
        if(potion.drop  && player.numHealthPotions < player.maxNumHealthPotions) {
            player.numHealthPotions += 1;
            System.out.println("The " + random + " dropped a health potion! You now have " + player.numHealthPotions + " health potions.\n");
        }
    }

    // Method that allows the enemy to level up
    public void levelUp () {
        maxHealth += 20;
        damage += 3;
        level += 1;
    }


}
