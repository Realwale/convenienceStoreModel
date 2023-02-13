package org.coderwale.model;

import lombok.Getter;
import lombok.Setter;
import org.coderwale.exceptions.AppException;
import org.coderwale.storeRepo.CashierRepo;
import org.coderwale.storeRepo.ProductRepo;
import org.coderwale.storeRepo.ReceiptRepo;

import java.time.LocalDateTime;
import java.util.List;


    @Getter
    @Setter
    public class Cashier extends Staff{

        //field dependency injection
        private final ProductRepo productRepo;
        private final ReceiptRepo receiptRepo;
        private final CashierRepo cashierRepo;


        private int noOfQueries;
        static final int MaxQuery = 10;

        public Cashier(String name, String address, int age, String id, ProductRepo productRepo, ReceiptRepo receiptRepo, CashierRepo cashierRepo) {
            super(name, address, age, id);
            this.productRepo = productRepo;
            this.receiptRepo = receiptRepo;
            this.cashierRepo = cashierRepo;
        }

    public Cashier(String name, String address, int age, String id, ProductRepo productRepo, ReceiptRepo receiptRepo, CashierRepo cashierRepo, ProductRepo productRepo1, ReceiptRepo receiptRepo1, CashierRepo cashierRepo1) {
            super(name, address, age, id, productRepo, receiptRepo, cashierRepo);
        this.productRepo = productRepo1;
        this.receiptRepo = receiptRepo1;
        this.cashierRepo = cashierRepo1;
    }

    public boolean isCashierAvailable() throws AppException {
            if (cashierRepo.getList().size() == 0) {
                throw new AppException("No cashier to attend to order");
            }
            return true;
        }

        public String sell (String productName, String customerName, int qty) throws AppException{
            isCashierAvailable();
            Product product = productRepo.findByName(productName);
            if (product == null){
                throw new AppException(productName + " IS OUT OF STOCK");
            }
            int rem = product.getQuantity() - qty;
            if ( rem >= 0 ){

                //String ref = "Ref_"+ receiptRepo.getList().size()+1;
                String ref = "Ref_" + (receiptRepo.getList().size() + 1);
                Receipt receipt = new Receipt(ref, customerName, this.getName(), product.getName(), product.getPrice(), product.getQuantity(), LocalDateTime.now());
                receiptRepo.save(receipt);
                if (rem == 0){
                    productRepo.delete(product.getName());
                    return ref;
                }
                product.setQuantity(rem);
                productRepo.save(product);
                return ref;
            }
            throw new AppException("This order can't be completed " + product.getQuantity() + " " + product.getName()+ " available");
        }

        //method overloading
        public Receipt printReceipt (String ref) throws AppException {
            isCashierAvailable();
            Receipt receipt = receiptRepo.getByRef(ref);
            System.out.println(receipt);
            return receipt;
        }

        public List<Receipt> printReceipt () throws AppException {
            isCashierAvailable();
            List<Receipt> receiptList = receiptRepo.getList();
            //generateCsv( receipt )
            isCashierAvailable();
            csvDownloader.downloadReceiptsToCsv(receiptList);
            for (Receipt receipt: receiptList) {
                System.out.println(receipt);
            }
            return receiptList;
        }

//        for (Receipt receipt: receiptList) {
//            System.out.println(receipt);
//        }
//        return receiptList;

        @Override
        public String toString() {
            return "Cashier{" +
                    "name=" + super.getName()+
                    ", address=" + super.getAddress()+
                    ", id=" + super.getId()+
                    ", noOfQueries=" + noOfQueries +
                    '}';
        }
    }


