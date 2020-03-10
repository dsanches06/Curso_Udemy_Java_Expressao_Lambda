package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;

import entities.Product;
import util.PriceUpdate;

public class ClassConsumer {

	public static void main(String[] args) {

		/**
		 * 
		 * INTERFACE FUNCIONAL - CONSUMER
		 * 
		 * interface funcional que implementa apenas o metodo = void accept(Object o)
		 */

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// uso de consumer por implementação da interface
		list.forEach(new PriceUpdate());

		// reference method com metodo estatico
		list.forEach(Product::staticPriceUpdate);

		// reference method com metodo não estatico
		list.forEach(Product::noStaticPriceUpdate);

		// expressão lambda declarada
		double factor = 1.1;

		Consumer<Product> cons = p -> p.setPrice(p.getPrice() * factor);
		list.forEach(cons);

		// expressão lambda inline
		list.forEach(p -> p.setPrice(p.getPrice() * factor));

		// imprimir (função de primeira ordem)
		list.forEach(System.out::println);

	}
}
