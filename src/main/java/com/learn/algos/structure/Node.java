package com.learn.algos.structure;

import lombok.Data;

@Data
public class Node<T> {
    private Integer key;
    private T value;
    private Node<T> left;
    private Node<T> right;
    private Node<T> parent;
}
