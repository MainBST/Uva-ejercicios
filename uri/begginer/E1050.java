package uri.begginer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class E1050 {
    public static class DDD {
        int ddd;
        String destination;

        public DDD(int ddd, String destination) {
            this.ddd = ddd;
            this.destination = destination;
        }

        public int getDdd() {
            return ddd;
        }

        public String getDestination() {
            return destination;
        }
    }

    public static List<DDD> builderListDDD() {
        List<DDD> listDDD = new ArrayList<>();
        listDDD.add(new DDD(61, "Brasilia"));
        listDDD.add(new DDD(71, "Salvador"));
        listDDD.add(new DDD(11, "Sao Paulo"));
        listDDD.add(new DDD(21, "Rio de Janeiro"));
        listDDD.add(new DDD(32, "Juiz de Fora"));
        listDDD.add(new DDD(19, "Campinas"));
        listDDD.add(new DDD(27, "Vitoria"));
        listDDD.add(new DDD(31, "Belo Horizonte"));
        return listDDD;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int destino = sc.nextInt();
        DDD ddd = builderListDDD().stream()
                .filter(d -> d.getDdd() == destino )
                .findFirst()
                .orElse(new DDD(0, "DDD nao cadastrado"));
        System.out.println(ddd.getDestination());
    }
}
