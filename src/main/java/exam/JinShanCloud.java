package exam;

/**
 * @Author HeJiageng
 * @Date 2019/9/24
 * @Desc
 */
public class JinShanCloud {

    public static int[][] test1(int[][] gray, int w, int h, int n) {
        int c = n / 2;
        int[][] smoothing = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int x0 = Math.max(0, j - c);
                int x1 = Math.min(w - 1, j + c);
                int y0 = Math.max(0, i - c);
                int y1 = Math.min(h - 1, i + c);
                smoothing[i][j] = calculate(gray, x0, x1, y0, y1);
            }
        }
        return smoothing;
    }

    private static int calculate(int[][] gray, int x0, int x1, int y0, int y1) {
        int length = (x1 - x0) * (y1 - y0);
        int[] array = new int[length];
        int p = 0;
        for (int i = x0; i <= x1; i++) {
            for (int j = y0; j <= y1; j++) {
                array[p++] = gray[i][j];
            }
        }
        sort(array, 0, length - 1);
        if (length % 2 == 0) {
            return (array[length / 2] + array[length / 2 + 1]) / 2;
        } else {
            return array[length / 2];
        }
    }

    private static void sort(int[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            merge(a, low, mid, high);
        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= high) {
            if (a[i] < a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = a[i++];
        }
        while (j <= high) {
            temp[k++] = a[j++];
        }
        for (int x = 0; x < temp.length; x++) {
            a[x + low] = temp[x];
        }
    }
}
