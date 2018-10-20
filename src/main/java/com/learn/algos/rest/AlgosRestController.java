package com.learn.algos.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.learn.algos.entity.Setting;
import com.learn.algos.service.SortService;
import com.learn.algos.service.TreeService;

@RequestMapping(value = "/api")
@RestController
@EnableWebSecurity
@EnableWebMvc
public class AlgosRestController {

    @Autowired
    public SortService service;
    
    @Autowired
    public TreeService treeService;

    @PostMapping(value = "/sort")
    public  @ResponseBody List<Integer> saveCheckList(@RequestBody Setting setting) {

	// List<Integer> sortedIns = service.insertionSort(setting.getList());
	// List<Integer> sortedMer = service.mergeSort(setting.getList());
	// List<Integer> sortedHeap = service.heapSort(setting.getList());
	List<Integer> sortedQuick = service.quickSort(setting.getList());

	System.out.println(sortedQuick);
	return sortedQuick;
    }
    
    @PostMapping(value = "/bst")
    public  @ResponseBody void bstConstruct(@RequestBody Setting setting) {
	treeService.construct(setting.getList());
    }
    
    @PutMapping(value = "/bst")
    public void bstInsert(@RequestBody Integer num) {
	treeService.insert(num);
    }

    @GetMapping(value = "/bst/{num}")
    public void bstSearch(@PathVariable Integer num) {
	System.out.println(treeService.search(num));
    }
    
    @DeleteMapping(value = "/bst/{num}")
    public void bstDelete(@PathVariable Integer num) {
	System.out.println(treeService.delete(num));
    }
}
