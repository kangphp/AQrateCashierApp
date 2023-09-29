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
    
    public TransactionController(){
        dbCon = new DatabaseUtil();
    }
    
    public ArrayList<Transaction> getAll()
    {
        ArrayList<Transaction> result = new ArrayList<Transaction>();
        
        rs = dbCon.executeSelect("SELECT * FROM transactions");
        
        if(rs != null){
            try{
                while(rs.next()){
                    Transaction transaction = new Transaction(
                            rs.getString(1),
                            Integer.valueOf(rs.getString(2)),
                            Integer.valueOf(rs.getString(3)),
                            rs.getString(4),
                            rs.getString(5),
                            0,
                            0,
                            0
                        );
                    result.add(transaction);
                }
            } catch (Exception ex){
                
            }
        }
        
        return result;
    }
    
    public String countTransByItem(String itemID)
    {
        //System.out.print(itemID);
        ArrayList<String> data = new ArrayList<String>();
        data.add(itemID);
        
        rs = dbCon.executeSelect("SELECT SUM(quantity) FROM transactions WHERE item_id = ?", data);
        String quan = "";
        
        if (rs != null)
        {
            try 
            {
                while(rs.next())
                {
                    quan = rs.getString(1);
                }
            } catch (Exception e) {
                quan = e.getMessage();
            }
        }
        
        return quan;
    }
    
    public Boolean addTrans(Transaction trans)
    {
        ArrayList<String> data = new ArrayList<String>();
        
        int random_int = (int)Math.floor(Math.random()*(1000-0+1)+0);
        Calendar cal = Calendar.getInstance();
        cal.get(Calendar.DAY_OF_MONTH);
        
        String idTrx = new SimpleDateFormat("MMM").format(cal.getTime()).toUpperCase() + String.valueOf(cal.get(Calendar.YEAR) + cal.get(Calendar.DAY_OF_MONTH) + random_int);
        
        data.add(idTrx);
        data.add(trans.getItemID());
        data.add(String.valueOf(trans.getQty()));
        data.add(String.valueOf(trans.getTotal()));
        data.add(String.valueOf(trans.getDateTrans()));
        data.add(String.valueOf(trans.getTimeTrans()));
        
        ArrayList<String> dataSale = new ArrayList<String>();
        dataSale.add(idTrx);
        dataSale.add(String.valueOf(trans.getTotalAll()));
        dataSale.add(String.valueOf(trans.getMoneyIn()));
        dataSale.add(String.valueOf(trans.getMoneyChange()));
        
        if (dbCon.execute("INSERT INTO transactions (idTrx, item_id, quantity, total_price, date, time) VALUES (?, ?, ?, ?, ?, ?)", data) && dbCon.execute("INSERT INTO sale_transactions (idTrx, total, money_in, money_change) VALUES (?, ?, ?, ?)", dataSale)){
            return true;
        } else {
            return false;
        }
    }
}
