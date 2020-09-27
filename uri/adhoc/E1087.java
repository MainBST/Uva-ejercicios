package uri.adhoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1087 {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int x1, y1, x2, y2;
        while (((x1 = fs.next()) != 0) && ((y1 = fs.next()) != 0) && ((x2 = fs.next()) != 0) && ((y2 = fs.next()) != 0)) {
            if (isSame(x1, y1, x2, y2)) {
                System.out.println("0");
            } else if (isDiagonal(x1, y1, x2, y2) || isOneAxisSame(x1, y1, x2, y2)) {
                System.out.println("1");
            } else {
                System.out.println("2");
            }
        }
    }

    static boolean isSame(int x1, int y1, int x2, int y2) {
        return (x1 == x2) && (y1 == y2);
    }

    static boolean isOneAxisSame(int x1, int y1, int x2, int y2) {
        return (x1 == x2) || (y1 == y2);
    }

    static boolean isDiagonal(int x1, int y1, int x2, int y2) {
        int originalX1 = x1, originalY1 = y1;
        for (; (x1 <= 8) && (y1 <= 8); x1++, y1++) if ((x1 == x2) && (y1 == y2)) return true;
        x1 = originalX1;
        y1 = originalY1;
        for (; (x1 >= 1) && (y1 >= 1); x1--, y1--) if ((x1 == x2) && (y1 == y2)) return true;
        x1 = originalX1;
        y1 = originalY1;
        for (; (x1 >= 1) && (y1 <= 8); x1--, y1++) if ((x1 == x2) && (y1 == y2)) return true;
        x1 = originalX1;
        y1 = originalY1;
        for (; (x1 <= 8) && (y1 >= 1); x1++, y1--) if ((x1 == x2) && (y1 == y2)) return true;
        return false;
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
