-- Phase 2 Migration Script
-- Run this in your MySQL database 'aqcashier'

-- 1. Update transactions table (Per-item discount)
ALTER TABLE transactions 
ADD COLUMN discount DOUBLE DEFAULT 0;

-- 2. Update sale_transactions table (Tax, Total Discount, Payment Method)
ALTER TABLE sale_transactions 
ADD COLUMN tax DOUBLE DEFAULT 0,
ADD COLUMN total_discount DOUBLE DEFAULT 0,
ADD COLUMN payment_method VARCHAR(50) DEFAULT 'CASH'; -- CASH, QRIS, TRANSFER

-- 3. Update users table (If not done in Phase 1)
-- ALTER TABLE users ADD COLUMN role VARCHAR(20) DEFAULT 'cashier';
