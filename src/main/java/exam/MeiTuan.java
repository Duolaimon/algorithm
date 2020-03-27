package exam;

import java.util.Scanner;

/**
 * @author HeJiaGeng
 * @date 2020/3/26
 * @desc
 */
public class MeiTuan {
    public static void main(String[] args) {
        MeiTuan meiTuan = new MeiTuan();
        meiTuan.test4();
    }


    /*
    1234567
    9 8 7 6 5 4 3 2 1
    -12
    2 3 7 6 4 1 2 4 6
    */
    public void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = scanner.next();
            int[] replace = new int[10];
            for (int i = 1; i < 10; i++) {
                replace[i] = scanner.nextInt();
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) == '-') {
                    sb.append(string.charAt(i));
                    continue;
                }
                sb.append(replace[string.charAt(i) - '0']);
            }
            System.out.println(sb);
        }
    }

    public void test2() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] radius = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                radius[i] = scanner.nextInt();
            }
            int radiusSquare = 0;
            int p = 0;
            for (int i = n; i > 0; i--) {
                p = p ^ 1;
                if (p == 1) {
                    radiusSquare += Math.pow(radius[i], 2);
                } else if (p == 0) {
                    radiusSquare -= Math.pow(radius[i], 2);
                }
            }
            System.out.println(String.format("%.5f", Math.PI * radiusSquare));
        }
    }

    public void test3() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[][] sum = new int[k + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                sum[0][i] = scanner.nextInt();
            }
            for (int i = 1; i <= k; i++) {
                sum[i][0] = 0;
                for (int j = 1; j <= n; j++) {
                    sum[i][j] = sum[i][j - 1] + sum[i - 1][j];
                }
            }
            System.out.println(sum[k][n] % (1e9 + 7));
        }
    }

    public int re(int k, int n, int[] a) {
        if (k == 0) {
            return a[n];
        }
        if (n == 0) {
            return 0;
        }
        return re(k - 1, n, a) + re(k, n - 1, a);
    }

    public void test4() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            int[] a = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                a[i] = scanner.nextInt();
            }
            int result = re(k, n, a);
            System.out.println((int)(result % (1e9 + 7)));
        }
    }
}

