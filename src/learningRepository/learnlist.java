package learningRepository;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class learnlist {

	
	public static void main(String[] args) {
		/*
		 * 1. https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html
		 * 2. https://medium.com/@malith.jayasinghe/a-performance-evaluation-of-java-arraylist-f097582b5c4d
		 */
		//1. DECLARING LISTS
		//>>ArrayList  quick example:
		List<String> listStrings = new ArrayList<String>();
		listStrings.add("One");
		listStrings.add("Two");
		listStrings.add("Three");
		listStrings.add("Four");
		System.out.println(listStrings);
		
		//>>LinkedList  quick example:
		List<String> linkedListStrings = new LinkedList<String>();
		linkedListStrings.add("Five");
		linkedListStrings.add("Six");
		linkedListStrings.add("Seven");
		linkedListStrings.add("Eight");
		System.out.println(linkedListStrings);
		
		//2.CREATING A NEW LIST
		//>>It’s a good practice to declare a list instance with a generic type parameter, for example:
		List<Object> listAnything = new ArrayList<Object>();
		List<String> listWords = new ArrayList<String>();
		//List<Integer> listNumbers = new ArrayList<Integer>();
		//List<String> linkedWords = new LinkedList<String>();
		
		//>>Since Java 7, we can remove the type parameter on the right side as follows:
		//>>The compiler is able to infer the actual type parameter from the declaration on the left side.
		List<Integer> listNumbers = new ArrayList<>();
		List<String> linkedWords = new LinkedList<>();	
		
		//>>Since Java 9, you can create a List collection from a fixed set of elements by using the factory method 
		//>>Note that the List collection returned by the List.of() factory method is immutable - meaning that you can’t
		//>>add more elements to it.
		
		//List<Integer> listOfNumbers = List.of(1, 2, 3, 4, 5, 6);
			
		//>>Since Java 10, you can shorten the declaration of a List collection by using the var reserved word like this:v
		//>>The compiler can infer the type of the variable on the left based on the object type on the right side. And var can be used to declare local variables only
		
		//var employees = new ArrayList<Employee>();
		
		//>>When creating a new ArrayList using the empty constructor, the list is constructed with an initial capacity of ten. If you are sure how many elements will be added to the list, it’s recommended to specify a capacity which is large enough. 
		//>>refer to link no.2 above
		
		//List<Integer> listNumbers = new ArrayList<>(1000);
		
		//3. Basic List operations: adding, retrieving, updating, removing elements
		//>>The methods add(Object), add(index, Object) and addAll() are used to add elements to the list.
		//>>Adding elements of sub types of the declared type:

		List<Number> linkedNumbers = new LinkedList<>();
		linkedNumbers.add(new Integer(123));
		linkedNumbers.add(new Float(3.1415));
		linkedNumbers.add(new Double(299.988));
		linkedNumbers.add(new Long(67000));
		
		//>>That inserts the String “Four” at the 2nd position in the list.
		listStrings.add(1, "Four");
		
		//>>We can also add all elements of an existing collection to the end of the list:
		listStrings.addAll(listWords);
		
		//>>Or add the elements to the list at a specified position:
		listStrings.addAll(2, listWords);
		
		String element = listStrings.get(1);
		Number number = linkedNumbers.get(3);

		
		
	
	
	
	
	}



}
