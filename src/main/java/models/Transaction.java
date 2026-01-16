package models;

public class Transaction {
    private String itemID;
    private Integer qty;
    private String dateTrans;
    private String timeTrans;
    private Integer total;
    private Integer totalAll;
    private Integer moneyIn;
    private Integer moneyChange;
    private Double discount;

    public Transaction(String item_id, Integer qty, Integer total, String dateTrans, String timeTrans, Integer totalAll,
            Integer moneyIn, Integer moneyChange, Double discount) {
        this.itemID = item_id;
        this.qty = qty;
        this.dateTrans = dateTrans;
        this.timeTrans = timeTrans;
        this.total = total;
        this.totalAll = totalAll;
        this.moneyIn = moneyIn;
        this.moneyChange = moneyChange;
        this.discount = discount;
    }

    // Additional Constructor for backward compatibility if needed, using default 0
    // discount
    public Transaction(String item_id, Integer qty, Integer total, String dateTrans, String timeTrans, Integer totalAll,
            Integer moneyIn, Integer moneyChange) {
        this(item_id, qty, total, dateTrans, timeTrans, totalAll, moneyIn, moneyChange, 0.0);
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public String getItemID() {
        return itemID;
    }

    public void setItemID(String itemID) {
        this.itemID = itemID;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getDateTrans() {
        return dateTrans;
    }

    public void setDateTrans(String dateTrans) {
        this.dateTrans = dateTrans;
    }

    public String getTimeTrans() {
        return timeTrans;
    }

    public void setTimeTrans(String timeTrans) {
        this.timeTrans = timeTrans;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(Integer totalAll) {
        this.totalAll = totalAll;
    }

    public Integer getMoneyIn() {
        return moneyIn;
    }

    public void setMoneyIn(Integer moneyIn) {
        this.moneyIn = moneyIn;
    }

    public Integer getMoneyChange() {
        return moneyChange;
    }

    public void setMoneyChange(Integer moneyChange) {
        this.moneyChange = moneyChange;
    }
}
