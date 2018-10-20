package com.learn.algos.service;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface SortService {
    public List<Integer> insertionSort(List<Integer> list);

    public List<Integer> mergeSort(List<Integer> list);

    public List<Integer> heapSort(List<Integer> list);

    public List<Integer> quickSort(List<Integer> list);
}
