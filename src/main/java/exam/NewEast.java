package exam;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.Gson;

/**
 * @Author HeJiageng
 * @Date 2019/9/23
 * @Desc
 */
public class NewEast {

    public static void main(String[] args) {
        test1();
    }

    public static void test1() {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            input = input.substring(1, input.length() - 1);
            String[] split = input.split("\\[");
            List<Node> nodeList = new LinkedList<>();
            for (String s : split) {
                if (s.length() < 5) {
                    continue;
                }
                Node node = new Node();
                node.id = (int) s.charAt(0) - 48;
                node.pid = (int) s.charAt(2) - 48;
                node.data = (int) s.charAt(4) - 48;
                nodeList.add(node);
            }
            Node p = null;
            for (int i = 0; i < nodeList.size(); i++) {
                if (nodeList.get(i).pid.equals(0)) {
                    p = nodeList.get(i);
                }
            }
            Node t = p;
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (nodeList.get(j).pid.equals(p.id)) {
                        p.children = nodeList.get(j);
                        p = p.children;
                    }
                }
            }
            System.out.println(new Gson().toJson(t));
        }
    }

    static class Node {
        Integer id;
        Integer pid;
        Integer data;
        Node children;
    }
}
