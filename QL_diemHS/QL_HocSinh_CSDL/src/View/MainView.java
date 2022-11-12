/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Connection.DatabaseConn;
import DAO.Another_DAO;
import DAO.DAO;
import DAO.DiemChiTiet_DAO;
import DAO.GiaoVien_DAO;
import DAO.HocKi_DAO;
import DAO.HocPhi_DAO;
import DAO.Lop_DAO;
import DAO.MonHocDAO;
import DAO.NamHoc_DAO;
import Model.DiemChiTiet;
import Model.GVBM;
import Model.GVCN;
import Model.GiaoVien;
import Model.HocKi;
import Model.HocSinhDiem;
import Model.Lop;
import Model.MonHoc;
import Model.NamHoc;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minh0
 */
public class MainView extends javax.swing.JFrame {

    private fmHocSinh HocSinh;//1
    private fmDiemHS diemHS;//2
    private fmXepLop xepLop;//3
    private fmDanhGiaHS danhGiaHS;//5
    private fmGiaoVien giaoVien;//6
    private fmGVCN GVCN;//7
    private fmThongKe thongKe;//9
    private fmDongHP dongHP;//10

    private DAO dao;

    private List<GiaoVien> dsgv;

    public MainView() {
        initComponents();
        this.setLocationRelativeTo(null);
        init();
        cb_giaoven.setSelectedIndex(0);
    }

    public void init() {
        dao = new NamHoc_DAO();
        DataStatic.dsNH = dao.getALL();
        dao = new HocKi_DAO();
        DataStatic.dsHK = dao.getALL();
        dao = new Lop_DAO();
        DataStatic.dsLop = dao.getALL();
        dao = new MonHocDAO();
        DataStatic.dsMH = dao.getALL();
        dao = new HocPhi_DAO();
        DataStatic.dsHP = dao.getALL();
        dao = new DiemChiTiet_DAO();
        DataStatic.dsDCT = dao.getALL();
        Another_DAO adao = new Another_DAO();
        DataStatic.dsHanhKiem = adao.getAllHanhKiem();
        DataStatic.dsHocLuc = adao.getAllHocLuc();
        dao = new GiaoVien_DAO();
        dsgv = dao.getALL();
        GiaoVien gv = new GiaoVien("", "", "", "", "", "", "", "");
        dsgv.add(0, gv);

        loadcbgiaovien();

        loadcb_NH();
        loadcb_HK();
        this.HocSinh = new fmHocSinh(this);
        this.diemHS = new fmDiemHS(this);
        this.xepLop = new fmXepLop(this);
        this.danhGiaHS = new fmDanhGiaHS(this);
        this.giaoVien = new fmGiaoVien();
        this.GVCN = new fmGVCN(this);
        this.thongKe = new fmThongKe(this);
        this.dongHP = new fmDongHP(this);

        this.HocSinh.setBounds(jpHienThi.getVisibleRect());
        this.diemHS.setBounds(jpHienThi.getVisibleRect());
        this.xepLop.setBounds(jpHienThi.getVisibleRect());
        this.danhGiaHS.setBounds(jpHienThi.getVisibleRect());
        this.giaoVien.setBounds(jpHienThi.getVisibleRect());
        this.GVCN.setBounds(jpHienThi.getVisibleRect());
        this.thongKe.setBounds(jpHienThi.getVisibleRect());
        this.dongHP.setBounds(jpHienThi.getVisibleRect());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    DatabaseConn.getDBConn().getconn().close();
                } catch (SQLException ex) {
                    Logger.getLogger(MainView.class.getName()).log(Level.SEVERE, null, ex);
                }
                super.windowClosing(e);
            }

        });
    }

    private void loadcbgiaovien() {
        cb_giaoven.removeAllItems();
        for (GiaoVien giaoVien1 : dsgv) {
            cb_giaoven.addItem(giaoVien1.getMaGV());
        }
    }

    private void opendlpc() {
        Another_DAO adao = new Another_DAO();
        lb_maGV.setText("Mã giáo viên: "+getmaGV());
        lb_tenGV.setText("Tên giáo viên: "+dsgv.get(cb_giaoven.getSelectedIndex()).getHoTenGV());
        lb_hocki.setText(HocKi.getTen(getmaHK(), DataStatic.dsHK));
        lb_namhoc.setText("Năm học: "+NamHoc.getNamHoc(getMaNH(), DataStatic.dsNH));
        List<GVCN> dsgvcn = adao.pcgvcn((String) cb_giaoven.getSelectedItem(), getMaNH(), getmaHK());
        List<GVBM> dsgvbm = adao.dspcGV_MH((String) cb_giaoven.getSelectedItem(), getMaNH(), getmaHK());
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_GVBM.getModel();
        tblmodel.setRowCount(0);
        for (GVBM gvbm : dsgvbm) {
            tblmodel.addRow(new Object[]{
                Lop.getTenLop(gvbm.getMalop(), DataStatic.dsLop),
                MonHoc.getTen(gvbm.getMaMonHoc(), DataStatic.dsMH)
            });
        }
        tblmodel = (DefaultTableModel) tbl_GVCN.getModel();
        tblmodel.setRowCount(0);
        for (GVCN gvcn : dsgvcn) {
            tblmodel.addRow(new Object[]{Lop.getTenLop(gvcn.getMalop(), DataStatic.dsLop)});
        }
        dl_dsPc.setSize(600, 600);
        dl_dsPc.setLocationRelativeTo(null);
        dl_dsPc.setResizable(false);
        dl_dsPc.setVisible(true);
    }

    public String getmaGV() {
        return cb_giaoven.getSelectedItem().toString().trim();
    }

    public void loadform(int form) {
        jpHienThi.removeAll();
        setFalseAll();
        switch (form) {
            case 1:

                jpHienThi.add(this.HocSinh);
                this.HocSinh.setVisible(true);
                break;
            case 2:

                jpHienThi.add(this.diemHS);
                this.diemHS.setVisible(true);
                break;
            case 3:

                jpHienThi.add(this.xepLop);
                this.xepLop.setVisible(true);
                break;
            case 4:
                break;
            case 5:

                jpHienThi.add(this.danhGiaHS);
                this.danhGiaHS.setVisible(true);
                break;
            case 6:

                jpHienThi.add(this.giaoVien);
                this.giaoVien.setVisible(true);
                break;
            case 7:

                jpHienThi.add(this.GVCN);
                this.GVCN.setVisible(true);
                break;
            case 8:
                break;
            case 9:
                jpHienThi.add(this.thongKe);
                this.thongKe.setVisible(true);
                break;
            case 10:
                jpHienThi.add(this.dongHP);
                this.dongHP.setVisible(true);
                break;
            default:

                jpHienThi.add(this.fmHome);
                break;

        }
    }

    public void setFalseAll() {
        this.HocSinh.setVisible(false);
        this.diemHS.setVisible(false);
        this.xepLop.setVisible(false);
        this.danhGiaHS.setVisible(false);
        this.giaoVien.setVisible(false);
        this.GVCN.setVisible(false);
        this.thongKe.setVisible(false);
        this.dongHP.setVisible(false);
    }

    public void loadcb_NH() {
        cb_namhoc.removeAllItems();
        for (NamHoc nh : DataStatic.dsNH) {
            cb_namhoc.addItem(nh.getNamHoc());
        }
    }

    public void loadcb_HK() {
        cb_hocky.removeAllItems();
        for (HocKi nh : DataStatic.dsHK) {
            cb_hocky.addItem(nh.getHK());
        }
    }

    public String getMaNH() {
        int index = cb_namhoc.getSelectedIndex();
        return DataStatic.dsNH.get(index).getMaNH();
    }

    public String getmaHK() {
        int index = cb_hocky.getSelectedIndex();
        return DataStatic.dsHK.get(index).getMaHK();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        fmHome = new javax.swing.JPanel();
        dl_dsPc = new javax.swing.JDialog();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_GVBM = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_GVCN = new javax.swing.JTable();
        lb_maGV = new javax.swing.JLabel();
        lb_tenGV = new javax.swing.JLabel();
        lb_namhoc = new javax.swing.JLabel();
        lb_hocki = new javax.swing.JLabel();
        cb_namhoc = new javax.swing.JComboBox<>();
        cb_hocky = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tenDN = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        btnHocSinh = new javax.swing.JToggleButton();
        btnXepLop = new javax.swing.JToggleButton();
        btnHocPhi = new javax.swing.JToggleButton();
        btnDiemHS = new javax.swing.JToggleButton();
        btnDanhGia = new javax.swing.JToggleButton();
        btnThongKe = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jToolBar2 = new javax.swing.JToolBar();
        jToggleButton8 = new javax.swing.JToggleButton();
        jToggleButton9 = new javax.swing.JToggleButton();
        jPanel3 = new javax.swing.JPanel();
        jToolBar3 = new javax.swing.JToolBar();
        jButton12 = new javax.swing.JButton();
        jButton13 = new javax.swing.JButton();
        jButton14 = new javax.swing.JButton();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jButton20 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jpHienThi = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cb_giaoven = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();

        javax.swing.GroupLayout fmHomeLayout = new javax.swing.GroupLayout(fmHome);
        fmHome.setLayout(fmHomeLayout);
        fmHomeLayout.setHorizontalGroup(
            fmHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        fmHomeLayout.setVerticalGroup(
            fmHomeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        dl_dsPc.setTitle("xem danh sách phân công");
        dl_dsPc.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        dl_dsPc.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phân công giảng dạy", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        tbl_GVBM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Lớp học", "Môn học"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_GVBM);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chủ nhiệm lớp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10), new java.awt.Color(255, 0, 51))); // NOI18N

        tbl_GVCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Lớp chủ nhiệm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_GVCN);

        lb_maGV.setText("Mã giáo viên");

        lb_tenGV.setText("Tên giáo viên");

        lb_namhoc.setText("Năm học: ");

        lb_hocki.setText("Học kì ");

        javax.swing.GroupLayout dl_dsPcLayout = new javax.swing.GroupLayout(dl_dsPc.getContentPane());
        dl_dsPc.getContentPane().setLayout(dl_dsPcLayout);
        dl_dsPcLayout.setHorizontalGroup(
            dl_dsPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 611, Short.MAX_VALUE)
            .addGroup(dl_dsPcLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(dl_dsPcLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_dsPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_maGV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lb_tenGV, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
                    .addGroup(dl_dsPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(lb_hocki, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lb_namhoc, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dl_dsPcLayout.setVerticalGroup(
            dl_dsPcLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_dsPcLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_maGV)
                .addGap(18, 18, 18)
                .addComponent(lb_tenGV)
                .addGap(18, 18, 18)
                .addComponent(lb_namhoc)
                .addGap(18, 18, 18)
                .addComponent(lb_hocki)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Phần mềm quản lý Học Sinh");

        cb_namhoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2019-2020", "2020-2021", "2021-2022" }));

        cb_hocky.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Học kì I", "Học kì II" }));

        jLabel1.setText("Năm học:");

        jLabel2.setText("Học kì:");

        jLabel3.setText("Tên giáo viên:");

        txt_tenDN.setEditable(false);

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jToolBar1.setEnabled(false);
        jToolBar1.setFocusable(false);

        buttonGroup1.add(btnHocSinh);
        btnHocSinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pupils.png"))); // NOI18N
        btnHocSinh.setText("Học sinh");
        btnHocSinh.setFocusable(false);
        btnHocSinh.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocSinh.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocSinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocSinhActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHocSinh);

        buttonGroup1.add(btnXepLop);
        btnXepLop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/phanlop.png"))); // NOI18N
        btnXepLop.setText("Xếp lớp");
        btnXepLop.setFocusable(false);
        btnXepLop.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXepLop.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnXepLop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXepLopActionPerformed(evt);
            }
        });
        jToolBar1.add(btnXepLop);

        buttonGroup1.add(btnHocPhi);
        btnHocPhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/namhoc.png"))); // NOI18N
        btnHocPhi.setText("Học phí");
        btnHocPhi.setFocusable(false);
        btnHocPhi.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnHocPhi.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnHocPhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHocPhiActionPerformed(evt);
            }
        });
        jToolBar1.add(btnHocPhi);

        buttonGroup1.add(btnDiemHS);
        btnDiemHS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/diem.png"))); // NOI18N
        btnDiemHS.setText("Điểm");
        btnDiemHS.setFocusable(false);
        btnDiemHS.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDiemHS.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDiemHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiemHSActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDiemHS);

        buttonGroup1.add(btnDanhGia);
        btnDanhGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/xeploai.png"))); // NOI18N
        btnDanhGia.setText("Đánh giá");
        btnDanhGia.setFocusable(false);
        btnDanhGia.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnDanhGia.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnDanhGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDanhGiaActionPerformed(evt);
            }
        });
        jToolBar1.add(btnDanhGia);

        buttonGroup1.add(btnThongKe);
        btnThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/ketqua.png"))); // NOI18N
        btnThongKe.setText("Thống kê");
        btnThongKe.setFocusable(false);
        btnThongKe.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnThongKe.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnThongKe);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Học sinh", jPanel1);

        jToolBar2.setEnabled(false);

        buttonGroup1.add(jToggleButton8);
        jToggleButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/dsgiaovien.png"))); // NOI18N
        jToggleButton8.setText("Giáo viên");
        jToggleButton8.setFocusable(false);
        jToggleButton8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton8.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton8ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton8);

        buttonGroup1.add(jToggleButton9);
        jToggleButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/giaovien.png"))); // NOI18N
        jToggleButton9.setText("Phân công GV");
        jToggleButton9.setToolTipText("");
        jToggleButton9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton9.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton9ActionPerformed(evt);
            }
        });
        jToolBar2.add(jToggleButton9);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Giáo viên", jPanel2);

        jToolBar3.setEnabled(false);

        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/namhoc.png"))); // NOI18N
        jButton12.setText("Năm học");
        jButton12.setFocusable(false);
        jButton12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton12.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton12);

        jButton13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/qddotuoi.png"))); // NOI18N
        jButton13.setText("Quy đinh");
        jButton13.setFocusable(false);
        jButton13.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton13.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton13);

        jButton14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/hocky.png"))); // NOI18N
        jButton14.setText("Học kỳ");
        jButton14.setFocusable(false);
        jButton14.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton14.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton14);

        jButton15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/monhoc.png"))); // NOI18N
        jButton15.setText("Môn học");
        jButton15.setFocusable(false);
        jButton15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton15.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton15);

        jButton16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/lophoc.png"))); // NOI18N
        jButton16.setText("Lớp học");
        jButton16.setFocusable(false);
        jButton16.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton16.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton16);

        jButton17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/huongdan.png"))); // NOI18N
        jButton17.setText("Loại điểm");
        jButton17.setFocusable(false);
        jButton17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton17.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton17);

        jButton18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/nghenghiep.png"))); // NOI18N
        jButton18.setText("Diện CS");
        jButton18.setFocusable(false);
        jButton18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton18.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton18);

        jButton19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/tongiao.png"))); // NOI18N
        jButton19.setText("Tôn giáo");
        jButton19.setFocusable(false);
        jButton19.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton19.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton19);

        jButton20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/dantoc.png"))); // NOI18N
        jButton20.setText("Dân tộc");
        jButton20.setFocusable(false);
        jButton20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton20.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton20);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/quanlynguoidung.png"))); // NOI18N
        jButton2.setText("Tài khoản");
        jButton2.setToolTipText("Quản lý tài khoản");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar3.add(jButton2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jToolBar3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Khác", jPanel3);

        jpHienThi.setBackground(new java.awt.Color(255, 255, 255));
        jpHienThi.setForeground(new java.awt.Color(153, 153, 153));

        javax.swing.GroupLayout jpHienThiLayout = new javax.swing.GroupLayout(jpHienThi);
        jpHienThi.setLayout(jpHienThiLayout);
        jpHienThiLayout.setHorizontalGroup(
            jpHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jpHienThiLayout.setVerticalGroup(
            jpHienThiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 579, Short.MAX_VALUE)
        );

        jLabel4.setText("Mã GV");

        cb_giaoven.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_giaoven.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_giaovenActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemdiem.png"))); // NOI18N
        jButton3.setText("Xem phân công");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cb_namhoc, 0, 112, Short.MAX_VALUE)
                    .addComponent(cb_giaoven, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_tenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(0, 18, Short.MAX_VALUE))
            .addComponent(jpHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cb_giaoven, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_hocky, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cb_namhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpHienThi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cb_hocky, cb_namhoc});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, jLabel2});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnHocSinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocSinhActionPerformed
        loadform(1);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnHocSinhActionPerformed

    private void btnXepLopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXepLopActionPerformed
        loadform(3);
// TODO add your handling code here:
    }//GEN-LAST:event_btnXepLopActionPerformed

    private void btnHocPhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHocPhiActionPerformed
        loadform(10);
// TODO add your handling code here:
    }//GEN-LAST:event_btnHocPhiActionPerformed

    private void btnDiemHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiemHSActionPerformed
        loadform(2);
// TODO add your handling code here:
    }//GEN-LAST:event_btnDiemHSActionPerformed

    private void btnDanhGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDanhGiaActionPerformed
        loadform(5);
// TODO add your handling code here:
    }//GEN-LAST:event_btnDanhGiaActionPerformed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        loadform(9);
// TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void jToggleButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton8ActionPerformed
        loadform(6);
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton8ActionPerformed

    private void jToggleButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton9ActionPerformed
        loadform(7);
        // TODO add your handling code here:
    }//GEN-LAST:event_jToggleButton9ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        opendlpc();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cb_giaovenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_giaovenActionPerformed
        // TODO add your handling code here:
        int index = cb_giaoven.getSelectedIndex();
        if(index < 0){
            
        }else{
            txt_tenDN.setText(dsgv.get(index).getHoTenGV());
        }
        
    }//GEN-LAST:event_cb_giaovenActionPerformed

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
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnDanhGia;
    private javax.swing.JToggleButton btnDiemHS;
    private javax.swing.JToggleButton btnHocPhi;
    private javax.swing.JToggleButton btnHocSinh;
    private javax.swing.JToggleButton btnThongKe;
    private javax.swing.JToggleButton btnXepLop;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cb_giaoven;
    private javax.swing.JComboBox<String> cb_hocky;
    private javax.swing.JComboBox<String> cb_namhoc;
    private javax.swing.JDialog dl_dsPc;
    private javax.swing.JPanel fmHome;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToggleButton jToggleButton8;
    private javax.swing.JToggleButton jToggleButton9;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JToolBar jToolBar3;
    private javax.swing.JPanel jpHienThi;
    private javax.swing.JLabel lb_hocki;
    private javax.swing.JLabel lb_maGV;
    private javax.swing.JLabel lb_namhoc;
    private javax.swing.JLabel lb_tenGV;
    private javax.swing.JTable tbl_GVBM;
    private javax.swing.JTable tbl_GVCN;
    private javax.swing.JTextField txt_tenDN;
    // End of variables declaration//GEN-END:variables
}
