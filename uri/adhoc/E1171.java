package uri.adhoc;

import java.util.Scanner;

public class E1171 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numeroCasos = sc.nextInt();
        int [] numeros = new int[2001];
        for(int i=0; i<numeroCasos; i++) numeros[sc.nextInt()]++;
        for(int i=0; i<numeros.length; i++) 
            if(numeros[i] > 0) 
                System.out.println(i + " aparece "+ numeros[i] +" vez(es)");
    }
}