/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package blackjack;

import java.util.Scanner;

/**
 *
 * @author sufia
 */
public class BlackJack {

    public static void main(String[] args) throws InterruptedException {
    int houseWins = 0;
    int playerWins = 0;
    int ties = 0;
        Scanner scnr = new Scanner(System.in);
        System.out.println("How many rounds would you like to play?");
        int numRounds = scnr.nextInt();
        int currentRound = 1;
        System.out.println("");
        //While loop used to loop the amount of rounds the player wants.
        while (currentRound <= numRounds) {
            System.out.println("Round " + currentRound);
            Deck deck = new Deck();
            //Drawing two cards each for both the house and the player
            int houseTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);
            int playerTotal = deck.drawCard().getValue(true) + deck.drawCard().getValue(true);

            System.out.println("The house is showing: " + houseTotal);
            Thread.sleep(600);
            //This while loop represents the player's turn. It continues to iterate
            //until the player's turn is done.
            while (playerTotal <= 21) {
                Thread.sleep(500);
                System.out.println("Player is showing: " + playerTotal);
                System.out.println("Would you like to hit or stand?\n\tEnter 1 for hit or 0 for stand.");
                int choice = scnr.nextInt();
                if (choice == 0) {
                    break;
                } else if (choice == 1) {
                    Card nextCard = deck.drawCard();
                    System.out.println("Player draws the " + nextCard.declareCard());
                    Thread.sleep(400);
                    playerTotal += nextCard.getValue(true);
                } else {
                    System.out.println("Invalid option, try again.");
                }
            }
            if (playerTotal > 21) {
                System.out.println("The player has busted!");
            } else {
                System.out.println("\nThe player stands with " + playerTotal + " points.");
            }
            //Code for the house's turn begins below
            System.out.println("The House will play next.");
            Thread.sleep(500);
            while (houseTotal <= 21) {
                Thread.sleep(500);
                while (houseTotal < 17) {
                    Card nextCard = deck.drawCard();
                    System.out.println("The House draws the " + nextCard.declareCard());
                    Thread.sleep(700);
                    houseTotal += nextCard.getValue(true);
                }
                if (houseTotal >= 17 && houseTotal <= 21) {
                    break;
                }
            }
            if (houseTotal > 21) {
                System.out.println("The House has busted!");
                System.out.println("");
            } else {
                System.out.println("\nThe House stands with " + houseTotal + " points.");
                System.out.println("");
            }
                            //Ending of the game, displaying results below//
                
            System.out.println("******GAME RESULTS******");
            if (houseTotal > 21) {
                System.out.println("The House busted. Player wins.");
                playerWins++;
            }
            if (playerTotal > 21) {
                System.out.println("The player has busted. The House wins.");
                houseWins++;
            }
            if (houseTotal > playerTotal && houseTotal <= 21) {
                System.out.println("House total is greater than the player's total. The House wins.");
                houseWins++;
            }
            if (playerTotal > houseTotal && playerTotal <= 21) {
                System.out.println("Player total is greater than the House's total. The player wins.");
                playerWins++;
            }
            if (playerTotal == houseTotal) {
                System.out.println("Player and House have the same totals. Tie.");
                ties++;
            }
            System.out.println("");
            currentRound++;
            System.out.println("Player Wins: " + playerWins);
            System.out.println("House Wins: " + houseWins);
            System.out.println("Ties: " + ties);
            System.out.println("");
        }
        scnr.close();
    }
}
