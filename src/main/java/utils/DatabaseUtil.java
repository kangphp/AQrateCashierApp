package utils;

import com.mysql.jdbc.MySQLConnection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.*;
import java.util.*;
import java.util.logging.*;
import models.Database;

public class DatabaseUtil {
    private Database config;
    private Connection dbConn;
    private Statement dbStmnt;
    private ResultSet dbRs;
    private PreparedStatement dbPre;

    public DatabaseUtil() {
        try {
            Properties props = new Properties();
            props.load(getClass().getClassLoader().getResourceAsStream("config.properties"));

            this.config = new Database(
                    props.getProperty("db.url"),
                    props.getProperty("db.user"),
                    props.getProperty("db.password"));

            Class.forName(props.getProperty("db.driver"));
            dbConn = createConn();
            dbStmnt = dbConn.createStatement();

        } catch (Exception ex) {
            Logger.getLogger(DatabaseUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return dbConn;
    }

    private Connection createConn() throws SQLException {
        return DriverManager.getConnection(config.getHost(), config.getUsername(), config.getPassword());
    }

    public boolean stop() {
        try {
            if (dbStmnt != null)
                dbStmnt.close();
            if (dbConn != null)
                dbConn.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ResultSet executeSelect(String query) {
        try {
            dbRs = dbStmnt.executeQuery(query);
            return dbRs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public boolean execute(String query) {
        try {
            dbStmnt.executeUpdate(query);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public ResultSet executeSelect(String query, ArrayList<String> data) {
        try {
            dbPre = (PreparedStatement) dbConn.prepareStatement(query);
            for (int i = 0; i < data.size(); i++) {
                dbPre.setString((i + 1), data.get(i));
            }
            dbRs = dbPre.executeQuery();
            return dbRs;
        } catch (SQLException e) {
            return null;
        }
    }

    public boolean execute(String query, ArrayList<String> data) {
        try {

            dbPre = (PreparedStatement) dbConn.prepareStatement(query);
            for (int i = 0; i < data.size(); i++) {
                dbPre.setString((i + 1), data.get(i));
            }
            dbPre.executeUpdate();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}
