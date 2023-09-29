package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import models.Sale;

public class SaleController {
    private DatabaseUtil koneksi;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public SaleController(){
        koneksi = new DatabaseUtil();
    }
    
    public ArrayList<Sale> getAll(){
        ArrayList<Sale> result = new ArrayList<Sale>();
        rs = koneksi.executeSelect("SELECT * FROM sale_transactions");
        if(rs != null){
            try{
                while(rs.next()){
                    Sale sales = new Sale(
                            rs.getString("idTrx"),
                            Integer.valueOf(rs.getString("total")),
                            Integer.valueOf(rs.getString("money_in"))
                        );
                    result.add(sales);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }
}
