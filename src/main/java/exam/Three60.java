package exam;

import java.util.Scanner;

/**
 * @author HeJiaGeng
 * @date 2020/3/27
 * @desc
 */
public class Three60 {

    public static void main(String[] args) {

    }


    public void test1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int price = 0;
            int continuous = 0;
            for (int i = 0; i < n; i++) {
                if (array[i] == 0) {
                    continue;
                } else if (array[i] == 1) {
                    price++;
                    continuous ++;
                } else if (array[i] == 2) {
                }
            }
        }
    }

    public void a(int[] array) {

    }
}
