package View;

import DAO.Another_DAO;
import DAO.DongHP_DAO;
import DAO.HocSinh_DAO;
import Model.DienChinhSach;
import Model.DongHocPhi;
import Model.HocPhi;
import Model.HocSinh;
import Model.Lop;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class fmDongHP extends javax.swing.JPanel {

    private List<DongHocPhi> dsHP = new ArrayList<>();
    private MainView mainView;

    public fmDongHP(MainView mainView) {
        initComponents();
        this.mainView = mainView;
        loadcb_lop();
        load_listtbl();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        mn_themMHP = new javax.swing.JMenuItem();
        dl_themMHP = new javax.swing.JDialog();
        cb_mucHP = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btn_themMHP = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cb_lop = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_dsdongHP = new javax.swing.JTable();
        btn_capnhat = new javax.swing.JButton();

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
        jMenu2.setText("Thêm");
        jMenu2.setEnabled(false);

        jMenuItem1.setText("Đánh dấu là đã đóng");
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("Đánh dấu toàn bộ là đã đóng");
        jMenu2.add(jMenuItem2);

        jPopupMenu1.add(jMenu2);

        jMenu1.setText("Xóa");
        jMenu1.setEnabled(false);

        jMenuItem3.setText("Đánh dấu là chưa đóng");
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Đánh dấu tất cả thành chưa đóng");
        jMenu1.add(jMenuItem4);

        jPopupMenu1.add(jMenu1);

        mn_themMHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        mn_themMHP.setText("Mức học phí");
        mn_themMHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mn_themMHPActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mn_themMHP);

        dl_themMHP.setTitle("Thay đổi mức học phí");
        dl_themMHP.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        cb_mucHP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Mức học phí");

        btn_themMHP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/save.png"))); // NOI18N
        btn_themMHP.setText("Lưu thay đổi");
        btn_themMHP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_themMHPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dl_themMHPLayout = new javax.swing.GroupLayout(dl_themMHP.getContentPane());
        dl_themMHP.getContentPane().setLayout(dl_themMHPLayout);
        dl_themMHPLayout.setHorizontalGroup(
            dl_themMHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_themMHPLayout.createSequentialGroup()
                .addGroup(dl_themMHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dl_themMHPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(dl_themMHPLayout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(btn_themMHP))
                    .addGroup(dl_themMHPLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cb_mucHP, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        dl_themMHPLayout.setVerticalGroup(
            dl_themMHPLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dl_themMHPLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cb_mucHP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_themMHP)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel1.setText("Lớp:");

        cb_lop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tbl_dsdongHP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã học sinh", "Tên học sinh", "Diện chính sách", "Học phí", "Đã đóng"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_dsdongHP.setComponentPopupMenu(jPopupMenu1);
        tbl_dsdongHP.getTableHeader().setReorderingAllowed(false);
        tbl_dsdongHP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_dsdongHPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_dsdongHP);

        btn_capnhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/refresh.png"))); // NOI18N
        btn_capnhat.setText("Cập nhật danh sách");
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(cb_lop, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cb_lop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_capnhat))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tbl_dsdongHPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_dsdongHPMouseClicked
        // TODO add your handling code here:
        //column = 5
        DongHP_DAO dao = new DongHP_DAO();
        int indexco = tbl_dsdongHP.getSelectedColumn();
        if (indexco == 5) {
            int index = tbl_dsdongHP.getSelectedRow();
            if (index != -1) {
                if (dsHP.get(index).getMaHocPhi() == null) {
                    JOptionPane.showMessageDialog(fmDongHP.this, "Chưa có mức học phí");
                } else {
                    if (dsHP.get(index).isDaDong()) {
                        dsHP.get(index).setDaDong(false);
                    } else {
                        dsHP.get(index).setDaDong(true);
                    }
                    dao.Sua(dsHP.get(index));
                    dsHP = dao.TìmKiem(dsHP.get(index));
                    load_listtbl();
                    tbl_dsdongHP.setRowSelectionInterval(index, index);
                }

            }
        }

    }//GEN-LAST:event_tbl_dsdongHPMouseClicked

    private void btn_capnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capnhatActionPerformed
        // TODO add your handling code here:
        int index = cb_lop.getSelectedIndex();
        Another_DAO adao = new Another_DAO();
        if (adao.checkGVCN(mainView.getmaGV(), mainView.getMaNH(),
                mainView.getmaHK(), DataStatic.dsLop.get(index).getMaLop()) == 1) {
            DongHP_DAO dao = new DongHP_DAO();
            DongHocPhi t = new DongHocPhi(mainView.getMaNH(), mainView.getmaHK(), "", "", DataStatic.dsLop.get(index).getMaLop(), 0, false);
            dsHP = dao.TìmKiem(t);
            load_listtbl();
        }else{
            JOptionPane.showMessageDialog(fmDongHP.this, "Bạn ko là GVCN của lớp");
        }

    }//GEN-LAST:event_btn_capnhatActionPerformed

    private void mn_themMHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mn_themMHPActionPerformed
        // TODO add your handling code here:
        dl_themMHP.setSize(260, 200);
        dl_themMHP.setLocationRelativeTo(null);
        dl_themMHP.setResizable(false);
        if (!dsHP.isEmpty()) {
            if (dsHP.get(0).getMaHocPhi() == null) {
                cb_mucHP.setSelectedIndex(0);
            } else {
                cb_mucHP.setSelectedItem(String.valueOf(HocPhi.getHocPhi(dsHP.get(0).getMaHocPhi(), DataStatic.dsHP)));
            }

        }
        dl_themMHP.setVisible(true);
        int index = tbl_dsdongHP.getSelectedRow();
        if (index == -1) {
            currentmode = SUACALOP;
        } else {
            currentmode = SUACANHAN;
            curentrow = index;
        }
    }//GEN-LAST:event_mn_themMHPActionPerformed

    private void btn_themMHPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_themMHPActionPerformed
        // TODO add your handling code here:
        DongHP_DAO dao = new DongHP_DAO();
        if (currentmode == SUACALOP) {
            for (int i = 0; i < dsHP.size(); i++) {
                DongHocPhi dongHocPhi = dsHP.get(i);
                dongHocPhi.setMaHocPhi(DataStatic.dsHP.get(cb_mucHP.getSelectedIndex()).getMaHocPhi());
                dao.Sua(dongHocPhi);
                System.out.println("jbsdjhbdj");
            }
            DongHocPhi dhp = dsHP.get(0);
            dsHP = dao.TìmKiem(dhp);
            load_listtbl();
        } else if (currentmode == SUACANHAN) {
            dsHP.get(curentrow).setMaHocPhi(DataStatic.dsHP.get(cb_mucHP.getSelectedIndex()).getMaHocPhi());
            DongHocPhi t = dsHP.get(curentrow);
            dao.Sua(t);
            dsHP = dao.TìmKiem(t);
            load_listtbl();
            tbl_dsdongHP.setRowSelectionInterval(curentrow, curentrow);
        }
        dl_themMHP.setVisible(false);
    }//GEN-LAST:event_btn_themMHPActionPerformed

    private void load_listtbl() {
        HocSinh_DAO dao = new HocSinh_DAO();
        DefaultTableModel tblmodel = (DefaultTableModel) tbl_dsdongHP.getModel();
        tblmodel.setRowCount(0);
        int i = 1;
        for (DongHocPhi dongHocPhi : dsHP) {
            HocSinh hs = dao.getT(dongHocPhi.getMaHS());
            tblmodel.addRow(new Object[]{i,
                 dongHocPhi.getMaHS(),
                 hs.getHotenHS(),
                 DienChinhSach.getTen(hs.getMaChinhSach(),
                 DataStatic.dsDSC), dongHocPhi.getHocPhi(),
                 dongHocPhi.isDaDong()});
            i++;
        }
    }

    public void loadcb_lop() {
        cb_lop.removeAllItems();
        for (Lop nh : DataStatic.dsLop) {
            cb_lop.addItem(nh.getTenLop());
        }
        cb_mucHP.removeAllItems();
        for (HocPhi hocPhi : DataStatic.dsHP) {
            cb_mucHP.addItem(String.valueOf(hocPhi.getHocPhi()));
        }
    }
    private int curentrow = 0;
    private int currentmode = SUACALOP;
    private static final int SUACALOP = 10;
    private static final int SUACANHAN = 1;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_capnhat;
    private javax.swing.JButton btn_themMHP;
    private javax.swing.JComboBox<String> cb_lop;
    private javax.swing.JComboBox<String> cb_mucHP;
    private javax.swing.JDialog dl_themMHP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mn_themMHP;
    private javax.swing.JTable tbl_dsdongHP;
    // End of variables declaration//GEN-END:variables
}
