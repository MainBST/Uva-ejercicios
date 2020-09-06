package uri.begginer;

import java.util.Scanner;

public class E3042 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m, treeLeft, treeCenter, treeRight, touches;
        boolean positionLeft, positionCenter, positionRight;
        while ((m = sc.nextInt()) != 0) {
            positionLeft = false; positionCenter = true; positionRight = false;
            touches = 0;
            for (int i = 0; i < m; i++) {
                treeLeft = sc.nextInt(); treeCenter = sc.nextInt(); treeRight = sc.nextInt();
                if ((treeLeft == 0) && (treeCenter == 0) && (treeRight == 0)) continue;
                else {
                    if (positionLeft) {
                        if (treeLeft == 0) continue;
                        positionLeft = false;
                        if (treeCenter == 0) {
                            positionCenter = true;
                            touches++;
                        } else if(treeRight == 0) {
                            positionRight = true;
                            touches = touches + 2;
                        }
                    } else if (positionCenter) {
                        if (treeCenter == 0) continue;
                        touches++;
                        positionCenter = false;
                        if (treeLeft == 0) {
                            positionLeft = true;
                        } else if (treeRight == 0) {
                            positionRight = true;
                        }
                    } else {
                        if (treeRight == 0) continue;
                        positionRight = false;
                        if (treeCenter == 0) {
                            positionCenter = true;
                            touches++;
                        } else if (treeLeft == 0) {
                            positionLeft = true;
                            touches = touches + 2;
                        }
                    }
                }
            }
            System.out.println(touches);
        }
    }
}