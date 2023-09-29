package customUI;

public class StockTrans {
    
    private String item_id;
    private Integer stock;
    
    public StockTrans(String item_id, Integer stock)
    {
        this.item_id = item_id;
        this.stock = stock;
    }
    /**
     * @return the item_id
     */
    public String getItem_id() {
        return item_id;
    }

    /**
     * @param item_id the item_id to set
     */
    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    /**
     * @return the stock
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    } 
}
