package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Main {

	public static int compareProducts(Product p1, Product p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}

	public static void main(String[] args) {

		/**
		 * 
		 * EXPRESSOES LAMBDA
		 * 
		 * (função de primeira ordem) -> nome_da_class::_method static
		 */

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.0));
		list.add(new Product("Notebook", 1200.0));
		list.add(new Product("Tablet", 450.0));

		// ordenar (função de primeira ordem)
		list.sort(Main::compareProducts);

		// imprimir (função de primeira ordem)
		list.forEach(System.out::println);

		// Expressividade
		List<Integer> listNumbers = new ArrayList<>();

		listNumbers.add(2);
		listNumbers.add(4);
		listNumbers.add(5);
		listNumbers.add(3);
		listNumbers.add(1);

		// imprimir
		System.out.println();
		listNumbers.forEach(System.out::println);
		
		// calcular soma
		Integer sum = listNumbers.stream().reduce(0, Integer::sum);
		System.out.println("Sum: " + sum);

	}

}
