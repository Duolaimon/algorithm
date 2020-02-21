/**
 * Leetcode - evaluate_division
 */
package com.duol.leetcode.evaluate_division;
import java.util.*;
import com.duol.common.*;

/** 
 * log instance is defined in Solution interface
 * this is how slf4j will work in this class:
 * =============================================
 *     if (log.isDebugEnabled()) {
 *         log.debug("a + b = {}", sum);
 *     }
 * =============================================
 */
class Solution2 implements Solution {

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        int numV = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for (List<String> equation : equations) {
            String a = equation.get(0);
            String b = equation.get(1);
            if (!map.containsKey(a))
                map.put(a, numV++);
            if (!map.containsKey(b))
                map.put(b, numV++);
        }
        UnionFind uf = new UnionFind(numV);
        for (int i = 0; i < equations.size(); i++) {
            int p = map.get(equations.get(i).get(0));
            int q = map.get(equations.get(i).get(1));
            double p_divide_q = values[i];
            uf.union(p, q, p_divide_q);
        }
        double[] answer = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!map.containsKey(a) || !map.containsKey(b)) {
                answer[i] = -1.0;
                continue;
            }

            int p = map.get(a);
            int q = map.get(b);
            if (uf.connected(p, q))
                answer[i] = uf.divide(p, q);
            else
                answer[i] = -1.0;
        }
        return answer;
    }
}


class UnionFind {
    //加权Union-Find算法
    private int[] id;
    private int count;
    private int[] size;

    private double[] quotient;

    public UnionFind(int N) {
        count = N;
        id = new int[N];
        quotient = new double[N];
        for (int i = 0; i < N; i++)
            id[i] = i;
        size = new int[N];
        for (int i = 0; i < N; i++)
            size[i] = 1;
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    public double divide(int p, int q) {
        //precondition: p and q is connected
        return divideRoot(p) / divideRoot(q);
    }

    public int find(int p) {
        // follow the link to find the root
        while (p != id[p]) {
            p = id[p];
        }
        return p;
    }


    private double divideRoot(int p) {
        // p / root
        double result = 1.0;
        while (p != id[p]) {
            result *= quotient[p];
            p = id[p];
        }
        return result;
    }

    public void union(int p, int q, double p_divide_q) {
        int i = find(p);
        int j = find(q);

        if (i == j)
            return;

        double p_divide_i = divideRoot(p);
        double q_divide_j = divideRoot(q);

        // link the small tree to the big tree
        if (size[i] < size[j]) {
            id[i] = j;
            quotient[i] = 1 / p_divide_i * p_divide_q * q_divide_j;
            size[j] += size[i];
        } else {
            id[j] = i;
            quotient[j] = (1 / q_divide_j) * (1 / p_divide_q) * p_divide_i;
            size[i] += size[j];
        }
        count--;
    }

}
