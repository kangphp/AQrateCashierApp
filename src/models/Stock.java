package models;

import java.time.*;
import java.util.*;

public class Stock {    
    private String idInvoice;
    private String item_id;
    private String code_sup;
    private Integer quantity;
    private Integer price;
    private String date;
    
    public Stock (String idInvoice, String item_id, String code_sup, Integer quantity, Integer price, String date)
    {
        this.idInvoice = idInvoice;
        this.item_id = item_id;
        this.code_sup = code_sup;
        this.quantity = quantity;
        this.price = price;
        this.date = date;
    }
    
    public String getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(String idInvoice) {
        this.idInvoice = idInvoice;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getCode_sup() {
        return code_sup;
    }

    public void setCode_sup(String code_sup) {
        this.code_sup = code_sup;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }    
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
