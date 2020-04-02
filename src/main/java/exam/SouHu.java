package exam;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HeJiaGeng
 * @date 2020/4/1
 * @desc 3 5
 * 0 3
 * 0 3
 * 0 3
 */
public class SouHu {
    public static void main(String[] args) {
        SouHu souHu = new SouHu();
        souHu.test2();
    }

    public void test2() {
        AtomicInteger flag = new AtomicInteger(0);
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 52; i += 2) {
                while (flag.get() != 0);
                System.out.print(String.format("%d%d", i, i + 1));
                flag.incrementAndGet();
            }
        });
        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                while (flag.get() != 1);
                char c = (char) ('A' + i);
                System.out.println(c);
                flag.decrementAndGet();

            }
        });
        t1.start();
        t2.start();
    }

    public void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int m = scanner.nextInt();
            int n = scanner.nextInt();
            int[] l = new int[m];
            int[] r = new int[m];
            for (int i = 0; i < m; i++) {
                l[i] = scanner.nextInt();
                r[i] = scanner.nextInt();
            }
            int sum = condition(l, r, n, 0);
            System.out.println(sum);
        }
    }

    private int condition(int[] l, int[] r, int n, int index) {
        if (index == l.length) {
            if (n == 0) {
                return 1;
            }
            return 0;
        }
        if (n == 0 && l[index] > 0) {
            return 0;
        }
        int sum = 0;
        for (int i = l[index]; i <= r[index]; i++) {
            if (n - i >= 0) {
                sum += condition(l, r, n - i, index + 1);
            }
        }
        return sum;
    }
}
