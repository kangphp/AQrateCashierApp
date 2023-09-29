package models;

public class Sale {
    private String idTrx;
    private Integer total;
    private Integer money_in;
    
    public Sale(String idTrx, Integer total, Integer money_in)
    {
        this.idTrx = idTrx;
        this.total = total;
        this.money_in = money_in;
    }
    
    /**
     * @return the idTrx
     */
    public String getIdTrx() {
        return idTrx;
    }

    /**
     * @param idTrx the idTrx to set
     */
    public void setIdTrx(String idTrx) {
        this.idTrx = idTrx;
    }

    /**
     * @return the total
     */
    public Integer getTotal() {
        return total;
    }

    /**
     * @param total the total to set
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * @return the money_in
     */
    public Integer getMoney_in() {
        return money_in;
    }

    /**
     * @param money_in the money_in to set
     */
    public void setMoney_in(Integer money_in) {
        this.money_in = money_in;
    }
    
}
