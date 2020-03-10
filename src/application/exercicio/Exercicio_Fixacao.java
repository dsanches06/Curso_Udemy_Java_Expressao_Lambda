package application.exercicio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Person;

public class Exercicio_Fixacao {

	public static String inputFolder = "C:\\Users\\Toshiba\\Downloads\\Curso Java COMPLETO\\55_Programacao_Funcional_Expressao_Lambda\\src\\application\\exercicio";

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file name: ");
		String path = inputFolder + "\\" + sc.nextLine();

		System.out.print("Enter salary: ");
		double salary = sc.nextDouble();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			List<Person> list = new ArrayList<>();

			String line = br.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				list.add(new Person(fields[0], fields[1], Double.parseDouble(fields[2])));
				line = br.readLine();
			}

			System.out.println("Email of people whose salary is more than " + String.format("%.2f", salary) + ":");

			// usar um comparador
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());

			// obter a lista emails de pessoas com salary maior que (input) salary
			List<String> emails = list.stream().filter(p -> p.getSalary() > salary).map(p -> p.getEmail()).sorted(comp)
					.collect(Collectors.toList());
			// imprimir
			emails.forEach(System.out::println);

			// soma de salarios das pessoas cujo nome inicia com M
			double sum = list.stream().filter(p -> p.getName().charAt(0) == 'M').map(p -> p.getSalary()).reduce(0.0,
					(x, y) -> x + y);
			System.out.println("Sum of people whose name starts with 'M' : " + String.format("%.2f", sum));

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
