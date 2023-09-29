package models;

public class Item {
    private String itemID;
    private String codeCat;
    private String name;
    private Integer price;
    
    public Item(String itemID, String catCode, String itemName, Integer price){
        this.itemID = itemID;
        this.codeCat = catCode;
        this.name = itemName;
        this.price = price;
    }

    public String getItemID() {
        return itemID;
    }

    public String getCodeCat() {
        return codeCat;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
