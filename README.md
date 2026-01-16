# AQrate Cashier App

AQrate Cashier App is a comprehensive Point of Sale (POS) system designed for efficiency and ease of use. It features a modern dark-themed UI, advanced inventory tracking, real-time analytics, and robust transaction management.

![Dashboard Screenshot](src/main/resources/assets/icons8-speed-48.png)

## Features

### 🚀 Core Features

- **Transaction Processing**: Fast and secure checkout with support for Tax (11%), Discounts, and Multiple Payment Methods (Cash, QRIS, Transfer).
- **Receipt Printing**: Integration with JasperReports for professional thermal receipt printing.
- **Barcode Scanner Support**: Quickly add items to the cart using standard barcode scanners.

### 📦 Inventory Management

- **Real-time Stock Tracking**: Automatic stock deduction upon sale and addition upon incoming shipments.
- **Stock Logs**: Detailed history of every stock movement (Incoming, Outgoing, Adjustments).
- **Supplier Management**: Maintain a database of suppliers and their details.
- **Low Stock Alerts**: Visual notifications when items run low to prevent stockouts.

### 📊 Analytics & Reporting

- **Interactive Dashboard**: Real-time view of Total Sales, Transaction Counts, and Top Selling Items (Pie Chart).
- **Excel Export**: One-click export of sales history to Excel (.xlsx) for offline analysis.
- **Incoming Logs**: Track stock replenishment history.

### 🎨 Modern UI/UX

- **Dark Mode**: Built with FlatLaf for a sleek, modern, and eye-friendly interface.
- **Responsive Design**: optimized for various screen sizes (within desktop context).

## Tech Stack

- **Language**: Java (JDK 17+)
- **GUI Framework**: Swing (with FlatLaf)
- **Database**: MySQL
- **Build Tool**: Maven
- **Reporting**: JasperReports
- **Excel Export**: Apache POI

## Installation

1.  **Clone the Repository**

    ```bash
    git clone https://github.com/kangphp/AQrateCashierApp.git
    ```

2.  **Database Setup**
    - Creates a MySQL database named `aqcashier`.
    - Import the SQL scripts located in `src/main/resources/sql/` in order:
      1.  `migration_phase2.sql`
      2.  `migration_phase3.sql`

3.  **Build the Project**

    ```bash
    mvn clean install
    ```

4.  **Run the Application**
    - Execute the `Driver` class in `src/main/java/Driver.java`.
    - Default Login credentials (if RBAC enabled): `admin` / `admin` (or as configured in your DB).

## License

This project is open-source and available under the MIT License.
