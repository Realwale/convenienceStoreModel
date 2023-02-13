package org.coderwale.model;

import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class Product {
        private String name;
        private ECategory category;
        private int price;
        private int quantity;

        public Product(String name, ECategory category, int price, int quantity) {
            this.name = name;
            this.category = category;
            this.price = price;
            this.quantity = quantity;
        }

        }


