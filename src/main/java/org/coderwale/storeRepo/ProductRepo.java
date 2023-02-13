package org.coderwale.storeRepo;

import org.coderwale.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private final List<Product> list;

    public ProductRepo() {
        this.list = new ArrayList<>();
    }

    public Product save (Product product){
        list.add(product);
        return product;
    }
    public Product delete(String name){
        Product product = findByName(name);
        if (product != null ){
            list.remove(product);
            return product;
        }
        return null;
    }

    public Product findByName(String name){
        for (Product product: list) {
            if (product.getName() == name){
                return product;
            }
        }
        return null;
    }

}

