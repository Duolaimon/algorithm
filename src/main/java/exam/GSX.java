package exam;

/**
 * @Author HeJiageng
 * @Date 2019-08-18
 * @Desc
 */
public class GSX {

    public static int MinEditDistance(String AStr, String BStr) {
        int len_A = AStr.length();
        int len_B = BStr.length();
        int[][] D = new int[len_B + 1][len_A + 1];
        D[0][0] = 0;
        for (int i = 1; i <= len_A; i++) {
            D[0][i] = i;
        }
        for (int i = 1; i <= len_B; i++) {
            D[i][0] = i;
        }
        for (int i = 1; i <= len_B; i++) {
            for (int j = 1; j <= len_A; j++)
                D[i][j] = Math.min(Math.min(D[i - 1][j] + 1, D[i][j - 1] + 1), (AStr.charAt(j - 1) == BStr.charAt(i - 1) ? D[i - 1][j - 1] : D[i - 1][j - 1] + 1));
        }
        return D[len_B][len_A];

    }

    public static void main(String[] args) {
        Integer a = 10;
        Integer b = Integer.valueOf(10);
        System.out.println(a == b);
    }

    static class Vehicle{
        protected String name = "V";

        public void run() {
            System.out.println("V run");
        }
    }
    static class Car extends Vehicle{
        protected String name = "C";

        public void run() {
            System.out.println("C run");
        }
    }
}

