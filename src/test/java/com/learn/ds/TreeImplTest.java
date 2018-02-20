package com.learn.ds;

import com.learn.algo.BreadthFirstSearch;

import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by Pavan.VijayaNar on 10/15/2017.
 */
public class TreeImplTest {

    @Test
    public void testTree() {
        TreeImpl<Integer> tree = new TreeImpl<>();
        tree.generate(100);

        TreeNode<Integer> child01 = new TreeNode<>("child01", 23);
        TreeNode<Integer> child02 = new TreeNode<>("child02", 1002);
        TreeNode<Integer> child03 = new TreeNode<>("child03", 74);
        tree.attachChildren(tree.getRoot(), child01, child02, child03);


        TreeNode<Integer> child11 = new TreeNode<>("child11", 323);
        TreeNode<Integer> child12 = new TreeNode<>("child12", 1342);
        tree.attachChildren(child01, child11, child12);

        ArrayList<TreeNode<Integer>> bfs = BreadthFirstSearch.create().generateSequence(tree);

    }

}