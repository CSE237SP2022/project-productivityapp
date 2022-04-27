
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
	Todo testTodo = new Todo(id);
	
	
	SubTodo subtodo = new SubTodo(1,0);

	@Test
	void testAddSubTodo() {
		
	    testTodo.addSubTodo(subtodo);
	    ArrayList<SubTodo> subList = testTodo.getSubTodoList();
	    assertEquals(true, subList.contains(subtodo));
	    
	}

	@Test
	void testDeleteAllSubtodos() {
		testTodo.addSubTodo(subtodo);

		ArrayList<SubTodo> subList = testTodo.getSubTodoList();
		assertEquals(false, subList.isEmpty()); // check that subList is not empty
		testTodo.deleteAllSubTodos();
		assertEquals(true, subList.isEmpty()); // check that subList is empty
		
		
	}

}
