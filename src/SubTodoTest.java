import static org.junit.jupiter.api.Assertions.*;

import java.time.Instant;

import org.junit.jupiter.api.Test;

class SubTodoTest {

	@Test
	void test() {

		int subtodoId = 2;
		int mainTodoId =1;
		String description="complete assignment 3";
		String dueDate ="01/01/2000";
		String progress = "75";
		String creationDate = Instant.now() +"";
		SubTodo subTodo = new SubTodo(2);
		
		subTodo.setDescription(description);
		subTodo.setDueDate(dueDate);
		subTodo.setProgress(progress);
		subTodo.setCreationDate(creationDate);
		
		assertEquals(subTodo.getId(),subtodoId);
		assertEquals(subTodo.getDescription(), description);
		assertEquals(subTodo.getDueDate(), dueDate);
		assertEquals(subTodo.getProgress(), progress);
		assertEquals(subTodo.getCreationDate(), creationDate);
	}

}
