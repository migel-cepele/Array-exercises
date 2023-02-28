package chapter6_7;
import java.security.SecureRandom;

public class RollDie {
    public static void main(String[] args) {

        SecureRandom r = new SecureRandom();

        int r1 = 0;
        int r2 = 0;
        int r3 = 0;
        int r4 = 0;
        int r5 = 0;
        int r6 = 0;

        //loop qe numeron frekuencat per cdo hedhje nga 6mil te zarit
        for(int i = 0; i < 6000000;i++) {
            int face = 1 + r.nextInt(6);

            switch(face) {
                case 1: ++r1;
                break;
                case 2: ++r2;
                break;
                case 3: ++r3;
                break;
                case 4: ++r4;
                break;
                case 5: ++r5;
                break;
                case 6: ++r6;
                break;

            }
        }

        System.out.println("Face\tFrenquency"); //headerat
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n",
        r1, r2, r3, r4, r5, r6);
        
        
    }
}
