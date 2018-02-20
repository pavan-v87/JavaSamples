package com.learn.ds;

import java.util.Iterator;

/**
 * Created by Pavan.VijayaNar on 10/14/2017.
 */

public class TreeImpl<T>  implements Tree<T> {
    private TreeNode<T> root;

    public TreeNode generate(T rootValue) {
        root = new TreeNode<>("root", rootValue);
        return root;
    }

    public void attachChildren(TreeNode<T> parent, TreeNode<T>... children) {
        for (TreeNode<T> child : children) {
            parent.addChild(child);
        }
    }

    @Override
    public TreeNode<T> getRoot() {
        return root;
    }

    @Override
    public Iterator<T> getIterator() {
        return new TreeIterator();
    }

    private class TreeIterator implements Iterator<T> {
        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public T next() {
            return null;
        }
    }
}
