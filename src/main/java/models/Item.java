package models;

public class Item {
    private String itemID;
    private String codeCat;
    private String name;
    private Integer price;

    private Integer currentStock;
    private Integer minStock;

    public Item(String itemID, String codeCat, String name, Integer price, Integer currentStock, Integer minStock) {
        this.itemID = itemID;
        this.codeCat = codeCat;
        this.name = name;
        this.price = price;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    // Backward compatibility constructor
    public Item(String itemID, String codeCat, String name, Integer price) {
        this(itemID, codeCat, name, price, 0, 5);
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public String getCodeCat() {
        return codeCat;
    }

    public void setCodeCat(String codeCat) {
        this.codeCat = codeCat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }
}
