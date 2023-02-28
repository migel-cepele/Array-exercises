package chapter6_7;
import java.util.Scanner;

//ushtrimi 7.36 ne fq308. Krijimi i nje kompjuteri te thjeshte simpletron
//me disa instruksione baze
public class Simpletron {
    //private data:
    //array me 100 hyrje qe sherben si accumulator per sml
    //konstantet per kodet e veprimeve aritmetike
    //instrunksionet perbehen nga 4 numra
    //2 numra per instruksionin + 2 numra per pozicionin e memorjes  qe aplikohet instruksioni
    //rezultatet e shprehjeve ruhen ne po ate vend qe eshte aplikuar instruksioni


    //programet e shkruajtura ne SML nisin gjithmone nga ideksi 00 i accumulator

    private int[] accumulator = new int[100]; //memorja e simpletron

    //input/output operations
    private final int READ = 10; //lexon nje word dhe e vendos ne nje pozicion fiks ne memory
    private final int WRITE = 11; //shkruan nje word nga nje pozicion fiks ne ekran

    //LOAD/STORE
    private final int LOAD = 20; //ngarkon nje te dhene nga nje pozicion ne memorje ne accumulator
    private final int STORE = 21; //ruan nje te dhene nga accumulator ne nje pozicion fiks ne memorje

    //ARITHMETIC
    private final int ADD = 30; //shton nje fjale nga nje pozicion fiks ne memorje ne accumulator
                                //rezultati ruhet ne accumulator
    private final int SUBTRACT = 31;
    private final int DIVIDE = 32;
    private final int MULTIPLY = 33;

    //TRANSFER OF CONTROL OPERATION
    private final int BRANCH = 40; //branch ne nje vend te memorjes
    private final int BRANCHNEG = 41; //BRANCH ne nje vend te memorjes nese accumulator eshte negativ
    private final int BRANCHZERO = 42; //branch ne nje vend te memorjes nese accumulator eshte 0
    private final int HALT = 43;

    private int index = 0; //indeksi qe tregon nr aktual te instruksioneve ne accumulator
    private int veprimi = 0; //vendi ku po kryhet veprimi aktual
    Scanner input = new Scanner(System.in);


    

    //public functions:

    //in/out
    public void output(int kodi) {
        System.out.println(accumulator[kodi%100]);
        index++;
    }

    public void input(int kodi) {
        System.out.println("Vendosni te dhenen qe do te ruani (signed 4 shifra): ");
        int x = input.nextInt();
        index++;
        accumulator[kodi%100] = x;
              
        
    }

    //load/store
    public void load(int x) {
        veprimi = index;
        accumulator[veprimi]= accumulator[x%100];
        index++;
        

    }

    public void store(int x) {
        
        accumulator[x%100] = accumulator[veprimi];
        index++;
    }

    //arithmetic
    public void add(int x) {
        accumulator[veprimi] += accumulator[x%100];
        index++;
    }

    public void subtract(int x) {
        accumulator[veprimi] -= accumulator[x%100];

        index++;
    }

    public void multiply(int x) {
        accumulator[veprimi] *= accumulator[x%100];
    
        index++;
    }

    public void divide(int x) {
        accumulator[veprimi] /= accumulator[x%100]; 
        index++;
    }

    //branch

    public void branch(int x) {
        index++;
        veprimi = x%100;
    }

    public void branchneg(int x) {
        if(accumulator[veprimi]<0) {
            index++;
            veprimi =  x%100;
        }
    }

    public void branchzero(int y) {
        if(accumulator[veprimi] == 0) {
            veprimi = y%100;
        }
        index++;
    }

    public boolean halt() {
        index++;
        return true;
    }


    //programi sipas sml
    public int mesatarjaSml() {

        //leximi i 10 nr qe do gjejme mesataren dhe vendosja ne tabelen accumulator
        //tabela e kodeve permban 5 inpute nr qe do u gjehet mesatarja, 1 input qe tregon sa
        //nr jane gjithsej dhe me pas veprimet perkatese per mesataren
        int mesatarja[] = {1020,1021,1022,1023,1024,1025,2020,3021,3022,3023,3024,3225,2120,1120};
        for(int i = 0; i <mesatarja.length; i++) {
            accumulator[i] = mesatarja[i];
        }

        while((index < accumulator.length) && (index < 100)) {
            
            switch(accumulator[index]/100) {
                case READ:
                input(accumulator[index]);
                break;
                case WRITE:
                output(accumulator[index]);
                break;
                case LOAD:
                load(accumulator[index]);
                break;
                case STORE:
                store(accumulator[index]);
                break;
                case ADD:
                add(accumulator[index]);
                break;
                case SUBTRACT:
                subtract(accumulator[index]);
                break;
                case DIVIDE:
                divide(accumulator[index]);
                break;
                case MULTIPLY:
                multiply(accumulator[index]);
                break;
                case BRANCH:
                branch(accumulator[index]);
                break;
                case BRANCHNEG:
                branchneg(accumulator[index]);
                break;
                case BRANCHZERO:
                branchzero(accumulator[index]);
                break;
                case HALT:
                halt();
                break;
            }
        }
        return -1;
    }


    
}
