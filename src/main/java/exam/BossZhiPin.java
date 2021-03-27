package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author HeJiaGeng
 * @date 2021/3/25
 * @desc
 */
public class BossZhiPin {
    public static void main(String[] args) {
        Object lock1 = new Object(), lock2 = new Object();
        new Thread(() -> {
            synchronized (lock1) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock2) {

                }
            }
        }).start();

        new Thread(() -> {
            synchronized (lock2) {
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (lock1) {

                }
            }
        }).start();

    }


    public static char find(char[] chars1, char[] chars2) {
        int index = 0;
        for (; index < chars2.length; index++) {
            if (chars1[index] != chars2[index]) {
                return chars1[index];
            }
        }
        return chars1[index];
    }

    public static int[] retainAll(int[] array1, int[] array2) {
        int len1 = array1.length, len2 = array2.length;
        int[] res = new int[Math.min(len1, len2)];
        int index = 0;
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (array1[i] == array2[j]) {
                res[index++] = array1[i];
                i++;
                j++;
            } else if (array1[i] > array2[j]) {
                j++;
            } else {
                i++;
            }
        }
        return res;
    }

    private Map<String, AtomicInteger> ipCountMap = new ConcurrentHashMap<>();

    public int getIp(String ip) {
        if (!ipCountMap.containsKey(ip)) {
            synchronized (this) {
                if (!ipCountMap.containsKey(ip)) {
                    AtomicInteger c = new AtomicInteger(1);
                    ipCountMap.put(ip, c);
                    return c.get();
                }
            }
        } else {
            AtomicInteger c = ipCountMap.get(ip);
            c.incrementAndGet();
            return c.get();
        }
        return 0;
    }
}
