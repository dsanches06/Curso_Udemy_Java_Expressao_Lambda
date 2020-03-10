package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;
import java.util.stream.Collectors;

import entities.Product;
import util.UpperCaseName;

public class ClassFunction {

	public static void main(String[] args) {

		/**
		 * 
		 * INTERFACE FUNCIONAL - FUNCTION <T, R>
		 * 
		 * interface funcional que implementa apenas o metodo = R apply(T t)
		 * 
		 * converter de list para stream -> list.stream()
		 * 
		 * converter de stream para list -> collect(Collectors.toList())
		 * 
		 * usa o stream().map para aplicar a função para todos os elementos da lista
		 */

		Locale.setDefault(Locale.US);
		List<Product> list = new ArrayList<>();

		list.add(new Product("Tv", 900.00));
		list.add(new Product("Mouse", 50.00));
		list.add(new Product("Tablet", 350.50));
		list.add(new Product("HD Case", 80.90));

		// lista nula
		List<String> names = null;

		// uso de consumer por implementação da interface
		names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());

		// reference method com metodo estatico
		names = list.stream().map(Product::staticUpperCaseName).collect(Collectors.toList());

		// reference method com metodo não estatico
		names = list.stream().map(Product::nonStaticUpperCaseName).collect(Collectors.toList());

		// expressão lambda declarada
		Function<Product, String> func = p -> p.getName().toUpperCase();
		names = list.stream().map(func).collect(Collectors.toList());
		
		// expressão lambda inline
		names = list.stream().map(p -> p.getName().toUpperCase()).collect(Collectors.toList());
		
		// imprimir (função de primeira ordem)
		names.forEach(System.out::println);

	}
}
