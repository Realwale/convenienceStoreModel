package org.coderwale;

import org.coderwale.exceptions.AppException;
import org.coderwale.model.*;
import org.coderwale.storeRepo.CashierRepo;
import org.coderwale.storeRepo.ProductRepo;
import org.coderwale.storeRepo.ReceiptRepo;
import org.coderwale.storeRepo.StaffRepo;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ProductRepo productRepo = new ProductRepo();
        ReceiptRepo receiptRepo = new ReceiptRepo();
        StaffRepo staffRepo = new StaffRepo();
        CashierRepo cashierRepo = new CashierRepo(productRepo, receiptRepo);

        Manager manager = new Manager("Wale", "Address", 14, "manager", staffRepo, cashierRepo, productRepo);
        manager.addProduct("Cocacola", ECategory.BEVERAGES, 200, 1000);
        manager.addProduct("Eva", ECategory.WINES, 800, 500);
        Person applicant = new Person("Agbosh", "address", 23);
        Person customer1 = new Person("Dunsin");
        Person customer2 = new Person("Ebuka");
        Cashier cashier = manager.hire(applicant, ERole.CASHIER);

        try {
            String ref1 = cashier.sell("Eva", customer1.getName(), 30);
            cashier.printReceipt(ref1);
        }
        catch (AppException.appException e){
            System.out.println(e.getMessage());
        } catch (AppException e) {
            throw new RuntimeException(e);
        }

        try {
            String ref2 = cashier.sell("Eva", customer2.getName(), 100);
            cashier.printReceipt(ref2);
            List<Receipt>receipts = new ArrayList<>();
            csvDownloader.downloadReceiptsToCsv(receipts);
        }catch (AppException e){
            System.out.println(e.getMessage());
        }

        try {
            String ref3 = cashier.sell("Cocacola", customer2.getName(), 10);
            cashier.printReceipt(ref3);
            List<Receipt>receipts = new ArrayList<>();
            csvDownloader.downloadReceiptsToCsv(receipts);
        }catch (AppException e){
            System.out.println(e.getMessage());
        }

        cashier.setNoOfQueries(20);
        manager.fire(cashier.getId());
        try {
            cashier.sell("Cocacola", customer2.getName(), 240);

        }catch (AppException e){
            System.out.println(e.getMessage());
        }
    }
}



