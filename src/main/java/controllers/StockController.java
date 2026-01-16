package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.time.*;
import models.Stock;
import models.Supplier;
import models.Transaction;

public class StockController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;

    public StockController() {
        koneksi = new DatabaseUtil();
    }

    // Adjust Stock (Incoming, Outgoing, Adjustment)
    public boolean adjustStock(String itemId, int qty, String type, String description) {
        String sqlUpdate = "UPDATE items SET current_stock = current_stock + ? WHERE item_id = ?";
        String sqlLog = "INSERT INTO stock_logs (item_id, type, quantity, balance_after, description) " +
                "VALUES (?, ?, ?, (SELECT current_stock FROM items WHERE item_id = ?), ?)";

        try {
            int adjustment = qty;
            if (type.equals("OUT")) {
                adjustment = -qty;
            }

            // 1. Update Current Stock
            ArrayList<String> updateData = new ArrayList<>();
            updateData.add(String.valueOf(adjustment));
            updateData.add(itemId);
            if (!koneksi.execute(sqlUpdate, updateData)) {
                return false;
            }

            // 2. Insert Log
            ArrayList<String> logData = new ArrayList<>();
            logData.add(itemId);
            logData.add(type);
            logData.add(String.valueOf(qty)); // Log absolute quantity
            logData.add(itemId); // For subquery
            logData.add(description);

            koneksi.execute(sqlLog, logData);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // Check for Low Stock
    public ArrayList<models.Item> getLowStockItems() {
        ArrayList<models.Item> result = new ArrayList<>();
        rs = koneksi.executeSelect("SELECT * FROM items WHERE current_stock <= min_stock");
        if (rs != null) {
            try {
                while (rs.next()) {
                    models.Item item = new models.Item(
                            rs.getString("item_id"),
                            rs.getString("code_cat"),
                            rs.getString("name"),
                            rs.getInt("price"),
                            rs.getInt("current_stock"),
                            rs.getInt("min_stock"));
                    result.add(item);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    public ArrayList<models.StockLog> getStockLogs() {
        ArrayList<models.StockLog> result = new ArrayList<>();
        // Assuming models.StockLog exists
        rs = koneksi.executeSelect("SELECT * FROM stock_logs ORDER BY created_at DESC");
        if (rs != null) {
            try {
                while (rs.next()) {
                    models.StockLog log = new models.StockLog(
                            rs.getInt("log_id"),
                            rs.getString("item_id"),
                            rs.getString("type"),
                            rs.getInt("quantity"),
                            rs.getInt("balance_after"),
                            rs.getString("description"),
                            rs.getString("created_at"));
                    result.add(log);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    // Deprecated or Legacy wrapping
    public Boolean addTrans(Stock trans) {
        // Redirect legacy 'addTrans' (Incoming) to new adjustStock
        return adjustStock(trans.getItem_id(), trans.getQuantity(), "IN", "Legacy Incoming: " + trans.getIdInvoice());
    }

    // ... Keep existing getters methods for compatibility if needed, or refactor
    // fully
    public ArrayList<Supplier> getSupp() {
        // ... same as before
        ArrayList<Supplier> result = new ArrayList<Supplier>();
        rs = koneksi.executeSelect("SELECT * FROM suppliers");
        if (rs != null) {
            try {
                while (rs.next()) {
                    Supplier supp = new Supplier(
                            rs.getString("code_sup"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address"));
                    result.add(supp);
                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    public ArrayList<Stock> getStocks() {
        // Legacy support
        ArrayList<Stock> result = new ArrayList<Stock>();
        rs = koneksi.executeSelect("SELECT * FROM stocks"); // This table might still exist or be deprecated
        if (rs != null) {
            try {
                while (rs.next()) {
                    Stock barang = new Stock(
                            rs.getString("idInvoice"),
                            rs.getString("item_id"),
                            rs.getString("code_sup"),
                            rs.getInt("quantity"),
                            rs.getInt("price"),
                            rs.getString("date"));
                    result.add(barang);
                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    // Updated to use current_stock from items table
    public String getQuantityByID(String id) {
        ArrayList<String> data = new ArrayList<String>();
        data.add(id);
        String result = "0";
        rs = koneksi.executeSelect("SELECT current_stock FROM items WHERE item_id = ?", data);
        if (rs != null) {
            try {
                while (rs.next()) {
                    result = rs.getString(1);
                }
            } catch (Exception ex) {
            }
        }
        return result;
    }

    // ... other methods ...
    public String getPriceByID(String id) {
        return "0";
    } // Deprecated logic
}
