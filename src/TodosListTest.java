import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.junit.jupiter.api.Test;

class TodosListTest {
	
	TodosList testedTodosList = new TodosList();
	

	@Test
	void testIsValidPercent() {
		String letter = "a";
		String integer = "15";
		String integer1 = "0";
		String word = "word";
		String decimal ="1.015";
		String negativeInteger ="-1";
		String greaterThan100 = "101";
		
		
		assertEquals(false,testedTodosList.isValidPercent(letter));
		assertEquals(true,testedTodosList.isValidPercent(integer));
		assertEquals(true,testedTodosList.isValidPercent(integer1));
		assertEquals(false,testedTodosList.isValidPercent(word));
		assertEquals(false,testedTodosList.isValidPercent(decimal));
		assertEquals(false,testedTodosList.isValidPercent(negativeInteger));
		assertEquals(false,testedTodosList.isValidPercent(greaterThan100));
	}

	@Test
	void testAddTodoToList() {
		Todo testTodo1 = new Todo (0);
		Todo testTodo2 = new Todo (1);
		Todo testTodo3 = new Todo (3);
		testedTodosList.addTodoToList(testTodo1);
		testedTodosList.addTodoToList(testTodo2);
		HashMap<Integer,Todo> todosMap = testedTodosList.getTodosMap();
		
		assertEquals(true, todosMap.containsValue(testTodo1));
		assertEquals(true, todosMap.containsValue(testTodo2));
		assertEquals(false, todosMap.containsValue(testTodo3));
	}

	@Test
	void testSelectTodo() {
		Todo testTodo1 = new Todo (0);
		Todo testTodo2 = new Todo (1);
		Todo testTodo3 = new Todo (2);
		
		testedTodosList.addTodoToList(testTodo1);
		testedTodosList.addTodoToList(testTodo2);
		testedTodosList.addTodoToList(testTodo3);
		
		assertEquals(testedTodosList.selectTodo(testTodo1.getId()), testTodo1);
		assertEquals(testedTodosList.selectTodo(testTodo2.getId()), testTodo2);
		assertEquals(testedTodosList.selectTodo(testTodo3.getId()), testTodo3);
		
		
	}

	@Test
	void testAlphabeticalSortTodos() {
		Todo testTodo1 = new Todo (0);
		testTodo1.setDescription("pears");
		Todo testTodo2 = new Todo (1);
		testTodo2.setDescription("apples");
		Todo testTodo3 = new Todo (2);
		testTodo3.setDescription("oranges");
		testedTodosList.addTodoToList(testTodo1);
		testedTodosList.addTodoToList(testTodo2);
		testedTodosList.addTodoToList(testTodo3);
		
		HashMap<String, Integer> tempMap = new HashMap<>();
		for(int key: testedTodosList.getTodosMap().keySet()) {
			tempMap.put(testedTodosList.getTodosMap().get(key).getDescription(), key);
		}
		
		Boolean sorted = false;
		
		
		List<String> sortedTodoList = testedTodosList.alphabeticalSortTodos(tempMap);
		
		String prevListItem = ""; 
		for (String listItem: sortedTodoList) {
		    if (listItem.compareTo(prevListItem) >= 0)
		        sorted=true;
		    prevListItem = listItem;
		}
		assertEquals(true,sorted);

				

	}

	
	@Test
	void testReverseAlphabeticalSortTodos() {
		Todo testTodo1 = new Todo (0);
		testTodo1.setDescription("pears");
		Todo testTodo2 = new Todo (1);
		testTodo2.setDescription("apples");
		Todo testTodo3 = new Todo (2);
		testTodo3.setDescription("oranges");
		testedTodosList.addTodoToList(testTodo1);
		testedTodosList.addTodoToList(testTodo2);
		testedTodosList.addTodoToList(testTodo3);
		
		HashMap<String, Integer> tempMap = new HashMap<>();
		for(int key: testedTodosList.getTodosMap().keySet()) {
			tempMap.put(testedTodosList.getTodosMap().get(key).getDescription(), key);
		}
		
		Boolean sorted = false;
		
		
		List<String> sortedTodoList = testedTodosList.reverseAlphabeticalSortTodos(tempMap);
		
		String prevListItem = ""; 
		for (String listItem: sortedTodoList) {
		    if (listItem.compareTo(prevListItem) < 0)
		        sorted=true;
		    prevListItem = listItem;
		}
		assertEquals(true,sorted);

			
	}
	/*
	@Test
	void testPrintingOutFilteredTodos() {
		fail("Not yet implemented");
	}

	@Test
	void testDateSortTodos() {
		fail("Not yet implemented");
	}*/

	@Test
	void testCheckDateFormat() {
		String validDateFormatandNumber = "10/23/2000";
		String randomInput= "#jfhs(3/df";
		String validDateFormatWithoutNumbers ="hn/#2/*jd8";
		String validDateFormatIncorrectLength = "9/23/2000";
		String validDateFormatIncorrectPuncuation = "09.23.2000";
		
		
		assertEquals(true,testedTodosList.checkDateFormat(validDateFormatandNumber));
		assertEquals(false,testedTodosList.checkDateFormat(validDateFormatWithoutNumbers));
		assertEquals(false,testedTodosList.checkDateFormat(randomInput));
		assertEquals(false,testedTodosList.checkDateFormat(validDateFormatIncorrectLength));
		assertEquals(false,testedTodosList.checkDateFormat(validDateFormatIncorrectPuncuation));
		
	}

	@Test
	void testIsNum() {
		
		String letter = "a";
		String integer = "15";
		String integer1 = "0";
		String word = "word";
		String decimal ="1.015";
		String negativeInteger ="-1";
		
		assertEquals(false,testedTodosList.isNum(letter));
		assertEquals(true,testedTodosList.isNum(integer));
		assertEquals(true,testedTodosList.isNum(integer1));
		assertEquals(false,testedTodosList.isNum(word));
		assertEquals(false,testedTodosList.isNum(decimal));
		assertEquals(true,testedTodosList.isNum(negativeInteger));
	}

	@Test
	void testDeleteTodos() {
		Todo testTodo1 = new Todo (0);
		testedTodosList.addTodoToList(testTodo1);
		assertEquals(true, testedTodosList.getTodosMap().containsValue(testTodo1));
		String input = String.valueOf(testTodo1.getId());
		testedTodosList.deleteTodos(input);
		assertEquals(false, testedTodosList.getTodosMap().containsValue(testTodo1));
		
		Todo testTodo2 = new Todo(1);
		testTodo2.setDescription("clean");
		testedTodosList.addTodoToList(testTodo2);
		assertEquals(true, testedTodosList.getTodosMap().containsValue(testTodo2));
		testedTodosList.deleteTodos(testTodo2.getDescription());
		assertEquals(false, testedTodosList.getTodosMap().containsValue(testTodo2));
		
	}

	@Test
	void testDeleteTodoByDescription() {		
		Todo testTodo2 = new Todo(1);
		testTodo2.setDescription("clean");
		testedTodosList.addTodoToList(testTodo2);
		assertEquals(true, testedTodosList.getTodosMap().containsValue(testTodo2));
		testedTodosList.deleteTodoByDescription(testTodo2.getDescription());
		assertEquals(false, testedTodosList.getTodosMap().containsValue(testTodo2));
	}

	@Test
	void testAddSubTodo() {
		Todo testTodo1 = new Todo (0);
		testedTodosList.addTodoToList(testTodo1);
		
		SubTodo testSubTodo1 = new SubTodo(0,testTodo1.getId());
		testedTodosList.addSubTodo(testTodo1, testSubTodo1);
		
		assertEquals(true,testTodo1.getSubTodoList().contains(testSubTodo1));
	}

	@Test
	void testCalculateTotalProgressOfSubTodos() {
		Todo testTodo1 = new Todo (0);
		testedTodosList.addTodoToList(testTodo1);
		
		SubTodo testSubTodo1 = new SubTodo(0,testTodo1.getId());
		testSubTodo1.setProgress("25%");
		SubTodo testSubTodo2 = new SubTodo(1,testTodo1.getId());
		testSubTodo2.setProgress("50%");
		SubTodo testSubTodo3 = new SubTodo(2,testTodo1.getId());
		testSubTodo3.setProgress("75%");
		
		testedTodosList.addSubTodo(testTodo1, testSubTodo1);
		testedTodosList.addSubTodo(testTodo1, testSubTodo2);
		testedTodosList.addSubTodo(testTodo1, testSubTodo3);

		assertEquals(50.0,testedTodosList.calculateTotalProgressOfSubTodos(testTodo1));
		
		testTodo1.deleteAllSubTodos();
		assertEquals(0.0,testedTodosList.calculateTotalProgressOfSubTodos(testTodo1));
		
		
		
		
	}


}
