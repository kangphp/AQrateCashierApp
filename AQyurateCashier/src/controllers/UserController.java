package controllers;

import com.mysql.jdbc.PreparedStatement;
import utils.DatabaseUtil;
import java.sql.*;
import java.util.*;
import models.User;

public class UserController {
    private DatabaseUtil dbCon;
    private ResultSet rs;
    private PreparedStatement pre;
    
    public UserController(){
        dbCon = new DatabaseUtil();
    }

    public ArrayList<User> getAll(){
        ArrayList<User> result = new ArrayList<User>();
        rs = dbCon.executeSelect("SELECT * FROM users");
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    User pengguna = new User(
                            Integer.parseInt(rs.getString(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            timestamp.toLocalDateTime()
                        );
                    result.add(pengguna);
                }
            } catch (Exception ex){
                
            }
        }
        return result;
    }

    public User getById(int user_id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(user_id));
        User pengguna = null;
        
        rs = dbCon.executeSelect("SELECT * FROM users WHERE id = ?", data);
        if(rs != null){
            try{
                while(rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    pengguna = new User(Integer.parseInt(rs.getString(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            timestamp.toLocalDateTime()
                        );
                    break;
                } 
            }catch (Exception ex){
                
            }
        }
        return pengguna;
    }
    
    public Boolean update(String user_id, String name, String username, String password){
        ArrayList<String> data = new ArrayList<String>();
        data.add(name);
        data.add(username);
        data.add(username);
        data.add(user_id);
        if (dbCon.execute("UPDATE users SET name = ?, username = ?, password = ? WHERE id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    public Boolean delete(String user_id){
        ArrayList<String> data = new ArrayList<String>();
        data.add(user_id);
        if (dbCon.execute("DELETE FROM users WHERE id = ?", data)){
            return true;
        } else {
            return false;
        }
    }
    
    
    public Boolean insert(User pengguna){
        ArrayList<String> data = new ArrayList<String>();
        if (pengguna.getId() != 0){
            data.add(String.valueOf(pengguna.getId()));
        }
        data.add(pengguna.getName());
        data.add(pengguna.getUsername());
        data.add(pengguna.getPassword());
        
        if(pengguna.getId() != 0){
            if (dbCon.execute("INSERT INTO users (id, name, username, password) VALUES (?, ?, ?)", data)){
                return true;
            } else {
                return false;
            }
        }else{
            if (dbCon.execute("INSERT INTO users (name, username, password) VALUES (?, ?, ?)", data)){
                return true;
            } else {
                return false;
            }
        } 
    }
    
    public User getLogin(String username, String password){
        ArrayList<String> data = new ArrayList<String>();
        data.add(String.valueOf(username));
        data.add(String.valueOf(password));
        User pengguna = null;
        
        rs = dbCon.executeSelect("SELECT * FROM users WHERE username = ? AND password = ?", data);
        if (rs != null){
            try{
                while (rs.next()){
                    Timestamp timestamp = rs.getTimestamp(5);
                    pengguna = new User(Integer.parseInt(rs.getString(1)),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            timestamp.toLocalDateTime()
                    );
                    break;
                }
            } catch(Exception e){
                
            }
        }
        return pengguna;
    }
    
    public void close(){
        dbCon.stop();
    }

}
    

