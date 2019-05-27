package leetcode;

import java.util.*;

public class _399 {
    public static void main(String[] args) {
        List<List<String>> equations = Arrays.asList(Arrays.asList("a", "b"), Arrays.asList("b", "c"));
        double[] values = new double[] {2.0, 3.0};
        List<List<String>> queries = Arrays.asList(Arrays.asList("a", "c"),
        Arrays.asList("b", "a"), Arrays.asList("a", "e"), Arrays.asList("a", "a"), Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(new _399().calcEquation(equations, values, queries)));
    }
    static class Node {
        String b;
        double value;
        Node(String b, double value) {
            this.b = b;
            this.value = value;
        }
    }

    private double recursive(String a, String target, double base, Set<String> visited) {
        if(visited.contains(a)) return -1.0D;
        visited.add(a);
        List<Node> nodes = map.get(a);
        for(int i = 0; i < nodes.size(); i++) {
            if(nodes.get(i).b.equals(target)) {
                return base * nodes.get(i).value;
            } else {
                double result = recursive(nodes.get(i).b, target, nodes.get(i).value, visited);
                if(result != -1.0D) {
                    return base * result;
                }
            }
        }
        return -1.0D;
    }
    Map<String, List<Node>> map = new HashMap<>();

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] result = new double[queries.size()];
        String a, b;
        List<Node> listA, listB;
        for(int i = 0; i < values.length; i++) {
            a = equations.get(i).get(0);
            b = equations.get(i).get(1);
            if(!map.containsKey(a)) {
                map.put(a, new ArrayList<>());
            }
            if(!map.containsKey(b)) {
                map.put(b, new ArrayList<>());
            }
            listA = map.get(a);
            listB = map.get(b);
            listA.add(new Node(b, values[i]));
            listB.add(new Node(a, 1 / values[i]));
        }
        for(int i = 0; i < queries.size(); i++) {
            a = queries.get(i).get(0);
            b = queries.get(i).get(1);
            if(!map.containsKey(a) || !map.containsKey(b)) {
                result[i] = -1.0D;
            } else if(a.equals(b)) {
                result[i] = 1.0D;
            } else {
                Set<String> visited = new HashSet<>();
                result[i] = recursive(a, b, 1, visited);
            }
        }
        return result;
    }
}
