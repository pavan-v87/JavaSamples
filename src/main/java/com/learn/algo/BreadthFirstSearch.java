package com.learn.algo;


import com.learn.ds.Tree;
import com.learn.ds.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by Pavan.VijayaNar on 10/14/2017.
 */

public class BreadthFirstSearch<T> {

    public static <T> BreadthFirstSearch<T> create() {
        return new BreadthFirstSearch<T>();
    }

    private BreadthFirstSearch() {

    }

    public <U> ArrayList<TreeNode<U>> generateSequence(Tree<U> tree) {
        TreeNode<U> root = tree.getRoot();
        Queue<TreeNode<U>> queue = new ArrayDeque<>();
        queue.add(root);
        ArrayList<TreeNode<U>> sequence = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode<U> currentVertex = queue.poll();
            ArrayList<TreeNode<U>> childNodes = currentVertex.getChildNodes();
            for(TreeNode<U> childVertex : childNodes) {
                if (!sequence.contains(childVertex)) {
                    queue.add(childVertex);
                }
            }
            sequence.add(currentVertex);
        }
        return sequence;
    }
}
