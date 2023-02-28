package chapter6_7;
import java.security.SecureRandom;

public class DeckOfCards {

    private Card[] deck; //pakoja e letrave
    private int currentCard; //indeksi i letres qe do shperndahet
    private static final int NUMBER_OF_CARDS = 52; //NR I LETRAVE TE PAKOS

    private static final SecureRandom r = new SecureRandom();

    //konstruktori qe mbush pakon e letrave
    public DeckOfCards() {
        String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
        "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

        deck = new Card[NUMBER_OF_CARDS]; //krijon nje array me card objects
        currentCard = 0; //letra e pare qe do te shperndahet nga pakoja

        //popullimi i pakos me objekte letra
        for(int i = 0; i < deck.length; i++) {
            deck[i] = new Card(faces[i%13], suits[i/13]);
        }

        

    }
    //funksioni  qe i ben shuffle pakos se letrave
        //Algoritimi i Fisher-Yates

    public void fisherYates() {
        //thirrja tjeter e metodes dealCard dote nisi ne deck[0] perseri
        currentCard = 0;

        //algoritmi
        int i = deck.length;
        while(--i > 0 ) {
            
            int index = r.nextInt(NUMBER_OF_CARDS - i+2);

            //swap letren e zgjedhur me letren ne fund te pakos
            Card temp = deck[index]; 
            deck[index] = deck[i];
            deck[i] = temp;

        }

    }
    //funksion qe shperndan nje leter te vetme
    public Card dealCard() {

        if(currentCard < deck.length)
        return deck[currentCard++];
        else
        return null;

    }
}
