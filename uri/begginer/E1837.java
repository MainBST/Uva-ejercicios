import java.util.Scanner;
import java.util.function.BiConsumer;

public class E1837 {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> preface = (x, y) -> {
            int f = 0, e, q, r;
            if(x < 0) {
                e = Math.abs(y);
                for(r = 0; r < e; r++) {
                    f = x - r;
                    if(f % y == 0) break;
                }
                q = f / y;
            } else {
                q = x / y;
                r = x % y;
            }
            System.out.printf("%d %d\n", q, r);
        };
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(), b = sc.nextInt();
        preface.accept(a, b);
    }
}