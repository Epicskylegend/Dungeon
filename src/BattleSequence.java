import java.util.Scanner;
import java.util.Random;

public class BattleSequence {

    public static void main(String args[]) {
// Allows for user input. //
        Scanner input = new Scanner(System.in);

// Instances of new objects that allow us to use variables from other classes. //
        Player player = new Player();
        Enemy enemy = new Enemy();
        Potion potion = new Potion();




// Allows us to use the randomizer. //
        Random rand = new Random();

// Code that will welcome the user and spawn a new enemy to get the game started before the loop. //


        System.out.println("Welcome to the dungeon!\n");

        enemy.random = enemy.type[rand.nextInt(enemy.type.length)];
        System.out.println("# A level " + enemy.level + " " + enemy.random + " with " + enemy.health + "/" + enemy.maxHealth + " health appears!\n");



// This is our game loop that will control the entire battle sequence. //   
        while (player.health > 0) {
            player.stats();
            player.openInventory = false;

            System.out.println("What would you like to do?\n");
            System.out.println("Type 1 to attack, 2 to use a health potion, 3 to block, and 4 to run.\n");

            String Input = input.nextLine();
            if (Input.equals("1")) {
                player.shieldActive = false;
                player.damage(enemy); // Method that allows the player to damage the enemy. //


                if (enemy.health >= player.attack && player.level < 2) {
                    System.out.println("The " + enemy.random + " has " + enemy.health + "/" + enemy.maxHealth + " health remaining.\n");
                }
            }

            else if (Input.equals("2")) {
                player.shieldActive = false;
                // Condition that prevents the user from exceeding the maximum health value. //
                if  (player.numHealthPotions > 0 && player.health < player.maxHealth && player.health + potion.healAmount >= player.maxHealth) {
                    player.healToMaxHealth(player);
                }
                else if (player.health == player.maxHealth) {
                    System.out.println("Your health is full. You cannot use any potions at this time.\n");
                }
                else if (player.numHealthPotions > 0 && player.health + potion.healAmount <= player.maxHealth) {
                    player.heal(potion);
                }
                else if (player.numHealthPotions < 1) {
                    System.out.println("You have no more potions available, defeat enemies for a chance to receive more.\n");
                }
            }


            else if (Input.equals("3") && player.shieldCapacity > 0 && !player.openInventory) {
                player.shieldActive = true;
                System.out.println("---------------------------");
                System.out.println("You use your shield to block the attack");
                System.out.println("---------------------------");
            }
            else if (Input.equals("3") && player.shieldCapacity == 0) {
                System.out.println("---------------------------");
                System.out.println("Your shield is depleted. You need to wait for it to recharge before you can use it again.");

            }
            else if (Input.equals("4")) {
                player.shieldActive = false;
                System.out.println("---------------------------");
                System.out.println("You run away from the " + enemy.random + ".\n");
                enemy.randomize(); // Method that will allow the player to run away from the current enemy and encounter a new one. //
            }


            else
                System.out.println("Invalid Input!\n" + "Please make sure to type in 1, 2, or 3, or 4.\n");

            // Block of code that will track the amount of enemies the player has defeated and the experience the players has earned.
            // Designed in case I want to make bosses or other enemies spawn when certain thresholds are reached.

            if (enemy.health < 1) {
                player.defeatedEnemies += 1;
                System.out.println("The " + enemy.random + " has been defeated.\n");
                enemy.potionDropChance(potion,player);
                enemy.random = enemy.type[rand.nextInt(enemy.type.length)];
                player.getExp();

                while(player.currentExp >= player.maxExp) { // When the player reaches the max exp, they will level up increasing their stats. //
                    player.levelUp(potion);
                    enemy.levelUp();
                    System.out.println("You feel uneasy as the enemies around you seem to get stronger...\n");
                }
                enemy.health = enemy.maxHealth;
                System.out.println("# A level " + enemy.level + " " + enemy.random + " with " + enemy.health + "/" + enemy.maxHealth + " health appears!\n");
            }

            else
            if (Input.equals("1") || Input.equals("2") && !player.openInventory || Input.equals("3")) {
                enemy.retaliation(player); // Method that allows the enemies that are alive to attack the player after each turn unless they run away. //
                if(!player.shieldActive) {
                    System.out.println("---------------------------");
                    System.out.println("The " + enemy.random + " strikes you for " + enemy.damage + " damage.\n");
                    player.health -= enemy.damage;
                    System.out.println("The " + enemy.random  + " has " + enemy.health + "/" + enemy.maxHealth + " health remaining.\n");
                    System.out.println("---------------------------");
                }

            }



        }
        if(player.health < 1) {
            System.out.println("---------------------------");
            System.out.println("You have run out of health and crawl out of the dungeon.\n");
            System.out.println("GAME OVER.");
            System.out.println("---------------------------");
            return;
        }


    }


}














