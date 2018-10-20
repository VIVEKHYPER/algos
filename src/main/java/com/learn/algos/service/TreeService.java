package com.learn.algos.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.learn.algos.structure.Node;

@Service
public interface TreeService {
    public void insert(Integer num);
    public Integer search(Integer num);
    public void construct(List<Integer> numlist);
    public Integer delete(Integer index);
    public <T> Integer delete(Node<T> index);
}
