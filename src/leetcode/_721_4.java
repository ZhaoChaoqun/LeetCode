package leetcode;

import java.util.*;

public class _721_4 {

    List<Integer> unionFind = new ArrayList<>();
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Integer> emailToId = new HashMap<>();
        int id = 0;
        for(List<String> account : accounts) {
            emailToName.put(account.get(1), account.get(0));
            if(!emailToId.containsKey(account.get(1))) {
                emailToId.put(account.get(1), id);
                unionFind.add(id++);
            }
            for(int i = 2; i < account.size(); i++) {
                emailToName.put(account.get(i), account.get(0));
                if(!emailToId.containsKey(account.get(i))) {
                    emailToId.put(account.get(i), id);
                    unionFind.add(id++);
                }
                union(emailToId.get(account.get(1)), emailToId.get(account.get(i)));
            }
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String email: emailToName.keySet()) {
            int index = find(emailToId.get(email));
            List<String> item = map.getOrDefault(unionFind.get(index), new ArrayList<>());
            item.add(email);
            map.put(unionFind.get(index), item);
        }
        for(List<String> emails : map.values()) {
            Collections.sort(emails);
            emails.add(0, emailToName.get(emails.get(0)));
        }
        return new ArrayList<>(map.values());
    }

    public void union(int i, int j) {
        unionFind.set(find(j), find(i));
    }
    public int find(int i) {
        int parent = unionFind.get(i);
        if(parent == i)
            return i;
        parent = find(parent);
        unionFind.set(i, parent);
        return parent;
    }



    public static void main(String[] args) {
        _721_4 test = new _721_4();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("David","David0@m.co","David1@m.co"),Arrays.asList("David","David3@m.co","David4@m.co"),Arrays.asList("David","David4@m.co","David5@m.co"),Arrays.asList("David","David2@m.co","David3@m.co"),Arrays.asList("David","David1@m.co","David2@m.co"));
        for(List<String> account : test.accountsMerge(accounts))
            System.out.println(account);
    }
}
