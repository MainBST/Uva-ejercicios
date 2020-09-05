package uri.begginer;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class E1828 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> elements = buildElements();
        int tests = sc.nextInt();
        String sheldon, raj;
        for (int i = 1; i <= tests; i++) {
            sheldon = sc.next();
            raj = sc.next();
            if (elements.get(sheldon).contains(raj)) {
                System.out.printf("Caso #%d: Bazinga!\n", i);
            } else if (elements.get(raj).contains(sheldon)) {
                System.out.printf("Caso #%d: Raj trapaceou!\n", i);
            } else {
                System.out.printf("Caso #%d: De novo!\n", i);
            }
        }
    }

    public static Map<String, String> buildElements() {
        Map<String, String> elements = new HashMap<>();
        elements.put("tesoura", "papel lagarto");
        elements.put("papel", "pedra Spock");
        elements.put("pedra", "lagarto tesoura");
        elements.put("lagarto", "Spock papel");
        elements.put("Spock", "tesoura pedra");
        return elements;
    }
}
