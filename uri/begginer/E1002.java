package uri.begginer;

import java.util.Scanner;

public class E1002 {
    public static void main(String[] args) {
        double radio, area;
        Scanner sc = new Scanner(System.in);
        radio = sc.nextDouble();
        area = 3.14159 * Math.pow(radio, 2);
        System.out.printf("A=%.4f\n", area);
    }
}
