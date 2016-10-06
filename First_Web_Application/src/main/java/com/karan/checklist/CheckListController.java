package com.karan.checklist;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CheckListController {
	
	
	@Autowired
	CheckListService chkListService;

	
	@RequestMapping(value = "/checkList",method = RequestMethod.GET)
	public String showCheckList(ModelMap model){
		
		
		model.addAttribute("checkList",chkListService.retrieveTodos("Karan"));
		
		return "checkList";
		
	}
	
	
	@RequestMapping(value = "/add-check",method = RequestMethod.GET)
	public String addCheck(ModelMap model){
		
		//model.addAttribute("checkList",chkListService.retrieveTodos("in28Minutes"));
		
		return "addCheck";
		
	}
	
	@RequestMapping(value = "/add-check",method = RequestMethod.POST)
	public String addChecknow(@RequestParam String name, String desc, ModelMap model){
		
		chkListService.addTodo(name, desc, new Date(), false);
		System.out.println("Desc"+name);
	
		return "redirect:checkList";
		
	}
}
