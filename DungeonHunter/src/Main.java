import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //System variables
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        //Enemy vars
        String[] enemies = {"Skeleton","Warrior","Zombie","Assassin"};
        int enemyAttackDamage = 25;
        int maxEnemyHealth = 75;

        //Player vars
        int health = 100;
        int attackDamage = 30;
        int numHealthPotions = 3;
        int healthPotionHealAmount = 25;
        int healthPotionDropChance = 50; //%

        boolean run = true;
        System.out.println("Welcome to Dungeon Hunt!");

        GAME:
        while (run){
            System.out.println("----------------------------------------------");
            String enemy = enemies[rand.nextInt(enemies.length)];
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            System.out.println("\t#"+enemy+" has appeared #\n");

            while(enemyHealth>0){
                System.out.println("\tYour HP: "+health);
                System.out.println("\t"+enemy+"'s HP: "+enemyHealth);
                System.out.println("\n\tWhat would you like to do?");
                System.out.println("\t1.Attack");
                System.out.println("\t2.Drink health potion");
                System.out.println("\t3.Run!");

                int ch = sc.nextInt();
                if(ch==1){
                    int damageDealt = rand.nextInt(attackDamage);
                    int damageTaken = rand.nextInt(enemyAttackDamage);

                    enemyHealth -= damageDealt;
                    health -= damageTaken;

                    System.out.println("\t>You attacked "+enemy+" for"+damageDealt+" damage.");
                    System.out.println("\t>You got damaged by "+damageTaken+" from "+enemy);

                    if(health<1){
                        System.out.println("\t>You got too much damage, you can not play further!");
                        break;
                    }
                }
                else if(ch==2){
                    if(numHealthPotions>0){
                        health += healthPotionHealAmount;
                        numHealthPotions--;

                        System.out.println("\t>You have taken health potion with healing amount of, "+healthPotionHealAmount);
                        System.out.println("\t>Your health is now, "+health);
                        System.out.println("\t>Number of health potions left, "+numHealthPotions);
                    }
                }
                else if(ch==3){
                    System.out.println("\t>You run away from, "+enemy);
                    continue GAME;
                }
                else{
                    System.out.println("\t>Invalid input!");
                }

            }
            if(health<1){
                System.out.println("\t>You are defeated!!");
                break;
            }

            System.out.println("----------------------------------------------");
            System.out.println("\t>You defeated, "+enemy);
            System.out.println("\t?Your HP is, "+health);
            if(rand.nextInt(100) < healthPotionDropChance){
                numHealthPotions++;
                System.out.println("\t>The "+enemy+" dropped a health potion!");
                System.out.println("\t>You have health potion number as, "+numHealthPotions);
            }
            System.out.println("----------------------------------------------");
            System.out.println("\tWhat would you like to do?");
            System.out.println("\t1.Continue fight");
            System.out.println("\t2.Exit dungeon");

            int ch = sc.nextInt();
            while(ch!=1 &&  ch!=2){
                System.out.println("\t>Invalid command.");
                ch = sc.nextInt();
            }

            if(ch==1){
                System.out.println("\t>Continue the game");
            }
            else if(ch==2){
                System.out.println("\t>Exiting the game");
                break;
            }

        }

        System.out.println();
        System.out.println("#############################");
        System.out.println("Thanks for playing the game!");
        System.out.println("#############################");
    }
}
