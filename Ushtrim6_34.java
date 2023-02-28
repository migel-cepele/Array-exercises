package chapter6_7;


public class Ushtrim6_34 {

    public String binary;
    public String octal;
    public String hexadecimal;

    public Ushtrim6_34(String k) {//konstruktori qe merr ne string me 8 bite
        binary = k;
        binaryToHexadecimal(binary);
        binaryToOctal(binary);

    }

    //funksion qe konverton nga nje string binar me 8 shifra ne string hexadecimal me 2 shifra duke perdorur metoden me karaktere
    public void binaryToHexadecimal(String binar) {
        
        char shifra1 = '0'; //shifra njesheve
        char shifra2 = '0';  //shifra dhjetsheve
        
        int nrDecimal = 0; //nr ndihmes per llogaritjet

        for (int i = 0; i < 4; i++) {
            if(binar.charAt(i) == '1') {
                nrDecimal = nrDecimal + (int)Math.pow(2,i);
            }
    
        }
         
        shifra1 = Character.forDigit(nrDecimal, 16); //argumenti i dyte eshte baza e sistemit te nr qe po e konvertojme
        

        int nrDec = 0; //nr ndihmes per llogaritjet
        for (int i = 4; i < 8; i++) {
            if(binar.charAt(i) == '1') {
                nrDec += (int)Math.pow(2,i-4);
            }
        }
        
       
        shifra2 = Character.forDigit(nrDec, 16); // argumenti eshte baza e nr qe do e konvertojme
        

        hexadecimal = "" + shifra2 + shifra1; // konvertimi ne string per shkak te thonjzave si operand
        System.out.printf("Paraqitja hexa: %16s%n", hexadecimal);
        
    }



    public void binaryToOctal(String binary) { //fun me i lehte per tu implementuar sepse perdor direkt konvertimin nga int ne string me baze 8
    

        int nrDec1 = 0; // nr decimal per llogaritjet
        

        for(int i = 0; i < 8; i++) {
            if(binary.charAt(i) == '1') {
                nrDec1 += (int)Math.pow(2, i);

            }
            
        }
        octal = Integer.toOctalString(nrDec1);

        System.out.printf("Paraqitja oktale: %16s%n", octal);


    }




    public static void main(String[] args) {

        

        new Ushtrim6_34("10101000");
        
        
        
    }
    
}
