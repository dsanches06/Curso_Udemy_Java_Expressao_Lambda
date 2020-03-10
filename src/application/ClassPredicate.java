package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Predicate;

import entities.Product;
import util.ProductPredicate;

public class ClassPredicate {

	public static void main(String[] args) {

		/**
		 * 
		 * INTERFACE FUNCIONAL - PREDICATE
		 * 
		 * interface funcional que implementa apenas o metodo = boolean test(Object o)
		 */

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// uso de predicate por implementação da interface
		list.removeIf(new ProductPredicate());

		// reference method com metodo estatico
		list.removeIf(Product::staticProductPredicate);

		// reference method com metodo não estatico
		list.removeIf(Product::nonStaticProductPredicate);

		// expressão lambda declarada
		double min = 100.0;
		
		Predicate<Product> pred = p -> p.getPrice() >= min;
		list.removeIf(pred);

		// expressão lambda inline
		list.removeIf(p -> p.getPrice() >= 100.0);

		// imprimir (função de primeira ordem)
		list.forEach(System.out::println);

	}

}
