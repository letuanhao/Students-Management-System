package View;

import DAO.Another_DAO;
import DAO.DanhGia_DAO;
import Model.DanhGiaHS;
import Model.HanhKiem;
import Model.HocLuc;
import Model.Lop;
import Model.another.DTB_HS;
import Model.another.DanhGiaCN;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fmDanhGiaHS extends javax.swing.JPanel {
    private MainView mainView;
    
    private List<DanhGiaHS> dsDanhGiaHS;
    private List<DanhGiaCN> danhGiaCNs;
    public fmDanhGiaHS(MainView mainView) {
        this.mainView = mainView;
        initComponents();
        
        loadcblop();
        loadcb_hanhkiem();
        loadcbtrangthai();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        popDanhGia = new javax.swing.JPopupMenu();
        itemSuaDG = new javax.swing.JMenuItem();
        dl_danhgia = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_maHS = new javax.swing.JTextField();
        txt_tenHS = new javax.swing.JTextField();
        cb_hanhkiem = new javax.swing.JComboBox<>();
        btn_luu = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_tbHK = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_hocluc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dsdiemTBHS = new javax.swing.JTable();
        dl_danhgiaCN = new javax.swing.JDialog();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_dsdiemTBHS1 = new javax.swing.JTable();
        lb_msten = new javax.swing.JLabel();
        lb_dtbhl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cb_hanhkiemCN = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txt_nhanxet = new javax.swing.JTextArea();
        btn_luuDGCN = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cb_ttcn = new javax.swing.JComboBox<>();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_danhgiaHK = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_danhgiaCN = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        cb_lophoc = new javax.swing.JComboBox<>();
        btn_capnhat = new javax.swing.JButton();

        itemSuaDG.setText("Đánh giá hạnh kiểm");
        itemSuaDG.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSuaDGActionPerformed(evt);
            }
        });
        popDanhGia.add(itemSuaDG);

        dl_danhgia.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel2.setText("Mã HS");

        jLabel3.setText("Tên HS");

        jLabel4.setText("Hạnh kiểm:");

        txt_maHS.setEditable(false);

        txt_tenHS.setEditable(false);

        cb_hanhkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_luu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_luu.setText("Lưu");
        btn_luu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuActionPerformed(evt);
            }
        });

        jLabel5.setText("TB học kì:");

        txt_tbHK.setEditable(false);

        jLabel6.setText("Học lực");

        txt_hocluc.setEditable(false);

        tbl_dsdiemTBHS.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Môn học", "Điểm TB", "TS_buổi hoc", "TS_nghỉ P", "TS_nghỉ KP"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_dsdiemTBHS);

        javax.swing.GroupLayout dl_danhgiaLayout = new javax.swing.GroupLayout(dl_danhgia.getContentPane());
        dl_danhgia.getContentPane().setLayout(dl_danhgiaLayout);
        dl_danhgiaLayout.setHorizontalGroup(
            dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_danhgiaLayout.createSequentialGroup()
                .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_danhgiaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_maHS, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                            .addComponent(txt_tenHS)
                            .addComponent(cb_hanhkiem, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45)
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tbHK, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                            .addComponent(txt_hocluc)))
                    .addGroup(dl_danhgiaLayout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(btn_luu, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );
        dl_danhgiaLayout.setVerticalGroup(
            dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_danhgiaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(dl_danhgiaLayout.createSequentialGroup()
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_maHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(txt_tbHK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenHS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(txt_hocluc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(dl_danhgiaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(cb_hanhkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(btn_luu)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        dl_danhgiaCN.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jScrollPane4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách DTB môn học", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N

        tbl_dsdiemTBHS1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Môn học", "Điểm TB"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(tbl_dsdiemTBHS1);

        lb_msten.setText("jLabel7");

        lb_dtbhl.setText("jLabel8");

        jLabel9.setText("Hạnh kiểm: ");

        cb_hanhkiemCN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel10.setText("Nhận xét của GVCN :");

        txt_nhanxet.setColumns(20);
        txt_nhanxet.setRows(5);
        jScrollPane5.setViewportView(txt_nhanxet);

        btn_luuDGCN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_luuDGCN.setText("Lưu đánh giá");
        btn_luuDGCN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_luuDGCNActionPerformed(evt);
            }
        });

        jLabel7.setText("Trạng thái: ");

        cb_ttcn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout dl_danhgiaCNLayout = new javax.swing.GroupLayout(dl_danhgiaCN.getContentPane());
        dl_danhgiaCN.getContentPane().setLayout(dl_danhgiaCNLayout);
        dl_danhgiaCNLayout.setHorizontalGroup(
            dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dl_danhgiaCNLayout.createSequentialGroup()
                .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dl_danhgiaCNLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                        .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(lb_dtbhl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lb_msten, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, dl_danhgiaCNLayout.createSequentialGroup()
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_hanhkiemCN, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addComponent(btn_luuDGCN))
                            .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(cb_ttcn, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dl_danhgiaCNLayout.setVerticalGroup(
            dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(dl_danhgiaCNLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_msten)
                .addGap(18, 18, 18)
                .addComponent(lb_dtbhl)
                .addGap(18, 18, 18)
                .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cb_hanhkiemCN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(dl_danhgiaCNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cb_ttcn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_luuDGCN)
                .addContainerGap())
        );

        jTabbedPane1.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);

        jScrollPane2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách học sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N
        jScrollPane2.setComponentPopupMenu(popDanhGia);

        tbl_danhgiaHK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "TB học kì", "Học lực", "Hạnh kiểm "
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_danhgiaHK.setComponentPopupMenu(popDanhGia);
        tbl_danhgiaHK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhgiaHKMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_danhgiaHK);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Học kì", jPanel1);

        jScrollPane3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách học sinh", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N

        tbl_danhgiaCN.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "TB cả năm", "Học lực", "Hạnh kiểm ", "Trang thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_danhgiaCN.getTableHeader().setReorderingAllowed(false);
        tbl_danhgiaCN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_danhgiaCNMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_danhgiaCN);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 497, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cả năm", jPanel2);

        jLabel1.setText("Lớp học");

        cb_lophoc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capnhatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(cb_lophoc, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_capnhat)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_capnhat)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(cb_lophoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
        Another_DAO adao = new Another_DAO();
        if (adao.checkGVCN(mainView.getmaGV(), mainView.getMaNH(), mainView.getmaHK(),DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop())==1){
            DanhGia_DAO dao = new DanhGia_DAO();
            dsDanhGiaHS = dao.TìmKiem(new DanhGiaHS("", "", DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop(),
                     mainView.getMaNH(), mainView.getmaHK(), "", "", 0));
            loadlisttbl();
            Another_DAO another_DAO = new Another_DAO();
            danhGiaCNs = another_DAO.danhGiaCNs(DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop(), mainView.getMaNH());
            loadtblDanhGiaCN();
        }else{
            JOptionPane.showMessageDialog(fmDanhGiaHS.this, "Bạn không là GVCN của lớp");
        }
        
    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void itemSuaDGActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSuaDGActionPerformed
        // TODO add your handling code here:
        int index = tbl_danhgiaHK.getSelectedRow();
        currentindex = index;
        if (dsDanhGiaHS!=null) {
            if (!dsDanhGiaHS.isEmpty()) {
                if (index == -1) {
                    currentindex =0;
                }
                opendsDTBHScacmon(String.valueOf(tbl_danhgiaHK.getValueAt(tbl_danhgiaHK.getSelectedRow(), 1)).trim()
                    ,String.valueOf(tbl_danhgiaHK.getValueAt(tbl_danhgiaHK.getSelectedRow(), 2)).trim() 
                    ,mainView.getMaNH(), mainView.getmaHK());
                openformdanhgia();
                
            }
        }
    }//GEN-LAST:event_itemSuaDGActionPerformed

    private void btn_luuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuActionPerformed
        // TODO add your handling code here:
        DanhGia_DAO dao = new DanhGia_DAO();
        DanhGiaHS danhGiaHS = dsDanhGiaHS.get(currentindex);
        int indexhk = cb_hanhkiem.getSelectedIndex();
        String maHK = DataStatic.dsHanhKiem.get(indexhk).getMaHanhKiem();
        danhGiaHS.setMaHanhKiem(maHK);
        System.out.println(danhGiaHS.getMaHS()+"|"+danhGiaHS.getMaNH()+"|"+danhGiaHS.getMaHK()+"|"+danhGiaHS.getMaHanhKiem());
        if (dao.Sua(danhGiaHS)==1) {
            dsDanhGiaHS.get(currentindex).setMaHanhKiem(maHK);
            tbl_danhgiaHK.setValueAt(HanhKiem.getTenDCT(maHK, DataStatic.dsHanhKiem), currentindex, 5);
        }
        
        
    }//GEN-LAST:event_btn_luuActionPerformed

    private void tbl_danhgiaHKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhgiaHKMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_danhgiaHKMouseClicked

    private void btn_luuDGCNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_luuDGCNActionPerformed
        // TODO add your handling code here:
        Another_DAO dao = new Another_DAO();
        DanhGiaCN danhGiaCN = danhGiaCNs.get(indexCN);
        danhGiaCN.maHanhKiem = DataStatic.dsHanhKiem.get(cb_hanhkiemCN.getSelectedIndex()).getMaHanhKiem();
        danhGiaCN.nhanxet = txt_nhanxet.getText().trim();
        danhGiaCN.trangthai = cb_ttcn.getSelectedItem().toString().trim();
        if (dao.SuaDGHSCN(danhGiaCN)==1) {
            danhGiaCNs.get(indexCN).maHanhKiem = danhGiaCN.maHanhKiem;
            danhGiaCNs.get(indexCN).nhanxet = danhGiaCN.nhanxet;
            danhGiaCNs.get(indexCN).trangthai = danhGiaCN.trangthai;
            tbl_danhgiaCN.setValueAt(HanhKiem.getTenDCT(danhGiaCN.maHanhKiem, DataStatic.dsHanhKiem),indexCN, 5);
            tbl_danhgiaCN.setValueAt(danhGiaCN.trangthai,indexCN, 6);
        }
    }//GEN-LAST:event_btn_luuDGCNActionPerformed

    private void tbl_danhgiaCNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_danhgiaCNMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==2){
            int index = tbl_danhgiaCN.getSelectedRow();
            indexCN = index;
            if (index==-1) {
                indexCN =  0;
            }
            openDanhGiaCN();
        }
    }//GEN-LAST:event_tbl_danhgiaCNMouseClicked
    
    private void loadcblop() {
        cb_lophoc.removeAllItems();
        for (Lop l : DataStatic.dsLop) {
            cb_lophoc.addItem(l.getTenLop());
        }
    }
    
    private void loadlisttbl(){
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_danhgiaHK.getModel();
        tblmodel.setRowCount(0);
        int i=1;
        for (DanhGiaHS danhGiaHS : dsDanhGiaHS) {
            tblmodel.addRow(new Object[]{i
                    ,danhGiaHS.getMaHS()
                    ,danhGiaHS.getTenHS()
                    ,danhGiaHS.getDiemTBHK()
                    ,HocLuc.getTenDCT(danhGiaHS.getMaHocLưc(), DataStatic.dsHocLuc)
                    ,HanhKiem.getTenDCT(danhGiaHS.getMaHanhKiem(), DataStatic.dsHanhKiem)
            });
            i++;
        }
    }
    private void loadcb_hanhkiem(){
        cb_hanhkiem.removeAllItems();
        for (HanhKiem hanhKiem : DataStatic.dsHanhKiem) {
            cb_hanhkiem.addItem(hanhKiem.getHanhKiem());
        }
        cb_hanhkiemCN.removeAllItems();
        for (HanhKiem hanhKiem : DataStatic.dsHanhKiem) {
            cb_hanhkiemCN.addItem(hanhKiem.getHanhKiem());
        }
    }
    private void loadcbtrangthai(){
        cb_ttcn.removeAllItems();
        for (String string : DataStatic.TT_CN) {
            cb_ttcn.addItem(string);
        }
    }
    private void openformdanhgia(){
        setText();
        
        dl_danhgia.setSize(1000, 500);
        dl_danhgia.setLocationRelativeTo(null);
        dl_danhgia.setResizable(false);
        dl_danhgia.setVisible(true);
    }
    
    private void setText(){
        DanhGiaHS danhGiaHS = dsDanhGiaHS.get(currentindex);
        txt_maHS.setText(danhGiaHS.getMaHS());
        txt_tenHS.setText(danhGiaHS.getTenHS());
        txt_tbHK.setText(String.valueOf(danhGiaHS.getDiemTBHK()));
        txt_hocluc.setText(HocLuc.getTenDCT(danhGiaHS.getMaHocLưc(), DataStatic.dsHocLuc));
        cb_hanhkiem.setSelectedItem(HanhKiem.getTenDCT(danhGiaHS.getMaHanhKiem(), DataStatic.dsHanhKiem));
    }
    
    private void opendsDTBHScacmon(String maHS,String hotenHs,String maNH,String maHK){
        Another_DAO dao = new Another_DAO();
        List<DTB_HS> ds = dao.dsDTBHStheoHK(maHS, maNH, maHK);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsdiemTBHS.getModel();
        tblmodel.setRowCount(0);
        int i=1;
        for (DTB_HS d : ds) {
            tblmodel.addRow(new Object[]{
                    d.tenMH
                    ,d.DTB_HS
                    ,d.TSBH
                    ,d.TSBP
                    ,d.TSBKP
            });
            i++;
        }
    }
    private void loadtblDanhGiaCN(){
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_danhgiaCN.getModel();
        tblmodel.setRowCount(0);
        Another_DAO adao = new Another_DAO();
        if(adao.checkGVCN(mainView.getmaGV(), mainView.getMaNH(), "02", DataStatic.dsLop.get(cb_lophoc.getSelectedIndex()).getMaLop())==1){
            int i = 1;
            for (DanhGiaCN danhGiaHS : danhGiaCNs) {
                tblmodel.addRow(new Object[]{i,
                     danhGiaHS.maHS,
                     danhGiaHS.tenHs,
                     danhGiaHS.diemTB,
                     HocLuc.getTenDCT(danhGiaHS.maHocLuc, DataStatic.dsHocLuc),
                     HanhKiem.getTenDCT(danhGiaHS.maHanhKiem, DataStatic.dsHanhKiem),
                     danhGiaHS.trangthai
                });
                i++;
            }
        }
        
    }
    private void openDanhGiaCN(){
        DanhGiaCN danhGiaCN = danhGiaCNs.get(indexCN);
        lb_msten.setText("Học sinh : "+danhGiaCN.maHS+" - "+danhGiaCN.tenHs);
        lb_dtbhl.setText("ĐTB: "+String.valueOf(danhGiaCN.diemTB)+" - Học lực : "+HocLuc.getTenDCT(danhGiaCN.maHocLuc, DataStatic.dsHocLuc));
        cb_hanhkiemCN.setSelectedItem(HanhKiem.getTenDCT(danhGiaCN.maHanhKiem, DataStatic.dsHanhKiem));
        cb_ttcn.setSelectedItem(danhGiaCN.trangthai);
        txt_nhanxet.setText(danhGiaCN.nhanxet);
        Another_DAO dao = new Another_DAO();
        List<DTB_HS> ds = dao.dsDTBHStheoNH(mainView.getMaNH(), danhGiaCN.maHS);
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsdiemTBHS1.getModel();
        tblmodel.setRowCount(0);
        int i=1;
        for (DTB_HS d : ds) {
            tblmodel.addRow(new Object[]{i
                    ,d.tenMH
                    ,d.DTB_HS
            });
            i++;
        }
        dl_danhgiaCN.setSize(650, 400);
        dl_danhgiaCN.setLocationRelativeTo(null);
        dl_danhgiaCN.setResizable(false);
        dl_danhgiaCN.setVisible(true);
    }
    private int indexCN =0;
    private int currentindex = 0;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_luu;
    private javax.swing.JButton btn_luuDGCN;
    private javax.swing.JComboBox<String> cb_hanhkiem;
    private javax.swing.JComboBox<String> cb_hanhkiemCN;
    private javax.swing.JComboBox<String> cb_lophoc;
    private javax.swing.JComboBox<String> cb_ttcn;
    private javax.swing.JDialog dl_danhgia;
    private javax.swing.JDialog dl_danhgiaCN;
    private javax.swing.JMenuItem itemSuaDG;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lb_dtbhl;
    private javax.swing.JLabel lb_msten;
    private javax.swing.JPopupMenu popDanhGia;
    private javax.swing.JTable tbl_danhgiaCN;
    private javax.swing.JTable tbl_danhgiaHK;
    private javax.swing.JTable tbl_dsdiemTBHS;
    private javax.swing.JTable tbl_dsdiemTBHS1;
    private javax.swing.JTextField txt_hocluc;
    private javax.swing.JTextField txt_maHS;
    private javax.swing.JTextArea txt_nhanxet;
    private javax.swing.JTextField txt_tbHK;
    private javax.swing.JTextField txt_tenHS;
    // End of variables declaration//GEN-END:variables
}
