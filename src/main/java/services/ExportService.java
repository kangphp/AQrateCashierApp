package services;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import utils.DatabaseUtil;
import java.io.FileOutputStream;
import java.sql.ResultSet;

public class ExportService {

    public boolean exportSalesToExcel(String filePath) {
        DatabaseUtil db = new DatabaseUtil();
        String sql = "SELECT st.idTrx, st.total, st.money_in, st.money_change, st.payment_method, t.date " +
                "FROM sale_transactions st " +
                "JOIN transactions t ON st.idTrx = t.idTrx " +
                "GROUP BY st.idTrx"; // To avoid duplicates from join

        try (Workbook workbook = new XSSFWorkbook()) {
            Sheet sheet = workbook.createSheet("Sales Data");

            // Header
            Row headerRow = sheet.createRow(0);
            String[] columns = { "Transaction ID", "Date", "Total", "Payment Method", "Paid", "Change" };
            for (int i = 0; i < columns.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(columns[i]);
            }

            // Data
            ResultSet rs = db.executeSelect(sql);
            int rowNum = 1;
            while (rs != null && rs.next()) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(rs.getString("idTrx"));
                row.createCell(1).setCellValue(rs.getString("date"));
                row.createCell(2).setCellValue(rs.getDouble("total"));
                row.createCell(3).setCellValue(rs.getString("payment_method"));
                row.createCell(4).setCellValue(rs.getDouble("money_in"));
                row.createCell(5).setCellValue(rs.getDouble("money_change"));
            }

            FileOutputStream fileOut = new FileOutputStream(filePath);
            workbook.write(fileOut);
            fileOut.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
