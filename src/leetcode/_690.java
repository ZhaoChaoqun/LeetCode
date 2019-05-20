package leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;
};

public class _690 {
    public static void main(String[] args) {

    }

    int backtracking(Employee employee, Map<Integer, Employee> map) {
        int sum = employee.importance;
        for (Integer subordinate : employee.subordinates) {
            sum += backtracking(map.get(subordinate), map);
        }
        return sum;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id, employee);
        return backtracking(map.get(id), map);
    }
}
