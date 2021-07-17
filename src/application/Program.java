package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		
		Scanner sc = new Scanner(System.in);
		List<Product> listProduct = new ArrayList<>();
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1 ; i<=n ; i++) {
			
			System.out.println("Product #" + i + " data:");
 			System.out.print("Commom, used or imported (c/u/i)? ");
 			char typeProduct = sc.next().charAt(0);
 			sc.nextLine();
 			System.out.print("Name:");
			String name = sc.nextLine();
			System.out.print("Price:");
			double price = sc.nextDouble();
			
 			if (typeProduct == 'c') {
 								
 				
 				listProduct.add(new Product(name,price));
 			}
 			
 			else if (typeProduct == 'i') {
 				System.out.print("Customs fee: ");
 				double customsFee = sc.nextDouble();
 				listProduct.add(new ImportedProduct(name, price, customsFee));
 			}
 			
 			else {
 				System.out.print("Manufacture date: ");
 				Date d1 = sdf1.parse(sc.next());
 				listProduct.add(new UsedProduct(name, price, d1));
 			}
		}
			
		System.out.println("PRICE TAGS: ");
		for (Product p : listProduct) {
				
		System.out.println(p.priceTag());
			
		}
		
		
		sc.close();
	
	}

}
