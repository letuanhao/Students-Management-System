/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import DAO.DAO;
import DAO.GVBM_DAO;
import DAO.GVCN_DAO;
import DAO.GiaoVien_DAO;
import DAO.XepLop_DAO;
import Model.GVBM;
import Model.GVCN;
import Model.GiaoVien;
import Model.HocKi;
import Model.HocSinh;
import Model.Lop;
import Model.MonHoc;
import Model.NamHoc;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author minh0
 */
public class fmGVCN extends javax.swing.JPanel {

    private DAO dao;
    private MainView main;
    private List<GiaoVien> dsGV;
    private List<GVCN> dsGVCN;
    private List<GVBM> dsGVBM;

    private List<HocSinh> dsHS;

    private int indexGVCN;
    private int indexGVBM;

    public fmGVCN(MainView mainView) {
        initComponents();
        this.main = mainView;
        loadcbGV();
        loadcbMH();
        loadcblop();
        loadcb();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop_gvcn = new javax.swing.JPopupMenu();
        mn_pcgvcn = new javax.swing.JMenuItem();
        mn_xoapcgvcn = new javax.swing.JMenuItem();
        mn_xemttgvcn = new javax.swing.JMenuItem();
        pop_gvbm = new javax.swing.JPopupMenu();
        mn_sua_gvbm = new javax.swing.JMenuItem();
        mn_xoa_gvbm = new javax.swing.JMenuItem();
        mn_xem_gvbm = new javax.swing.JMenuItem();
        dl_gvcn = new javax.swing.JDialog();
        lb_lop = new javax.swing.JLabel();
        lb_namhoc = new javax.swing.JLabel();
        lb_hocki = new javax.swing.JLabel();
        cb_giaovien = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btn_openTKGV = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_TTGV = new javax.swing.JTextArea();
        btn_xemdsHS = new javax.swing.JButton();
        btn_luu = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_monhoc = new javax.swing.JComboBox<>();
        dl_dsHS = new javax.swing.JDialog();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_dshs = new javax.swing.JTable();
        dl_timkiemGV = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maGV = new javax.swing.JTextField();
        txt_tenGV = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cb_chuyenmon = new javax.swing.JComboBox<>();
        cb_trinhdo = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_dsGV = new javax.swing.JTable();
        btn_timkiemGV = new javax.swing.JButton();
        btn_chonGV = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_pcgvcn = new javax.swing.JTable();
        btn_capnhatdsGVCN = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_pcgvbm = new javax.swing.JTable();
        cb_lophoc = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_them = new javax.swing.JButton();
        btn_capnhadsGVBM = new javax.swing.JButton();

        mn_pcgvcn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        mn_pcgvcn.setText("Phân công GVCN");
        mn_pcgvcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_pcgvcnActionPerformed(evt);
            }
        });
        pop_gvcn.add(mn_pcgvcn);

        mn_xoapcgvcn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        mn_xoapcgvcn.setText("Xóa phân công");
        mn_xoapcgvcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_xoapcgvcnActionPerformed(evt);
            }
        });
        pop_gvcn.add(mn_xoapcgvcn);

        mn_xemttgvcn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemdiem.png"))); // NOI18N
        mn_xemttgvcn.setText("Xem");
        mn_xemttgvcn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_xemttgvcnActionPerformed(evt);
            }
        });
        pop_gvcn.add(mn_xemttgvcn);

        mn_sua_gvbm.setText("Sủa phân công");
        mn_sua_gvbm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_sua_gvbmActionPerformed(evt);
            }
        });
        pop_gvbm.add(mn_sua_gvbm);

        mn_xoa_gvbm.setText("Xóa phân công");
        mn_xoa_gvbm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_xoa_gvbmActionPerformed(evt);
            }
        });
        pop_gvbm.add(mn_xoa_gvbm);

        mn_xem_gvbm.setText("Xem phân công");
        mn_xem_gvbm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_xem_gvbmActionPerformed(evt);
            }
        });
        pop_gvbm.add(mn_xem_gvbm);

        dl_gvcn.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        lb_lop.setText("Lớp :");

        lb_namhoc.setText("Năm học:");

        lb_hocki.setText("Học kì: ");

        cb_giaovien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cb_giaovien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_giaovienActionPerformed(evt);
            }
        });

        jLabel5.setText("Mã GV:");

        btn_openTKGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemdiem.png"))); // NOI18N
        btn_openTKGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_openTKGVActionPerformed(evt);
            }
        });

        jLabel6.setText("Thông tin giáo viên");

        txt_TTGV.setEditable(false);
        txt_TTGV.setColumns(20);
        txt_TTGV.setRows(5);
        jScrollPane1.setViewportView(txt_TTGV);

        btn_xemdsHS.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemdiem.png"))); // NOI18N
        btn_xemdsHS.setText("Xem dsHS");
        btn_xemdsHS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xemdsHSActionPerformed(evt);
            }
        });

        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        btn_huy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_huy.setText("Hủy");
        btn_huy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_huyActionPerformed(evt);
            }
        });

        jLabel7.setText("Môn học");

        cb_monhoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout dl_gvcnLayout = new javax.swing.GroupLayout(dl_gvcn.getContentPane());
        dl_gvcn.getContentPane().setLayout(dl_gvcnLayout);
        dl_gvcnLayout.setHorizontalGroup(
            dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_gvcnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_gvcnLayout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cb_giaovien, 0, 150, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_openTKGV, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_gvcnLayout.createSequentialGroup()
                        .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_hocki, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_lop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lb_namhoc, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(dl_gvcnLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(9, 9, 9)
                        .addComponent(cb_monhoc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(dl_gvcnLayout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(btn_xemdsHS)
                .addGap(28, 28, 28)
                .addComponent(btn_luu)
                .addGap(30, 30, 30)
                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        dl_gvcnLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_luu, btn_xemdsHS});

        dl_gvcnLayout.setVerticalGroup(
            dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_gvcnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_lop)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_gvcnLayout.createSequentialGroup()
                        .addComponent(lb_namhoc)
                        .addGap(18, 18, 18)
                        .addComponent(lb_hocki)
                        .addGap(18, 18, 18)
                        .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_openTKGV)
                            .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cb_giaovien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dl_gvcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_xemdsHS)
                    .addComponent(btn_luu)
                    .addComponent(btn_huy))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        dl_dsHS.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel8.setText("Tổng số học sinh: ");

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh sách học sinh"));

        tbl_dshs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã HS", "Tên HS", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_dshs);

        javax.swing.GroupLayout dl_dsHSLayout = new javax.swing.GroupLayout(dl_dsHS.getContentPane());
        dl_dsHS.getContentPane().setLayout(dl_dsHSLayout);
        dl_dsHSLayout.setHorizontalGroup(
            dl_dsHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_dsHSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(361, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        dl_dsHSLayout.setVerticalGroup(
            dl_dsHSLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_dsHSLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE))
        );

        dl_timkiemGV.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel1.setText("Mã GV");

        jLabel3.setText("Tên GV");

        jLabel4.setText("Chuyên môn");

        txt_maGV.setText("jTextField1");

        txt_tenGV.setText("jTextField2");

        jLabel9.setText("Trình độ:");

        cb_chuyenmon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_trinhdo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbl_dsGV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã GV", "Tên GV", "Chuyên Môn", "Trình độ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_dsGV);

        btn_timkiemGV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xemdiem.png"))); // NOI18N
        btn_timkiemGV.setText("Tìm kiếm");
        btn_timkiemGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_timkiemGVActionPerformed(evt);
            }
        });

        btn_chonGV.setText("Chọn GV này");
        btn_chonGV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_chonGVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dl_timkiemGVLayout = new javax.swing.GroupLayout(dl_timkiemGV.getContentPane());
        dl_timkiemGV.getContentPane().setLayout(dl_timkiemGVLayout);
        dl_timkiemGVLayout.setHorizontalGroup(
            dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_trinhdo, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_maGV, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tenGV, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cb_chuyenmon, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                        .addComponent(btn_timkiemGV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_chonGV)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 432, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dl_timkiemGVLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel3, jLabel4, jLabel9});

        dl_timkiemGVLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cb_chuyenmon, cb_trinhdo, txt_maGV, txt_tenGV});

        dl_timkiemGVLayout.setVerticalGroup(
            dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_timkiemGVLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_maGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenGV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cb_chuyenmon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_trinhdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dl_timkiemGVLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_timkiemGV)
                    .addComponent(btn_chonGV))
                .addContainerGap(184, Short.MAX_VALUE))
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phân công GVCN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        tbl_pcgvcn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã giáo viên", "Tên giáo viên", "Chuyên môn", "Lớp chủ nhiệm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pcgvcn.setComponentPopupMenu(pop_gvcn);
        jScrollPane4.setViewportView(tbl_pcgvcn);

        btn_capnhatdsGVCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_capnhatdsGVCN.setText("Cập nhật danh sách");
        btn_capnhatdsGVCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatdsGVCNActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_capnhatdsGVCN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_capnhatdsGVCN)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45))
        );

        jTabbedPane1.addTab("Phân công GVCN", jPanel1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách phân công giáo viên giảng dạy của lớp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10), new java.awt.Color(255, 0, 0))); // NOI18N

        tbl_pcgvbm.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã giáo viên", "Tên giáo viên", "Chuyên môn", "Môn học dạy"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_pcgvbm.setComponentPopupMenu(pop_gvbm);
        jScrollPane3.setViewportView(tbl_pcgvbm);

        cb_lophoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Lớp học: ");

        btn_them.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_them.setText("Thêm môn học và phân công");
        btn_them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themActionPerformed(evt);
            }
        });

        btn_capnhadsGVBM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_capnhadsGVBM.setText("Cập nhật danh sách");
        btn_capnhadsGVBM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhadsGVBMActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1000, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_lophoc, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_them)
                .addGap(18, 18, 18)
                .addComponent(btn_capnhadsGVBM)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_lophoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_them)
                    .addComponent(btn_capnhadsGVBM))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 499, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Phân công GVBM", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_timkiemGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_timkiemGVActionPerformed
        // TODO add your handling code here:
        String maGV = txt_maGV.getText().trim();
        String tengv = txt_tenGV.getText().trim();
        GiaoVien gv = new GiaoVien(maGV, tengv, "", "", (String) cb_chuyenmon.getSelectedItem(), (String) cb_trinhdo.getSelectedItem(), "", "");
        loadtblGV(gv);

    }//GEN-LAST:event_btn_timkiemGVActionPerformed

    private void btn_chonGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_chonGVActionPerformed
        // TODO add your handling code here:
        int index = tbl_dsGV.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            GiaoVien gv = dsGV.get(index);
            dl_timkiemGV.setVisible(false);
            cb_giaovien.setSelectedItem(gv.getMaGV());
            setTextTT(gv.getMaGV());

        }
    }//GEN-LAST:event_btn_chonGVActionPerformed

    private void mn_pcgvcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_pcgvcnActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvcn.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            String malop = dsGVCN.get(index).getMalop();
            loadtblHS(malop, main.getMaNH(), main.getmaHK());
            lb_lop.setText("Lớp " + Lop.getTenLop(malop, DataStatic.dsLop));
            lb_namhoc.setText("Năm học " + NamHoc.getNamHoc(main.getMaNH(), DataStatic.dsNH));
            lb_hocki.setText(HocKi.getTen(main.getmaHK(), DataStatic.dsHK));
            cb_giaovien.setSelectedItem(dsGVCN.get(index).getMaGV());
            openForm(PC_GVCN);
        }


    }//GEN-LAST:event_mn_pcgvcnActionPerformed

    private void mn_sua_gvbmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_sua_gvbmActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvbm.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            String malop = DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop();
            loadtblHS(malop, main.getMaNH(), main.getmaHK());
            lb_lop.setText("Lớp " + Lop.getTenLop(malop, DataStatic.dsLop));
            lb_namhoc.setText("Năm học " + NamHoc.getNamHoc(main.getMaNH(), DataStatic.dsNH));
            lb_hocki.setText(HocKi.getTen(main.getmaHK(), DataStatic.dsHK));
            cb_giaovien.setSelectedItem(dsGVBM.get(index).getMaGV());
            setcb_monhoc(dsGVBM.get(index).getMaMonHoc());
            openForm(SUA_PC_GVBM);
        }

    }//GEN-LAST:event_mn_sua_gvbmActionPerformed

    private void btn_themActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themActionPerformed
        // TODO add your handling code here:

        String malop = DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop();
        loadtblHS(malop, main.getMaNH(), main.getmaHK());
        lb_lop.setText("Lớp " + Lop.getTenLop(malop, DataStatic.dsLop));
        lb_namhoc.setText("Năm học " + NamHoc.getNamHoc(main.getMaNH(), DataStatic.dsNH));
        lb_hocki.setText(HocKi.getTen(main.getmaHK(), DataStatic.dsHK));
        openForm(THEM_PC_GVBM);

    }//GEN-LAST:event_btn_themActionPerformed

    private void btn_xemdsHSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xemdsHSActionPerformed
        // TODO add your handling code here:
        opendsHS();
    }//GEN-LAST:event_btn_xemdsHSActionPerformed

    private void btn_openTKGVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_openTKGVActionPerformed
        // TODO add your handling code here:
        openTKGV();
    }//GEN-LAST:event_btn_openTKGVActionPerformed

    private void btn_capnhatdsGVCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatdsGVCNActionPerformed
        // TODO add your handling code here:
        GVCN gvcn = new GVCN("", "", main.getMaNH(), main.getmaHK());
        loadTbldsGVCN(gvcn);
        loadcbGV();
    }//GEN-LAST:event_btn_capnhatdsGVCNActionPerformed

    private void btn_capnhadsGVBMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhadsGVBMActionPerformed
        // TODO add your handling code here:
        GVBM gvbm = new GVBM(DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop(), main.getMaNH(), main.getmaHK(), "", "");
        loadTbldsGVBM(gvbm);
        loadcbGV();
        loadcbMH();
    }//GEN-LAST:event_btn_capnhadsGVBMActionPerformed

    private void cb_giaovienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_giaovienActionPerformed
        // TODO add your handling code here:
        setTextTTGV((String) cb_giaovien.getSelectedItem());
    }//GEN-LAST:event_cb_giaovienActionPerformed

    private void mn_xemttgvcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_xemttgvcnActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvcn.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            String malop = dsGVCN.get(index).getMalop();
            loadtblHS(malop, main.getMaNH(), main.getmaHK());
            lb_lop.setText("Lớp " + Lop.getTenLop(malop, DataStatic.dsLop));
            lb_namhoc.setText("Năm học " + NamHoc.getNamHoc(dsGVCN.get(index).getMaNamHoc(), DataStatic.dsNH));
            lb_hocki.setText(HocKi.getTen(dsGVCN.get(index).getMaHocKi(), DataStatic.dsHK));
            cb_giaovien.setSelectedItem(dsGVCN.get(index).getMaGV());
            openForm(XEM_PC_GVCN);
        }
    }//GEN-LAST:event_mn_xemttgvcnActionPerformed

    private void btn_huyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_huyActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_huyActionPerformed

    private void mn_xem_gvbmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_xem_gvbmActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvbm.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            String malop = DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop();
            loadtblHS(malop, main.getMaNH(), main.getmaHK());
            lb_lop.setText("Lớp " + Lop.getTenLop(malop, DataStatic.dsLop));
            lb_namhoc.setText("Năm học " + NamHoc.getNamHoc(main.getMaNH(), DataStatic.dsNH));
            lb_hocki.setText(HocKi.getTen(main.getmaHK(), DataStatic.dsHK));
            cb_giaovien.setSelectedItem(dsGVBM.get(index).getMaGV());
            setcb_monhoc(dsGVBM.get(index).getMaMonHoc());
            openForm(XEM_PC_GVBM);
        }
    }//GEN-LAST:event_mn_xem_gvbmActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
        String maNH = main.getMaNH();
        String maHK = main.getmaHK();
        String malop = "";
        String maGV = (String) cb_giaovien.getSelectedItem();
        if (cb_monhoc.isVisible()) {
            dao = new GVBM_DAO();
            String maMH = DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc();
            malop = DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop();
            GVBM gvbm = new GVBM(malop, maNH, maHK, maGV, maMH);
            int check = dao.Them(gvbm);
            if (check == 0) {

            } else {
                loadTbldsGVBM(gvbm);
                //dl_gvcn.setVisible(false);
            }
        } else {
            dao = new GVCN_DAO();
            int index = tbl_pcgvcn.getSelectedRow();
            if (index == -1) {
                JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
            } else {
                malop = dsGVCN.get(index).getMalop();
                dao = new GVCN_DAO();
                GVCN gvcn = new GVCN(maGV, malop, maNH, maHK);
                int check = dao.Them(gvcn);
                if (check == 0) {

                } else {
                    loadTbldsGVCN(gvcn);
                    //dl_gvcn.setVisible(false);
                }
            }
        }
    }//GEN-LAST:event_btn_luuActionPerformed

    private void mn_xoapcgvcnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_xoapcgvcnActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvcn.getSelectedRow();
        dao = new GVCN_DAO();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            int ck = JOptionPane.showConfirmDialog(fmGVCN.this, " Xóa phân công này : ", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (ck == JOptionPane.YES_OPTION) {
                int check = dao.Xoa(dsGVCN.get(index));
                if (check == 0) {
                    JOptionPane.showMessageDialog(fmGVCN.this, "Xóa không thành công");
                } else {
                    loadTbldsGVCN(dsGVCN.get(index));
                }
            }
        }
    }//GEN-LAST:event_mn_xoapcgvcnActionPerformed

    private void mn_xoa_gvbmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_xoa_gvbmActionPerformed
        // TODO add your handling code here:
        int index = tbl_pcgvbm.getSelectedRow();
        dao = new GVBM_DAO();
        if (index == -1) {
            JOptionPane.showMessageDialog(fmGVCN.this, "Bạn chưa chọn Giáo viên");
        } else {
            int ck = JOptionPane.showConfirmDialog(fmGVCN.this, " Xóa phân công này : ", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            if (ck == JOptionPane.YES_OPTION) {
                int check = dao.Xoa(dsGVBM.get(index));
                if (check == 0) {
                    JOptionPane.showMessageDialog(fmGVCN.this, "Xóa không thành công");
                } else {
                    loadTbldsGVBM(dsGVBM.get(index));
                }
            }
        }
    }//GEN-LAST:event_mn_xoa_gvbmActionPerformed

    public void opendsHS() {
        dl_dsHS.setSize(500, 500);
        dl_dsHS.setLocationRelativeTo(null);
        dl_dsHS.setResizable(false);
        dl_dsHS.setTitle("Danh sách học sinh");

        dl_dsHS.setVisible(true);

    }

    public void openTKGV() {
        dl_timkiemGV.setSize(750, 400);
        dl_timkiemGV.setLocationRelativeTo(null);
        dl_timkiemGV.setResizable(false);
        dl_timkiemGV.setTitle("Tìm kiếm giáo viên");

        dl_timkiemGV.setVisible(true);
    }

    public void openForm(int chedo) {
        dl_gvcn.setSize(500, 300);
        dl_gvcn.setLocationRelativeTo(null);
        dl_gvcn.setResizable(false);
        switch (chedo) {
            case PC_GVCN:
                dl_gvcn.setTitle("Phân công giáo viên chủ nhiệm");
                cb_monhoc.setVisible(false);
                btn_luu.setEnabled(true);
                break;
            case XEM_PC_GVCN:
                dl_gvcn.setTitle("Phân công giáo viên chủ nhiệm");
                cb_monhoc.setVisible(false);
                btn_luu.setEnabled(false);
                break;
            case THEM_PC_GVBM:
                dl_gvcn.setTitle("Phân công giáo viên bộ môn");
                cb_monhoc.setVisible(true);
                btn_luu.setEnabled(true);
                break;
            case SUA_PC_GVBM:
                dl_gvcn.setTitle("Phân công giáo viên bộ môn");
                cb_monhoc.setVisible(true);
                btn_luu.setEnabled(true);
                break;
            case XEM_PC_GVBM:
                dl_gvcn.setTitle("Phân công giáo viên bộ môn");
                cb_monhoc.setVisible(true);
                btn_luu.setEnabled(false);
                break;
        }

        dl_gvcn.setVisible(true);

    }

    private void loadtblGV(GiaoVien gv) {
        dao = new GiaoVien_DAO();
        dsGV = dao.TìmKiem(gv);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsGV.getModel();
        tblmodel.setRowCount(0);
        if (dsGV != null || !dsGV.isEmpty()) {
            for (GiaoVien giaoVien : dsGV) {
                tblmodel.addRow(new Object[]{
                    giaoVien.getMaGV(), giaoVien.getHoTenGV(), giaoVien.getChuyenMon(), giaoVien.getTrinhDo()
                });
            }
        }
    }

    private void loadtblHS(String malop, String maNamHoc, String maHK) {
        XepLop_DAO daoXl = new XepLop_DAO();
        List<HocSinh> dsHS = daoXl.tkHSlop(false, maNamHoc, maHK, malop, true, false, maNamHoc, maHK);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dshs.getModel();
        int i = 1;
        tblmodel.setRowCount(0);
        if (dsHS != null || !dsHS.isEmpty()) {
            for (HocSinh hocSinh : dsHS) {
                tblmodel.addRow(new Object[]{
                    i, hocSinh.getMaHS(), hocSinh.getHotenHS(), hocSinh.getTrangThai()
                });
                i++;
            }
        }
        jLabel8.setText("Tổng số học sinh: " + dsHS.size());
    }

    private void setTextTTGV(String maGV) {
        dao = new GiaoVien_DAO();
        GiaoVien gv = (GiaoVien) dao.getT(maGV);
        if (gv == null) {
            gv = new GiaoVien("", "", "", "", "", "", "", "");
        }
        txt_TTGV.setText(
                "Tên GV: " + gv.getHoTenGV() + " \n"
                + "Giới tính: " + gv.getGioitinh() + "\n"
                + "Trình độ: " + gv.getTrinhDo() + "\n"
                + "Chuyên môn: " + gv.getChuyenMon() + "\n"
                + "SĐT: " + gv.getDienThoai() + "\n"
                + "Địa chỉ: " + gv.getDiachi() + "\n"
                + "Ghi chú: " + gv.getGhiChu()
        );

    }

    private void setTextTT(String malop) {
        lb_namhoc.setText("Năm học : " + NamHoc.getNamHoc(main.getMaNH(), DataStatic.dsNH));
        lb_hocki.setText(HocKi.getTen(main.getmaHK(), DataStatic.dsHK));
        lb_lop.setText("Lớp: " + Lop.getTenLop(malop, DataStatic.dsLop));
    }

    private void loadcblop() {
        cb_lophoc.removeAllItems();
        for (Lop l : DataStatic.dsLop) {
            cb_lophoc.addItem(l.getTenLop());
        }
    }

    private void loadcbMH() {
        cb_monhoc.removeAllItems();
        for (MonHoc object : DataStatic.dsMH) {
            cb_monhoc.addItem(object.getMonHoc());
        }
    }

    private void loadcbGV() {
        dao = new GiaoVien_DAO();
        List<GiaoVien> dsGV = dao.getALL();
        cb_giaovien.removeAllItems();
        for (GiaoVien giaoVien : dsGV) {
            cb_giaovien.addItem(giaoVien.getMaGV());
        }
    }

    private void loadTbldsGVCN(GVCN gvcn) {
        dao = new GVCN_DAO();
        dsGVCN = dao.TìmKiem(gvcn);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_pcgvcn.getModel();
        tblmodel.setRowCount(0);
        for (GVCN gvcn1 : dsGVCN) {
            GiaoVien_DAO gvdao = new GiaoVien_DAO();
            GiaoVien gv = gvdao.getT(gvcn1.getMaGV());
            tblmodel.addRow(new Object[]{
                gv.getMaGV(), gv.getHoTenGV(), gv.getChuyenMon(), Lop.getTenLop(gvcn1.getMalop(), DataStatic.dsLop)
            });
        }
        tbl_pcgvcn.setRowHeight(20);
    }

    private void loadTbldsGVBM(GVBM gvbm) {
        dao = new GVBM_DAO();
        dsGVBM = dao.TìmKiem(gvbm);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_pcgvbm.getModel();
        tblmodel.setRowCount(0);
        for (GVBM gvbm1 : dsGVBM) {
            GiaoVien_DAO gvdao = new GiaoVien_DAO();
            GiaoVien gv = gvdao.getT(gvbm1.getMaGV());
            tblmodel.addRow(new Object[]{
                gv.getMaGV(), gv.getHoTenGV(), gv.getChuyenMon(), MonHoc.getTen(gvbm1.getMaMonHoc(), DataStatic.dsMH)
            });
        }
    }

    private void loadcb() {
        cb_trinhdo.removeAllItems();
        cb_trinhdo.addItem("");
        for (String td : DataStatic.TD) {
            cb_trinhdo.addItem(td);
        }

        cb_chuyenmon.removeAllItems();
        cb_chuyenmon.addItem("");
        for (String cm : DataStatic.CM) {
            cb_chuyenmon.addItem(cm);
        }

    }

    private void setcb_monhoc(String maMH) {
        cb_monhoc.setSelectedItem(MonHoc.getTen(maMH, DataStatic.dsMH));
    }
    private static final int PC_GVCN = 1;
    private static final int XEM_PC_GVCN = 2;
    private static final int THEM_PC_GVBM = 3;
    private static final int SUA_PC_GVBM = 4;
    private static final int XEM_PC_GVBM = 5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhadsGVBM;
    private javax.swing.JButton btn_capnhatdsGVCN;
    private javax.swing.JButton btn_chonGV;
    private javax.swing.JButton btn_huy;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_openTKGV;
    private javax.swing.JButton btn_them;
    private javax.swing.JButton btn_timkiemGV;
    private javax.swing.JButton btn_xemdsHS;
    private javax.swing.JComboBox<String> cb_chuyenmon;
    private javax.swing.JComboBox<String> cb_giaovien;
    private javax.swing.JComboBox<String> cb_lophoc;
    private javax.swing.JComboBox<String> cb_monhoc;
    private javax.swing.JComboBox<String> cb_trinhdo;
    private javax.swing.JDialog dl_dsHS;
    private javax.swing.JDialog dl_gvcn;
    private javax.swing.JDialog dl_timkiemGV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_hocki;
    private javax.swing.JLabel lb_lop;
    private javax.swing.JLabel lb_namhoc;
    private javax.swing.JMenuItem mn_pcgvcn;
    private javax.swing.JMenuItem mn_sua_gvbm;
    private javax.swing.JMenuItem mn_xem_gvbm;
    private javax.swing.JMenuItem mn_xemttgvcn;
    private javax.swing.JMenuItem mn_xoa_gvbm;
    private javax.swing.JMenuItem mn_xoapcgvcn;
    private javax.swing.JPopupMenu pop_gvbm;
    private javax.swing.JPopupMenu pop_gvcn;
    private javax.swing.JTable tbl_dsGV;
    private javax.swing.JTable tbl_dshs;
    private javax.swing.JTable tbl_pcgvbm;
    private javax.swing.JTable tbl_pcgvcn;
    private javax.swing.JTextArea txt_TTGV;
    private javax.swing.JTextField txt_maGV;
    private javax.swing.JTextField txt_tenGV;
    // End of variables declaration//GEN-END:variables
}
