/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author sufia
 */
public class Deck {

    public Card drawCard() {
        int value = (int) (1 + (Math.random() * 13));
        int randomSuit = (int) (1 + (Math.random() * 4));
        String suit = null;
        switch(randomSuit) {
            case 1:
                suit = "Spades";
                break;
            case 2:
                suit = "Clubs";
                break;
            case 3:
                suit = "Hearts";
                break;
            case 4:
                suit = "Diamonds";
                break;
            default:
                break;
        }

        return new Card(value, suit);
    }

}
