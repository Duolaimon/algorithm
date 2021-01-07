package com.duol.util;

/**
 * @author HeJiaGeng
 * @date 2021/1/7
 * @desc
 */
public class ArrayUtil {
    public static int[][] newTwoIntArray(String arrayStr) {
        String substring = arrayStr.substring(1, arrayStr.length() - 1);
        String[] split = substring.split(", ");

        int[][] array = new int[split.length][];
        for (int i = 0; i < split.length; i++) {
            array[i] = newOneIntArray(split[i]);
        }
        return array;
    }

    public static int[] newOneIntArray(String arrayStr) {
        String substring = arrayStr.substring(1, arrayStr.length() - 1);
        String[] split = substring.split(",");
        int[] array = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            array[i] = Integer.parseInt(split[i]);
        }
        return array;
    }
}
