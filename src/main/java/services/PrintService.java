package services;

import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.view.JasperViewer;
import utils.DatabaseUtil;

public class PrintService {

    public void printReceipt(String transactionId) {
        try {
            InputStream reportStream = getClass().getResourceAsStream("/reports/receipt.jrxml");
            if (reportStream == null) {
                System.out.println("Receipt template not found!");
                return;
            }

            JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);

            Map<String, Object> parameters = new HashMap<>();
            parameters.put("ID_TRX", transactionId);

            Connection conn = new DatabaseUtil().getConnection();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, conn);

            // Show print preview
            JasperViewer.viewReport(jasperPrint, false);

            // Or print directly:
            // JasperPrintManager.printReport(jasperPrint, false);

        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}
