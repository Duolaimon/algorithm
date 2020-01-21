package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Author HeJiageng
 * @Date 2019-04-28
 * @Desc
 */
public class DuXiaoMan {
    public static void main(String[] args) {
        test4();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String numStr = sc.nextLine();
            int num = Integer.valueOf(numStr);
            boolean one = false, all = true;
            for (int i = 0; i < numStr.length(); i++) {
                int c = numStr.charAt(i) - 48;
                if (num % c == 0) {
                    one = true;
                } else {
                    all = false;
                }
            }
            if (one && !all) {
                System.out.println("H");
            } else if (!one) {
                System.out.println("S");
            } else if (all) {
                System.out.println("G");
            }
        }
    }

    public static void test2() {
        Scanner scanner = new Scanner(System.in);
        String[][] big = new String[10000][10000];
        int startNum = scanner.nextInt();
        for (int i = 0; i < startNum; i++) {
            big[scanner.nextInt()][scanner.nextInt()] = "1";
        }
        int question = scanner.nextInt();
        int[] results = new int[question];
        for (int k = 0; k < question; k++) {
            int countStart = 0;
            int i = scanner.nextInt();
            int j = scanner.nextInt();
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            for (int a = i; a <= x; a++) {
                for (int b = j; b <= y; b++) {
                    if (big[a][b] != null) {
                        countStart++;
                    }
                }
            }
            results[k] = countStart;
        }
        for (int result : results) {
            System.out.println(result);
        }
    }

    public static void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int A = scanner.nextInt();
            int B = scanner.nextInt();
            int C = scanner.nextInt();
            int[] array = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                array[i] = scanner.nextInt();
            }
            int[] prise = new int[N + 1];
            prise[1] = 0;
            for (int i = 2; i <= N; i++) {
                int min = Integer.MAX_VALUE;
                for (int j = i - 1; j >= 1; j--) {
                    int cur;
                    if (array[j] == i) {
                        cur = prise[j] + A;
                    } else if (array[j] > i) {
                        cur = (array[j] - i) * B + A + prise[j];
                    } else {
                        cur = (i - array[j]) * C + A + prise[j];
                    }
                    if (cur < min) {
                        min = cur;
                    }
                }
                prise[i] = min;
            }
            System.out.println(prise[N]);
        }
    }

    public static void test4() {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int num = scanner.nextInt();
        int[][] big = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                big[i][j] = 1;
            }
        }
        for (int i = 0; i < num; i++) {
            int a = scanner.nextInt() + 50;
            int b = scanner.nextInt() + 50;

            big[a][b] = 100;
        }

        int[][] dp = new int[100][100];
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (i == 0) {
                    if (j == 0) {
                        dp[i][j] = big[i][j];
                    } else {
                        dp[i][j] = dp[i][j - 1] + big[i][j];
                    }
                } else {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][j] + big[i][j];
                    } else {
                        dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + big[i][j];
                    }
                }
            }
        }

        x = 50 + x;
        y = 50 + y;
        System.out.println(dp[x - 1][y - 1] - dp[50][50]);
    }

}

