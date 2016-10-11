package com.karan.checklist;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CheckRestController {
	
	@Autowired 
	CheckListService chls;
	
	
	@RequestMapping(value = "/todo/")
	public List<CheckList> retrieveAllCheck(){
		return chls.retrieveTodos("Karan");
		
	}
	
	@RequestMapping(value = "/todo/{id}")
	public List<CheckList> retrieveAllCheck(@PathVariable int id){
		return chls.retrieveTodos(id);
		
	}

}
