package chapter6_7;
import java.security.SecureRandom;

public class Craps {

    //gjeneratori i nr rastesor qe do perdori metoda rollDie
    private static final SecureRandom r = new SecureRandom();

    //enum type qe perbehet nga konstantet qe paraqesin gjendjen e lojes

    private enum Status {CONTINUE, WON, LOST};

    //konstante qe paraqesin hedhjet e zakonshme te zarit
    private static final int SNAKE_EYES = 2;
    private static final int TREY = 3;
    private static final int SEVEN= 7;
    private static final int YO_LEVEN = 11;
    private static final int BOX_CARS = 12;


    //metoda rollDice, calculate sum and display results

    public static int rollDice() {
        int die1 = 1 + r.nextInt(6);
        int die2 = 1 + r.nextInt(6);

        int sum = die1 + die2;

        System.out.printf("Lojtari ka %d + %d = %d%n", die1, die2, sum);
        return sum;
    }

    //luan nje loje craps
    public static void main(String[] args) {
        
        int myPoint = 0; //pike nese nuk ka fitore ose humbje ne hedhjen e pare
        Status gameStatus; // mund te marri nje nga tre vlerat e lojes ne enum

        int sumOfDice = rollDice();

        switch (sumOfDice) {
            case SEVEN://win with 7 or 11 on first roll
            case YO_LEVEN:
            gameStatus = Status.WON;
            break;
            case SNAKE_EYES: //win with 2,3,12 on first roll
            case TREY:
            case BOX_CARS:
            gameStatus = Status.LOST;
            break;
            default://did not win or lose so remember point
            gameStatus = Status.CONTINUE;
            myPoint = sumOfDice; //mban mend piket
            System.out.print("Piket jane: "+ myPoint);
            break;
        }

        while (gameStatus == Status.CONTINUE) {
            sumOfDice = rollDice(); //roll dice again

            if (sumOfDice == myPoint) 
                gameStatus = Status.WON;
            else
                if(sumOfDice == SEVEN)
                   gameStatus = Status.LOST;
        }

        if(gameStatus == Status.WON)
        System.out.println("lojtari fiton!");
        else
        System.out.println("lojtari humb");
    }

}
