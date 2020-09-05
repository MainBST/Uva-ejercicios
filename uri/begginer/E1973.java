package uri.begginer;

import java.util.Scanner;

public class E1973 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberStart = sc.nextInt();
        int i, k = 0;
        long sumStarts = 0, sumSheeps = 0;
        int[] stars = new int[numberStart];
        int[] sheeps = new int[numberStart];

        for (i = 0; i < numberStart; i++) {
            sheeps[i] = sc.nextInt();
            stars[i] = 0;
        }

        while (true) {
            if (k == 0 && sheeps[k] % 2 == 0){
                stars[k] = 1;
                if (sheeps[k] > 0) sheeps[k]--;
                break;
            } else if (k == (numberStart-1) && sheeps[k] % 2 == 1) {
                stars[k] = 1;
                if (sheeps[k] > 0) sheeps[k]--;
                break;
            } else if (sheeps[k] % 2 == 1) {
                if (sheeps[k] > 0) sheeps[k]--;
                stars[k] = 1;
                k++;
            } else if (sheeps[k] % 2 == 0) {
                stars[k] = 1;
                if (sheeps[k] > 0) sheeps[k]--;
                k--;
            }
        }

        for (i = 0; i < numberStart; i++) {
            sumSheeps += sheeps[i];
            sumStarts += stars[i];
        }

        System.out.println(sumStarts + " " + sumSheeps);
    }
}