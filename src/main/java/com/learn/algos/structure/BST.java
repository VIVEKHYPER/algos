package com.learn.algos.structure;

import java.util.List;
import java.util.Objects;

import com.learn.algos.rest.exception.TreeSearchNotFoundException;

import lombok.Data;

@Data
public class BST<T> implements Tree<T> {

    private Node<T> root;
    private Integer size;

    public BST() {
	size = 0;
    }

    public BST(Node<T> root) {
	this.root = root;
	this.size = 1;
    }

    @Override
    public void insert(Node<T> node) {
	Node<T> y = null;
	Node<T> x = root;
	while (Objects.nonNull(x)) {
	    y = x;
	    if (node.getKey() < x.getKey()) {
		x = x.getLeft();
	    } else {
		x = x.getRight();
	    }
	}
	node.setParent(y);
	if (Objects.isNull(y)) {
	    root = node;
	} else if (node.getKey() < y.getKey()) {
	    y.setLeft(node);
	} else {
	    y.setRight(node);
	}
	size++;
    }

    public void inorderWalk(Node<T> node) {
	if (Objects.nonNull(node)) {
	    inorderWalk(node.getLeft());
	    System.out.println("Key : " + node.getKey() + "\n Value: " + node.getValue() + "\n");
	    inorderWalk(node.getRight());
	}
    }

    public void preorderWalk(Node<T> node) {
	if (Objects.nonNull(node)) {
	    System.out.println("Key : " + node.getKey() + "\n Value: " + node.getValue() + "\n");
	    preorderWalk(node.getLeft());
	    preorderWalk(node.getRight());
	}
    }

    public void postorderWalk(Node<T> node) {
	if (Objects.nonNull(node)) {
	    postorderWalk(node.getLeft());
	    postorderWalk(node.getRight());
	    System.out.println("Key : " + node.getKey() + "\n Value: " + node.getValue() + "\n");
	}
    }

    @Override
    public Node<T> search(Node<T> node, Integer num) throws NullPointerException{
	if(Objects.isNull(node)) {
	    throw new NullPointerException("Node<T> is Null");
	}
	if (node.getKey() == num) {
	    return node;
	} else if (node.getKey() < num) {
	    return search(node.getRight(), num);
	} else {
	    return search(node.getLeft(), num);
	}
    }

    @Override
    public void construct(List<Integer> numlist) {
	numlist.stream().forEach(action -> {
	    Node<T> node = new Node<T>();
	    node.setKey(action);
	    this.insert(node);
	});
    }

    @Override
    public Integer delete(Integer num) throws TreeSearchNotFoundException{
	Node<T> delNode;
	try {
	    delNode = this.search(root, num);
	} catch (NullPointerException exc) {
	    throw new TreeSearchNotFoundException("Node not found for : " + num);
	}
	if(Objects.isNull(delNode.getLeft())) {
	    transplant(delNode, delNode.getRight());
	}
	else if(Objects.isNull(delNode.getRight())) {
	    transplant(delNode, delNode.getLeft());
	}
	else {
	    Node<T> treeMin = treeMinimum(delNode.getRight());
	    if(!treeMin.getParent().equals(delNode)) {
		transplant(treeMin, treeMin.getRight());
		treeMin.setRight(delNode.getRight());
		treeMin.getRight().setParent(treeMin);
	    }
	    transplant(delNode, treeMin);
	    treeMin.setLeft(delNode.getLeft());
	    treeMin.getLeft().setParent(treeMin);
	}
	return delNode.getKey();
    }

    public void transplant(Node<T> u, Node<T> v) {
	if(u.getParent() == null) {
	   this.root = v;
	}
	else if(u == u.getParent().getLeft()) {
	    u.getParent().setLeft(v);
	}
	else {
	    u.getParent().setRight(v);
	}
	if(Objects.nonNull(v)) {
	    v.setParent(u.getParent());
	}
    }
    
    public Node<T> treeMinimum(Node<T> x) {
	while(Objects.nonNull(x.getLeft())) {
	    x = x.getLeft();
	}
	return x;
    }

    public Node<T> treeMaximum(Node<T> x) {
	while(Objects.nonNull(x.getRight())) {
	    x = x.getRight();
	}
	return x;
    }
    
    @Override
    public Integer delete(Node<T> index) {
	return null;
    }

}
