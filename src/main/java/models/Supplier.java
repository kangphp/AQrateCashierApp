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

    public Supplier(String code_sup, String name, String phone, String address) {
        this.code_sup = code_sup;
        this.name = name;
        this.phone = phone;
        this.address = address;
    }

    /**
     * @return the code_sup
     */
    public String getCodeSup() {
        return code_sup;
    }

    public void setCodeSup(String code_sup) {
        this.code_sup = code_sup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
