package leetcode;

import java.util.SortedSet;
import java.util.TreeSet;

public class MultiSet {

    static class Item implements Comparable<Item> {
        int a;
        public boolean delete;
        @Override
        public String toString() {
            return "Item [a=" + a + "]";
        }
        public Item(int a) {
            super();
            this.a = a;
        }
        public Item(int a, boolean delete) {
            super();
            this.a = a;
            this.delete = delete;
        }
        @Override
        public int compareTo(Item o) {//remove方法也会调用这里的方法，可以在remove的时候调试进来看看如何
            if (a > o.a)
                return 1;
            if (a == o.a && (delete || o.delete))//注意这里的delete，是this.delete为判断的依据。o.delete指的是set中的，这样写万无一失吧
                return 0;
            return -1;
        }
    }

    public static void main(String[] args) {
        Item a = new Item(2);
        TreeSet<Item> set = new TreeSet<>();
        set.add(new Item(1));
        set.add(a);
        set.add(a);
        set.add(new Item(2));
        set.add(new Item(3));
        SortedSet<Item> it = (SortedSet<Item>) set.subSet(new Item(1), new Item(4));
        for (Item item : it) {
            System.err.println(item);
        }
        System.out.println();
        set.remove(new Item(2, true));
        for (Item item : set) {
            System.out.println(item);
        }
    }
}
