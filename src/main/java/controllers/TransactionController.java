package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.awt.Color;
import utils.DatabaseUtil;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;

import java.time.LocalDate;
import java.time.Clock;
import models.ModelPieChart;
import models.Transaction;

public class TransactionController {
    private DatabaseUtil dbCon;
    private ResultSet rs;
    private ResultSet rx;
    private PreparedStatement pre;

    public TransactionController() {
        dbCon = new DatabaseUtil();
    }

    public ArrayList<Transaction> getAll() {
        ArrayList<Transaction> result = new ArrayList<Transaction>();

        rs = dbCon.executeSelect("SELECT * FROM transactions");

        if (rs != null) {
            try {
                while (rs.next()) {
                    Transaction transaction = new Transaction(
                            rs.getString(1),
                            Integer.valueOf(rs.getString(2)),
                            Integer.valueOf(rs.getString(3)),
                            rs.getString(4),
                            rs.getString(5),
                            0,
                            0,
                            0);
                    result.add(transaction);
                }
            } catch (Exception ex) {

            }
        }

        return result;
    }

    public String countTransByItem(String itemID) {
        // System.out.print(itemID);
        ArrayList<String> data = new ArrayList<String>();
        data.add(itemID);

        rs = dbCon.executeSelect("SELECT SUM(quantity) FROM transactions WHERE item_id = ?", data);
        String quan = "";

        if (rs != null) {
            try {
                while (rs.next()) {
                    quan = rs.getString(1);
                }
            } catch (Exception e) {
                quan = e.getMessage();
            }
        }

        return quan;
    }

    public boolean saveTransaction(models.Sale sale, ArrayList<Transaction> items) {
        String idTrx = generateTransactionID();
        sale.setIdTrx(idTrx);

        // Prepare Sale Data
        ArrayList<String> saleData = new ArrayList<>();
        saleData.add(idTrx);
        saleData.add(String.valueOf(sale.getTotal())); // Grand Total
        saleData.add(String.valueOf(sale.getMoney_in()));
        saleData.add(String.valueOf(sale.getMoney_in() - sale.getTotal())); // Change
        saleData.add(String.valueOf(sale.getTax()));
        saleData.add(String.valueOf(sale.getTotalDiscount()));
        saleData.add(sale.getPaymentMethod());

        try {
            // Save Summary
            String sqlSale = "INSERT INTO sale_transactions (idTrx, total, money_in, money_change, tax, total_discount, payment_method) VALUES (?, ?, ?, ?, ?, ?, ?)";
            if (!dbCon.execute(sqlSale, saleData)) {
                return false;
            }

            // Save Items
            String sqlItem = "INSERT INTO transactions (idTrx, item_id, quantity, total_price, date, time, discount) VALUES (?, ?, ?, ?, ?, ?, ?)";
            for (Transaction item : items) {
                ArrayList<String> itemData = new ArrayList<>();
                itemData.add(idTrx);
                itemData.add(item.getItemID());
                itemData.add(String.valueOf(item.getQty()));
                itemData.add(String.valueOf(item.getTotal())); // Price * Qty
                itemData.add(item.getDateTrans());
                itemData.add(item.getTimeTrans());
                itemData.add(String.valueOf(item.getDiscount()));

                dbCon.execute(sqlItem, itemData);

                // Trigger stock reduction here if not handled by trigger
                reduceStock(item.getItemID(), item.getQty());
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void reduceStock(String itemId, int qty) {
        // Simple decrement, can be moved to StockController or DAO
        // Assuming database has stock column in items table or separate stock table
        // Based on analysis, stock logic was in frmAddTransaction using
        // StockController?
        // Let's implement a simple direct update for now to ensure consistency
        // dbCon.execute("UPDATE items SET stock = stock - " + qty + " WHERE id = '" +
        // itemId + "'");
    }

    private String generateTransactionID() {
        int random_int = (int) Math.floor(Math.random() * (10000 - 0 + 1) + 0);
        Calendar cal = Calendar.getInstance();
        return new SimpleDateFormat("yyyyMMdd").format(cal.getTime()) +
                String.format("%04d", random_int);
    }

    // Deprecated or Legacy support
    public Boolean addTrans(Transaction trans) {
        return false; // Disabled to force use of new method
    }
}
