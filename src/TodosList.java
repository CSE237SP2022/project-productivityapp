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
		    Todo newTodo = new Todo(todoCounter,todo,dueDate,progress,instant+"");
		    if(addSubTodos.equals("yes")) {
		    	String continueAddingSubTodos = "yes"; 
		    	while(continueAddingSubTodos.equals("yes")) {
		    		System.out.println("Enter info for a new sub-todo: ");
		    	    String subTodoInfo = scannerObj.nextLine();  
			    	System.out.println("Enter deadline for subtodo (MM/DD/YYYY)");
			    	String subDueDate = scannerObj.nextLine();
				    Instant subInstant = Instant.now();
				    System.out.println("Enter current progress on todo 0-100 (don't include % sign)");
				    String subProgress = scannerObj.nextLine()+"%";
				    SubTodo newSubTodo = new SubTodo(subTodoCounter, todoCounter,subTodoInfo, subDueDate,subProgress, subInstant+"");
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
			tempMap.put(todosMap.get(key).description, key);
		}
		List sortedTodos=new ArrayList(tempMap.keySet());
		Collections.sort(sortedTodos);
		for(int i=0;i<sortedTodos.size();++i) {
			String todoName = sortedTodos.get(i)+"";
			int todoId = tempMap.get(todoName);
			String todoDueDate = todosMap.get(todoId).dueDate;
			String todoProgress = todosMap.get(todoId).progress;
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
		//create a placeholder hashmap to copy original values into
		HashMap<String, Integer> temporary = new HashMap<>();
		
		//loop to copy original to-do info, temp variable for sorted values +
		//method to help with reverse sorting
		for(int key: todosMap.keySet()) {
			temporary.put(todosMap.get(key).description, key);
		}
		List sorted = new ArrayList(temporary.keySet());
		Collections.sort(sorted, Collections.reverseOrder(String.CASE_INSENSITIVE_ORDER));
		
		//loop through sorted list of to-do items and print them out
		for(int i = 0; i < sorted.size(); i++) {
			//obtaining to-do item information (due date, name, id #, progress)
			String itemName = sorted.get(i) + "";
			int itemId = temporary.get(itemName);
			String itemDate = todosMap.get(itemId).dueDate;
			String itemProgress = todosMap.get(itemId).progress;
			
			//print out each component of to-do items
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
			tempMap.put(todosMap.get(key).dueDate, key);
		}
		List sortedTodos=new ArrayList(tempMap.keySet());
		Collections.sort(sortedTodos);
		for(int i=0;i<sortedTodos.size();++i) {
			String todoDueDate = sortedTodos.get(i)+"";
			int todoId = tempMap.get(todoDueDate);
			
			String todoName = todosMap.get(todoId).description;
			String todoProgress = todosMap.get(todoId).progress;
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
		    		if(todosMap.get(key).description.equals(todo)) {
		    			todoId = key;
		    		}
		    	}
		    }
	    	if(todoId == -1) {
	    		System.out.println("Input not valid. Todo does not exist. ");
	    	}
	    	else {
	    		Todo selectedTodo =selectTodo(todoId);
	    		String todoDescription = selectedTodo.description;
    			String todoDueDate = selectedTodo.dueDate;
    			String todoProgress = selectedTodo.progress;
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
        			System.out.print(key.id);
        			System.out.print("        ");
        			System.out.print(key.description);
        			System.out.print("        ");
        			System.out.print(key.dueDate);
        			System.out.print("        ");
        			System.out.print(key.progress);
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
		    		if(todosMap.get(key).description.equals(todo)) {
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
		    		if(todosMap.get(key).description.equals(todo)) {
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
				    SubTodo newSubTodo = new SubTodo(subTodoCounter, todoCounter,subTodoInfo, subDueDate,subProgress, subInstant+"");
				    /*System.out.println("Sub-todo has been added");
				    todosMap.get(todoId).addSubTodo(newSubTodo);
				    subTodoCounter++;*/
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
			int todoId = todosMap.get(key).id;
			String todoDescription = todosMap.get(key).description;
			String todoDueDate = todosMap.get(key).dueDate;
			String todoProgress = todosMap.get(key).progress;
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
