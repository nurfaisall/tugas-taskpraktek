package org.acme;

import org.acme.model.Factorial;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args){
//        System.out.println("hello world");
//
//        List<Integer> number = new ArrayList<>();
//        List<Integer> factorial = new ArrayList<>();
//
//        for (int i = 1; i < 4; i++){
//            number.add(i);


//        }

        int n = 6;
        int f = 1;

        for (int m = 1; m <= n; m++){
            System.out.println("m = "+m);
            f = f*m;

            System.out.println(f);
        }


    }
}
