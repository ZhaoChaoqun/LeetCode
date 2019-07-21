package leetcode;

public class MyCircularDeque {
    int[] array;
    int start, end;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        array = new int[k+1];
    }

    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if(isFull())
            return false;
        if(start == 0)
            start = array.length;
        array[--start] = value;
        return true;
    }

    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if(isFull())
            return false;
        array[end++] = value;
        if(end == array.length)
            end = 0;
        return true;
    }

    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(isEmpty())
            return false;
        if(++start == array.length)
            start = 0;
        return true;
    }

    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(isEmpty())
            return false;
        if(--end < 0)
            end = array.length - 1;
        return true;
    }

    /** Get the front item from the deque. */
    public int getFront() {
        if(isEmpty()) return -1;
        return array[start];
    }

    /** Get the last item from the deque. */
    public int getRear() {
        if(isEmpty()) return -1;
        if(end == 0)
            return array[array.length - 1];
        return array[end - 1];
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return start == end;
    }

    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return start - 1 == end || (end == array.length - 1 && start == 0);
    }

    public static void main(String[] args) {
        MyCircularDeque circularDeque =  new MyCircularDeque(4); // 设置容量大小为3
        System.out.println(circularDeque.insertFront(9));			        // 返回 true
        System.out.println(circularDeque.deleteLast());			        // 返回 true
        System.out.println(circularDeque.getRear());  				// 返回 2
    }
}
