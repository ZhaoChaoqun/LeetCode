package leetcode;

import java.util.List;

// This is the interface that allows for creating nested lists.
// You should not implement it, or speculate about its implementation
public class NestedInteger {
    // Constructor initializes an empty nested sortedIndex.
    public NestedInteger() {}

    // Constructor initializes a single integer.
    public NestedInteger(int value) {}

    // @return true if this NestedInteger holds a single integer, rather than a nested sortedIndex.
    public boolean isInteger() {
        return false;
    }

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested sortedIndex
    public Integer getInteger() {
        return 0;
    }

    // Set this NestedInteger to hold a single integer.
    public void setInteger(int value) {
    }

    // Set this NestedInteger to hold a nested sortedIndex and adds a nested integer to it.
    public void add(NestedInteger ni) {
    }

    // @return the nested sortedIndex that this NestedInteger holds, if it holds a nested sortedIndex
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList() {
        return null;
    }
}
