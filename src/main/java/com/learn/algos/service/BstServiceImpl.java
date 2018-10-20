package com.learn.algos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.algos.rest.exception.TreeSearchNotFoundException;
import com.learn.algos.structure.BST;
import com.learn.algos.structure.Node;

@Service
public class BstServiceImpl implements TreeService {

    BST<String> bst = new BST<String>();

    @Override
    public void insert(Integer num) {
	Node<String> node = new Node<String>();
	node.setKey(num);
	bst.insert(node);
	System.out.println("Inorder walk...\n");
	bst.inorderWalk(bst.getRoot());
    }

    @Override
    public Integer search(Integer num) {
	Node<String> search;
	try {
	    search = bst.search(bst.getRoot(), num);
	} catch (NullPointerException exc) {
	    throw new TreeSearchNotFoundException("Node not found for : " + num);
	}
	if (search.getKey() == null) {
	    return -1;
	} else {
	    return search.getKey();
	}
    }

    @Override
    public void construct(List<Integer> numlist) {

	bst.construct(numlist);
	System.out.println("Inorder walk...\n");
	bst.inorderWalk(bst.getRoot());

	System.out.println("Preorder walk...\n");
	bst.preorderWalk(bst.getRoot());

	System.out.println("Postorder walk...\n");
	bst.postorderWalk(bst.getRoot());
    }

    @Override
    public Integer delete(Integer num) {
	return bst.delete(num);
    }

    @Override
    public <T> Integer delete(Node<T> index) {
	return null;
    }

}
