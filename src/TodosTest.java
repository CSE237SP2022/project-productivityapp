import static org.junit.jupiter.api.Assertions.*;


import java.time.Instant;


import org.junit.jupiter.api.Test;

class TodosTest {

	int id = 0 ;
	String description="clean up room";
	String dueDate ="01/01/2000";
	String progress = "25";
	String creationDate = Instant.now() +"";
	
	SubTodo subTodo = new SubTodo(0,1, "make bed", dueDate, progress,creationDate);
	Todo todo1 = new Todo(1, description, dueDate, progress,creationDate);
	Todo todo2 = new Todo(2, "put away clothes", dueDate, progress,creationDate);
	Todo todo3 = new Todo(3, "water plants", dueDate, progress,creationDate);
	
	
	@Test
	void testPrintTodos() {
		
		
		Todos.todosMap.put(todo1.id, todo1);
		Todos.todosMap.put(todo2.id, todo2);
		Todos.todosMap.put(todo3.id, todo3);
		
		String line1="1        clean up room        01/01/2000        25";
		String line2= "2        put away clothes        01/01/2000        25";
		String line3="3        water plants        01/01/2000        25";
	    //System.out.print("Hello Baeldung Readers!!");
		Todos.printTodos();
	    

		//fail("Not yet implemented");
	}

	@Test
	void testCreateTodos() {
		
		
		int prevTodoCounter = Todos.todoCounter;
		
		//run create Todo function
		Todos.createTodos();

		assertEquals(prevTodoCounter+1,Todos.subTodoCounter);
		
		//fail("Not yet implemented");
	}

	@Test
	void testIsNum() {
		fail("Not yet implemented");
	}

	@Test
	void testSelectTodo() {
		fail("Not yet implemented");
	}

	@Test
	void testDeleteTodos() {
		fail("Not yet implemented");
	}

	@Test
	void testAddSubTodo() {
		fail("Not yet implemented");
	}

}
