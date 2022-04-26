import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TodosList {
	private HashMap<Integer,Todo> todosMap;
	private int todoCounter;
	private int subTodoCounter;
	private Scanner scannerObj = new Scanner(System.in);
	public TodosList() {
		todosMap = new HashMap<>();
		todoCounter = 0;
		subTodoCounter = 0;
	}
	
	public HashMap<Integer,Todo> getTodosMap(){
		return todosMap;
	}
	
	public Todo createTodoPrompt() {
		System.out.println("Enter info for a new todo (type 'exit' to leave): ");
	    String todo = scannerObj.nextLine();  
	    System.out.println("Your new todo is: " + todo);
	    if(!todo.equals("exit")) {
	    	System.out.println("Enter deadline for todo (MM/DD/YYYY)");
	    	String dueDate = scannerObj.nextLine();
		    Instant instant = Instant.now();
		    System.out.println("Enter current progress on todo 0-100 (don't include % sign)");
		    String progress = scannerObj.nextLine()+"%";
		    System.out.println("Would you like to add sub-todos? (yes/no)");
		    String addSubTodos = scannerObj.nextLine();
		    Todo newTodo = new Todo(todoCounter);
		    newTodo.setDescription(todo);
		    newTodo.setDueDate(dueDate);
		    newTodo.setProgress(progress);
		    newTodo.setCreationDate(instant+"");
		    if(addSubTodos.equals("yes")) {
		    	String continueAddingSubTodos = "yes"; 
		    	//separate into methods
		    	while(continueAddingSubTodos.equals("yes")) {
		    		System.out.println("Enter info for a new sub-todo: ");
		    	    String subTodoInfo = scannerObj.nextLine();  
			    	System.out.println("Enter deadline for subtodo (MM/DD/YYYY)");
			    	String subDueDate = scannerObj.nextLine();
				    Instant subInstant = Instant.now();
				    System.out.println("Enter current progress on todo 0-100 (don't include % sign)");
				    String subProgress = scannerObj.nextLine()+"%";
				    SubTodo newSubTodo = new SubTodo(subTodoCounter, todoCounter);
				    newSubTodo.setDescription(subTodoInfo);
				    newSubTodo.setDueDate(subDueDate);
				    newSubTodo.setProgress(subProgress);
				    newSubTodo.setCreationDate(subInstant+"");
				    newTodo.addSubTodo(newSubTodo);
				    subTodoCounter++;
				    System.out.println("Would you like to keep adding sub-todos? (yes/no)");
				    continueAddingSubTodos = scannerObj.nextLine();
		    	}
		    }
		    return newTodo;
	    }
	    return null;
	}
	
	public void createTodos(Todo newTodo) {
	    todosMap.put(todoCounter, newTodo);
	    todoCounter++;
	    System.out.println("New todo has been added to list!");
	}
	
	public Todo selectTodo(int id) {
		return todosMap.get(id);
		
	}
	public void alphabeticalSortTodos() {
		HashMap<String, Integer> tempMap = new HashMap<>();
		for(int key: todosMap.keySet()) {
			tempMap.put(todosMap.get(key).getDescription(), key);
		}
		List<String> sortedTodos=new ArrayList<String>(tempMap.keySet());
		Collections.sort(sortedTodos);
		for(int i=0;i<sortedTodos.size();++i) {
			String todoName = sortedTodos.get(i)+"";
			int todoId = tempMap.get(todoName);
			String todoDueDate = todosMap.get(todoId).getDueDate();
			String todoProgress = todosMap.get(todoId).getProgress();
			System.out.print(todoId);
			System.out.print("        ");
			System.out.print(todoName);
			System.out.print("        ");
			System.out.print(todoDueDate);
			System.out.print("        ");
			System.out.print(todoProgress);
			System.out.print("        ");
			System.out.println("");
		}
	}
	
	public void reverseAlphabeticalSortTodos() {
		HashMap<String, Integer> temporary = new HashMap<>();

		for(int key: todosMap.keySet()) {
			temporary.put(todosMap.get(key).getDescription(), key);
		}
		List<String> sorted = new ArrayList<String>(temporary.keySet());
		Collections.sort(sorted, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		
		for(int i = 0; i < sorted.size(); i++) {
			String itemName = sorted.get(i) + "";
			int itemId = temporary.get(itemName);
			String itemDate = todosMap.get(itemId).getDueDate();
			String itemProgress = todosMap.get(itemId).getProgress();
			
			System.out.print(itemId);
			System.out.print("        ");
			System.out.print(itemName);
			System.out.print("        ");
			System.out.print(itemDate);
			System.out.print("        ");
			System.out.print(itemProgress);
			System.out.print("        ");
			System.out.println("");
			
		}
	}
	
	public void dateSortTodos() {
		HashMap<String, Integer> tempMap = new HashMap<>();
		for(int key: todosMap.keySet()) {
			tempMap.put(todosMap.get(key).getDueDate(), key);
		}
		List<String> sortedTodos=new ArrayList<String>(tempMap.keySet());
		Collections.sort(sortedTodos);
		for(int i=0;i<sortedTodos.size();++i) {
			String todoDueDate = sortedTodos.get(i)+"";
			int todoId = tempMap.get(todoDueDate);
			
			String todoName = todosMap.get(todoId).getDescription();
			String todoProgress = todosMap.get(todoId).getProgress();
			System.out.print(todoId);
			System.out.print("        ");
			System.out.print(todoName);
			System.out.print("        ");
			System.out.print(todoDueDate);
			System.out.print("        ");
			System.out.print(todoProgress);
			System.out.print("        ");
			System.out.println("");
		}
	}
	
	public static boolean isNum(String str) {  
		  try {  
		    int i = Integer.parseInt(str);  
		  }  
		  catch(NumberFormatException e) {  
		    return false;  
		  }
		  return true;  
	}
	
	public void selectTodoPrompt() {
		System.out.println("Enter name or id of todo you would like to select (type 'exit' to leave): ");
	    String todo = scannerObj.nextLine();
	    if(!todo.equals("exit")) {
	    	int todoId = -1;
		    if(isNum(todo)) {
		    	todoId = Integer.parseInt(todo);
		    }
		    else {
		    	for(int key:todosMap.keySet()) {
		    		if(todosMap.get(key).getDescription().equals(todo)) {
		    			todoId = key;
		    		}
		    	}
		    }
	    	if(todoId == -1) {
	    		System.out.println("Input not valid. Todo does not exist. ");
	    	}
	    	else {
	    		Todo selectedTodo =selectTodo(todoId);
	    		String todoDescription = selectedTodo.getDescription();
    			String todoDueDate = selectedTodo.getDueDate();
    			String todoProgress = selectedTodo.getProgress();
    			System.out.print(todoId);
    			System.out.print("        ");
    			System.out.print(todoDescription);
    			System.out.print("        ");
    			System.out.print(todoDueDate);
    			System.out.print("        ");
    			System.out.print(todoProgress);
    			System.out.print("        ");
    			System.out.println("");
    			System.out.println("Subtodos: ");
    			for(SubTodo key: todosMap.get(todoId).getSubTodoList()) {
    				System.out.print("        ");
        			System.out.print(key.getId());
        			System.out.print("        ");
        			System.out.print(key.getDescription());
        			System.out.print("        ");
        			System.out.print(key.getDueDate());
        			System.out.print("        ");
        			System.out.print(key.getProgress());
        			System.out.print("        ");
        			System.out.println("");
    			}
	    	}
	    }
	}
	
	public void deleteTodos(String todo) {
		if(!todo.equals("exit")) {
		    if(isNum(todo)) {
		    	todosMap.remove(Integer.parseInt(todo));
		    }
		    else {
		    	int todoId = -1;
		    	for(int key:todosMap.keySet()) {
		    		if(todosMap.get(key).getDescription().equals(todo)) {
		    			todoId = key;
		    		}
		    	}
		    	if(todoId != -1) {
		    		todosMap.remove(todoId);
		    	}
		    	else {
		    		System.out.println("Input not valid. Todo does not exist. ");
		    	}
		    }
	    }
		
	}
	
	public void deleteTodosPrompt() {
		System.out.println("Enter name or id of todo you would like to delete (type 'exit' to leave): ");
	    String todo = scannerObj.nextLine();
	    deleteTodos(todo);
		
	}
	
	public void addSubTodo(int todoId,SubTodo newSubTodo) {
	    System.out.println("Sub-todo has been added");
	    todosMap.get(todoId).addSubTodo(newSubTodo);
	    subTodoCounter++;
	}
	
	public SubTodo addSubTodoPrompt() {
		System.out.println("Enter name or id of todo you would like add subtodos too (type 'exit' to leave): ");
	    String todo = scannerObj.nextLine();
	    if(!todo.equals("exit")) {
	    	int todoId = -1;
		    if(isNum(todo) && todosMap.containsKey(Integer.parseInt(todo))) {
		    	todoId = Integer.parseInt(todo);
		    }
		    else {
		    	for(int key:todosMap.keySet()) {
		    		if(todosMap.get(key).getDescription().equals(todo)) {
		    			todoId = key;
		    		}
		    	}
		    }
	    	if(todoId == -1) {
	    		System.out.println("Input not valid. Todo does not exist. ");
	    	}
	    	else {
		    	String continueAddingSubTodos = "yes"; 
		    	while(continueAddingSubTodos.equals("yes")) {
		    		System.out.println("Enter info for a new sub-todo: ");
		    	    String subTodoInfo = scannerObj.nextLine();  
			    	System.out.println("Enter deadline for subtodo (MM/DD/YYYY)");
			    	String subDueDate = scannerObj.nextLine();
				    Instant subInstant = Instant.now();
				    System.out.println("Enter current progress on todo 0-100 (don't include % sign)");
				    String subProgress = scannerObj.nextLine()+"%";
				    SubTodo newSubTodo = new SubTodo(subTodoCounter, todoCounter);
				    newSubTodo.setDescription(subTodoInfo);
				    newSubTodo.setDueDate(subDueDate);
				    newSubTodo.setProgress(subProgress);
				    newSubTodo.setCreationDate(subInstant+"");
				    addSubTodo(todoId,newSubTodo);
				    System.out.println("Would you like to keep adding sub-todos? (yes/no)");
				    continueAddingSubTodos = scannerObj.nextLine();
				    
		    	}
	    	}
	    }
		SubTodo newSubTodo = new SubTodo(0);
		return newSubTodo;
	}
	
	public void printTodos() {
		System.out.println("Here are your current todos: ");
		for(int key:todosMap.keySet()) {
			int todoId = todosMap.get(key).getId();
			String todoDescription = todosMap.get(key).getDescription();
			String todoDueDate = todosMap.get(key).getDueDate();
			String todoProgress = todosMap.get(key).getProgress();
			System.out.print(todoId);
			System.out.print("        ");
			System.out.print(todoDescription);
			System.out.print("        ");
			System.out.print(todoDueDate);
			System.out.print("        ");
			System.out.print(todoProgress);
			System.out.print("        ");
			System.out.println("");
		}
	}
	
}
