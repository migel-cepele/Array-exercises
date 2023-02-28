package chapter6_7;

import java.util.ArrayList;

public class ArrayListCollection {
    public static void main(String[] args) {
        
        ArrayList<String> items = new ArrayList<String>();

        items.add("red"); //shton red ne fund te items
        items.add(0, "sdhdsl"); //shton ate ne indeksin 0

        System.out.println(items.size()); //printon madhesine e items
        System.out.println(items.get(0)); //printon elementin 0

        items.remove("red"); //heq red nga items
        System.out.printf("red is %sin the list%n", items.contains("red")? "": "not ");
        

    }
}
