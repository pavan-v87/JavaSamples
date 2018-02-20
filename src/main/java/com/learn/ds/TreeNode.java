package com.learn.ds;

import java.util.ArrayList;

/**
 * Created by Pavan.VijayaNar on 10/14/2017.
 */

public class TreeNode<T> {
    private final String label;
    private final T value;

    private final ArrayList<TreeNode<T>> childNodes;

    public TreeNode(String l, T val) {
        label = l;
        value = val;
        this.childNodes = new ArrayList<>();
    }
    void addChild(TreeNode child) {
        childNodes.add(child);
    }

    public ArrayList<TreeNode<T>> getChildNodes() {
        return childNodes;
    }

    @Override
    public String toString() {
        return label + " -> " + value;
    }

    /*public static class Builder {
        public void add() {

        }
        public TreeNode build () {

        }
    } */
}
