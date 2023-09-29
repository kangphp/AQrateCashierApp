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
    
    public StockController(){
        koneksi = new DatabaseUtil();
    }
    
    public Boolean addTrans(Stock trans)
    {
        ArrayList<String> data = new ArrayList<String>();
        
        data.add(trans.getIdInvoice());
        data.add(trans.getItem_id());
        data.add(String.valueOf(trans.getCode_sup()));
        data.add(String.valueOf(trans.getQuantity()));
        data.add(String.valueOf(trans.getPrice()));
        data.add(String.valueOf(trans.getDate()));
        
        if (koneksi.execute("INSERT INTO stocks (idInvoice, item_id, code_sup, quantity, price, date) VALUES (?, ?, ?, ?, ?, ?)", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public ArrayList<Supplier> getSupp()
    {
        ArrayList<Supplier> result = new ArrayList<Supplier>();
        
        rs = koneksi.executeSelect("SELECT * FROM suppliers");
        if(rs != null){
            try{
                while(rs.next()){
                    Supplier supp = new Supplier(
                            rs.getString("code_sup"),
                            rs.getString("name"),
                            rs.getString("phone"),
                            rs.getString("address")
                        );
                    result.add(supp);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public ArrayList<Stock> getStocks(){
        ArrayList<Stock> result = new ArrayList<Stock>();
        rs = koneksi.executeSelect("SELECT * FROM stocks");
        if(rs != null){
            try{
                while(rs.next()){
                    Stock barang = new Stock(
                            rs.getString("idInvoice"),
                            rs.getString("item_id"),
                            rs.getString("code_sup"),
                            rs.getInt("quantity"),
                            rs.getInt("price"),
                            rs.getString("date")
                        );
                    result.add(barang);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public String getPriceByID(String id)
    {
        ArrayList<String> data = new ArrayList<String>();
        data.add(id);
        String result = "";
        
        rs = koneksi.executeSelect("SELECT SUM(price) FROM stocks WHERE item_id = ?", data);
        
        if(rs != null){
            try{
                while(rs.next()){
                    result = rs.getString(1);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public String getQuantityByID(String id)
    {
        ArrayList<String> data = new ArrayList<String>();
        data.add(id);
        String result = "";
        
        rs = koneksi.executeSelect("SELECT SUM(quantity) FROM stocks WHERE item_id = ?", data);
        
        if(rs != null){
            try{
                while(rs.next()){
                    result = rs.getString(1);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
}
