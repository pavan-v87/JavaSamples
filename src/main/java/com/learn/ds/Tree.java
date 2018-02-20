package com.learn.ds;

import java.util.Iterator;

/**
 * Created by Pavan.VijayaNar on 10/14/2017.
 */

public interface Tree<T> {
    TreeNode<T> getRoot();
    Iterator<T> getIterator();
}
