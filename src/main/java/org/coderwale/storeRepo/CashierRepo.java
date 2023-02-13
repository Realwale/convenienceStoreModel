package org.coderwale.storeRepo;

import lombok.Getter;
import org.coderwale.model.Cashier;
import org.coderwale.model.Staff;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


    @Getter
    public class CashierRepo{
        private final List<Cashier> list;
        private final ProductRepo productRepo;
        private final ReceiptRepo receiptRepo;

        public CashierRepo(ProductRepo productRepo, ReceiptRepo receiptRepo) {
            this.productRepo = productRepo;
            this.receiptRepo = receiptRepo;
            this.list = new ArrayList<>();
        }

        public Staff save(Staff staff){
            Cashier cashier = new Cashier(staff.getName(), staff.getAddress(), staff.getAge(), staff.getId(), productRepo, receiptRepo, this);
            list.add(cashier);
            return cashier;
        }


        public Cashier delete(String id){
            Cashier staff = findByID(id);
            if (staff != null ){
                list.remove(staff);
                return staff;
            }
            return null;
        }


        public Cashier findByID(String id){
            for (Cashier staff: list){
                if (Objects.equals(staff.getId(), id)){
                    return staff;
                }
            }
            return null;
        }
    }

