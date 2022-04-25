
import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class TodoTest {

	int id = 0 ;
	String description="clean up room";
	String dueDate ="01/01/2000";
	String progress = "25";
	String creationDate = Instant.now() +"";
	Todo todo = new Todo(0,description,dueDate,progress,creationDate);
	
	SubTodo subtodo = new SubTodo(1,id, "make bed", dueDate, progress,creationDate);
	SubTodo subtodo1 = new SubTodo(2,id, "water plants", dueDate, progress,creationDate);
	SubTodo subtodo2 = new SubTodo(3,id, "put away clothes", dueDate, progress,creationDate);
	SubTodo subtodo3 = new SubTodo(4,id, "turn off lights", dueDate, progress,creationDate);
	
	@Test
	void testTodo() {
		assertEquals(id,todo.id);
		assertEquals(description, todo.description);
		assertEquals(dueDate, todo.dueDate);
		assertEquals(progress, todo.progress);
		assertEquals(creationDate, todo.creationDate);
		//fail("Not yet implemented");
	}

	@Test
	void testAddSubTodo() {
		 todo.addSubTodo(subtodo);
		 ArrayList<SubTodo> subList = todo.getSubTodoList();
		 assertEquals(true, subList.contains(subtodo));
		 assertEquals(todo.id, subtodo.mainTodoId);
		 
		//fail("Not yet implemented");
	}

	@Test
	void testGetSubTodoList() {
		todo.addSubTodo(subtodo);
		todo.addSubTodo(subtodo1);
		todo.addSubTodo(subtodo2);
		ArrayList<SubTodo> subList = todo.getSubTodoList();
		assertEquals(true, subList.contains(subtodo));
		assertEquals(true, subList.contains(subtodo1));
		assertEquals(true, subList.contains(subtodo2));
		assertEquals(false, subList.contains(subtodo3));

		//fail("Not yet implemented");
	}

	@Test
	void testDeleteAllSubtodos() {
		todo.addSubTodo(subtodo);
		todo.addSubTodo(subtodo1);
		todo.addSubTodo(subtodo2);
		ArrayList<SubTodo> subList = todo.getSubTodoList();
		assertEquals(false, subList.isEmpty()); // check that subList is not empty
		//delete all subTodos
		todo.deleteAllSubtodos();
		assertEquals(true, subList.isEmpty()); // check that subList is empty
		
		
		//fail("Not yet implemented");
	}

}
