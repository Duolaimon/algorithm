package exam;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author HeJiageng
 * @Date 2019-04-07
 * @Desc
 */
public class Tencent {
    public static void main(String[] args) {
        tx1();
    }

    public static void tx2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] attack = new int[n];
            for (int i = 0; i < n; i++) {
                attack[i] = sc.nextInt();
            }
            int[] price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt();
            }
            int maxSumP = 0;
            int maxA = 0;
            for (int i = 0; i < n; i++) {
                maxSumP += price[i];
                if (maxA < attack[i]) {
                    maxA = attack[i];
                }
            }
            int[][] p = new int[n + 1][maxSumP + 1];
            for (int i = 1; i <= maxSumP; i++) {
                p[1][i] = attack[0];
            }
            for (int i = 2; i <= n; i++) {
                for (int j = 0; j <= maxSumP; j++) {
                    if (j > price[i - 1]) {
                        p[i][j] = p[i - 1][j - price[i - 1]] + attack[i - 1];
                    }else {
                        p[i][j] = p[i - 1][j];
                    }
                }
            }
            System.out.println(Arrays.deepToString(p));
            for (int i = 1; i < maxSumP; i++) {
                if (p[n][i] >= maxA) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }

    public static void tx1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int length = Integer.valueOf(sc.nextLine());
            String str = sc.nextLine();
            if (str.length() != length) {
                continue;
            }
            if (length == 0 || length == 1) {
                System.out.println(length);
                continue;
            }
            int start1 = 0, end1 = 0, start2 = 1, end2 = length;
            while (start2 < end2) {
                int s = (int) str.charAt(end1);
                int e = (int) str.charAt(start2);
                if (s != e) {
                    if (start1 == end1) {
                        end1 = start2 + 1;
                        start1 = end1;
                        start2 += 2;
                    } else {
                        end1 = start1;
                        start2++;
                    }
                    length -= 2;
                } else {
                    start1 = end1;
                    end1 = start2;
                    start2++;
                }
            }
            System.out.println(length);
        }
    }
}
