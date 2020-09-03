package uri.begginer;

import java.math.BigInteger;
import java.util.Scanner;

public class E2334 {
    public static void main(String[] args) {
        BigInteger patos;
        Scanner sc = new Scanner(System.in);
        patos = sc.nextBigInteger();
        do {
            if(patos.equals(BigInteger.ZERO)) System.out.println("0");
            else System.out.println((patos.subtract(BigInteger.ONE)));
            patos = sc.nextBigInteger();
        } while(!(patos.equals(BigInteger.valueOf(-1))));
    }
}
