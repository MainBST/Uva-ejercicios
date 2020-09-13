package uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1311 {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int[] izquierda = new int[1000100];
        int[] derecha = new int[1000100];
        int numeroSoldados, numeroReportes, left, right;
        while (((numeroSoldados = fs.nextInt()) != 0 ) && ((numeroReportes = fs.nextInt()) != 0)) {
            for (int i = 0; i<=numeroSoldados; i++) {
                izquierda[i] = i -1;
                derecha[i] = i + 1;
            }
            for (int i = 0; i < numeroReportes; i++) {
                left = fs.nextInt();
                right = fs.nextInt();

                if (izquierda[left] < 1) System.out.print("*");
                else System.out.print(izquierda[left]);

                if (derecha[right] > numeroSoldados) System.out.println(" *");
                else System.out.println(" " + derecha[right]);

                izquierda[derecha[right]] = izquierda[left];
                derecha[izquierda[left]] = derecha[right];
            }
            System.out.println("-");
        }

    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}