import java.util.*;
public class Todo {
	public String description,dueDate, progress,creationDate;
	public int id;
	private ArrayList<SubTodo> subTodoList = new ArrayList<>();
	public Todo(int id, String description, String dueDate, String progress,String creationDate) {
		this.id = id;
		this.description = description;
		this.dueDate = dueDate;
		this.progress = progress;
		this.creationDate = creationDate;
	}
	public void addSubTodo(SubTodo todo) {
		subTodoList.add(todo);
	}
	public ArrayList<SubTodo> getSubTodoList() {
		return subTodoList;
	}
	public void deleteAllSubtodos() {
		subTodoList.clear();
	}
}
