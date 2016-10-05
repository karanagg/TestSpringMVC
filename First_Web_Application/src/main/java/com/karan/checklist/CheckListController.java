package com.karan.checklist;

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

	
	@RequestMapping(value = "/checkList",method = RequestMethod.POST)
	public String showCheckList(@RequestParam String name, ModelMap model){
		
		model.addAttribute("checkList",chkListService.retrieveTodos("in28Minutes"));
		
		return "checkList";
		
	}
	
	
	
}
