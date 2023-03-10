package com.example.product.service;

import com.example.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final List<Product> products;

    public ProductService() {
        //tạo list ảo chứa đối tượng tương tác, sau sẽ thêm Db xử lý
        //id được xử lý tăng tự động khi tạo mới, tương đương với Db sau này
        products = new ArrayList<>();
        products.add(new Product(1,"Coca-cola", 8000D, 50));
        products.add(new Product(2,"Sting", 7000D, 110));
        products.add(new Product(3,"Pepsi", 7000D, 65));
    }

    public List<Product> findAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId()== id ) {
                return product;
            }
        }
        return null;
    }

    public void createProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                int id = products.indexOf(p);
                products.set(id, product);
            }
        }
    }

    public void deleteProduct(int id) {
        Product product = findById(id);
        if (product != null) {
            products.remove(product);
        }
    }
}
