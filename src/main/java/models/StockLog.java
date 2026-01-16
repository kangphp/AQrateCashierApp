package models;

public class StockLog {
    private int logId;
    private String itemId;
    private String type;
    private int quantity;
    private int balanceAfter;
    private String description;
    private String createdAt;

    public StockLog(int logId, String itemId, String type, int quantity, int balanceAfter, String description,
            String createdAt) {
        this.logId = logId;
        this.itemId = itemId;
        this.type = type;
        this.quantity = quantity;
        this.balanceAfter = balanceAfter;
        this.description = description;
        this.createdAt = createdAt;
    }

    public int getLogId() {
        return logId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getBalanceAfter() {
        return balanceAfter;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedAt() {
        return createdAt;
    }
}
