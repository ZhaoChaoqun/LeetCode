package leetcode;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class LinkParser {

    public static void main(String[] args) {
        File parent = new File("./problems");
        if(parent.exists() && parent.isDirectory()) {
            for(File category : parent.listFiles()) {
                System.out.println(category.getName());
                if(!category.isDirectory())
                    continue;
                File[] problems = category.listFiles();
                Arrays.sort(problems, new Comparator<File>() {
                    @Override
                    public int compare(File o1, File o2) {
                        return Integer.valueOf(o1.getName().split(". ")[0]) - Integer.valueOf(o2.getName().split(". ")[0]);
                    }
                });
                for(File problem : problems) {
                    String fileName = problem.getName();
                    System.out.println("- [" + fileName.replace(".md", "") + "](" + category + "/" + fileName.replaceAll(" ", "%20") + ")");
                }
            }
        }
    }
}
