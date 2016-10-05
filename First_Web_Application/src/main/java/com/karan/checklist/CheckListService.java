package com.karan.checklist;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class CheckListService {
	
	private static List<CheckList> todos = new ArrayList<CheckList>();
	private static int todoCount = 3;

	static {
		todos.add(new CheckList(1, "in28Minutes", "Learn Spring MVC", new Date(),false));
		todos.add(new CheckList(2, "in28Minutes", "Learn Struts", new Date(), false));
		todos.add(new CheckList(3, "in28Minutes", "Learn Hibernate", new Date(),false));
	}

	public List<CheckList> retrieveTodos(String user) {
		List<CheckList> filteredTodos = new ArrayList<CheckList>();
		for (CheckList todo : todos) {
			if (todo.getUser().equals(user))
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
