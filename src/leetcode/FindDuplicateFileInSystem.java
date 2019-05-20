package leetcode;

import java.util.*;

/**
 * Created by zhaochaoqun on 2017/6/19.
 */
public class FindDuplicateFileInSystem {

    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for(String path : paths) {
            String[] files = path.split(" ");
            String root = files[0];
            for(int i = 1; i < files.length; i++) {
                int index = files[i].indexOf('(');
                String fileName = root + "/" + files[i].substring(0, index);
                String content = files[i].substring(index + 1, files[i].length() - 1);
                if(map.containsKey(content)) {
                    map.get(content).add(fileName);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(fileName);
                    map.put(content, list);
                }
            }
        }
        List<List<String>> result = new ArrayList<>(map.size());
        for(List<String> value : map.values()) {
            if(value.size() > 1)
                result.add(value);
        }
        return result;
    }

    public static void main(String[] args) {
        for(List<String> file : findDuplicate(new String[] {"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"})) {
            System.out.println(file);
        }
    }
}
