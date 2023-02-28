package chapter6_7;

public class BarChart{
    public static void main(String[] args) {

        int [] a = {1, 0, 4, 2, 1, 0, 5, 1, 3,0};

        System.out.println("Grade distribution: ");

        //per cdo element ne array do printojme nje rresht te grafiku
        for(int i = 1; i < a.length; i++) {

            //output bar label(00-09 ...)
            if(i == 10)
            System.out.printf("%5d", 100);
            else
            System.out.printf("%02d-%02d: ", i * 10, i *10 +9);

            //output asterisks per cdo note
            for(int j = 0; j < a[i]; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
        
    }
}