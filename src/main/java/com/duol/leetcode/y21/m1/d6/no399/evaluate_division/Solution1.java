/**
 * Leetcode - evaluate_division
 */
package com.duol.leetcode.y21.m1.d6.no399.evaluate_division;
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
class Solution1 implements Solution {

    private HashMap<String, String> parent = new HashMap<>();

    private HashMap<String, Double> quotient = new HashMap<>();

    public String find(String p) {
        if (!parent.get(p).equals(p)) {
            //需要先保存父亲的值,因为后面压缩后树只有两层,后面*的就是根节点的权值1,是不对的
            //这里可以看看上面的并茶几的方向和值来判断
            String f = parent.get(p);
            parent.put(p, find(f));
            //这样压缩后的子节点才是正确的
            quotient.put(p, quotient.get(p) * quotient.get(f));
        }
        return parent.get(p);
    }

    public void init(String s) {
        if (!parent.containsKey(s)) {
            parent.put(s, s);
            quotient.put(s, 1.0);
        }
    }

    public void merge(String a, String b, Double value) {
        init(a);
        init(b);
        String fa = find(a); // a/fa=val[a], b/fb=val[b]
        String fb = find(b);
        if (fa.equals(fb)) {
            return;
        }
        parent.put(fa, fb);
        quotient.put(fa, value * (quotient.get(b) / quotient.get(a)));
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            merge(equation.get(0), equation.get(1), values[i]);
        }
        double[] res = new double[queries.size()];
        int index = 0;
        for (List<String> query : queries) {
            String a = query.get(0);
            String b = query.get(1);
            if (!parent.containsKey(a) || !parent.containsKey(b)) {
                res[index++] = -1;
            } else {
                //先做路径压缩
                res[index++] = find(a).equals(find(b)) ? quotient.get(a) / quotient.get(b) : -1;
            }
        }
        return res;
    }

}
