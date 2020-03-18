package exam;

import java.util.*;

/**
 * @author HeJiaGeng
 * @date 2020/3/15
 * @desc
 */
public class ZiJieTiaoDong {
    public static void main(String[] args) {
        No1();
    }

    private static void No1() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            Map<String, List<String>> resultMap = new HashMap<>(n);
            for (int i = 0; i < n; i++) {
                String type = scanner.next();
                String file = scanner.next();
                if (resultMap.containsKey(file)) {
                    resultMap.get(file).add(type);
                } else {
                    List<String> typeList = new ArrayList<>();
                    typeList.add(type);
                    resultMap.put(file, typeList);
                }
            }
            for (Map.Entry<String, List<String>> entry : resultMap.entrySet()) {
                System.out.print(entry.getKey());
                for (String type : entry.getValue()) {
                    System.out.print(" ");
                    System.out.print(type);
                }
            }
        }
    }
}
