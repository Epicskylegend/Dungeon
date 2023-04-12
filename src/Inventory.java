import java.util.Scanner;

public class Inventory {

    Potion potion = new Potion();



    Scanner input = new Scanner(System.in);

    int healthPotion, shieldPotion, strengthPotion;
    int numHealthPotions = 3, maxNumHealthPotions = 3;
    int numShieldPotions = 3, maxNumShieldPotions = 3;
    int numStrengthPotions = 3, maxNumStrengthPotions = 3;

    public void open () {

        System.out.println("---------------------------");
        System.out.println("1. Health Potions x " + numHealthPotions);
        System.out.println("2. Defense Potions x " + numShieldPotions);
        System.out.println("3. Strength Potions x " + numStrengthPotions);
        System.out.println("---------------------------");

    }
    public int getHealAmount ()  {
        return potion.healAmount;
    }





}
