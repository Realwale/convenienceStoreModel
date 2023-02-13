package org.coderwale.model;

import lombok.Getter;
import lombok.Setter;
import org.coderwale.storeRepo.CashierRepo;
import org.coderwale.storeRepo.ProductRepo;
import org.coderwale.storeRepo.ReceiptRepo;

@Getter
    @Setter
    public class Staff extends Person{

        private String id;

        // Inheritance: Staff inheriting the properties of Person

        public Staff(String name, String address, int age, String id, ProductRepo productRepo, ReceiptRepo receiptRepo, CashierRepo cashierRepo) {
                super(name, address, age);
                this.id = id;
        }

    public Staff(String name, String address, int age, String id) {
        super(name, address, age);
    }

//    public Staff(String name, String address, int age, String id) {
//        super(name, address, age, id);
//        this.id;
//    }
}

