package org.coderwale.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class csvDownloader {
    public static void downloadReceiptsToCsv(List<Receipt> receipts) {
        String fileName = "receipts.csv";

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.append("Reference").append(',')
                    .append("Customer Name").append(',')
                    .append("Cashier Name").append(',')
                    .append("Product Name").append(',')
                    .append("Product Price").append(',')
                    .append("Quantity").append(',')
                    .append("Date").append('\n');

            for (Receipt receipt : receipts) {
                writer.append((char) receipt.getReference()).append(',')
                        .append(receipt.getCustomerName()).append(',')
                        .append(receipt.getCashierName()).append(',')
                        .append(receipt.getProductName()).append(',')
                        .append(String.valueOf(receipt.getProductPrice())).append(',')
                        .append(String.valueOf(receipt.getQuantity())).append(',')
                        .append(receipt.getDate().toString()).append('\n');
            }

            System.out.println("Downloaded receipts to CSV file successfully!!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

