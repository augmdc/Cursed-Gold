/**
CursedGold by Augustin Marks de Chabris
This program is a game where 2 players (computer vs computer or human vs computer or human vs human)
try to force the other player to take the last coin in a pile of 16 coins.
*/

import java.util.Scanner;
import java.util.Random;
public class CursedGold {
  public static Scanner keyboard = new Scanner(System.in);
  public static Random random_object = new Random();

  public static void main(String[] args) {
    int coins = 16;
    System.out.println("Welcome to Cursed Gold!.  Here be the rules:");
    System.out.println("-Ye can only take 1, 2 or 3 gold coins on yer turn.");
    System.out.println("-The poor soul that takes the last coin walks the plank (loses).");
    System.out.println("---------------------------------------------");
    
    System.out.println("Be playarr 1 human? y/n");
    String Player1_c_or_h = keyboard.nextLine();
    System.out.println("Be playarr 2 human? y/n");
    String Player2_c_or_h = keyboard.nextLine();
    System.out.println();

    if (Player1_c_or_h.equals("y") == true && Player2_c_or_h.equals("y") == true) {
    System.out.println("Arrrr I be stacking up a pile of coins " + coins + " high.\n");
    while (coins > 1) {
      coins -= Player1();
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(1,coins);
      coins -= Player2();
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(2,coins);
      System.out.println("---------------------------------------------");
    }
  }

  else if (Player1_c_or_h.equals("n") == true && Player2_c_or_h.equals("y") == true) {
    System.out.println("Arrrr I be stacking up a pile of coins " + coins + " high.\n");
    while (coins > 1) {
      coins -= computerPlayerChoice(1);
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(1,coins);
      coins -= Player2();
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(2,coins);
      System.out.println("---------------------------------------------");
    }
  }
  else if (Player1_c_or_h.equals("y") == true && Player2_c_or_h.equals("n") == true) {
    System.out.println("Arrrr I be stacking up a pile of coins " + coins + " high.\n");
    while (coins > 1) {
      coins -= Player1();
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(1,coins);
      coins -= computerPlayerChoice(2);
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(2,coins);
      System.out.println("---------------------------------------------");
    }
  }

  else if (Player1_c_or_h.equals("n") == true && Player2_c_or_h.equals("n") == true) {
    System.out.println("Arrrr I be stacking up a pile of coins " + coins + " high.\n");
    while (coins > 1) {
      coins -= computerPlayerChoice(1);
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(1,coins);
      coins -= computerPlayerChoice(2);
      System.out.println("Thar be " + (coins) + " gold left matey.");
      isWinner(2,coins);
      System.out.println("---------------------------------------------");
    }
  }

  }

public static int Player1() {
  return rightNumberOfCoins("Player1 Taking this number of coin(s):");
}

public static int Player2() {
  return rightNumberOfCoins("Player2 Taking this number of coin(s):");
}

public static void isWinner(int PlayerNumber, int num_coins) {
  if (num_coins == 1 || num_coins == 2 || num_coins == 3) {
    System.out.println("Winner is Player " + PlayerNumber + "\n");
    System.exit(0);
  }
  else {
    System.out.print("\b");
  }
}

  public static int rightNumberOfCoins(String str) {
    do {
      System.out.print(str);
      int user_input = keyboard.nextInt();
    } while (user_input < 1 || user_input > 3);

  return user_input;
  }

  public static int computerPlayerChoice(int PlayerNumber) {
    int choice = random_object.nextInt(2) + 1;
    System.out.println("Player" + PlayerNumber + " Taking " + choice + " gold coin(s)");
    return choice;
  }

}
