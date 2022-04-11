import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.Test;

class SubTodoTest {

	@Test
	void test() {
		//fail("Not yet implemented");
		int id = 2;
		int mainTodoId =1;
		String description="complete assignment 3";
		String dueDate ="01/01/2000";
		String progress = "75";
		String creationDate = Instant.now() +"";
		SubTodo subTodo = new SubTodo(id,mainTodoId,description,dueDate,progress,creationDate);
		
		assertEquals(id,subTodo.id);
		assertEquals(description, subTodo.description);
		assertEquals(dueDate, subTodo.dueDate);
		assertEquals(progress, subTodo.progress);
		assertEquals(creationDate, subTodo.creationDate);
	}

}
