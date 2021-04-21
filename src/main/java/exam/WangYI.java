package exam;

/**
 * @author HeJiaGeng
 * @date 2021/4/2
 * @desc
 */
public class WangYI {

    public static void main(String[] args) {
        System.out.println(floor(1));
        System.out.println(floor(2));
        System.out.println(floor(3));
        System.out.println(floor(4));
        System.out.println(floor(5));
    }

    public static int floor(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int res = 2;
        int pre = 1;
        for (int i = 2; i < n; i++) {
            int temp = pre;
            pre = res;
            res = res + temp;
        }
        return res;
    }
}
