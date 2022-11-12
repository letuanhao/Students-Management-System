package View;

import Connection.DatabaseConn;
import DAO.Another_DAO;
import DAO.DiemHS_DAO;
import DAO.HSDiem_DAO;
import DAO.TKMon_DAO;
import Model.DiemChiTiet;
import Model.DiemHocSinh;
import Model.DiemTKMHnam;
import Model.HocSinhDiem;
import Model.Lop;
import Model.MonHoc;
import Model.Tongketmon;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

public class fmDiemHS extends javax.swing.JPanel {

    private MainView mainView;
    private List<HocSinhDiem> dsHocSinhDiem;

    public fmDiemHS(MainView mainView) {
        initComponents();
        this.mainView = mainView;
        loadcblop();
        loadcbMH();
        updatcelllistener();
    }

    public void updatcelllistener() {

        CellEditorListener ChangeNotification = new CellEditorListener() {
            public void editingCanceled(ChangeEvent e) {
                System.out.println("The user canceled editing.");
            }

            public void editingStopped(ChangeEvent e) {
//                System.out.println("The user stopped editing successfully.");
//                System.out.println(tbl_tkmon.getSelectedRow());
                TKMon_DAO dao = new TKMon_DAO();

                if (tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 1) != null) {
                    String maHS = String.valueOf(tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 1));
                    String tongBHString = "0";
                    if (tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 5) != null) {
                        tongBHString = String.valueOf(tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 5));
                    }
                    String tongBPString = "0";
                    if (tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 6) != null) {
                        tongBPString = String.valueOf(tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 6));
                    }
                    String tongBKPString = "0";
                    if (tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 5) != null) {
                        tongBKPString = String.valueOf(tbl_tkmon.getValueAt(tbl_tkmon.getSelectedRow(), 7));
                    }
                    Tongketmon tongketmon = new Tongketmon(maHS.trim(), DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc(),
                             mainView.getMaNH(), mainView.getmaHK(), 0, 0,
                             Integer.parseInt(tongBHString),
                             Integer.parseInt(tongBPString),
                             Integer.parseInt(tongBKPString));
                    if (dao.Sua(tongketmon) == 0) {
                        JOptionPane.showMessageDialog(fmDiemHS.this, "Không thành công");
                    }
                }
            }
        };
        tbl_tkmon.getDefaultEditor(Integer.class).addCellEditorListener(ChangeNotification);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pop_qlDiem = new javax.swing.JPopupMenu();
        itemQLDiem = new javax.swing.JMenuItem();
        itemDSnhapDiem = new javax.swing.JMenuItem();
        dl_qldiemhs = new javax.swing.JDialog();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_maHS = new javax.swing.JTextField();
        lb_loaidiem = new javax.swing.JLabel();
        txt_hoten = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_diemctHS = new javax.swing.JTable();
        btn_themhsdiem = new javax.swing.JButton();
        btn_luuhsdiem = new javax.swing.JButton();
        btn_xoahsdiem = new javax.swing.JButton();
        txt_diemso = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_madiem = new javax.swing.JTextField();
        dl_themdsDiem = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_dsnhapdiem = new javax.swing.JTable();
        btn_themdsdiem = new javax.swing.JButton();
        lb_loaidiemnhapds = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jp_diem = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDiemHS = new javax.swing.JTable();
        jp_dtbhk = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_tkmon = new javax.swing.JTable();
        jp_dtbcn = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbl_dsTKMHnam = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cb_monhoc = new javax.swing.JComboBox<>();
        cb_lop = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        btn_reload = new javax.swing.JButton();

        itemQLDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        itemQLDiem.setText("QL Điểm");
        itemQLDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemQLDiemActionPerformed(evt);
            }
        });
        pop_qlDiem.add(itemQLDiem);

        itemDSnhapDiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        itemDSnhapDiem.setText("Thêm danh sách điểm");
        itemDSnhapDiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemDSnhapDiemActionPerformed(evt);
            }
        });
        pop_qlDiem.add(itemDSnhapDiem);

        jLabel1.setText("Mã HS");

        jLabel4.setText("Tên HS");

        jLabel5.setText("Điểm số");

        txt_maHS.setEditable(false);

        lb_loaidiem.setText("Loại điểm: ");

        txt_hoten.setEditable(false);

        tbl_diemctHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "STT", "Điểm số"
            }
        ));
        tbl_diemctHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_diemctHSMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_diemctHS);

        btn_themhsdiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_themhsdiem.setText("Thêm");
        btn_themhsdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themhsdiemActionPerformed(evt);
            }
        });

        btn_luuhsdiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_luuhsdiem.setText("Lưu");
        btn_luuhsdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuhsdiemActionPerformed(evt);
            }
        });

        btn_xoahsdiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btn_xoahsdiem.setText("Xóa");
        btn_xoahsdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoahsdiemActionPerformed(evt);
            }
        });

        txt_diemso.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        jLabel8.setText("Mã điểm");

        txt_madiem.setEditable(false);

        javax.swing.GroupLayout dl_qldiemhsLayout = new javax.swing.GroupLayout(dl_qldiemhs.getContentPane());
        dl_qldiemhs.getContentPane().setLayout(dl_qldiemhsLayout);
        dl_qldiemhsLayout.setHorizontalGroup(
            dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(24, 24, 24)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_maHS)
                            .addComponent(txt_hoten)))
                    .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lb_loaidiem)
                            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txt_diemso, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                                .addComponent(btn_themhsdiem)
                                .addGap(18, 18, 18)
                                .addComponent(btn_luuhsdiem))
                            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(btn_xoahsdiem))
                            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_madiem)))
                        .addGap(0, 13, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dl_qldiemhsLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btn_luuhsdiem, btn_themhsdiem, btn_xoahsdiem});

        dl_qldiemhsLayout.setVerticalGroup(
            dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_qldiemhsLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txt_madiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_maHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_hoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(lb_loaidiem)
                        .addGap(22, 22, 22)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_diemso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_qldiemhsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_themhsdiem)
                            .addComponent(btn_luuhsdiem))
                        .addGap(18, 18, 18)
                        .addComponent(btn_xoahsdiem))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        dl_themdsDiem.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        tbl_dsnhapdiem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã HS", "Tên HS", "Điểm số"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dsnhapdiem.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tbl_dsnhapdiem);

        btn_themdsdiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        btn_themdsdiem.setText("Thêm danh sách điểm");
        btn_themdsdiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themdsdiemActionPerformed(evt);
            }
        });

        lb_loaidiemnhapds.setText("THÊM ĐIỂM MIỆNG");

        javax.swing.GroupLayout dl_themdsDiemLayout = new javax.swing.GroupLayout(dl_themdsDiem.getContentPane());
        dl_themdsDiem.getContentPane().setLayout(dl_themdsDiemLayout);
        dl_themdsDiemLayout.setHorizontalGroup(
            dl_themdsDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE)
            .addGroup(dl_themdsDiemLayout.createSequentialGroup()
                .addGroup(dl_themdsDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_themdsDiemLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(btn_themdsdiem, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_themdsDiemLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lb_loaidiemnhapds, javax.swing.GroupLayout.PREFERRED_SIZE, 306, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        dl_themdsDiemLayout.setVerticalGroup(
            dl_themdsDiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_themdsDiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_loaidiemnhapds)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_themdsdiem)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách điểm học sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N

        tblDiemHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "Điểm miệng", "Điểm 15'", "Điểm giữa kì", "Điểm cuối kì", "Điểm thi lại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDiemHS.setComponentPopupMenu(pop_qlDiem);
        tblDiemHS.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblDiemHS);

        javax.swing.GroupLayout jp_diemLayout = new javax.swing.GroupLayout(jp_diem);
        jp_diem.setLayout(jp_diemLayout);
        jp_diemLayout.setHorizontalGroup(
            jp_diemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_diemLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1050, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_diemLayout.setVerticalGroup(
            jp_diemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Điểm", jp_diem);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách tổng kết môn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N

        tbl_tkmon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Họ tên học sinh", "Điểm TB thành phần", "Điểm TB học kì", "Tổng số buổi học", "Nghỉ phép", "Nghỉ không phép"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_tkmon.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbl_tkmon);

        javax.swing.GroupLayout jp_dtbhkLayout = new javax.swing.GroupLayout(jp_dtbhk);
        jp_dtbhk.setLayout(jp_dtbhkLayout);
        jp_dtbhkLayout.setHorizontalGroup(
            jp_dtbhkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1056, Short.MAX_VALUE)
            .addGroup(jp_dtbhkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1056, Short.MAX_VALUE))
        );
        jp_dtbhkLayout.setVerticalGroup(
            jp_dtbhkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
            .addGroup(jp_dtbhkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Điểm tổng kết học kì", jp_dtbhk);

        tbl_dsTKMHnam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Họ tên HS", "Điểm TB cả năm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tbl_dsTKMHnam);

        javax.swing.GroupLayout jp_dtbcnLayout = new javax.swing.GroupLayout(jp_dtbcn);
        jp_dtbcn.setLayout(jp_dtbcnLayout);
        jp_dtbcnLayout.setHorizontalGroup(
            jp_dtbcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_dtbcnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 1044, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_dtbcnLayout.setVerticalGroup(
            jp_dtbcnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 499, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Điểm tổng kết cả năm", jp_dtbcn);

        jLabel2.setText("Lớp: ");

        cb_monhoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setText("Môn học");

        btn_reload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_reload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_reloadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(cb_monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_lop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(btn_reload)
                .addGap(544, 544, 544))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cb_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cb_monhoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btn_reload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_reloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_reloadActionPerformed
        // TODO add your handling code here:
        Another_DAO adao = new Another_DAO();
        if (adao.checkGVBM(mainView.getmaGV(), mainView.getMaNH(), mainView.getmaHK(), DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc(), DataStatic.dsLop.get(cb_lop.getSelectedIndex()).getMaLop()) == 1) {
            HSDiem_DAO dao = new HSDiem_DAO();
            HocSinhDiem t = new HocSinhDiem("", DataStatic.dsLop.get(cb_lop.getSelectedIndex()).getMaLop(),
                    "", DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc(),
                    mainView.getMaNH(), mainView.getmaHK());
            dsHocSinhDiem = dao.TìmKiem(t);
            loadListtblDiem();
            loaddsTKMHnam();
        }else{
            JOptionPane.showMessageDialog(fmDiemHS.this, "Bạn ko là GVBM của lớp");
        }
        
        //System.out.println(dsHocSinhDiem.size());
    }//GEN-LAST:event_btn_reloadActionPerformed

    private void itemQLDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemQLDiemActionPerformed
        // TODO add your handling code here:
        int indexco = tblDiemHS.getSelectedColumn();
        int indexro = tblDiemHS.getSelectedRow();
        if (indexro == -1) {

        } else {
            indexQLDiemHS = indexro;
            if (indexco == 3) {
                curentdiem = MIENG;
                curentloaidiem = DataStatic.DIEMMIENG;
                loadtbldiemctHS(dsHocSinhDiem.get(indexQLDiemHS).getDiemMieng());
                openFormQLdiemHS();
            } else if (indexco == 4) {
                curentdiem = P15;
                curentloaidiem = DataStatic.DIEM15P;
                loadtbldiemctHS(dsHocSinhDiem.get(indexQLDiemHS).getDiem15());
                openFormQLdiemHS();
            } else if (indexco == 5) {
                curentdiem = GK;
                curentloaidiem = DataStatic.DIEMGK;
                loadtbldiemctHS(dsHocSinhDiem.get(indexQLDiemHS).getDiemGK());
                openFormQLdiemHS();
            } else if (indexco == 6) {
                curentdiem = CK;
                curentloaidiem = DataStatic.DIEMCK;
                loadtbldiemctHS(dsHocSinhDiem.get(indexQLDiemHS).getDiemHK());
                openFormQLdiemHS();
            } else if (indexco == 7) {
                curentdiem = THILAI;
                curentloaidiem = DataStatic.DIEMTHILAI;
                loadtbldiemctHS(dsHocSinhDiem.get(indexQLDiemHS).getDiemThiLai());
                openFormQLdiemHS();
            }

        }
    }//GEN-LAST:event_itemQLDiemActionPerformed

    private void btn_themhsdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themhsdiemActionPerformed
        // TODO add your handling code here:
        DiemHocSinh dhs = new DiemHocSinh(0, curentloaidiem,
                dsHocSinhDiem.get(indexQLDiemHS).getMaMH(),
                txt_maHS.getText(), dsHocSinhDiem.get(indexQLDiemHS).getMaHK(),
                dsHocSinhDiem.get(indexQLDiemHS).getMaNH(), Float.valueOf(txt_diemso.getText()));
        DiemHS_DAO dao = new DiemHS_DAO();
        int check = dao.Them(dhs);
        if (check == 1) {
            List<DiemHocSinh> ds = dao.TìmKiem(dhs);
            loaddatawhensuccess(ds);
        } else {
            JOptionPane.showMessageDialog(dl_qldiemhs, "Thêm không thành công");
        }
    }//GEN-LAST:event_btn_themhsdiemActionPerformed

    private void btn_luuhsdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuhsdiemActionPerformed
        // TODO add your handling code here:
        DiemHocSinh dhs = new DiemHocSinh(Integer.valueOf(txt_madiem.getText()),
                curentloaidiem,
                dsHocSinhDiem.get(indexQLDiemHS).getMaMH(),
                txt_maHS.getText(), dsHocSinhDiem.get(indexQLDiemHS).getMaHK(),
                dsHocSinhDiem.get(indexQLDiemHS).getMaNH(), Float.valueOf(txt_diemso.getText()));
        DiemHS_DAO dao = new DiemHS_DAO();
        int check = dao.Sua(dhs);
        List<DiemHocSinh> ds = dao.TìmKiem(dhs);
        loaddatawhensuccess(ds);
    }//GEN-LAST:event_btn_luuhsdiemActionPerformed

    private void btn_xoahsdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoahsdiemActionPerformed
        // TODO add your handling code here:

        DiemHocSinh dhs = new DiemHocSinh(Integer.valueOf(txt_madiem.getText()),
                curentloaidiem,
                dsHocSinhDiem.get(indexQLDiemHS).getMaMH(),
                txt_maHS.getText(), dsHocSinhDiem.get(indexQLDiemHS).getMaHK(),
                dsHocSinhDiem.get(indexQLDiemHS).getMaNH(), Float.valueOf(txt_diemso.getText()));
        DiemHS_DAO dao = new DiemHS_DAO();
        int check = dao.Xoa(dhs);
        List<DiemHocSinh> ds = dao.TìmKiem(dhs);
        loaddatawhensuccess(ds);
    }//GEN-LAST:event_btn_xoahsdiemActionPerformed

    private void tbl_diemctHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_diemctHSMouseClicked
        // TODO add your handling code here:
        int index = tbl_diemctHS.getSelectedRow();
        if (index != -1) {
            if (curentdiem == MIENG) {
                DiemHocSinh dhs = dsHocSinhDiem.get(indexQLDiemHS).getDiemMieng().get(index);
                txt_madiem.setText(String.valueOf(dhs.getSTT()));
                txt_diemso.setText(String.valueOf(dhs.getDiemSo()));
            } else if (curentdiem == P15) {
                DiemHocSinh dhs = dsHocSinhDiem.get(indexQLDiemHS).getDiem15().get(index);
                txt_madiem.setText(String.valueOf(dhs.getSTT()));
                txt_diemso.setText(String.valueOf(dhs.getDiemSo()));
            } else if (curentdiem == GK) {
                DiemHocSinh dhs = dsHocSinhDiem.get(indexQLDiemHS).getDiemGK().get(index);
                txt_madiem.setText(String.valueOf(dhs.getSTT()));
                txt_diemso.setText(String.valueOf(dhs.getDiemSo()));
            } else if (curentdiem == CK) {
                DiemHocSinh dhs = dsHocSinhDiem.get(indexQLDiemHS).getDiemHK().get(index);
                txt_madiem.setText(String.valueOf(dhs.getSTT()));
                txt_diemso.setText(String.valueOf(dhs.getDiemSo()));
            } else if (curentdiem == THILAI) {
                DiemHocSinh dhs = dsHocSinhDiem.get(indexQLDiemHS).getDiemThiLai().get(index);
                txt_madiem.setText(String.valueOf(dhs.getSTT()));
                txt_diemso.setText(String.valueOf(dhs.getDiemSo()));
            }
        }


    }//GEN-LAST:event_tbl_diemctHSMouseClicked

    private void itemDSnhapDiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemDSnhapDiemActionPerformed
        // TODO add your handling code here:
        int indexco = tblDiemHS.getSelectedColumn();
        if (indexco == 3) {
            curentloaidiem = DataStatic.DIEMMIENG;
            openformnhapdsdiem();
        } else if (indexco == 4) {
            curentloaidiem = DataStatic.DIEM15P;
            openformnhapdsdiem();
        } else if (indexco == 5) {
            curentloaidiem = DataStatic.DIEMGK;
            openformnhapdsdiem();
        } else if (indexco == 6) {
            curentloaidiem = DataStatic.DIEMCK;
            openformnhapdsdiem();
        } else if (indexco == 7) {
            curentloaidiem = DataStatic.DIEMTHILAI;
            openformnhapdsdiem();
        }
    }//GEN-LAST:event_itemDSnhapDiemActionPerformed

    private void btn_themdsdiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themdsdiemActionPerformed
        // TODO add your handling code here:
        DiemHS_DAO dao = new DiemHS_DAO();
        boolean isdone = true;
        Connection c = DatabaseConn.getDBConn().getconn();
        try {
            c.setAutoCommit(false);
            for (int i = 0; i < tbl_dsnhapdiem.getRowCount(); i++) {
                if (tbl_dsnhapdiem.getValueAt(i, 3) != null) {
                    DiemHocSinh dhs = new DiemHocSinh(0, curentloaidiem,
                            dsHocSinhDiem.get(indexQLDiemHS).getMaMH(),
                            String.valueOf(tbl_dsnhapdiem.getValueAt(i, 1)).trim(),
                            dsHocSinhDiem.get(indexQLDiemHS).getMaHK(),
                            dsHocSinhDiem.get(indexQLDiemHS).getMaNH(),
                            Float.valueOf((String.valueOf(tbl_dsnhapdiem.getValueAt(i, 3)).trim())));
                    if (dao.Them(dhs) == 0) {
                        c.rollback();
                        isdone = false;
                        break;
                    }

                }
            }
            c.commit();

        } catch (SQLException ex) {
        }

        try {
            c.setAutoCommit(true);
        } catch (SQLException ex) {

        }
        HSDiem_DAO diem_DAO = new HSDiem_DAO();
        if (isdone) {
            HocSinhDiem t = new HocSinhDiem("", DataStatic.dsLop.get(cb_lop.getSelectedIndex()).getMaLop(),
                    "", DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc(),
                    mainView.getMaNH(), mainView.getmaHK());
            dsHocSinhDiem = diem_DAO.TìmKiem(t);
            loadListtblDiem();
            dl_themdsDiem.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(dl_themdsDiem, "Thêm không thành công");
        }
    }//GEN-LAST:event_btn_themdsdiemActionPerformed

    private void loaddatawhensuccess(List<DiemHocSinh> ds) {
        DefaultTableModel tblmodel = (DefaultTableModel) tblDiemHS.getModel();
        if (curentdiem == MIENG) {
            dsHocSinhDiem.get(indexQLDiemHS).setDiemMieng(ds);
            tblmodel.setValueAt(HocSinhDiem.getDiemList(ds), indexQLDiemHS, 3);
        } else if (curentdiem == P15) {
            dsHocSinhDiem.get(indexQLDiemHS).setDiem15(ds);
            tblmodel.setValueAt(HocSinhDiem.getDiemList(ds), indexQLDiemHS, 4);
        } else if (curentdiem == GK) {
            dsHocSinhDiem.get(indexQLDiemHS).setDiemGK(ds);
            tblmodel.setValueAt(HocSinhDiem.getDiemList(ds), indexQLDiemHS, 5);
        } else if (curentdiem == CK) {
            dsHocSinhDiem.get(indexQLDiemHS).setDiemHK(ds);
            tblmodel.setValueAt(HocSinhDiem.getDiemList(ds), indexQLDiemHS, 6);
        } else if (curentdiem == THILAI) {
            dsHocSinhDiem.get(indexQLDiemHS).setDiemThiLai(ds);
            tblmodel.setValueAt(HocSinhDiem.getDiemList(ds), indexQLDiemHS, 7);
        }
        loadtbldiemctHS(ds);

    }

    private void openformnhapdsdiem() {
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsnhapdiem.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        if (dsHocSinhDiem != null) {
            for (HocSinhDiem hocSinhDiem : dsHocSinhDiem) {
                tblmodel.addRow(new Object[]{i,
                    hocSinhDiem.getMaHS(),
                    hocSinhDiem.getTenHS()
                });
                i++;
            }
        }
        lb_loaidiemnhapds.setText("Loại điểm : " + DiemChiTiet.getTenDCT(curentloaidiem, DataStatic.dsDCT));
        dl_themdsDiem.setSize(600, 550);
        dl_themdsDiem.setLocationRelativeTo(null);
        dl_themdsDiem.setResizable(false);
        dl_themdsDiem.setVisible(true);
    }

    private void openFormQLdiemHS() {
        HocSinhDiem hsd = dsHocSinhDiem.get(indexQLDiemHS);
        txt_maHS.setText(hsd.getMaHS());
        txt_hoten.setText(hsd.getTenHS());
        lb_loaidiem.setText("Loại điểm : " + DiemChiTiet.getTenDCT(curentloaidiem, DataStatic.dsDCT));
        txt_madiem.setText("");
        txt_diemso.setText("0");
        dl_qldiemhs.setSize(600, 350);
        dl_qldiemhs.setLocationRelativeTo(null);
        dl_qldiemhs.setResizable(false);
        dl_qldiemhs.setVisible(true);
    }

    private void loadtbldiemctHS(List<DiemHocSinh> ds) {
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_diemctHS.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        for (DiemHocSinh d : ds) {
            tblmodel.addRow(new Object[]{i,
                d.getDiemSo()});
            i++;
        }
    }

    private void loadListtblDiem() {
        DefaultTableModel tblmodel = (DefaultTableModel) tblDiemHS.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        for (HocSinhDiem hocSinhDiem : dsHocSinhDiem) {
            tblmodel.addRow(new Object[]{i,
                hocSinhDiem.getMaHS(),
                hocSinhDiem.getTenHS(),
                HocSinhDiem.getDiemList(hocSinhDiem.getDiemMieng()),
                HocSinhDiem.getDiemList(hocSinhDiem.getDiem15()),
                HocSinhDiem.getDiemList(hocSinhDiem.getDiemGK()),
                HocSinhDiem.getDiemList(hocSinhDiem.getDiemHK()),
                HocSinhDiem.getDiemList(hocSinhDiem.getDiemThiLai()),});
            i++;
        }
        loadListtblTKmon();
    }

    private void loadListtblTKmon() {
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_tkmon.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        for (HocSinhDiem hocSinhDiem : dsHocSinhDiem) {
            tblmodel.addRow(new Object[]{i,
                hocSinhDiem.getMaHS(),
                hocSinhDiem.getTenHS(),
                diemsof(hocSinhDiem.getTKmon().getDiemQT()),
                diemsof(hocSinhDiem.getTKmon().getDiemTB()),
                diemsoi(hocSinhDiem.getTKmon().getTongBH()),
                diemsoi(hocSinhDiem.getTKmon().getBHphep()),
                diemsoi(hocSinhDiem.getTKmon().getBHKphep())
            });
            i++;
        }

    }

    private String diemsoi(int object) {
        String t = "";
        int tint = Integer.valueOf(String.valueOf(object));
        if (tint != -1) {
            t = String.valueOf(object);
        }
        return t;
    }

    private String diemsof(float object) {
        String t = "";
        float tf = Float.valueOf(String.valueOf(object));
        if (tf != -1.0f) {
            t = String.valueOf(object);
        }
        return t;
    }

    private void loadcblop() {
        cb_lop.removeAllItems();
        for (Lop l : DataStatic.dsLop) {
            cb_lop.addItem(l.getTenLop());
        }
    }

    private void loadcbMH() {
        cb_monhoc.removeAllItems();
        for (MonHoc object : DataStatic.dsMH) {
            cb_monhoc.addItem(object.getMonHoc());
        }
    }

    private void loaddsTKMHnam() {
        Another_DAO dao = new Another_DAO();
        List<DiemTKMHnam> ds = dao.dsDiemTKMHnam(mainView.getMaNH(),
                 DataStatic.dsLop.get(cb_lop.getSelectedIndex()).getMaLop(), DataStatic.dsMH.get(cb_monhoc.getSelectedIndex()).getMaMonHoc());
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsTKMHnam.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        for (DiemTKMHnam d : ds) {
            tblmodel.addRow(new Object[]{i,
                d.maHS,
                d.tenHS,
                d.DiemTBCN
            });
            i++;
        }
    }
    private int indexQLDiemHS;
    private String curentloaidiem = DataStatic.DIEMMIENG;
    private int curentdiem = MIENG;
    private static final int MIENG = 1;
    private static final int P15 = 2;
    private static final int GK = 3;
    private static final int CK = 4;
    private static final int THILAI = 5;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_luuhsdiem;
    private javax.swing.JButton btn_reload;
    private javax.swing.JButton btn_themdsdiem;
    private javax.swing.JButton btn_themhsdiem;
    private javax.swing.JButton btn_xoahsdiem;
    private javax.swing.JComboBox<String> cb_lop;
    private javax.swing.JComboBox<String> cb_monhoc;
    private javax.swing.JDialog dl_qldiemhs;
    private javax.swing.JDialog dl_themdsDiem;
    private javax.swing.JMenuItem itemDSnhapDiem;
    private javax.swing.JMenuItem itemQLDiem;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel jp_diem;
    private javax.swing.JPanel jp_dtbcn;
    private javax.swing.JPanel jp_dtbhk;
    private javax.swing.JLabel lb_loaidiem;
    private javax.swing.JLabel lb_loaidiemnhapds;
    private javax.swing.JPopupMenu pop_qlDiem;
    private javax.swing.JTable tblDiemHS;
    private javax.swing.JTable tbl_diemctHS;
    private javax.swing.JTable tbl_dsTKMHnam;
    private javax.swing.JTable tbl_dsnhapdiem;
    private javax.swing.JTable tbl_tkmon;
    private javax.swing.JFormattedTextField txt_diemso;
    private javax.swing.JTextField txt_hoten;
    private javax.swing.JTextField txt_maHS;
    private javax.swing.JTextField txt_madiem;
    // End of variables declaration//GEN-END:variables
}
