package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ClassStream {

	public static void main(String[] args) {

		/**
		 * 
		 * INTERFACE FUNCIONAL - STREAM
		 * 
		 * é uma sequencia de elementos advinda de uma fonte de dados que oferece
		 * suporte a "operaçoes agregadas"
		 * 
		 * fontes de dados tipo: collecões, array, iteradores, recurso E/S
		 * 
		 * converter de list para stream -> list.stream()
		 * 
		 * converter de stream para list -> Collect(Collectors.toList())
		 * 
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

		// criar uma stream apartir de uma colleção
		Stream<Integer> str0 = list.stream();
		// imprimir uma stream convertido para array
		System.out.println(Arrays.toString(str0.toArray()));

		// criar uma stream com map
		Stream<Integer> str1 = list.stream().map(x -> x * 10);
		// imprimir uma stream convertido para array
		System.out.println(Arrays.toString(str1.toArray()));

		// criar uma stream apartir de Stream.of()
		Stream<String> str2 = Stream.of("Maria", "Bob", "Alex");
		// imprimir uma stream convertido para array
		System.out.println(Arrays.toString(str2.toArray()));

		// criar uma stream apartir de Stream.of()
		Stream<Integer> str3 = Stream.iterate(0, x -> x + 2);
		// imprimir uma stream convertido para array
		System.out.println(Arrays.toString(str3.limit(10).toArray()));
		
		// criar uma stream apartir de Stream.of()
		Stream<Long> str4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[] {p[1], p[0] + p[1]}).map(p -> p[0]);
		//imprimir uma stream convertido para array
		System.out.println(Arrays.toString(str4.limit(20).toArray()));
	}
}
