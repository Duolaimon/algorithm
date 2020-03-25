package exam;

import java.util.*;

/**
 * @author HeJiaGeng
 * @date 2020/3/22
 * @desc
 */
public class KuaiShou {

    public static void main(String[] args) {
        KuaiShou k = new KuaiShou();
        k.coolPhoneNum();
    }

    public int[] latestInstance(int[] height) {
        int[] result = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = height.length - 1; i >= 0; i--) {
            result[i] = 0;
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int t = stack.pop();
                result[t] = t - i;
            }
            stack.push(i);
        }
        return result;
    }

    public void lessThanI() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            String[] input = next.split(" ");
            int[] array = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                array[i] = Integer.parseInt(input[i]);
            }
            int[] result = new int[array.length];
            int index = 0;
            int first;
            int second;
            if (array[0] > array[1]) {
                first = array[0];
                second = array[1];
                result[index++] = 1;
            } else {
                first = array[1];
                second = array[0];
            }
            for (int i = 2; i < array.length; i++) {
                if (array[i] >= first) {
                    second = first;
                    first = array[i];
                } else if (array[i] >= second) {
                    second = array[i];
                    result[index++] = i;
                }
            }
            for (int r : result) {
                if (r != 0) {
                    System.out.print(String.format("%d ", r));
                }
            }
        }
    }

    public void coolPhoneNum() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            String[] input = next.split(",");
            Map<String, Integer> numValueMap = new HashMap<>(input.length);
            List<String> coolNumList = new LinkedList<>();
            for (String s : input) {
                int value = value(s);
                if (value > 3 * 9) {
                    coolNumList.add(s);
                    numValueMap.put(s, value);
                }
            }
            String[] coolNums = coolNumList.toArray(new String[]{});
            Arrays.sort(coolNums, (a, b) -> numValueMap.get(b) - numValueMap.get(a));
            String result = String.join(",", coolNums);
            System.out.println(result);
        }
    }

    private int value(String num) {
        String s = num.substring(3);
        int cStart = -2, cEnd = -1, sStart = -2, sEnd = -1;
        for (int i = 1; i < s.length() - 1; i++) {
            int preSub = s.charAt(i) - s.charAt(i - 1);
            int suffSub = s.charAt(i + 1) - s.charAt(i);
            if (preSub == 0 && suffSub == 0) {
                if (sEnd - sStart >= 3) {
                    continue;
                }
                if (sStart != i - 2) {
                    sStart = i - 1;
                }
                sEnd = i + 1;
            }
            if (preSub == suffSub) {
                if (cEnd - cStart >= 3) {
                    continue;
                }
                if (cStart != i - 2) {
                    cStart = i - 1;
                }
                cEnd = i + 1;
            }
        }
        int continuous = 9;
        int cValue = (cEnd - cStart + 1) * continuous;
        int same = 10;
        int sValue = (sEnd - sStart + 1) * same;
        return Math.max(cValue, sValue);
    }
}
