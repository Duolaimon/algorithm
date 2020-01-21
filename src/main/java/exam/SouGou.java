package exam;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author HeJiageng
 * @Date 2019/9/8
 * @Desc
 */
public class SouGou {
    public static void main(String[] args) {
        mapInsert();
    }


    public static void mapInsert() {
        Scanner sc = new Scanner(System.in);
        int N = 0;
        Map<String, String> saveMap = new HashMap<>();
        LinkedList<String> queue = new LinkedList<>();
        while (sc.hasNext()) {
            String l = sc.nextLine();
            String[] strings = l.split(" ");
            if (strings.length == 1) {
                N = Integer.parseInt(l);
                saveMap = new HashMap<>(N);
                queue = new LinkedList<>();
            } else {
                String key = strings[0];
                String value = strings[1];
                int size = saveMap.size();
                if (size == N && !saveMap.containsKey(key)) {
                    String oldestKey = queue.pollFirst();
                    String oldestValue = saveMap.remove(oldestKey);
                    System.out.println(oldestKey + " " + oldestValue);
                }
                saveMap.put(key, value);
                queue.remove(key);
                queue.addLast(key);
            }

        }
    }

    public static void atomicNieDie() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {

        }
    }
}
