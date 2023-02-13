package org.coderwale.model;

import org.coderwale.storeRepo.CashierRepo;
import org.coderwale.storeRepo.ProductRepo;
import org.coderwale.storeRepo.StaffRepo;

    public class Manager extends Staff{

        //constructor dependency injection... an example of composition
        private static StaffRepo staffRepo;
        private static CashierRepo cashierRepo;
        private static ProductRepo productRepo;

        public Manager(String name, String address, int age, String id, StaffRepo staffRepo, CashierRepo cashierRepo, ProductRepo productRepo) {
            super(name, address, age, id);
            Manager.staffRepo = staffRepo;
            Manager.cashierRepo = cashierRepo;
            Manager.productRepo = productRepo;
        }

        //generics
        public <T> T hire(Person person, ERole role) {
            Staff staff = staffRepo.save(person);
            if (staff != null) {

                if (role == ERole.CASHIER) {
                    return (T) cashierRepo.save(staff);
                }
            }
            return null;
        }

        public Staff fire (String staffId) {
            Cashier cashier = cashierRepo.findByID(staffId);
            if (cashier.getNoOfQueries() >= Cashier.MaxQuery){
                cashierRepo.delete(cashier.getId());
                return cashier;
            }
            return null;
        }

        public Product addProduct(String name, ECategory category, int price, int qty){
            Product product = productRepo.findByName(name);
            if (product != null) {
                qty += product.getQuantity();
            }else {
                product = new Product(name, category, price, qty);
            }
            return productRepo.save(product);
        }
    }
