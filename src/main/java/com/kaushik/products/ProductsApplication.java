package com.kaushik.products;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.kaushik.products.service.ProductService;

@SpringBootApplication
public class ProductsApplication {

	private final ProductService productService;

	@Autowired
	public ProductsApplication(ProductService productService) {
		this.productService = productService;
	}

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(ProductsApplication.class, args);
		ProductsApplication app = context.getBean(ProductsApplication.class);
		app.crud();
	}

	public void crud() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. add product");
			System.out.println("2. delete product");
			System.out.println("3. list products");
			System.out.println("4. get product by id");
			System.out.println("5. update product");
			System.out.println("6. get product by name");
			System.out.println("7. exit");

			int choice = sc.nextInt();
			switch (choice) {
				case 1:
					productService.addProduct();
					break;
				case 2:
					productService.deleteProduct();
					break;
				case 3:
					productService.listProducts();
					break;
				case 4:
					productService.getProductById();
					break;
				case 5:
					productService.updateProduct();
					break;
				case 6:
					productService.getProductByName();
					break;
				default:
					System.out.println("exiting");
					break;
			}
			sc.nextLine();
		}
	}

}
