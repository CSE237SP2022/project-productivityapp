import java.util.*;
public class Todo {
	private String description,dueDate, progress,creationDate;
	private int id;
	private ArrayList<SubTodo> subTodoList = new ArrayList<>();
	
	public Todo(int id) {
		this.id= id;
	}
	
	public int getId() {
		return id;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDueDate(String date) {
		this.dueDate = date;
	}
	
	public String getDueDate() {
		return dueDate;
	}
	
	public void setProgress(String progress) {
		this.progress = progress;
	}
	
	public String getProgress() {
		return progress;
	}
	
	public void setCreationDate(String date) {
		this.creationDate = date;
	}
	
	public String getCreationDate() {
		return creationDate;
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
