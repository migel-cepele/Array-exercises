package chapter6_7;

public class StudentPoll {
    public static void main(String[] args) {

        int[] responses = {1, 2, 5, 2, 5, 2, 2, 3, 2, 24, 5, 1, 1};
        
        //array of frenquency
        int[] frenquency = new int[6];

        for(int i = 0; i < responses.length; i++) {
            //kap rastet kur vlerat e responses jane me te larta sec duhet te jene
            try{
                ++frenquency[responses[i]];
            } catch(ArrayIndexOutOfBoundsException e) {
                System.out.println(e);
                System.out.printf("   responses[%d] = %d%n%n", i, responses[i]);

            }
        }

        System.out.printf("%s%10s%n", "Rating", "Frequency");
        for(int i = 1; i <= frenquency.length; i++) 
        System.out.printf("%6d%10d%n", i, frenquency[i]);
        


    }
    
}
