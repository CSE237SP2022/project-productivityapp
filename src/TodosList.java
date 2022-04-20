import java.util.HashMap;

public class TodosList {
	public HashMap<Integer,Todo> todosMap;
	//public HashMap<Integer, SubTodo> subTodosMap = new HashMap<>();
	private int todoCounter = 0;
	private int subTodoCounter = 0;
	public void TodosList() {
		todosMap = new HashMap<>();
	}
	
}
