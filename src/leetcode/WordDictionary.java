package leetcode;

import java.util.ArrayList;
import java.util.List;

public class WordDictionary {
//    static class Node {
//        Node[] children = new Node[26];
//        char value;
//        boolean isLeaf = false;
//
//        public Node() {
//        }
//
//        public Node(char value) {
//            this.value = value;
//        }
//    }
//
//    private Node root;
//
//    public WordDictionary() {
//        root = new Node();
//    }
//
//    public void addWord(String word) {
//        if(word == null || word.length() == 0) return;
//        char[] array = word.toCharArray();
//        List<Node>  = root.children;
//        Node node = null;
//        int i = 0, current = 0;
//        for(; current < array.length;) {
//            for(; current < array.length && i < list.size(); i++) {
//                node = list.get(i);
//                if(node.value == array[current]) {
//                    ++current;
//                    if(current == array.length) {
//                        node.isLeaf = true;
//                        return;
//                    }
//                    list = node.children;
//                    i = -1;
//                }
//            }
//            if(current < array.length) {
//                node = new Node(array[current++]);
//                list.add(node);
//                if(current == array.length) {
//                    node.isLeaf = true;
//                    return;
//                }
//                Node child = null;
//                for(; current < array.length;) {
//                    child = new Node(array[current++]);
//                    node.children.add(child);
//                    if(current == array.length) {
//                        child.isLeaf = true;
//                        return;
//                    }
//                    node = child;
//                }
//            }
//        }
//    }
//
//    public boolean search(String word) {
//        if(word == null || word.length() == 0) return false;
//        return search(word.toCharArray(), root.children, 0);
//    }
//
//    private boolean search(char[] array, List<Node> list, int current) {
//        Node node = null;
//        int i = 0;
//        for(; current < array.length;) {
//            for(; current < array.length && i < list.size(); i++) {
//                if(array[current] == '.') {
//                    for(Node item : list) {
//                        if((current + 1 == array.length && item.isLeaf)
//                                || (!item.children.isEmpty() && search(array, item.children, current + 1))) {
//                            return true;
//                        }
//                    }
//                    return false;
//                } else {
//                    node = list.get(i);
//                    if(node.value == array[current]) {
//                        ++current;
//                        if(current == array.length && node.isLeaf) {
//                            return true;
//                        }
//                        list = node.children;
//                        i = -1;
//                    }
//                }
//            }
//            if(current < array.length) {
//                return false;
//            }
//        }
//        return false;
//    }
}