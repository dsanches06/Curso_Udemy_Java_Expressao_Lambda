package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamPepiline {

	public static void main(String[] args) {
		/**
		 *  PIPELINE
		 *  
		 *  São uso de operações intermediarias e terminais de uma stream
		 * 
		 * OPERAÇÕES INTERMEDIARIAS
		 * 
		 * • filter
		 * • map
		 * • flatmap
		 * • peek
		 * • distinct
		 * • sorted
		 * • skip
		 * • limit (*) -> usar para apanhar apenas os elementos precisos e depois termina
		 * 
		 * 
		 * OPERAÇÕES TERMINAIS
		 *  
		 * • forEach 
		 * • forEachOrdered
		 * • toArray 
		 * • reduce 
		 * • collect 
		 * • min 
		 * • max 
		 * • count 
		 * • anyMatch(*) 
		 * • allMatch (*) 
		 * • noneMatch (*) 
		 * • findFirst (*) 
		 * • findAny (*)
		 */
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
        
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		System.out.println(Arrays.toString(st1.toArray()));
		
		int sum = list.stream().reduce(0, (x, y) -> x + y);
		System.out.println("Resultado (x + y): " + sum);
		
		int mult = list.stream().reduce(1, (x, y) -> x * y);
		System.out.println("Resultado (x * y): " + mult);
		
		List<Integer> newList = list.stream()
				     .filter(x -> x % 2 == 0)
				     .map(x -> x * 10)
				     .collect(Collectors.toList());
		System.out.println(Arrays.toString(newList.toArray()));
		
		
		
		
	}
	
}
