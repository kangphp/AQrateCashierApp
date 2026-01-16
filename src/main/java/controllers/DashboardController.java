package controllers;

import utils.DatabaseUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DashboardController {
    private DatabaseUtil db;

    public DashboardController() {
        db = new DatabaseUtil();
    }

    public String getTotalSalesToday() {
        String sql = "SELECT SUM(total) FROM sale_transactions WHERE DATE(created_at) = CURDATE()"; // Assuming
                                                                                                    // created_at exists
                                                                                                    // or is handled
        // If created_at doesn't exist, we might need to join or assume 'date' column
        // logic from Phase 2
        // Let's assume we rely on Transaction items 'date' or we need to add timestamp
        // to sale_transactions?
        // Phase 2 added 'date' and 'time' to transactions (items), check
        // sale_transactions structure
        // sale_transactions has idTrx. We can join or just use a simpler query if date
        // is not there.
        // Wait, Phase 2 migration didn't add date to sale_transactions explicitly?
        // Let's check migration_phase2.sql or TransactionController.

        // Check TransactionController saveTransaction:
        // INSERT INTO sale_transactions ...
        // It does NOT seem to save date! Oh no.
        // But transactions (items) HAS date.
        // So we can JOIN.

        sql = "SELECT SUM(st.total) FROM sale_transactions st " +
                "JOIN transactions t ON st.idTrx = t.idTrx " +
                "WHERE t.date = CURDATE()"; // Grouping might duplicate sums if not careful using DISTINCT

        // Better: Use transactions table for total sales?
        // SELECT SUM(total_price) FROM transactions WHERE date = CURDATE()
        sql = "SELECT SUM(total_price) FROM transactions WHERE date = CURDATE()";

        ResultSet rs = db.executeSelect(sql);
        try {
            if (rs.next() && rs.getString(1) != null) {
                return "Rp " + java.text.NumberFormat.getIntegerInstance().format(rs.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Rp 0";
    }

    public String getTotalTransactionsToday() {
        String sql = "SELECT COUNT(DISTINCT idTrx) FROM transactions WHERE date = CURDATE()";
        ResultSet rs = db.executeSelect(sql);
        try {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "0";
    }

    public Map<String, Double> getTopSellingItems() {
        Map<String, Double> data = new HashMap<>();
        String sql = "SELECT i.name, SUM(t.quantity) as qty FROM transactions t " +
                "JOIN items i ON t.item_id = i.item_id " +
                "GROUP BY t.item_id ORDER BY qty DESC LIMIT 5";
        ResultSet rs = db.executeSelect(sql);
        try {
            while (rs.next()) {
                data.put(rs.getString("name"), rs.getDouble("qty"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }
}
