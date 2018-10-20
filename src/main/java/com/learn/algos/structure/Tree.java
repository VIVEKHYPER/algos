package com.learn.algos.structure;

import java.util.List;

public interface Tree<T> {
    public void insert(Node<T> node);
    public void construct(List<Integer> numlist);
    public Integer delete(Integer num);
    public Integer delete(Node<T> node);
    public Node<T> search(Node<T> node, Integer num);
}
