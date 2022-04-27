import java.util.*;

public class ProductivityApp {

	public static void main(String[] args) {
		boolean exitProgram = false;
		Scanner scannerObj = new Scanner(System.in);
		TodosList todosList = new TodosList();
		while(!exitProgram) {
			System.out.println("Todo list commands: ");
			System.out.println("type 'create' to create a new todo");
			System.out.println("type 'print' to print out all todos");
			System.out.println("type 'print filter alphabetical' to filter todos alphabetically");
			System.out.println("type 'print filter reverse alphabetical' to filter todos reverse alphabetically");
			System.out.println("type 'print filter date' to filter todos by due date");
			System.out.println("type 'select' to see info about a particular todo");
			System.out.println("type 'add subtodo' to add a subtodo to one of the main todos");
			System.out.println("type 'delete' to delete a todo");
			System.out.println("type 'exit' to exit from program");
			String todoCommand = scannerObj.nextLine();
			if(todoCommand.equals("create")) {
				Todo newTodo = todosList.createTodoPrompt();
				todosList.addTodoToList(newTodo);
			}
			else if(todoCommand.equals("delete")) {
				todosList.deleteTodosPrompt();
			}
			else if(todoCommand.equals("select")) {
				todosList.selectTodoPrompt();
			}
			else if(todoCommand.equals("add subtodo")) {
				todosList.addSubTodoPrompt();
			}
			else if(todoCommand.equals("print")) {
				todosList.printTodos();
			}
			else if(todoCommand.equals("print filter alphabetical")) {
				todosList.alphabeticalSortTodos();
			}
			else if(todoCommand.equals("print filter reverse alphabetical")){
				todosList.reverseAlphabeticalSortTodos();
			}
			else if(todoCommand.equals("print filter date")) {
				todosList.dateSortTodos();
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
		scannerObj.close();
	}
	
}
