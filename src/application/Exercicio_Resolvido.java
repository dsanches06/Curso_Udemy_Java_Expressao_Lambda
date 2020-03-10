package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Product;

public class Exercicio_Resolvido {

	public static String inputFolder = "C:\\Users\\Toshiba\\Downloads\\Curso Java COMPLETO\\55_Programacao_Funcional_Expressao_Lambda\\src\\application";

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file name: ");
		String path = inputFolder + "\\" + sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Product> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				list.add(new Product(fields[0], Double.parseDouble(fields[1])));
				line = br.readLine();
			}

			// uso de expressao lambda para calcular o preço medio
			double avg = list.stream().map(p -> p.getPrice()).reduce(0.0, (x, y) -> x + y) / list.size();
			System.out.println("Average Price: " + String.format("%.2f", avg));

			//comparar duas string independentemente da letra maiuscula ou minuscula
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			// obter a lista de nomes em menores que preco medio em ordem decrescente
			List<String> names = list.stream()
					// filtrar os produtos cujos preço < avg
					.filter(p -> p.getPrice() < avg)
					// mapeia e captura os nomes desses produtos filtrados
					.map(p -> p.getName())
					// ordenar em ordem decrescente usando comparator
					.sorted(comp.reversed())
					// agora é converter de stream para lista
					.collect(Collectors.toList());

			names.forEach(System.out::println);

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

}
