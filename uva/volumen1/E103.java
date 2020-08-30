package uva.volumen1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class E103 {
    public static class Caja implements Comparable<Caja> {
        int dimension [];
        int enlace;

        @Override
        public int compareTo(Caja c) {
            for(int i=dimension.length-1; i>=0; i--) {
                int diferencia = this.dimension[i]- c.dimension[i];
                if (diferencia != 0) {
                    return diferencia;
                }
            }
            return 0;
        }

        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            for (int i=0; i<dimension.length; i++) {
                sb.append(dimension[i] + " ");
            }
            return sb.toString();
        }
    }

    public static boolean esAgregable(Caja caja1, Caja caja2) {
        for (int i=0; i<caja1.dimension.length; i++) {
            if (caja1.dimension[i] >= caja2.dimension[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine())!=null) {
            StringTokenizer st = new StringTokenizer(s);
            int numeroCajas = Integer.parseInt(st.nextToken());
            int dimensionCaja = Integer.parseInt(st.nextToken());
            Caja [] caja = new Caja [numeroCajas];
            for (int i=0; i<numeroCajas; i++) {
                caja[i]=new Caja();
                caja[i].enlace =i+1;
                caja[i].dimension = new int [dimensionCaja];

                st = new StringTokenizer(br.readLine());
                for (int j=0; j<dimensionCaja; j++) {
                    caja[i].dimension[j]=Integer.parseInt(st.nextToken());
                }

                Arrays.sort(caja[i].dimension);
            }
            Arrays.sort(caja);

            int [] lista = new int [numeroCajas];
            lista[0] = 1;
            for (int i=1; i<numeroCajas; i++) {
                lista[i] = 1;
                for (int j=0; j<i; j++) {
                    if (esAgregable(caja[j], caja[i])) {
                        lista[i]=Math.max(1+lista[j], lista[i]);
                    }
                }
            }

            int maximo = 0;
            for (int i=0; i<lista.length; i++) {
                maximo = Math.max(maximo, lista[i]);
            }
            System.out.println(maximo);

            int [] solucion = new int [maximo];
            Caja ultima = null;
            for (int i=lista.length-1; i>=0 && maximo>0; i--) {
                if (lista[i]==maximo && (ultima==null || esAgregable(caja[i], ultima))) {
                    solucion[maximo-1] = i;
                    maximo--;
                    ultima= caja[i];
                }
            }

            for (int i=0;i<solucion.length;i++) {
                System.out.print(caja[solucion[i]].enlace);
                if (i < solucion.length-1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
