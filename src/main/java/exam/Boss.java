package exam;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author HeJiaGeng
 * @date 2020/4/3
 * @desc
 */
public class Boss {
    public static void main(String[] args) {
        Boss boss = new Boss();
        boss.test1();
    }

    public void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int K = scanner.nextInt();
            int N = scanner.nextInt();
            AtomicInteger n = new AtomicInteger(1);
            for (int i = 0; i < K; i++) {
                int finalI = i;
                new Thread(() -> {
                    int num = finalI + 1;
                    while (n.get() != N - 1) {
                        while (n.get() % K != num && !(num == K && n.get() % K == 0)) {

                        }
                        System.out.print(String.format("%d:%d ", num, n.get()));
                        n.getAndIncrement();
                    }
                }).start();
            }
        }
    }
}
