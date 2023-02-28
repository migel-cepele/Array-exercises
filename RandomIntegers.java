package chapter6_7;
import java.security.SecureRandom; //klasa SecureRandom perzgjedh nr rastesor nondetermistic

public class RandomIntegers {
    public static void main(String[] args) {
        SecureRandom r = new SecureRandom();

        for(int i = 1; i <= 20; i++) {
            //zgjedh nje nr rastesor nga 1 ne 6
            int face = 1+r.nextInt(6);//nextInt gjeneron nr rastesor deri ne 5

            System.out.printf("%d ", face);

            if (i % 5 ==0 )
              System.out.println();
        }
    }
}