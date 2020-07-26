package application;

import java.text.DateFormat;
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

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner scanner = new Scanner(System.in);
		List<Product> product = new ArrayList<>();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		Product suporte;
		
		System.out.print("Enter the number of product:  ");
		int n = scanner.nextInt();
		
		for(int i = 0; i < n; i++) {
			System.out.println("Product #" + (i+1) + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char situation = scanner.next().charAt(0);
			System.out.print("Name: ");
			scanner.nextLine();
			String name = scanner.nextLine();
			System.out.print("Price: $");
			Double price = scanner.nextDouble();
			scanner.nextLine();
			
			if(situation == 'c') {
				suporte = new Product(name, price);
				product.add(suporte);
			}
			
			else if(situation == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date  manufactureDate = formato.parse(scanner.nextLine());
				suporte = new UsedProduct(name, price, manufactureDate);
				product.add(suporte);
			}
			else if(situation == 'i') {
				System.out.print("Custom fee: $");
				Double customsFee = scanner.nextDouble();
				suporte = new ImportedProduct(name, price, customsFee);
				product.add(suporte);
			}
		}
		System.out.println();
		
		System.out.println("Price Tags: ");
		for(Product x : product) {
			System.out.println(x.priceTag());
		}
		scanner.close();
		
	}

}
