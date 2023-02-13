package org.coderwale.storeRepo;

import org.coderwale.model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReceiptRepo {
    private final List<Receipt> list;
    public ReceiptRepo() {
        this.list = new ArrayList<>();
    }
    public Receipt save(Receipt receipt){
        list.add(receipt);
        return receipt;
    }
    public Receipt getByRef(String ref){
        for (Receipt receipt: list){
            if (Objects.equals(receipt.getRef(), ref)){
                return receipt;
            }
        }
        return null;
    }
    // exception where all receipts of a particular products might be requested.
    public List<Receipt> getByProductName(String name){
        List<Receipt> receipts = new ArrayList<>();
        for (Receipt receipt: list){
            if (Objects.equals(receipt.getProductName(), name)){
                receipts.add(receipt);
            }
        }
        return receipts;
    }

    public List<Receipt> getList() {
        return list;
    }
}
