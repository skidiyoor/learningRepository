package learningRepository;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapCollection {
  // A map contains values on the basis of key, i.e. key and value pair. Each key and value pair is known as an entry. A Map contains unique keys.
  // Map is not a true collection (Separate branch in collection framework)
  // A Map doesn't allow duplicate keys, but you can have duplicate values.
  
  /* 3 classes that implement Map interface
   * 1) HashMap       : Doesn't maintain order   (allow null keys and values) ( If you try to insert duplicate key, it will replace the element of the corresponding key.)        
   * 2) LinkedHashMap : Maintain insertion Order (allow null keys and values)         
   * 3) TreeMap       : Sorted map (ascending)   (doesn't allow null keys ) 
   *
				     Map                   |   Get & Put   | ContainsKey |   Next   | Data Structure
					 ----------------------|---------------|-------------|----------|-------------------------
				     HashMap               | O(1)          |   O(1)      | O(h / n) | Hash Table
				     LinkedHashMap         | O(1)          |   O(1)      | O(1)     | Hash Table + Linked List
				     TreeMap               | O(log n)      |   O(log n)  | O(log n) | Red-black tree
  */
	
	public static void main(String[] args) {
		
	//1.Creating MAP
		
		// a. HashMap
			Map<Integer,String> employeeHashMap = new HashMap<>();
			
			Map<Number,Number> x1=new HashMap<>();
			x1.put(1, 1);
			x1.put(2.2, 2);
			x1.put(1.3f, 1);
			
			x1.entrySet()
			 .stream()
			 .forEach(System.out::println);
		
		//b.LinkedHashMap
			Map<Integer,String> employeeLinkedMap = new LinkedHashMap<>();
		
		//b.TreeMap
			Map<Integer,String> employeeTreeMap = new TreeMap<>();
		
	//2. Add (key,value) pair
		
		// PUT
			employeeHashMap.put(100, "Chris");
			employeeHashMap.put(101, "Shubha");
			employeeHashMap.put(102, "Aswathi");
		
	    // PUTIFABSENT - if absent add value and returns null. if not absent return value part
			String b= employeeHashMap.putIfAbsent(103, "Alex");
		
		// PUTALL
			employeeLinkedMap.putAll(employeeHashMap);
		
			/*Collection<String> set=employeeLinkedMap.values();
			set.forEach(System.out::println);*/
	
	//3. Get value associated with specific key
		
			String name= employeeHashMap.get(102);		
		
	//4. Check if map cointains a key/value - Case sensitive
	
			boolean b1= employeeHashMap.containsKey(100);
		
			boolean b2= employeeHashMap.containsValue("Shubha");
		
	//5. Remove a key,value pair if present. Return value field or null if not present
		
			String name3=employeeHashMap.remove(103);  //return "Alex"
		
			boolean removed= employeeHashMap.remove(104, "john"); //return false
		
    //6. Replace value for a key
		
		//a
			employeeHashMap.replace(102, "janvi"); //replace aswathi with janvi
			employeeHashMap.replace(101, "Shubha", "vishnu"); // give old value and new value
			
		//b.
			employeeHashMap.replaceAll((k,x)->x.toUpperCase()); // apply the lamda function to each value 
		
   //7. size of map
		
			int size= employeeHashMap.size();
		
   //8. check if Map is empty
		
			boolean emplyOrNot= employeeHashMap.isEmpty();
	
   //9. Iterating 
		
		// a) keySet
		
			Set<Integer> s=employeeHashMap.keySet();
			Iterator<Integer> itr=s.iterator();
			
			//itr.forEachRemaining(System.out::println);   
			
			while(itr.hasNext())
			{
				itr.next();
				//System.out.println(itr.next());
			}
		
		// b) values
		
			Collection<String> val=employeeHashMap.values();
			//val.forEach(System.out::println);
			
	   // c)EntrySet	
			
			Set<Map.Entry<Integer, String>> setEntry = employeeHashMap.entrySet();
			//setEntry.forEach(entryval->System.out.println(entryval.getKey()+":"+entryval.getValue()));
	
	//10. Emptying Map	
			employeeLinkedMap.clear();
			
	/*
	 * To make thread safe map, use Collections.synchronizedMap
	 * Map<Integer, String> map = Collections.synchronizedMap(new HashMap<>());
	 *      For sorted maps
	 * Map<Integer, String> map = Collections.synchronizedSortedMap(new TreeMap<>());
	*/
			
	// Methods of Map.Entry
	// 1) comparingByKey() and comparyByKey(Comparator)
			
			employeeTreeMap.putAll(employeeHashMap);
			
			employeeTreeMap.entrySet()
			               .stream()
			               .sorted(Map.Entry.comparingByKey())
			               .forEach(System.out::println);
			
			employeeTreeMap.entrySet()
			               .stream()
			               .sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
			               .forEach(System.out::println);
			
	//2) comparingByValue and comparingByValue(comparator)
			
			employeeTreeMap.entrySet()
			               .stream()
			               .sorted(Map.Entry.comparingByValue())
			               .forEach(System.out::println);
			
			
			employeeTreeMap.entrySet()
			               .stream()
			               .sorted(Map.Entry.comparingByValue((s1,s2)->s2.length()-s1.length()))
			               .forEach(System.out::println);
			
	//Some more methods
			//11)compute - it remap the values based on the function provided, only for the specified key
				employeeHashMap.compute(101, (k,v)->(v!=null)?v.concat(" BRE"):null);
				employeeHashMap.entrySet()
				               .stream()
				               .forEach(System.out::println);
				
			//12)computeIfPresent and computeIfAbsent
				employeeHashMap.computeIfAbsent(103, (k)->(k!=null)?100+k.toString():200+k.toString());
				employeeHashMap.entrySet()
				               .stream()
				               .forEach(System.out::println);
				
				employeeHashMap.computeIfPresent(102, (k,v)->(v!=null)?v.concat(" BREGROUP"):null);
				employeeHashMap.entrySet()
				               .stream()
				               .forEach(System.out::println);
	}

}
