package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 1 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 1);
        System.out.println(cache.get(2));
        cache.put(3, 2);
        System.out.println(cache.get(2));
        System.out.println(cache.get(3));
    }

    class Node {
        int key;
        int value;
        Node prev;
        Node next;
        Node(int key, int value, Node prev, Node next) {
            this.key = key;
            this.value = value;
            this.prev = prev;
            this.next = next;
        }
    }
    int capacity;
    Map<Integer, Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        map = new HashMap<>(capacity);
        this.capacity = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(tail != node) {
                remove(node);
                addToTail(node);
            }
            return node.value;
        }
        return -1;
    }
    private void remove(Node node) {
        if(node == head) {
            head = node.next;
        } else {
            node.prev.next = node.next;
        }
        node.next.prev = node.prev;
    }
    private void addToTail(Node node) {
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail.next = null;
    }
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            if(tail != node) {
                remove(node);
                addToTail(node);
            }
            node.value = value;
        } else {
            if(head == null) {
                head = tail = new Node(key, value, null, null);
                map.put(key, tail);
                return;
            }
            if(map.size() == capacity) {
                map.remove(head.key);
                head = head.next;
            }
            tail.next = new Node(key, value, tail, null);
            tail = tail.next;
            map.put(key, tail);
        }
    }

}
