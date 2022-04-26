
public class SubTodo {
	private String description,dueDate, progress,creationDate;
	private int id, mainTodoId;
	
	public SubTodo(int id) {
		this.id = id;
	}
	
	public SubTodo(int id,int mainTodoId) {
		this.id = id;
		this.mainTodoId = mainTodoId;
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
}