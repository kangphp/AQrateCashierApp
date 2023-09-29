package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import models.Item;

public class ItemController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public ItemController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Item> getAllItems(){
        ArrayList<Item> result = new ArrayList<Item>();
        rs = koneksi.executeSelect("SELECT * FROM items");
        if(rs != null){
            try{
                while(rs.next()){
                    Item barang = new Item(
                            rs.getString("item_id"),
                            rs.getString("code_cat"),
                            rs.getString("name"),
                            rs.getInt("price")
                        );
                    result.add(barang);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
    
    public Item getById(String itemID){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(itemID));
        Item barang = null;
        
        rs = koneksi.executeSelect("SELECT * FROM items WHERE item_id = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    
                    barang = new Item(
                            rs.getString("item_id"),
                            rs.getString("code_cat"),
                            rs.getString("name"),
                            rs.getInt("price")
                        );
                    break;
                } 
            }catch (Exception ex){
                
            }
        }
        return barang;
    }
    
    public Boolean addItem (Item barang)
    {
        ArrayList<String> data = new ArrayList<String>();
        
        data.add(String.valueOf(barang.getItemID()));
        data.add(barang.getCodeCat());
        data.add(barang.getName());
        data.add(String.valueOf(barang.getPrice()));
        
        
        if (koneksi.execute("INSERT INTO items (item_id, code_cat, name, price) VALUES (?, ?, ?, ?)", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean updateItem(String item_id, String code_cat, String name, String price){
        ArrayList<String> data = new ArrayList<String>();
        data.add(code_cat);
        data.add(name);
        data.add(price);
        data.add(item_id);
        
        if (koneksi.execute("UPDATE items SET code_cat = ?, name = ?, price = ? WHERE item_id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean deleteItem(String item_id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(item_id);
        if (koneksi.execute("DELETE FROM items WHERE item_id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public void close(){
        koneksi.stop();
    }
}
