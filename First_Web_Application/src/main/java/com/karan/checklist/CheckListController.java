package com.karan.checklist;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class CheckListController {
	
	
	@Autowired
	CheckListService chkListService;

	@InitBinder
	protected void initBinder(WebDataBinder binder){		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));		
	}
	
	@RequestMapping(value = "/checkList",method = RequestMethod.GET)
	public String showCheckList(ModelMap model){
		
		
		model.addAttribute("checkList",chkListService.retrieveTodos("Karan"));
		
		return "checkList";
		
	}
	
	
	@RequestMapping(value = "/add-check",method = RequestMethod.GET)
	public String addCheck(ModelMap model){		
		model.addAttribute("checkList",new CheckList(0, "Karan", "Testing", null, false));		
		return "addCheck";
		
	}
	
	
	@RequestMapping(value = "/deleteCheck",method = RequestMethod.GET)
	public String deleteCheck(@RequestParam int id, ModelMap model){
		model.clear();
		chkListService.deleteTodo(id);		
		return "redirect:checkList";
		
	}
	
	/**
	 * Display Update jsp
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/updateCheck",method = RequestMethod.GET)
	public String updateCheck(@RequestParam int id, ModelMap model){
		model.clear();
		List<CheckList> updateCheck = chkListService.retrieveTodos(id);
		
		model.addAttribute("checkList",updateCheck.get(0));
		
		return "addCheck";
		
	}
	
	/**
	 * Updating to do list
	 * @param model
	 * @param chkList
	 * @param result
	 * @return
	 */
	@RequestMapping(value = "/updateCheck",method = RequestMethod.POST)
	public String updateChecks(ModelMap model, @Valid CheckList chkList,  BindingResult result){
		if(result.hasErrors()){
			System.out.println("inside errors update");
			return "addCheck";
		}
		else{
		System.out.println("Updated todos"+chkList.getId());
		chkListService.updateTodos(chkList);
		model.clear();
	
		return "redirect:checkList";
		}
		
	}
	
	
	@RequestMapping(value = "/add-check",method = RequestMethod.POST)
	public String addChecknow(ModelMap model, @Valid CheckList chkList,  BindingResult result){
		if(result.hasErrors()){
			System.out.println("inside errors");
			return "addCheck";
		}
		else{
		
		chkListService.addTodo(chkList.getUser(), chkList.getDesc(), new Date(), false);
		model.clear();
	
		return "redirect:checkList";
		}
	}
}
