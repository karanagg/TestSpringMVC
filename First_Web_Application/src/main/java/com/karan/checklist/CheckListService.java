package com.karan.checklist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.SessionAttributes;

@Service
@SessionAttributes("name")
public class CheckListService {
	
	private static List<CheckList> todos = new ArrayList<CheckList>();
	private static int todoCount = 3;

	static {
		todos.add(new CheckList(1, "Karan", "Learn Spring MVC", new Date(),false));
		todos.add(new CheckList(2, "Karan", "Learn Struts", new Date(), false));
		todos.add(new CheckList(3, "Karan", "Learn Hibernate", new Date(),false));
	}

	/**
	 * Retrieve Todos based on User
	 * @param user
	 * @return
	 */
	public List<CheckList> retrieveTodos(String user) {
		List<CheckList> filteredTodos = new ArrayList<CheckList>();
		for (CheckList todo : todos) {
			if (todo.getUser().equals(user))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}
	/**
	 * RetrieveTods based on ID
	 * @param id
	 * @return
	 */
	/*public List<CheckList> updateTodos(CheckList chkList) {
		List<CheckList> filteredTodos = new ArrayList<CheckList>();
		for (CheckList todo : todos) {
			if (todo.getId()==(chkList.getId())){
				System.out.println("Before removal"+todos);
				//todos.remove(todo);
			    deleteTodo(chkList.getId());
				System.out.println("After removal"+todos);
				
			}
			 //   todos.add(chkList);
			    System.out.println("After loading"+todos);
		}
		return filteredTodos;
	}
	*/
	
	public void updateTodos(CheckList chkList) {
		deleteTodo(chkList.getId());
		todos.add(chkList);
	}
	
	/**
	 * RetrieveTods based on ID
	 * @param id
	 * @return
	 */
	public List<CheckList> retrieveTodos(int id) {
		List<CheckList> filteredTodos = new ArrayList<CheckList>();
		for (CheckList todo : todos) {
			if (todo.getId()==(id))
				filteredTodos.add(todo);
		}
		return filteredTodos;
	}



	public void addTodo(String name, String desc, Date targetDate, boolean isDone) {
		todos.add(new CheckList(++todoCount, name, desc, targetDate, isDone));
	}

	public void deleteTodo(int id) {
		Iterator<CheckList> iterator = todos.iterator();
		while (iterator.hasNext()) {
			CheckList todo = iterator.next();
			if (todo.getId() == id) {
				iterator.remove();
			}
		}
	}

}
