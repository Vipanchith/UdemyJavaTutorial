/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fighting;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Vipanchith
 */
public class Fighting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random generator = new Random();
        
        String monsterName;
        int num = generator.nextInt(5);
        switch (num) {
            case 0: monsterName = "Black Daemon"; break;
            case 1: monsterName = "The Rabbit"; break;
            case 2: monsterName = "Silver Dragon"; break;
            case 3: monsterName = "Mountain Troll"; break;
            case 4: monsterName = "Alien"; break;
            default: monsterName = "N/A"; break;
        }
        
        System.out.print("Attack Points of "+monsterName+":");
        int monsterAttack = generator.nextInt(8)+1;
        System.out.println(monsterAttack);
        System.out.print("Defense Points of "+monsterName+":");
        int monsterDefense = generator.nextInt(15)+3;
        System.out.println(monsterDefense);
        System.out.print("Damage of "+monsterName+":");
        int monsterDamage = generator.nextInt(3)+1;
        System.out.println(monsterDamage);
        System.out.print("Life Points of "+monsterName+":");
        int monsterLife = generator.nextInt(20)+15;
        System.out.println(monsterLife);
        
        
        System.out.print("Your Attack Points:");
        int yourAttack = generator.nextInt(6)+5;
        System.out.println(yourAttack);
        System.out.print("Your Defense Points:");
        int yourDefense = generator.nextInt(10)+6;
        System.out.println(yourDefense);
        System.out.print("Your Damage:");
        int yourDamage = generator.nextInt(3)+2;
        System.out.println(yourDamage);
        System.out.print("Your Life Points:");
        int yourLife = generator.nextInt(20)+25;
        System.out.println(yourLife);
        //sc.nextLine();
        boolean runaway = false;
        
        
        do {
            boolean attacker = generator.nextBoolean();
            if (attacker) {
                System.out.println("You attack");
                int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
                int attackValue = yourAttack + dice;
                System.out.println("Rolled values: "+dice);
                System.out.println("Your attack value: " + attackValue);
                if (attackValue > monsterDefense) {
                    System.out.println("Your attack was successful.");
                    monsterLife = monsterLife - yourDamage;
                    System.out.println(monsterName + "'s remaining Life Points: " + monsterLife);
                } else {
                    System.out.println("Your attack was not successful.");
                }
            } else {
                System.out.println(monsterName + " attacks");
                int dice = generator.nextInt(6)+1 + generator.nextInt(6)+1;
                int attackValue = monsterAttack + dice;
                System.out.println("Rolled values: "+dice);
                System.out.println(monsterName + "'s attack value: " + attackValue);
                if (attackValue > yourDefense) {
                    System.out.println(monsterName + "'s attack was successful.");
                    yourLife = yourLife - monsterDamage;
                    System.out.println("Your remaining Life Points: " + yourLife);
                } else {
                    System.out.println(monsterName + "'s attack was not successful.");
                }
            }
            System.out.println("Press ENTER to continue. (Or type in 'run' to run away)");
            String command = sc.nextLine();
            switch (command) {
                case "run":
                    System.out.println("You ran away. You coward! -4 Life Points!");
                    yourLife -= 4;
                    runaway = true;
                    break;
                default:
            }
        } while (yourLife > 0 && monsterLife > 0 && !runaway);
        if (yourLife <= 0) {
            System.out.println("You are dead. R.I.P. :-(");
        }
        if (monsterLife <= 0) {
            System.out.println("You won. The "+monsterName+" is dead.");
        }
    }
    
}
