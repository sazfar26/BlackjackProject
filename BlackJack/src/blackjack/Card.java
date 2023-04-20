/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package blackjack;

/**
 *
 * @author sufia
 */
public class Card {

    private int value;
    private String suit;

    public Card(int val, String sut) {
        this.value = val;
        this.suit = sut;
    }

    public String getSuit() {
        return this.suit;
    }

    public int getValue(boolean isBlackJack) {
        if (!isBlackJack) {
            return value;
        } else {
            if (value == 1) {
                return 11;
            } else {
                if (value > 10) {
                    return 10;
                } else {
                    return value;
                }
            }
        }
    }
    public String declareCard() {
        String result = null;
        switch(this.value) {
            case 11: 
                result = "the Jack of " + this.suit;
                break;
            case 12:
                result = "the Queen of " + this.suit;
                break;
            case 13: 
                result = "the King of " + this.suit;
                break;
            case 1:
                result = "the Ace of " + this.suit;
                break;
            default:
                result = "the " + this.value + " of " + this.suit;
        }
        return result;
    }
}
