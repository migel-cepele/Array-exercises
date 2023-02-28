package chapter6_7;

public class GradeBookTest {
    public static void main(String[] args) {
        int[][] gradesArray = {{87, 54, 69}, 
        {65,85,98},
        {47,75,12},
        {65,85,94},
        {47,32,54}, 
        {85,75,96}};

        GradeBook myGradeBook = new GradeBook("java", gradesArray);
        myGradeBook.processGrades();
    }
}
