package org.coderwale.model;

import java.time.LocalDateTime;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

    @Getter
    public class Receipt {
        private String ref;
        private String customerName;
        private String cashierName;
        private String productName;
        private int price;
        private int quantity;
        private LocalDateTime date;

        public Receipt(String ref, String customerName, String cashierName, String productName, int price, int quantity, LocalDateTime date) {
            this.ref = ref;
            this.customerName = customerName;
            this.cashierName = cashierName;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
            this.date = date;
        }

        @Override
        public String toString() {
            return "Receipt Details:" + System.lineSeparator() +
                    "Reference: " + ref + System.lineSeparator() +
                    "Customer Name: " + customerName + System.lineSeparator() +
                    "Cashier Name: " + cashierName + System.lineSeparator() +
                    "Product Name: " + productName + System.lineSeparator() +
                    "Price: " + price + System.lineSeparator() +
                    "Quantity: " + quantity + System.lineSeparator() +
                    "Date: " + date;
        }


        public int getReference() {
            return 0;
        }

        public int getProductPrice() {
            return 0;
        }
    }


