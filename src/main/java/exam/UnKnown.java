package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author HeJiageng
 * @Date 2019/9/12
 * @Desc
 */
public class UnKnown {

    public static void main(String[] args) {
        UnKnown unKnown = new UnKnown();
        System.out.println(unKnown.findKth(new int[]{2, 3, 6, 5, 9, 1, 4 ,3}, 3));
    }


    public int findKth(int[] arr, int k) {
        int oSize = 0;
        int[] sArr = new int[arr.length];
        for (int num : arr) {
            if (num % 2 == 1) {
                sArr[oSize++] = num;
            }
        }
        if (oSize < k) {
            return 0;
        }
        return findKth(sArr, k, 0, oSize - 1);
    }

    private int findKth(int[] sArr, int k, int start, int end) {
        int low = start;
        int high = end;
        int temp = sArr[low];
        while (low < high) {
            while (low < high && sArr[high] >= temp) {
                high--;
            }
            sArr[low] = sArr[high];
            while (low < high && sArr[low] < temp) {
                low++;
            }
            sArr[high] = sArr[low];
        }
        sArr[high] = temp;
        if (high == k - 1) {
            return temp;
        } else if (high > k - 1) {
            return findKth(sArr, k, start, high - 1);
        } else {
            return findKth(sArr, k, high + 1, end);
        }
    }


    public void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String line = sc.nextLine();
            String[] nums = line.split(",");
            Set<Integer> set = new HashSet<>(nums.length);
            for (String num : nums) {
                set.add(Integer.valueOf(num));
            }
            System.out.println(set.size());
        }
    }

    public static void test2() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] scores = new int[n];
            int[] num = new int[n];
            for (int i = 0; i < n; i++) {
                scores[i] = sc.nextInt();
                num[i] = 1;
            }

            for (int i = 1; i < n; i++) {
                int curScore = scores[i];
                int preScore = scores[i - 1];
                if (curScore > preScore) {
                    num[i] = num[i - 1] + 1;
                } else if (curScore < preScore) {
                    num[i] = num[i - 1] - Math.max(num[i - 1] - 1, 1);
                    if (num[i] == 0) {
                        for (int j = i; j >= 0; j--) {
                            num[j]++;
                            if (num[j] != num[j - 1]) {
                                break;
                            }
                        }
                    }
                }
            }

            int sum = num[0];
            for (int i = 1; i < num.length; i++) {
                sum += num[i];
            }
            System.out.println(sum);
        }
    }
}
