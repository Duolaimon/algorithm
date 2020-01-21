package exam;

import java.util.Scanner;

/**
 * @Author HeJiageng
 * @Date 2019-08-10
 * @Desc
 */
public class BeiKe {

    public static void main(String[] args) {
        higtLow();
    }

    public static void minAbsDiff() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] array = new long[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextLong();
            }
            long minL = array[0];
            long minR = array[1];
            long curMinNum = Math.abs(minL - minR);
            for (int i = 1; i < array.length - 1; i++) {
                long minNum = Math.abs(array[i] - array[i + 1]);
                if (minNum < curMinNum) {
                    minL = array[i];
                    minR = array[i + 1];
                    curMinNum = minNum;
                }
            }
            System.out.printf("%d %d\n", minL, minR);
        }
    }

    public static void longAbsoluteAsc() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            long[] array = new long[n];
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextLong();
            }
            for (int i = 0; i < n; i++) {
                result[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (array[j] < array[i] && result[j] + 1 > result[i]) {
                        result[i] = result[j] + 1;
                    }
                }
            }
            int max = result[0];
            for (int i = 1; i < result.length; i++) {
                max = Math.max(result[i], max);
            }
            System.out.println(max);
        }
    }

    public static void weight() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            float[] array = new float[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextFloat();
            }
            final float proportion = 0.9f;
            int result = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = i + 1; j < array.length; j++) {
                    float max = Math.max(array[i], array[j]);
                    float min = Math.min(array[i], array[j]);
                    if (min >= max * proportion) {
                        result++;
                    }
                }
            }
            System.out.println(result);
        }
    }

    static void higtLow() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            boolean isSub = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] <= array[i + 1]) {
                    //非纯递减
                    isSub = false;
                    break;
                }
            }
            boolean isAdd = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] >= array[i + 1]) {
                    //非纯递增
                    isAdd = false;
                    break;
                }
            }
            if (isAdd || isSub) {
                System.out.println(0);
                continue;
            }
            boolean success = false;
            int num = 0;
            int curHigh = 0;
            do {
                boolean sub = false;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > curHigh && !sub) {
                        curHigh = array[i];
                    } else {
                        //开始递减
                        sub = true;
                        if (array[i] > curHigh) {
                            num += array[i] - array[i - 1] + 1;
                            array[i - 1] = array[i] + 1;
                            success = false;
                            break;
                        }else {
                            success = true;
                        }
                    }
                }
            } while (!success);
            System.out.println(num);
        }
    }
}
