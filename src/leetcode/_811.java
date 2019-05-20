package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _811 {

    public static void main(String[] args) {
        _811 test = new _811();
        System.out.println(test.subdomainVisits(new String[] {"9001 discuss.leetcode.com"}));
        System.out.println(test.subdomainVisits(new String[] {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"}));
    }
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();
        for(String cpdomain : cpdomains) {
            String [] array = cpdomain.split(" ");
            String subdomain = array[1];
            String[] subdomains = subdomain.split("\\.");
            if (map.containsKey(subdomain)) {
                map.put(subdomain, map.get(subdomain) + Integer.parseInt(array[0]));
            } else {
                map.put(subdomain, Integer.parseInt(array[0]));
            }
            if(subdomains.length == 3) {
                subdomain = subdomains[1] + "." + subdomains[2];
                if (map.containsKey(subdomain)) {
                    map.put(subdomain, map.get(subdomain) + Integer.parseInt(array[0]));
                } else {
                    map.put(subdomain, Integer.parseInt(array[0]));
                }
                if (map.containsKey(subdomains[2])) {
                    map.put(subdomains[2], map.get(subdomains[2]) + Integer.parseInt(array[0]));
                } else {
                    map.put(subdomains[2], Integer.parseInt(array[0]));
                }

            } else if(subdomains.length == 2) {
                if (map.containsKey(subdomains[1])) {
                    map.put(subdomains[1], map.get(subdomains[1]) + Integer.parseInt(array[0]));
                } else {
                    map.put(subdomains[1], Integer.parseInt(array[0]));
                }

            }
        }
        List<String> list = new ArrayList<>(map.size());
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getValue() + " " + entry.getKey());
        }
        return list;
    }
}

