package views;

import controllers.DashboardController;
import customUI.*;
import java.awt.Color;
import java.util.Map;
import javax.swing.JLabel;
import models.ModelPieChart;

public class frmDashboard extends javax.swing.JFrame {

    private DashboardController dc = new DashboardController();

    public frmDashboard() {
        initComponents();
        loadData();
    }

    private void loadData() {
        // Cards
        lblTotalSales.setText(dc.getTotalSalesToday());
        lblTotalTrans.setText(dc.getTotalTransactionsToday());

        // Chart
        pieChart1.setChartType(PieChart.PeiChartType.DONUT_CHART);
        Map<String, Double> topItems = dc.getTopSellingItems();
        int index = 0;
        Color[] colors = { new Color(23, 126, 238), new Color(221, 65, 65), new Color(47, 157, 64),
                new Color(196, 151, 58), new Color(100, 100, 100) };

        for (Map.Entry<String, Double> entry : topItems.entrySet()) {
            pieChart1.addData(new ModelPieChart(entry.getKey(), entry.getValue(), colors[index % colors.length]));
            index++;
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        pnlRoot = new PanelRound();
        btnBack = new Button();
        jLabel1 = new JLabel();
        pnlCards = new javax.swing.JPanel();
        cardSales = new PanelRound();
        lblSalesTitle = new JLabel();
        lblTotalSales = new JLabel();
        cardTrans = new PanelRound();
        lblTransTitle = new JLabel();
        lblTotalTrans = new JLabel();
        pieChart1 = new PieChart();
        jLabel2 = new JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        pnlRoot.setBackground(new java.awt.Color(34, 36, 48));

        btnBack.setText("Back");
        btnBack.addActionListener(evt -> {
            new frmMenu().setVisible(true);
            dispose();
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36));
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Dashboard");

        pnlCards.setOpaque(false);
        pnlCards.setLayout(new java.awt.GridLayout(1, 2, 20, 0));

        cardSales.setBackground(new java.awt.Color(44, 46, 58));
        cardSales.setRoundTopLeft(20);
        cardSales.setRoundTopRight(20);
        cardSales.setRoundBottomLeft(20);
        cardSales.setRoundBottomRight(20);

        lblSalesTitle.setFont(new java.awt.Font("Segoe UI", 0, 18));
        lblSalesTitle.setForeground(new java.awt.Color(200, 200, 200));
        lblSalesTitle.setText("Today's Sales");

        lblTotalSales.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTotalSales.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalSales.setText("Rp 0");

        javax.swing.GroupLayout cardSalesLayout = new javax.swing.GroupLayout(cardSales);
        cardSales.setLayout(cardSalesLayout);
        cardSalesLayout.setHorizontalGroup(
                cardSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardSalesLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(cardSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTotalSales)
                                        .addComponent(lblSalesTitle))
                                .addContainerGap(100, Short.MAX_VALUE)));
        cardSalesLayout.setVerticalGroup(
                cardSalesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardSalesLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblSalesTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalSales)
                                .addContainerGap(20, Short.MAX_VALUE)));

        pnlCards.add(cardSales);

        cardTrans.setBackground(new java.awt.Color(44, 46, 58));
        cardTrans.setRoundTopLeft(20);
        cardTrans.setRoundTopRight(20);
        cardTrans.setRoundBottomLeft(20);
        cardTrans.setRoundBottomRight(20);

        lblTransTitle.setFont(new java.awt.Font("Segoe UI", 0, 18));
        lblTransTitle.setForeground(new java.awt.Color(200, 200, 200));
        lblTransTitle.setText("Transactions");

        lblTotalTrans.setFont(new java.awt.Font("Segoe UI", 1, 24));
        lblTotalTrans.setForeground(new java.awt.Color(255, 255, 255));
        lblTotalTrans.setText("0");

        javax.swing.GroupLayout cardTransLayout = new javax.swing.GroupLayout(cardTrans);
        cardTrans.setLayout(cardTransLayout);
        cardTransLayout.setHorizontalGroup(
                cardTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardTransLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(cardTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblTotalTrans)
                                        .addComponent(lblTransTitle))
                                .addContainerGap(100, Short.MAX_VALUE)));
        cardTransLayout.setVerticalGroup(
                cardTransLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(cardTransLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(lblTransTitle)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotalTrans)
                                .addContainerGap(20, Short.MAX_VALUE)));

        pnlCards.add(cardTrans);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Top Selling Items");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jLabel1)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(pnlCards, javax.swing.GroupLayout.DEFAULT_SIZE, 600,
                                                        Short.MAX_VALUE)
                                                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addContainerGap(30, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addComponent(pnlCards, javax.swing.GroupLayout.PREFERRED_SIZE, 100,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(pieChart1, javax.swing.GroupLayout.PREFERRED_SIZE, 300,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(30, Short.MAX_VALUE)));

        javax.swing.GroupLayout rootLayout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(rootLayout);
        rootLayout.setHorizontalGroup(
                rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        rootLayout.setVerticalGroup(
                rootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));

        pack();
        setLocationRelativeTo(null);
    }

    private PanelRound pnlRoot;
    private Button btnBack;
    private JLabel jLabel1;
    private javax.swing.JPanel pnlCards;
    private PanelRound cardSales;
    private JLabel lblSalesTitle;
    private JLabel lblTotalSales;
    private PanelRound cardTrans;
    private JLabel lblTransTitle;
    private JLabel lblTotalTrans;
    private PieChart pieChart1;
    private JLabel jLabel2;

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new frmDashboard().setVisible(true));
    }
}
