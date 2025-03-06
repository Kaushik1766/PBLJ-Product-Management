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

    public void addProduct() {
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
        try {
            productRepository.save(product);
        } catch (Exception e) {
            System.out.println("error while saving product");
        }
    }

    public void listProducts() {
        try {
            List<Product> products = productRepository.findAll();
            for (Product pr : products) {
                System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("error while fetching products");
        }
    }

    public void updateProduct() {
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
        try {
            productRepository.save(product);
        } catch (Exception e) {
            System.out.println("error while updating product");
        }
    }

    public void deleteProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product id");
        String id = sc.nextLine();
        sc.close();
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error while deleting product");
        }
    }

    public void getProductById() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product id");
        String id = sc.nextLine();
        sc.close();
        try {
            Product product = productRepository.findById(id).orElseThrow();
            System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice() + " "
                    + product.getQuantity());
        } catch (Exception e) {
            System.out.println("error while fetching product");
        }
    }

    public void getProductByName() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter product name");
        String name = sc.nextLine();
        sc.close();
        try {
            List<Product> products = productRepository.findByName(name);
            for (Product pr : products) {
                System.out.println(pr.getId() + " " + pr.getName() + " " + pr.getPrice() + " " + pr.getQuantity());
            }
        } catch (Exception e) {
            System.out.println("error while fetching product");
        }
    }
}
