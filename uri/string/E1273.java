package uri.strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E1273 {
    public static void main(String[] args) {
        FastReader fs = new FastReader();
        int numberWords, maxLength;
        String[] words = new String[51];
        while ((numberWords = fs.nextInt()) != 0) {
            for (int i = 0; i < numberWords; i++) words[i] = fs.next();
            maxLength = maxLength(words, numberWords);
            printWithSpaces(words, numberWords, maxLength);
        }
    }

    static int maxLength(String[] words, int numberWords) {
        int length = 0;
        for (int i = 0; i < numberWords; i++) if (words[i].length() > length) length = words[i].length();
        return length;
    }

    static void printWithSpaces(String[] words, int numberWords, int spaces) {
        int spacesCalculate = 0;
        for (int i = 0; i < numberWords; i++) {
            spacesCalculate = spaces - words[i].length();
            System.out.printf("%" + (spacesCalculate + words[i].length()) + "S\n", words[i]);
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
