package models;

public class Sale {
    private String idTrx;
    private Integer total;
    private Integer money_in;
    private Double tax;
    private Double totalDiscount;
    private String paymentMethod;

    public Sale(String idTrx, Integer total, Integer money_in, Double tax, Double totalDiscount, String paymentMethod) {
        this.idTrx = idTrx;
        this.total = total;
        this.money_in = money_in;
        this.tax = tax;
        this.totalDiscount = totalDiscount;
        this.paymentMethod = paymentMethod;
    }

    // Backward compatibility if needed
    public Sale(String idTrx, Integer total, Integer money_in) {
        this(idTrx, total, money_in, 0.0, 0.0, "CASH");
    }

    public String getIdTrx() {
        return idTrx;
    }

    public void setIdTrx(String idTrx) {
        this.idTrx = idTrx;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getMoney_in() {
        return money_in;
    }

    public void setMoney_in(Integer money_in) {
        this.money_in = money_in;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public Double getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Double totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
