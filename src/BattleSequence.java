import java.util.Scanner;
import java.util.Random;

public class BattleSequence {

    public static void main(String args[]) {

        int start = 0; // condition to run the program. //

// Allows for user input. //
        Scanner input = new Scanner(System.in);

// Instances of new objects that allow us to use variables from other classes. //
        Player player = new Player();
        Enemy enemy = new Enemy();
        Potion potion = new Potion();

// Allows us to use the randomizer. //
        Random rand = new Random();

// Code that will welcome the user and spawn a new enemy to get the game started before the loop. //
        System.out.println("Welcome to the dungeon!");

        enemy.random = enemy.type[rand.nextInt(enemy.type.length)];
        System.out.println("# A " + enemy.random + " appears! #");

// This is our game loop that will control the entire battle sequence. //
        while (start == 0) {
            player.stats();

            System.out.println("What would you like to do?\n");
            System.out.println("Type 1 to attack, 2 to use health potion, and 3 to run\n");

            String Input = input.nextLine();
            if (Input.equals("1")) {
                player.damage(enemy); // Method that allows the player to damage the enemy. //

                if (enemy.health >= player.attack) {
                    System.out.println("The " + enemy.random + " has " + enemy.health + " health remaining.\n");
                }
            }

             else if (Input.equals("2")) {
                // Condition that prevents the user from exceeding the maximum health value. //
                if (player.numHealthPotions > 0 && player.health < player.maxHealth && player.health + potion.healAmount >= player.maxHealth) {
                        player.healToMaxHealth(player);
                    }

                else if(player.health >= player.maxHealth) {
                    System.out.println("Your health is full. You cannot use any potions at this time.\n");
                }

                else if(player.health + potion.healAmount <= player.maxHealth) {
                    player.heal(potion);
                }

                else if(player.numHealthPotions < 1){
                    System.out.println("You have no more potions available, defeat enemies for a chance to receive more.\n");
                }

            }
            else if (Input.equals("3")) {
                enemy.randomizeEnemy(); // Method that will allow the player to run away from the current enemy and encounter a new one. //
            }
            else
                System.out.println("Invalid Input!\n" + "Please make sure to type in 1, 2, or 3.\n");


            if (enemy.health < 1) {
                enemy.defeated(); // Method that will spawn a new enemy with full health each time an enemy is defeated. //

            }
            else {
                if (Input.equals("1") || Input.equals("2")) {
                    enemy.retaliation(player); // Method that allows the enemies that are alive to attack the player after each turn unless they run away. //
                }
            }
            if(player.health < 1) {
                player.gameOver(); // Method that will end the game if the player runs out of health. //
                return;
            }

            }


        }


    }










