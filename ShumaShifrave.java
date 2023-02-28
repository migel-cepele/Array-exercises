package chapter6_7;

public class ShumaShifrave {
    private static int nr;
    
    public static void setNr(int a) {
        nr =a;
    }

    public static int shuma() {

        int shifrat=0;
        int shuma = 0;
        int nrOrg = Math.abs(nr);
        while(nrOrg/10 != 0) {
            shifrat++;
            nrOrg /=10;
        }
        

        nrOrg = Math.abs(nr);
        for(int i = 0; i< shifrat; i++) {
            shuma+=nr%10;
            nrOrg/=10;


        }
        return shuma+1;



    }
    public static void main(String[] args) {

        ShumaShifrave.setNr(58758);
        System.out.println(ShumaShifrave.shuma());
        
    }
}
