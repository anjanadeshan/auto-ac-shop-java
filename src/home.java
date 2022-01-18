
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
//import net.proteanit.sql.*;
import java.sql.*;
import java.util.HashMap;

import java.util.Locale;
import javax.management.Query;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Anjana Deshan
 */
public class home extends javax.swing.JFrame {

    login logi = new login();


    /* Connection con=null;
    
PreparedStatement pst = null;
ResultSet rs=null;
String db="jdbc:mysql://localhost:3306/ostpro";
     */
    // SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd eeee");
    /**
     * Creates new form home
     */
    public home() {

        initComponents();

        //JOptionPane.showMessageDialog(null, "**********************"); 
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        try {

            logi.con = DriverManager.getConnection(logi.db, "root", "");

        } catch (SQLException ex) {
            //Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data_Base Fail-HOME");
        }
        //-------------------------------------------------------------------------------------------
        // JOptionPane.showMessageDialog(null, "IKKK"); 
        String sq = "SELECT Auto_increment FROM information_schema.tables WHERE table_name='admins' AND table_schema='ostpro';";
        //JOptionPane.showMessageDialog(null, "IKKK"); 
        try {
            logi.pst = logi.con.prepareStatement(sq);
            //   JOptionPane.showMessageDialog(null, "IKKK"); 
            // JOptionPane.showMessageDialog(null,rs+"_____");
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            logi.rs = logi.pst.executeQuery();

            while (logi.rs.next()) {

                int b = logi.rs.getInt(1);
                //JOptionPane.showMessageDialog(null,b+" ------"); 3 down  testting walata  gatta ewa sql exequte result display karanne mehema
                // System.out.println("BILL of the date u specified is:"+b);  
                // jLabel19.setText(""+b+"dgf");
                jbno.setText("" + b);
                //JOptionPane.showMessageDialog(null, "IKKK"); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    /* USE LESS public void tes(String para) {
           initComponents();
  // ho();
        JOptionPane.showMessageDialog(null, "fuck"); 
         jLabel3.setText( para);
        jTextField11.setText(para);
      
      } */
    public void jobid() {
        String sq = "SELECT Auto_increment FROM information_schema.tables WHERE table_name='job_details' AND table_schema='ostdb';";
        // JOptionPane.showMessageDialog(null, "IKKK"); 
        try {
            logi.pst = logi.con.prepareStatement(sq);
            //   JOptionPane.showMessageDialog(null, "IKKK"); 
            // JOptionPane.showMessageDialog(null,rs+"_____");
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            logi.rs = logi.pst.executeQuery();

            while (logi.rs.next()) {

                int b = logi.rs.getInt(1);
                //JOptionPane.showMessageDialog(null,b+" ------"); 3 down  testting walata  gatta ewa sql exequte result display karanne mehema
                // System.out.println("BILL of the date u specified is:"+b);  
                // jLabel19.setText(""+b+"dgf");
                jbno.setText("" + b);

                //  JOptionPane.showMessageDialog(null, "IKKK"); 
            }

        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public home(String para) {

        initComponents();
        findUsers();
        jComboBox1.setSelectedItem(null);
        jComboBox1.setEnabled(false);

        jLabel3.setText(para);
        jTextField11.setText(para);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Date d = new Date();
                SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss a ");
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd EEEE ");
                jLabel1.setText(sdft.format(d));
                jLabel2.setText(sdf.format(d));
            }
        }, 200, 200);
//============================================================================================== User name gann ona nisa login clz ekn parameter ekk ekka class eke  ehe call krala tama visible kare so normal home dann ona okkoma methna danwa uda homE   wada na

//JOptionPane.showMessageDialog(null, "**********************"); 
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            //  Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
        }

        try {

            logi.con = DriverManager.getConnection(logi.db, "root", "");

        } catch (SQLException ex) {
            //Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Data_Base Fail-HOME");
        }
        //-------------------------------------------------------------------------------------------
        // JOptionPane.showMessageDialog(null, "IKKK"); 
        jobid();

    }
    Statement st;
    PreparedStatement pst;
    ResultSet rs;
    Connection coninter = null;

    public Connection getConnection() {

        Connection con = null;
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/ostdb", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

    public ArrayList<srch> ListUsers(String Search) {

        ArrayList<srch> usersList = new ArrayList<srch>();
        // JOptionPane.showMessageDialog(null,usersList);

        Statement st;
        ResultSet rs;
        try {

            Connection con = getConnection();

            st = con.createStatement();

            //JOptionPane.showMessageDialog(null,"ajdfadf");
            String searchQuery = "SELECT job_id, customer_name,vehicle_no, bill_date  FROM ostdb.job_details WHERE CONCAT(job_id, customer_name,vehicle_no, bill_date) LIKE '%" + Search + "%'";
            //"SELECT job_id, customer_name,vehicle_no, bill_date  FROM `job_details` WHERE CONCAT('job_id', 'customer_name','vehicle_no', 'bill_date') LIKE '%" + ValToSearch + "%'";

            rs = st.executeQuery(searchQuery);
            // st = con.prepareStatement(searchQuery);
            //rs = st.executeQuery();
            //JOptionPane.showMessageDialog(null,"aaaaa");
            srch user;
            while (rs.next()) {
                user = new srch(rs.getInt("job_id"),
                        rs.getString("customer_name"),
                        rs.getString("vehicle_no"),
                        rs.getString("bill_date")
                );
                // JOptionPane.showMessageDialog(null,usersList);
                usersList.add(user);
                //JOptionPane.showMessageDialog(null,user);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());

        }
        return usersList;
    }

    public void findUsers() {

        ArrayList<srch> users = ListUsers(jTextField1.getText());
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new Object[]{"Bill NO", "Customer Name                 ", "Vehicle Number", "Bill Date"});
        Object[] row = new Object[4];
        for (int i = 0; i < users.size(); i++) {
            row[0] = users.get(i).getId();
            row[1] = users.get(i).getName();
            row[2] = users.get(i).getVno();
            row[3] = users.get(i).getBdate();
            model.addRow(row);
        }
        jTable1.setModel(model);
        TableColumnModel columnModel = jTable1.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(45);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jbno = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField11 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jbno1 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jLabel24 = new javax.swing.JLabel();
        jTextField13 = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jTextField14 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jTextField17 = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jTextField1 = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jTextField21 = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        jTextField22 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setModalExclusionType(null);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 5, 5, 5, new java.awt.Color(51, 255, 255)));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 0));
        jLabel2.setFont(new java.awt.Font("Rondalo", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 10, 290, 40));

        jLabel1.setBackground(new java.awt.Color(255, 51, 153));
        jLabel1.setFont(new java.awt.Font("Rondalo", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 10, 220, 40));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 153));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jTabbedPane1.setForeground(new java.awt.Color(51, 51, 51));
        jTabbedPane1.setFont(new java.awt.Font("28 Days Later", 0, 48)); // NOI18N

        jPanel2.setBackground(java.awt.SystemColor.textHighlight);
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(0, 0, 102), new java.awt.Color(0, 204, 204)));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/By6muTH.gif"))); // NOI18N
        jLabel32.setText("jLabel32");

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/teamwork_rotate_earth_pa_300_clr.gif"))); // NOI18N

        jLabel40.setBackground(new java.awt.Color(204, 0, 153));
        jLabel40.setFont(new java.awt.Font("Asimov", 1, 48)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 255, 0));
        jLabel40.setText("Still Building....");

        jLabel36.setBackground(new java.awt.Color(51, 0, 51));
        jLabel36.setFont(new java.awt.Font("Papyrus", 1, 48)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(51, 0, 51));
        jLabel36.setText("- System (Testing V1.00)");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel38))
                    .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(520, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(383, 383, 383)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(232, 232, 232)
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(102, 102, 102)
                .addComponent(jLabel38)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(31, 31, 31)
                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(519, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("HOME", jPanel2);

        jPanel3.setBackground(new java.awt.Color(102, 102, 255));

        jLabel4.setBackground(new java.awt.Color(0, 204, 204));
        jLabel4.setFont(new java.awt.Font("Terminator Two", 0, 36)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Customer_48px.png"))); // NOI18N
        jLabel4.setText("Customer Details");
        jLabel4.setToolTipText("");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel4.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("Full Name     :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("JOB NO:");

        jbno.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbno.setForeground(new java.awt.Color(255, 0, 51));
        jbno.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jbno.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbno.setOpaque(false);

        jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        jTextField3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(0, 0, 102));
        jTextField3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTextField3.setOpaque(false);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setText(" Address       :");

        jTextArea1.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(2);
        jTextArea1.setTabSize(4);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel8.setText("Phone Number :");

        jTextField4.setBackground(new java.awt.Color(204, 204, 255));
        jTextField4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(0, 0, 102));
        jTextField4.setOpaque(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel9.setText("NIC No :");

        jTextField5.setBackground(new java.awt.Color(204, 204, 255));
        jTextField5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(0, 0, 102));
        jTextField5.setOpaque(false);

        jLabel10.setBackground(new java.awt.Color(0, 204, 204));
        jLabel10.setFont(new java.awt.Font("Terminator Two", 0, 36)); // NOI18N
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Car_Rental_48px.png"))); // NOI18N
        jLabel10.setText("Vehicle Details");
        jLabel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel10.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setText("Vehicle No:");

        jTextField6.setBackground(new java.awt.Color(204, 204, 255));
        jTextField6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(0, 0, 102));
        jTextField6.setOpaque(false);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel12.setText("Vehicle Brand:");

        jTextField7.setBackground(new java.awt.Color(204, 204, 255));
        jTextField7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField7.setForeground(new java.awt.Color(0, 0, 102));
        jTextField7.setOpaque(false);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Vehicle Model:");

        jTextField8.setBackground(new java.awt.Color(204, 204, 255));
        jTextField8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField8.setForeground(new java.awt.Color(0, 0, 102));
        jTextField8.setOpaque(false);
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel14.setText("Vehicle Type:");

        jTextField9.setBackground(new java.awt.Color(204, 204, 255));
        jTextField9.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField9.setForeground(new java.awt.Color(0, 0, 102));
        jTextField9.setOpaque(false);

        jTextField10.setBackground(new java.awt.Color(204, 204, 255));
        jTextField10.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField10.setForeground(new java.awt.Color(0, 0, 102));
        jTextField10.setOpaque(false);

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel15.setText("Vehicle Color:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel16.setText(" Description:");

        jTextArea2.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea2.setColumns(1);
        jTextArea2.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextArea2.setLineWrap(true);
        jTextArea2.setRows(2);
        jTextArea2.setTabSize(4);
        jScrollPane2.setViewportView(jTextArea2);

        jTextArea3.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea3.setColumns(1);
        jTextArea3.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextArea3.setLineWrap(true);
        jTextArea3.setRows(2);
        jTextArea3.setTabSize(4);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel17.setText("Remark:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("USER:");

        jTextField11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField11.setForeground(new java.awt.Color(0, 0, 255));
        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField11.setOpaque(false);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("The Devil Net", 0, 24)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Clear_Symbol_50px_2.png"))); // NOI18N
        jButton1.setText("CLEAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(java.awt.SystemColor.textText);
        jButton2.setFont(new java.awt.Font("The Devil Net", 0, 24)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Save_48px.png"))); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbno, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(35, 35, 35)
                                                .addComponent(jLabel9))
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel12)
                                                    .addComponent(jLabel14)
                                                    .addComponent(jLabel15))))
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField8, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField9, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel10))
                                .addGap(199, 199, 199)
                                .addComponent(jLabel17)))
                        .addContainerGap(494, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addGap(18, 18, 18)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel5)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(36, 36, 36)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel16)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 933, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbno))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(28, 28, 28))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(27, 27, 27))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 11, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField7, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(1, 1, 1)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField9, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField10)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addGap(82, 82, 82))))
        );

        jTabbedPane1.addTab("NEW JOB", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));

        jPanel5.setBackground(java.awt.SystemColor.activeCaptionBorder);
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setBackground(new java.awt.Color(0, 204, 204));
        jLabel20.setFont(new java.awt.Font("Terminator Two", 0, 18)); // NOI18N
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Customer_48px.png"))); // NOI18N
        jLabel20.setText("CUSTOMER Details");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel20.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, 43));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setText("Full Name         :");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel22.setText("JOB NO:");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 13, 107, 31));

        jbno1.setEditable(false);
        jbno1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jbno1.setForeground(new java.awt.Color(255, 0, 51));
        jbno1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jbno1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jbno1.setOpaque(false);
        jPanel5.add(jbno1, new org.netbeans.lib.awtextra.AbsoluteConstraints(124, 13, 104, -1));

        jTextField12.setBackground(new java.awt.Color(204, 204, 255));
        jTextField12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jTextField12.setForeground(new java.awt.Color(0, 0, 102));
        jTextField12.setOpaque(false);
        jPanel5.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 390, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setText(" Address            :");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 440, -1, -1));

        jTextArea4.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea4.setColumns(1);
        jTextArea4.setFont(new java.awt.Font("Microsoft YaHei UI", 1, 18)); // NOI18N
        jTextArea4.setLineWrap(true);
        jTextArea4.setRows(2);
        jTextArea4.setTabSize(4);
        jTextArea4.setWrapStyleWord(true);
        jTextArea4.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane4.setViewportView(jTextArea4);

        jPanel5.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 400, 70));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setText("Phone Number :");
        jPanel5.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 550, -1, -1));

        jTextField13.setBackground(new java.awt.Color(204, 204, 255));
        jTextField13.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField13.setForeground(new java.awt.Color(0, 0, 102));
        jTextField13.setOpaque(false);
        jPanel5.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 590, 400, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setText("NIC No :");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 630, -1, 30));

        jTextField14.setBackground(new java.awt.Color(204, 204, 255));
        jTextField14.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextField14.setForeground(new java.awt.Color(0, 0, 102));
        jTextField14.setOpaque(false);
        jPanel5.add(jTextField14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 670, 260, 35));

        jLabel26.setBackground(new java.awt.Color(0, 204, 204));
        jLabel26.setFont(new java.awt.Font("Terminator Two", 0, 18)); // NOI18N
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Car_Rental_48px.png"))); // NOI18N
        jLabel26.setText("Vehicle Details");
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jLabel26.setDebugGraphicsOptions(javax.swing.DebugGraphics.NONE_OPTION);
        jPanel5.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 450, -1, 43));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setText("Vehicle No:");
        jPanel5.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 510, -1, 30));

        jTextField15.setBackground(new java.awt.Color(204, 204, 255));
        jTextField15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField15.setForeground(new java.awt.Color(0, 0, 102));
        jTextField15.setOpaque(false);
        jPanel5.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 510, 357, -1));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setText("Vehicle Brand:");
        jPanel5.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 550, -1, 30));

        jTextField16.setBackground(new java.awt.Color(204, 204, 255));
        jTextField16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField16.setForeground(new java.awt.Color(0, 0, 102));
        jTextField16.setOpaque(false);
        jPanel5.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 550, 357, -1));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setText("Vehicle Model:");
        jPanel5.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 610, -1, 30));

        jTextField17.setBackground(new java.awt.Color(204, 204, 255));
        jTextField17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField17.setForeground(new java.awt.Color(0, 0, 102));
        jTextField17.setOpaque(false);
        jPanel5.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 610, 357, -1));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setText("Vehicle Type:");
        jPanel5.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 660, -1, 30));

        jTextField18.setBackground(new java.awt.Color(204, 204, 255));
        jTextField18.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField18.setForeground(new java.awt.Color(0, 0, 102));
        jTextField18.setOpaque(false);
        jPanel5.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 663, 357, -1));

        jTextField19.setBackground(new java.awt.Color(204, 204, 255));
        jTextField19.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField19.setForeground(new java.awt.Color(0, 0, 102));
        jTextField19.setOpaque(false);
        jPanel5.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 704, 357, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setText("Vehicle Color:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 700, -1, 30));

        jTextArea5.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea5.setColumns(1);
        jTextArea5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea5.setLineWrap(true);
        jTextArea5.setRows(2);
        jTextArea5.setTabSize(4);
        jScrollPane5.setViewportView(jTextArea5);

        jPanel5.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1019, 402, 347, 135));

        jTextArea6.setBackground(new java.awt.Color(204, 204, 255));
        jTextArea6.setColumns(1);
        jTextArea6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jTextArea6.setLineWrap(true);
        jTextArea6.setRows(2);
        jTextArea6.setTabSize(4);
        jScrollPane6.setViewportView(jTextArea6);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1021, 602, 345, 125));

        jLabel33.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel33.setText("Amount:");
        jPanel5.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1009, 555, -1, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel34.setText("Job USER:");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, 140, 31));

        jTextField20.setEditable(false);
        jTextField20.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField20.setForeground(new java.awt.Color(0, 0, 255));
        jTextField20.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField20.setOpaque(false);
        jPanel5.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(1161, 13, 126, -1));

        jScrollPane7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTable1.setAutoCreateRowSorter(true);
        jTable1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTable1.setFont(new java.awt.Font("Ebrima", 1, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2          ", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("table");
        jTable1.setAutoscrolls(false);
        jTable1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jTable1.setGridColor(new java.awt.Color(51, 0, 204));
        jTable1.setRequestFocusEnabled(false);
        jTable1.setRowHeight(20);
        jTable1.setSelectionBackground(new java.awt.Color(51, 51, 51));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(jTable1);

        jPanel5.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 720, 200));

        jTextField1.setToolTipText("");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, 170, 30));

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel35.setText(" Description:");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(1009, 365, -1, 30));

        jButton5.setBackground(new java.awt.Color(0, 255, 0));
        jButton5.setFont(new java.awt.Font("Nasalization", 1, 20)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Update_64px_2.png"))); // NOI18N
        jButton5.setText("UPDATE");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 250, 180, 60));

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel37.setText("Last Updated User:");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 290, 200, 31));

        jTextField21.setEditable(false);
        jTextField21.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jTextField21.setForeground(new java.awt.Color(0, 0, 255));
        jTextField21.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField21.setOpaque(false);
        jPanel5.add(jTextField21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 290, 150, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel39.setText("Last Updated on:");
        jPanel5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 340, 170, 31));

        jTextField22.setEditable(false);
        jTextField22.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jTextField22.setForeground(new java.awt.Color(0, 0, 255));
        jTextField22.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTextField22.setOpaque(false);
        jTextField22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField22ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField22, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 340, 220, 30));

        jComboBox1.setBackground(new java.awt.Color(255, 0, 0));
        jComboBox1.setFont(new java.awt.Font("Terminator Two", 1, 24)); // NOI18N
        jComboBox1.setMaximumRowCount(4);
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "INPROGRESS", "FIXED-REPAIRED", "PAID-JOB DONE" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jComboBox1MouseReleased(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jComboBox1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jComboBox1PropertyChange(evt);
            }
        });
        jPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 100, 340, 50));

        jButton6.setBackground(new java.awt.Color(0, 255, 0));
        jButton6.setFont(new java.awt.Font("Nasalization", 1, 24)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/print.png"))); // NOI18N
        jButton6.setText("PRINT");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 250, 170, 60));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel41.setText("Search :");
        jPanel5.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jButton7.setBackground(new java.awt.Color(0, 255, 0));
        jButton7.setFont(new java.awt.Font("Nasalization", 1, 20)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Update_64px_2.png"))); // NOI18N
        jButton7.setText("DELETE");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 250, 180, 60));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1366, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 738, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel4Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jTabbedPane1.addTab("Update", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 1370, 820));
        jTabbedPane1.getAccessibleContext().setAccessibleDescription("xfgdf");
        jTabbedPane1.getAccessibleContext().setAccessibleParent(jTabbedPane1);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Close_Window_52px_3.png"))); // NOI18N
        jLabel19.setText("jLabel19");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(1340, 10, 50, 40));

        jLabel3.setFont(new java.awt.Font("Century Schoolbook", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Name_52px.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jButton4.setBackground(new java.awt.Color(0, 0, 0));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(102, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/content/icons8_Exit_50px.png"))); // NOI18N
        jButton4.setText("Log Out");
        jButton4.setBorder(null);
        jButton4.setOpaque(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 10, 190, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 929, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

// int jbid = Integer.parseInt(jbno.getText());
        // int jbid = ;
        String Name = jTextField3.getText();
        String Address = jTextArea1.getText();
        String phonno = jTextField4.getText();
        String nic = jTextField5.getText();
        String vehino = jTextField6.getText();
        String vehibrand = jTextField7.getText();
        String vehimodal = jTextField8.getText();
        String vehitype = jTextField9.getText();
        String vehicolor = jTextField10.getText();
        String desc = jTextArea2.getText();
        String remark = jTextArea3.getText();
        Date d = new Date();
        SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String bildate = sdf.format(d);
        String biltime = sdft.format(d);
        String lastupdate = (sdf.format(d) + " " + sdft.format(d));
        String billuser = jTextField11.getText();
        if ("".equals(Name) && "".equals(phonno) && "".equals(vehino)) {
            JOptionPane.showMessageDialog(null, "You Must Enter Customer Name, Phone Number And Vehicle Number ", "Enter The Values", JOptionPane.OK_OPTION);

            jTextField3.setBackground(new java.awt.Color(255, 102, 102));
            jTextField4.setBackground(new java.awt.Color(255, 102, 102));
            jTextField6.setBackground(new java.awt.Color(255, 102, 102));
            // jTextField4.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
            // jTextField6.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 51)));
        } else if ("".equals(Name) && "".equals(phonno)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField3.setBackground(Color.red);
            jTextField4.setBackground(new java.awt.Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Customer Name Field & Phone Number Field is Empty, Please Enter !", "Enter The Values", JOptionPane.OK_OPTION);

        } else if ("".equals(Name) && "".equals(vehino)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField3.setBackground(Color.red);
            jTextField6.setBackground(new java.awt.Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Customer Name Field & Phone Number Field is Empty, Please Enter !", "Enter The Values", JOptionPane.OK_OPTION);

        } else if ("".equals(phonno) && "".equals(vehino)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(Color.red);
            jTextField6.setBackground(new java.awt.Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Phone Number Field & Vehicle Number Field is Empty, Please Enter !", "Enter The Values", JOptionPane.OK_OPTION);

        } else if (Name == null || "".equals(Name)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField3.setBackground(Color.red);
            JOptionPane.showMessageDialog(null, "Customer Name Field is Empty Please Enter The Name", "Enter The Values", JOptionPane.OK_OPTION);

        } else if (phonno == null || "".equals(phonno)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Phone Number Field is Empty Please Enter The Number", "Enter The Values", JOptionPane.OK_OPTION);

        } else if (vehino == null || "".equals(vehino)) {
            jTextField3.setBackground(new java.awt.Color(204, 204, 255));
            jTextField4.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(204, 204, 255));
            jTextField6.setBackground(new java.awt.Color(255, 102, 102));
            JOptionPane.showMessageDialog(null, "Vehicle Number Field is Empty Please Enter The Number", "Enter The Values", JOptionPane.OK_OPTION);

        } else {
            //  JOptionPane.showMessageDialog(null, "apooi"+Name);
            //job id removes cus its Ai  job_id, '" + jbid + "',
            try {
                String q = "INSERT INTO job_details (customer_name,address,phone_no,nic_no,vehicle_no,vehicle_model,vehicle_brand,colour,type,Description,Remarks,bill_date,bill_time,last_update,user,job_Status) values ('" + Name + "','" + Address + "','" + phonno + "','" + nic + "','" + vehino + "','" + vehimodal + "','" + vehibrand + "','" + vehicolor + "','" + vehitype + "','" + desc + "','" + remark + "','" + bildate + "','" + biltime + "','" + lastupdate + "','" + billuser + "','INPROGRESS')";
                logi.pst = logi.con.prepareStatement(q);
                logi.pst.execute();
                //tableload();
                JOptionPane.showMessageDialog(null, "Sucsess fully added");
                jTextField3.setText("");
                jTextArea1.setText("");
                jTextArea2.setText("");
                jTextArea3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                jTextField7.setText("");
                jTextField8.setText("");
                jTextField9.setText("");
                jTextField10.setText("");

                // jTextField3.setBorder(null);
                //jTextField4.setBorder(null);
                // jTextField6.setBorder(null);
                jTextField3.setBackground(new java.awt.Color(204, 204, 255));
                jTextField4.setBackground(new java.awt.Color(204, 204, 255));
                jTextField6.setBackground(new java.awt.Color(204, 204, 255));
                jobid();
                findUsers();

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jTextField3.setText("");
        jTextArea1.setText("");
        jTextArea2.setText("");
        jTextArea3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextField7.setText("");
        jTextField8.setText("");
        jTextField9.setText("");
        jTextField10.setText("");
        //jTextField11.setText("");
        jTextField3.setBackground(new java.awt.Color(204, 204, 255));
        jTextField4.setBackground(new java.awt.Color(204, 204, 255));
        jTextField6.setBackground(new java.awt.Color(204, 204, 255));
        jobid();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed
    DefaultTableModel model = new DefaultTableModel();
    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

        findUsers();
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jComboBox1.setEnabled(true);
        Connection con = getConnection();
        int r = jTable1.getSelectedRow();

        String id = jTable1.getValueAt(r, 0).toString();
        jbno1.setText(id);

        try {
            st = con.createStatement();

        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Query = "SELECT  *  FROM ostdb.job_details WHERE job_id = '" + id + "'";
        //customer_name,address ,phone_no,nic_no, vehicle_no, vehicle_model,vehicle_brand,colour,type,Description,Remarks, bill_date,bill_time,last_update,user,
        try {

            rs = st.executeQuery(Query);
            rs.next();
            // JOptionPane.showMessageDialog(null,"Result======="+rs.getString("job_id") );

            jTextField12.setText(rs.getString("customer_name"));
            jTextArea4.setText(rs.getString("address"));
            jTextField13.setText(rs.getString("phone_no"));
            jTextField14.setText(rs.getString("nic_no"));
            jTextField15.setText(rs.getString("vehicle_no"));
            jTextField16.setText(rs.getString("vehicle_brand"));
            jTextField17.setText(rs.getString("vehicle_model"));
            jTextField18.setText(rs.getString("type"));
            jTextField19.setText(rs.getString("colour"));
            jTextArea5.setText(rs.getString("Description"));
            jTextArea6.setText(rs.getString("Remarks"));
            jTextField20.setText(rs.getString("user"));
            jTextField21.setText(rs.getString("last_update_user"));
            jTextField22.setText(rs.getString("last_update"));
            jComboBox1.setSelectedItem(rs.getString("job_Status"));
            /* while (rs.next()) {
                
             jTextField12.setText(rs.getString("job_id"));
             JOptionPane.showMessageDialog(null,rs.getString("job_id") );
                
                
                
            }*/
            //String name = jTable1.getValueAt(r, 1).toString();
            //  JOptionPane.showMessageDialog(null,"*"+id+"----"+name );
            // TODO add your handling code here:
        } catch (SQLException ex) {
            Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex);
            System.out.println(ex.getMessage());
        }
        if(jComboBox1.getSelectedItem()=="INPROGRESS"){
        
        jComboBox1.setBackground(Color.red);
        } 
         if(jComboBox1.getSelectedItem()=="FIXED-REPAIRED"){
        
        jComboBox1.setBackground(Color.yellow);
        } 
         if(jComboBox1.getSelectedItem()=="PAID-JOB DONE"){
        
        jComboBox1.setBackground(Color.green);
        } 
         
         
         
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Connection con = getConnection();
        coninter = getConnection();

        String Name = jTextField12.getText();
        String Address = jTextArea4.getText();
        String phonno = jTextField13.getText();
        String nic = jTextField14.getText();
        String vehino = jTextField15.getText();
        String vehibrand = jTextField16.getText();
        String vehimodal = jTextField17.getText();
        String vehitype = jTextField18.getText();
        String vehicolor = jTextField19.getText();
        String desc = jTextArea5.getText();
        String remark = jTextArea6.getText();
        Date d = new Date();
        SimpleDateFormat sdft = new SimpleDateFormat("hh:mm:ss a ");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        String bildate = sdf.format(d);
        String biltime = sdft.format(d);
        String lastupdate = (sdf.format(d) + " " + sdft.format(d));
        String billuser = jTextField11.getText();
        String lstupdtuser = jLabel3.getText();
        String id = jbno1.getText();
        //  String status = jComboBox1.getSelectedItem();
        String status = (String) (jComboBox1.getSelectedItem());
        if (jbno1.getText() == null || "".equals(jbno1.getText())) {

            JOptionPane.showMessageDialog(null, "Plase Select a Job To Update ", "No Any Selection Found", JOptionPane.OK_OPTION);
        } else {
            int response = JOptionPane.showConfirmDialog(null, "Are You Sure Do You Want To Update This JOB " + jbno1.getText() + " ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.NO_OPTION) {

            } else if (response == JOptionPane.YES_OPTION) {
                //Connection con = getConnection();
                try {

                    String sql = "UPDATE job_details SET  customer_name='" + Name + "',address='" + Address + "',phone_no='" + phonno + "',nic_no='" + nic + "',vehicle_no='" + vehino + "',vehicle_model='" + vehimodal + "'  ,vehicle_brand='" + vehibrand + "' ,colour='" + vehicolor + "',type='" + vehitype + "',Description='" + desc + "' ,Remarks='" + remark + "',last_update='" + lastupdate + "',last_update_user='" + lstupdtuser + "',job_Status='" + status + "' where  job_id='" + id + "'";

                    pst = coninter.prepareStatement(sql);
                    //JOptionPane.showMessageDialog(null,"----" );
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Update Sucessfully!");
                    findUsers();
                    jTextField12.setText("");
                    jTextArea4.setText("");
                    jTextField13.setText("");
                    jTextField14.setText("");
                    jTextField15.setText("");
                    jTextField16.setText("");
                    jTextField17.setText("");
                    jTextField18.setText("");
                    jTextField19.setText("");
                    jTextArea5.setText("");
                    jTextArea6.setText("");
                    jbno1.setText("");
                    jComboBox1.setSelectedItem(null);
                    jComboBox1.setEnabled(false);

                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }
// String q = "INSERT INTO job_details (customer_name,address,phone_no,nic_no,vehicle_no,vehicle_model,vehicle_brand,colour,type,Description,Remarks,bill_date,bill_time,last_update,user) values ('" + Name + "','" + Address + "','" + phonno + "','" + nic + "','" + vehino + "','" + vehimodal + "','" + vehibrand + "','" + vehicolor + "','" + vehitype + "','" + desc + "','" + remark + "','" + bildate + "','" + biltime + "','" + lastupdate + "','" + billuser + "')";
                // String sql = "UPDATE job_details SET  customer_name='" + Name + "',address='" + Address + "',phone_no='" + phonno + "',nic_no='" + nic + "',vehicle_no='" + vehino + "',vehicle_model='" + vehimodal + "'  ,vehicle_brand='" + vehibrand + "' ,colour='" + vehicolor + "',type='" + vehitype + "',Description='" + desc + "' ,Remarks='" + remark + "',last_update='" + lastupdate + "',last_update_user='" + lstupdtuser + "' where  job_id='" + jbno1.getText() + "'";
                // String sql="UPDATE job_details SET  customer_name='" + Name + "' WHERE  job_id = '" +jbno1.getText() + "'";
                //JOptionPane.showMessageDialog(null,"----" );
                //  try {

                // JOptionPane.showMessageDialog(null,rss+"aaaaaa"+sst);
                // String sl="UPDATE job_details SET  customer_name='damnaaaaaaaaaaaaaaaaa' WHERE  job_id='1'";
                //rss = sst.executeQuery(sl);
                //   JOptionPane.showMessageDialog(null,"Sucessfully UPDATED!" );
                //  }catch(SQLException ex) {
                //   Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                // }
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField22ActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked





        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jComboBox1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseReleased
       
         
// TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1MouseReleased

    private void jComboBox1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jComboBox1PropertyChange
         // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1PropertyChange

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed

 if(jComboBox1.getSelectedItem()=="INPROGRESS"){
        
        jComboBox1.setBackground(Color.red);
        } 
         if(jComboBox1.getSelectedItem()=="FIXED-REPAIRED"){
        
        jComboBox1.setBackground(Color.yellow);
        } 
         if(jComboBox1.getSelectedItem()=="PAID-JOB DONE"){
        
        jComboBox1.setBackground(Color.green);
        } 


        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.hide();
        
        new login().setVisible(true);



// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
            try{
                InputStream in=new FileInputStream(new File("C:\\xamppo\\htdocs\\Jquary\\ostproject\\src\\report2.jrxml"));
                                                               
                JasperDesign jd=JRXmlLoader.load(in); 
                String sql="SELECT * FROM job_details WHERE job_id="+ jbno1.getText();
                JRDesignQuery newQuery=new JRDesignQuery();
                newQuery.setText(sql);
                jd.setQuery(newQuery);
                JasperReport jr=JasperCompileManager.compileReport(jd);
                
//                HashMap para=new Hashmap();
              //  JRBeanCollectionDataSource jcd=new JRBeanCollectionDataSource();
                JasperPrint j=JasperFillManager.fillReport(jr,null,logi.con);
                JasperViewer.viewReport(j,false);
//                OutputStream os=new FileOutputStream(new File("C:\\jreports"));
//                JasperExportManager.exportReportToPdfStream(j, os);
                
            }
            catch (Exception e){
              JOptionPane.showMessageDialog(null, e);
            }
        
        
        
        
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Connection con = getConnection();
        coninter = getConnection();

        ;
        String id = jbno1.getText();
       
        
        if (jbno1.getText() == null || "".equals(jbno1.getText())) {

            JOptionPane.showMessageDialog(null, "Plase Select a Job To Delete ", "No Any Selection Found", JOptionPane.OK_OPTION);
        } else {
            int response = JOptionPane.showConfirmDialog(null, "Are You Sure Do You Want To DELETE This JOB " + jbno1.getText() + " ", "Confirm", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);

            if (response == JOptionPane.NO_OPTION) {

            } else if (response == JOptionPane.YES_OPTION) {
                //Connection con = getConnection();
                try {

                    String sql = "DELETE FROM job_details WHERE job_id="+id+"";

                    pst = coninter.prepareStatement(sql);
                    //JOptionPane.showMessageDialog(null,"----" );
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "DELETE Sucessfull");
                    findUsers();
                    jTextField12.setText("");
                    jTextArea4.setText("");
                    jTextField13.setText("");
                    jTextField14.setText("");
                    jTextField15.setText("");
                    jTextField16.setText("");
                    jTextField17.setText("");
                    jTextField18.setText("");
                    jTextField19.setText("");
                    jTextArea5.setText("");
                    jTextArea6.setText("");
                    jbno1.setText("");
                    jComboBox1.setSelectedItem(null);
                    jComboBox1.setEnabled(false);

                } catch (SQLException ex) {
                    Logger.getLogger(home.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }

    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {

                new home().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField14;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField21;
    private javax.swing.JTextField jTextField22;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextField jbno;
    private javax.swing.JTextField jbno1;
    // End of variables declaration//GEN-END:variables
}
