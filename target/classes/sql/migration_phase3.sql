-- Phase 3 Migration Script
-- Run this in your MySQL database 'aqcashier'

-- 1. Update items table (Stock Tracking)
ALTER TABLE items 
ADD COLUMN current_stock INT DEFAULT 0,
ADD COLUMN min_stock INT DEFAULT 5;

-- 2. Create stock_logs table
CREATE TABLE IF NOT EXISTS stock_logs (
    log_id INT AUTO_INCREMENT PRIMARY KEY,
    item_id VARCHAR(50) NOT NULL,
    type VARCHAR(20) NOT NULL, -- IN, OUT, ADJUSTMENT
    quantity INT NOT NULL,
    balance_after INT NOT NULL,
    description TEXT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (item_id) REFERENCES items(item_id) ON DELETE CASCADE
);

-- 3. Create Suppliers table (if not exists or needs update)
-- Existing table likely exists based on StockController analysis, but ensuring structure
CREATE TABLE IF NOT EXISTS suppliers (
    code_sup VARCHAR(20) PRIMARY KEY,
    name VARCHAR(100),
    phone VARCHAR(20),
    address TEXT
);
