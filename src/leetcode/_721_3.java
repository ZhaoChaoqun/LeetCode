package leetcode;

import java.util.*;

public class _721_3 {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<String>> graphic = new HashMap<>();
        Map<String, String> email2name = new HashMap<>();
        for(List<String> account : accounts) {
            List<String> neighbors = graphic.getOrDefault(account.get(1), new ArrayList<>());
            neighbors.addAll(account.subList(2, account.size()));
            neighbors.add(account.get(1));
            graphic.put(account.get(1), neighbors);
            email2name.put(account.get(1), account.get(0));
            for(int i = 2; i < account.size(); i++) {
                email2name.put(account.get(i), account.get(0));
                neighbors = graphic.getOrDefault(account.get(i), new ArrayList<>());
                neighbors.add(account.get(1));
                graphic.put(account.get(i), neighbors);
            }
        }
        return dfsSearch(graphic, email2name);
    }

    private List<List<String>> dfsSearch(Map<String, List<String>> graphic, Map<String, String> email2name) {
        List<List<String>> result = new ArrayList<>();
        Set<String> visited = new HashSet<>();
        for(Map.Entry<String, List<String>> account : graphic.entrySet()) {
            if(visited.contains(account.getKey())) continue;
            List<String> emails = new ArrayList<>();
            dfs(graphic, account.getKey(), visited, emails);
            if(!emails.isEmpty())
                Collections.sort(emails);
            emails.add(0, email2name.get(emails.get(0)));
            result.add(emails);
        }
        return result;
    }

    private void dfs(Map<String, List<String>> graphic, String email, Set<String> visited, List<String> emails) {
        if(!visited.contains(email)) {
            visited.add(email);
            emails.add(email);
            for(String neighbor : graphic.get(email)) {
                dfs(graphic, neighbor, visited, emails);
            }
        }
    }

    public static void main(String[] args) {
        _721_3 test = new _721_3();
        List<List<String>> accounts = Arrays.asList(Arrays.asList("David","David0@m.co","David1@m.co"),Arrays.asList("David","David3@m.co","David4@m.co"),Arrays.asList("David","David4@m.co","David5@m.co"),Arrays.asList("David","David2@m.co","David3@m.co"),Arrays.asList("David","David1@m.co","David2@m.co"));
        for(List<String> account : test.accountsMerge(accounts))
            System.out.println(account);
    }
}
