package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List<Product> product = new ArrayList<>();

		System.out.print("Enter the number of products: ");
		int productNumbers = sc.nextInt();

		for (int i = 0; i < productNumbers; i++) {

			System.out.println("Product #" + (i + 1) + " data:");
			System.out.print("Common, used or imported? (c/u/i)");
			char type = sc.next().charAt(0);
			System.out.print("Name: ");
			String name = sc.next();
			System.out.print("Price: ");
			Double price = sc.nextDouble();

			if (type == 'u') { // Checando se é usado
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(sc.next());

				product.add(new UsedProduct(name, price, manufactureDate));
			} else if (type == 'c') { // Checando se é comum

				product.add(new Product(name, price));
			} else if (type == 'i') { // Checando se é importado
				System.out.print("Customs Fee: ");
				Double customsFee = sc.nextDouble();

				product.add(new ImportedProduct(name, price, customsFee));
			} else { // Usuário digitou errado
				System.out.println("Tipo do produto digitado incorretamente, o programa será encerrado.");
			}

		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		for (Product c : product) {
			System.out.print(c.priceTag());
		}


		sc.close();

	}

}
