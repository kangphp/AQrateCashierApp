/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author User-PC
 */
public class Supplier {
    private String code_sup;
    private String name;
    private String phone;
    private String address;
    
    public Supplier (String code_sup, String name, String phone, String address)
    {
        this.code_sup = code_sup;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    /**
     * @return the code_sup
     */
    public String getCode_sup() {
        return code_sup;
    }

    /**
     * @param code_sup the code_sup to set
     */
    public void setCode_sup(String code_sup) {
        this.code_sup = code_sup;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }
    
    
}
