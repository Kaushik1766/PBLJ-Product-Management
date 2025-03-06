package com.kaushik.products.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.kaushik.products.models.Product;
import com.kaushik.products.repository.CategoryRepository;
import com.kaushik.products.repository.OrderItemRepository;
import com.kaushik.products.repository.ProductRepository;
import com.kaushik.products.repository.PurchaseOrderRepository;
import com.kaushik.products.repository.SupplierRepository;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product name");
        String name = sc.nextLine();
        System.out.println("enter product price");
        double price = sc.nextDouble();
        System.out.println("enter product quantity");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("enter product description");
        String description = sc.nextLine();
        sc.close();
        Product product = new Product(name, description, price, quantity);
        productRepository.save(product);
    }

    public void listProducts() throws Exception {
        List<Product> products = productRepository.findAll();
        for (Product pr : products) {
            System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getQuantity());
        }
    }

    public void updateProduct() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product id");
        String id = sc.nextLine();
        System.out.println("enter product name");
        String name = sc.nextLine();
        System.out.println("enter product price");
        double price = sc.nextDouble();
        System.out.println("enter product quantity");
        int quantity = sc.nextInt();
        sc.nextLine();
        System.out.println("enter product description");
        String description = sc.nextLine();
        sc.close();
        Product product = new Product(name, description, price, quantity);
        product.setId(id);
        productRepository.save(product);
    }

    public void deleteProduct() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product id");
        String id = sc.nextLine();
        sc.close();
        productRepository.deleteById(id);
    }

    public void getProductById() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product id");
        String id = sc.nextLine();
        sc.close();
        Product product = productRepository.findById(id).orElseThrow();
        System.out.println(
                product.getId() + " " + product.getName() + " " + product.getPrice() + " " + product.getQuantity());
    }

    public void getProductByName() throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product name");
        String name = sc.nextLine();
        sc.close();
        List<Product> products = productRepository.findByName(name);
        for (Product pr : products) {
            System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getQuantity());
        }
    }
}
