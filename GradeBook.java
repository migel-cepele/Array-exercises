package chapter6_7;

public class GradeBook {
    private String courseName; //emri i lendes per keto nota
    private int[][] grades; //array 2d per notat e studenteve

    //konstruktori qe inicializon instance variables
    public GradeBook(String courseName, int[][] grades) {
        this.courseName = courseName;
        this.grades = grades;
    }

    //metoda per te vendosur emrin e lendes
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    //metoda qe merr emrin e lendes
    public String getCourseName() {
        return courseName;
    }

    //operacionet mbi te dhenat
    public void processGrades() {

        outputGrades();

        // call methods getMinimum and getMaximum
        System.out.printf("%n%s %d%n%s %d%n%n",
        "Lowest grade in the grade book is", getMinimum(),
        "Highest grade in the grade book is", getMaximum());

        outputBarChart();


    }

    public int getMinimum() {
        int lowGrade = grades[0][0];
        //loop through rows
        for(int[] studentGrades : grades) {

            //loop through columns
            for(int grade : studentGrades) {
                if(grade < lowGrade)
                lowGrade = grade;
            }
        }

        return lowGrade;
    }

    public int getMaximum() {
        int highGrade = grades[0][0];
        //loop through rows
        for(int[] studentGrades : grades) {

            //loop through columns
            for(int grade : studentGrades) {
                if(grade > highGrade)
                highGrade = grade;
            }
        }

        return highGrade;
        
    }

    //percakto mesataren per disa nota
    public double getAvarage(int[] setofGrades) {
        int total = 0;
        for(int grade : setofGrades)
        total += grade;

        return (double) total/setofGrades.length;
    }

    public void outputBarChart() {
        System.out.println("Overall grade distribution: ");

        //ruan frekuencat e notave nga 10 gjithsej
        int[] frenquency = new int[11];

        for(int[] studentGrades : grades) {

            for(int grade : studentGrades) {
                ++frenquency[grade/10];
            }
        }

        //per cdo frekuence notash printo bar in chart
        for(int i = 1; i < frenquency.length; i++) {

            //output bar label(00-09 ...)
            if(i == 10)
            System.out.printf("%5d", 100);
            else
            System.out.printf("%02d-%02d: ", i * 10, i *10 +9);

            //output asterisks per cdo note
            for(int j = 0; j < frenquency[i]; j++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }

    public void outputGrades() {
        System.out.printf("The grades are: %n%n");
        System.out.print("         "); //align column heads

        // create a column heading for each of the tests
        for (int test = 0; test < grades[0].length; test++)
          System.out.printf("Test %d ", test + 1);

        System.out.println("Average"); // student average column heading

          // create rows/columns of text representing array grades
        for (int student = 0; student < grades.length; student++)
        {
            System.out.printf("Student %2d", student + 1);

            for (int test : grades[student]) // output student's grades
               System.out.printf("%8d", test);

               // call method getAverage to calculate student's average grade;
               // pass row of grades as the argument to getAverage
            double avarage = getAvarage(grades[student]);
            System.out.printf("%9.2f%n", avarage);
        }
    }
}
