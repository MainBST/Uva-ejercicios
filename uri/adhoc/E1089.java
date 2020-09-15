package uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1089 {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int numberSamples, resultado, p0, p1;
        int[] vector = new int[3];

        while ((numberSamples = fs.next()) != 0) {
            resultado = 0;
            vector[0] = fs.next();
            vector[1] = fs.next();
            if (numberSamples == 2) {
                if (vector[0] != vector[1]) resultado = 2;
            } else {
                p0 = vector[0];
                p1 = vector[1];
                for (int i = 2; i < numberSamples; i++) {
                    vector[2] = fs.next();
                    if(((vector[1]>vector[0]) && (vector[1]>vector[2])) || ((vector[1]<vector[0]) && (vector[1]<vector[2]))) ++resultado;
                    vector[0]=vector[1];
                    vector[1]=vector[2];
                }
                if ((p0>p1 && p0>vector[2]) || (p0<p1 && p0<vector[2])) ++resultado;
                if ((vector[2]>vector[0] && vector[2]>p0) || (vector[2]<vector[0] && vector[2]<p0)) ++resultado;
            }
            System.out.println(resultado);
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        int next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return Integer.parseInt(st.nextToken());
        }
    }
}
