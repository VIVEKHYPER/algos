package com.learn.algos.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author vivek
 *
 *         Sorting algorithms
 */
@Service
public class SortServiceImpl implements SortService {
    int heapSize;

    /**
     *
     * Insertion Sort
     */
    @Override
    public List<Integer> insertionSort(List<Integer> list) {
	for (int i = 1; i < list.size(); i++) {
	    Integer temp = list.get(i);
	    int j;
	    for (j = i - 1; j >= 0 && list.get(j) > temp; j--) {
		list.set(j + 1, list.get(j));
	    }
	    list.set(j + 1, temp);
	}
	return list;
    }

    /**
     *
     * Merge Sort
     */
    @Override
    public List<Integer> mergeSort(List<Integer> list) {
	int p = 0;
	int r = list.size() - 1;
	mergeSortRecur(list, p, r);
	return list;
    }

    private void mergeSortRecur(List<Integer> list, int p, int r) {
	if (p < r) {
	    int q = (p + r) / 2;
	    mergeSortRecur(list, p, q);
	    mergeSortRecur(list, q + 1, r);
	    merge(list, p, q, r);
	}
    }

    private void merge(List<Integer> list, int p, int q, int r) {
	int n1 = q - p + 1;
	int n2 = r - q;
	Integer[] Left = new Integer[n1 + 1];
	Integer[] Right = new Integer[n2 + 1];
	for (int i = 0; i < n1; i++) {
	    Left[i] = list.get(p + i);
	}

	Left[n1] = Integer.MAX_VALUE;

	for (int i = 0; i < n2; i++) {
	    Right[i] = list.get(q + 1 + i);
	}

	Right[n2] = Integer.MAX_VALUE;

	int i = 0;
	int j = 0;
	for (int k = p; k <= r; k++) {
	    if (Left[i] < Right[j]) {
		list.set(k, Left[i++]);
	    } else {
		list.set(k, Right[j++]);
	    }
	}
    }

    /**
     *
     * Heap Sort
     */
    @Override
    public List<Integer> heapSort(List<Integer> list) {

	buildMaxHeap(list);

	for (int i = list.size() - 1; i >= 1; i--) {
	    int temp = list.get(0);
	    list.set(0, list.get(i));
	    list.set(i, temp);
	    heapSize--;
	    maxHeapify(list, 0);
	}

	return list;
    }

    private void buildMaxHeap(List<Integer> list) {
	heapSize = list.size();
	for (int i = (heapSize / 2) - 1; i >= 0; i--) {
	    maxHeapify(list, i);
	}
    }

    private void maxHeapify(List<Integer> list, int i) {
	int largest;
	if (left(i) < heapSize && list.get(left(i)) > list.get(i)) {
	    largest = left(i);
	} else {
	    largest = i;
	}

	if (right(i) < heapSize && list.get(right(i)) > list.get(largest)) {
	    largest = right(i);
	}
	if (largest != i) {
	    int temp = list.get(i);
	    list.set(i, list.get(largest));
	    list.set(largest, temp);
	    maxHeapify(list, largest);
	}
    }

    private int right(int i) {
	return i * 2 + 2;
    }

    private int left(int i) {
	return i * 2 + 1;
    }

    /**
     *
     * Quick Sort
     */
    @Override
    public List<Integer> quickSort(List<Integer> list) {
	int p = 0;
	int r = list.size() - 1;
	mergeSortRecur(list, p, r);
	return list;
    }

    @SuppressWarnings("unused")
    private void quickSortRecur(List<Integer> list, int p, int r) {
	if (p < r) {
	    int q = partition(list, p, r);
	    quickSortRecur(list, p, q - 1);
	    quickSortRecur(list, q + 1, r);
	}
    }

    private int partition(List<Integer> list, int p, int r) {
	int x = list.get(r);
	int i = p - 1;
	for (int j = p; j < r; j++) {
	    if (list.get(j) <= x) {
		i++;
		int temp = list.get(i);
		list.set(i, list.get(j));
		list.set(j, temp);
	    }
	}
	int temp = list.get(i + 1);
	list.set(i + 1, list.get(r));
	list.set(r, temp);
	return i + 1;
    }
}
