package uri.begginer;

import java.text.DecimalFormat;
import java.util.Scanner;

public class E1021 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double valor = sc.nextDouble();
        int notas[] = {100, 50, 20, 10, 5, 2};
        double moedas[] = {1.00, 0.50, 0.25, 0.10, 0.05, 0.01};
        System.out.println("NOTAS:");
        for (int i = 0; i < notas.length; i++) {
            int cantidadNota = (int) (valor / notas[i]);
            System.out.printf("%d nota(s) de R$ %.2f\n",cantidadNota ,  (double) notas[i]);
            valor = pasarADouble(valor - notas[i]*cantidadNota);
        }
        System.out.println("MOEDAS:");
        for (int i = 0; i < moedas.length; i++) {
            int cantidadMoeda = (int) (valor / moedas[i]);
            System.out.printf("%d moeda(s) de R$ %.2f\n", (int) (valor / moedas[i]), moedas[i]);
            valor = pasarADouble(valor - moedas[i] * cantidadMoeda);
        }
    }

    private static double pasarADouble(double x) {
        DecimalFormat format = new DecimalFormat("#0.00");
        return Double.valueOf(format.format(x));
    }
}
