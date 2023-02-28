package chapter6_7;

public class Card {
    private final String face; //cfare lloj letre(as,jan,etj)
    private final String suit; //cfare lloji eshte nje face(spathi,etj)

    //konstruktori qe inicializon karten
    public Card(String face, String suit) {
        this.face = face;
        this.suit = suit;
    }

    //funksion qe kthen llojin e letres
    public String toString() {
        return face + " of" + suit;
    }
    
}
