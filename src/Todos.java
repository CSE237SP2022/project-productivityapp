
import java.util.Arrays;
import java.util.HashMap;
import java.util.*;
import java.time.Instant;

public class Todos {
	
	static public HashMap<String,Todo> todosMap = new HashMap<>();
	static boolean exitProgram = false;
	static Scanner scannerObj = new Scanner(System.in);
	
	static void printTodos() {
		System.out.println("Here are your current todos: ");
		for(String key:todosMap.keySet()) {
			String todoDescription = todosMap.get(key).description;
			String todoDueDate = todosMap.get(key).dueDate;
			String todoProgress = todosMap.get(key).progress;
			System.out.print(todoDescription);
			System.out.print("        ");
			System.out.print(todoDueDate);
			System.out.print("        ");
			System.out.print(todoProgress);
			System.out.print("        ");
			System.out.println("");
		}
	}
	
	static void createTodos() {
		System.out.println("Enter info for a new todo (type 'exit' to leave): ");
	    String todo = scannerObj.nextLine();  
	    System.out.println("Your new todo is: " + todo);
	    if(!todo.equals("exit")) {
	    	System.out.println("Enter deadline for todo (MM/DD/YYYY)");
	    	String dueDate = scannerObj.nextLine();
		    Instant instant = Instant.now();
		    System.out.println("Enter current progress on todo 0-100 (don't include % sign)");
		    String progress = scannerObj.nextLine()+"%";
		    Todo newTodo = new Todo(todo,dueDate,progress);
		    todosMap.put(instant+"", newTodo);
		    System.out.println("New todo has been added to list!");
	    }
	    
	}
	
	public static void main(String[] args) {
		while(!exitProgram) {
			System.out.println("Todo list commands: ");
			System.out.println("type 'create' to create a new todo");
			System.out.println("type 'edit' to edit todo");
			System.out.println("type 'print' to print out all todos");
			System.out.println("type 'exit' to exit from program");
			String todoCommand = scannerObj.nextLine();
			if(todoCommand.equals("create")) {
				createTodos();
			}
			else if(todoCommand.equals("edit")) {
				System.out.println("edit todos function here");
			}
			else if(todoCommand.equals("print")) {
				printTodos();
			}
			else if(todoCommand.equals("exit")) {
				exitProgram = true;
			}
			else {
				System.out.println("Invalid command entered");
			}
			System.out.println("");
			System.out.println("");
		}
	}
	
	
}
