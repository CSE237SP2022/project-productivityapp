
public class SubTodo {
	public String description,dueDate, progress,creationDate;
	public int id,mainTodoId;
	public SubTodo(int id, int mainTodoId, String description, String dueDate, String progress,String creationDate) {
		this.id = id;
		this.mainTodoId = mainTodoId;
		this.description = description;
		this.dueDate = dueDate;
		this.progress = progress;
		this.creationDate = creationDate;
	}
}