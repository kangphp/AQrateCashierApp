package controllers;

import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.*;
import utils.DatabaseUtil;
import models.Category;

/**
 *
 * @author User-PC
 */
public class CategoryController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public CategoryController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Category> getCategory ()
    {
        ArrayList<Category> cat= new ArrayList<Category>();
        rs = koneksi.executeSelect("SELECT * FROM categories");
        
        if(rs != null){
            try{
                while(rs.next()){
                    Category category = new Category(
                            rs.getString("code_cat"),
                            rs.getString("name")
                        );
                    cat.add(category);
                }
            } catch (Exception ex){
                
            }
        }
        return cat;
    }
    
    public Boolean insertCategory(Category cat)
    {
        ArrayList<String> data = new ArrayList<String>();
        
        data.add(String.valueOf(cat.getCatID()));
        data.add(cat.getCatName());
        
        
        if (koneksi.execute("INSERT INTO categories (code_cat, name) VALUES (?, ?)", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean updateCategory(String name, String code_cat){
        ArrayList<String> data = new ArrayList<String>();
        data.add(name);
        data.add(code_cat);
        
        if (koneksi.execute("UPDATE categories SET name = ? WHERE code_cat = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean deleteCategory(String code_cat){
        ArrayList<String> data = new ArrayList<String>();
        data.add(code_cat);
        if (koneksi.execute("DELETE FROM categories WHERE code_cat = ?", data)){
            return true;
        } else {
            return false;
        }
    }
}
