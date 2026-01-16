package controllers;

import utils.DatabaseUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import models.Supplier;

public class SupplierController {
    private DatabaseUtil db;

    public SupplierController() {
        db = new DatabaseUtil();
    }

    public ArrayList<Supplier> getAll() {
        ArrayList<Supplier> list = new ArrayList<>();
        ResultSet rs = db.executeSelect("SELECT * FROM suppliers");
        if (rs != null) {
            try {
                while (rs.next()) {
                    list.add(new Supplier(
                            rs.getString("code_sup"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address")));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public boolean add(Supplier s) {
        ArrayList<String> data = new ArrayList<>();
        data.add(s.getCodeSup());
        data.add(s.getName());
        data.add(s.getPhone());
        data.add(s.getAddress());
        return db.execute("INSERT INTO suppliers (code_sup, name, phone, address) VALUES (?, ?, ?, ?)", data);
    }

    public boolean update(Supplier s) {
        ArrayList<String> data = new ArrayList<>();
        data.add(s.getName());
        data.add(s.getPhone());
        data.add(s.getAddress());
        data.add(s.getCodeSup());
        return db.execute("UPDATE suppliers SET name = ?, phone = ?, address = ? WHERE code_sup = ?", data);
    }

    public boolean delete(String id) {
        ArrayList<String> data = new ArrayList<>();
        data.add(id);
        return db.execute("DELETE FROM suppliers WHERE code_sup = ?", data);
    }
}
