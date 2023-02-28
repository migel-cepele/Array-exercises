package chapter6_7;

public class DeckOfCardsTest {
    public static void main(String[] args) {
        DeckOfCards d = new DeckOfCards();
        d.fisherYates();

        //printo letrat e perziera
        for(int i = 1; i <=52; i++) {
            System.out.printf("%-19s", d.dealCard());

            if(i%4 ==0)
            System.out.println();
        }
    }
}
