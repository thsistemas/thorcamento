package com.thsistemas.orcamento.tests;

import com.thsistemas.orcamento.dto.ProductDTO;
import com.thsistemas.orcamento.entities.Category;
import com.thsistemas.orcamento.entities.Product;
import java.time.Instant;

public class Factory {

    public static Product createProduct(){
        Product product = new Product(1L, "Phone", "Good Phone", 800.0, "https://img.com/img.png", Instant.parse("2020-07-13T20:50:07.12345Z"));
        product.getCategories().add(new Category(2L, "ELETRONICOS HD"));
        return product;
    }

    public static ProductDTO createProductDTO(){
        Product product = createProduct();
        return new ProductDTO(product, product.getCategories());
    }
}
