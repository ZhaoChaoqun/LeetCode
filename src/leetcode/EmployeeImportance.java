package leetcode;

import com.sun.javafx.collections.ElementObservableListDecorator;

import java.util.*;

/**
 * Created by zhaochaoqun on 2018/1/13.
 */
public class EmployeeImportance {

    static class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;

        public Employee(int id, int importance, List<Integer> subordinates) {
            this.id = id;
            this.importance = importance;
            this.subordinates = subordinates;
        }
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return recursive(map, id);
    }
    int recursive(Map<Integer, Employee> employees, int id) {
        Employee employee = employees.get(id);
        int importance = employee.importance;
        for(Integer subordinate : employee.subordinates) {
            importance += recursive(employees, subordinate);
        }
        return importance;
    }

    public static void main(String[] args) {
        EmployeeImportance test = new EmployeeImportance();
        Employee e1 = new Employee(1, 5, Arrays.asList(2, 3));
        Employee e2 = new Employee(2, 3, Collections.emptyList());
        Employee e3 = new Employee(3, 3, Collections.emptyList());
        List<Employee> list = Arrays.asList(e1, e2, e3);
        System.out.println(test.getImportance(list, 1));
    }
}
