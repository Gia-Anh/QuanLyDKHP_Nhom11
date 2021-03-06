package ui.form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import dao.HocPhanDAO;
import dao.KetQuaHocTapDAO;
import dao.LopHocPhanDAO;
import dao.SinhVienDAO;
import entity.CT_LopHocPhan;
import entity.HocPhan;
import entity.LopHocPhan;
import entity.SinhVien;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class frm_DangKyHocPhan extends JPanel{
	private JComboBox<String> cmbHocKy;
	private DefaultTableModel modelHP;
	private JTable tableHP;
	private JScrollPane scroll;
	private DefaultTableModel modelLHP;
	private JTable tableLHP;
	private JScrollPane scroll2;
	private DefaultTableModel modelCTLHP;
	private JTable tableCTLHP;
	private JScrollPane scroll3;
	private JButton btnDangKy;
	private JButton btnXemDSHP;
	private JButton btnChon;
	private JComboBox<String> cmbPhuongThucDK;
	private JComboBox<String> cmbNamHoc;
	
	private HocPhanDAO hocPhanDAO = new HocPhanDAO();
	private LopHocPhanDAO lopHocPhanDAO = new LopHocPhanDAO();
	private SinhVienDAO sinhVienDAO = new SinhVienDAO();
	private KetQuaHocTapDAO kqDAO = new KetQuaHocTapDAO();
	
	

	public frm_DangKyHocPhan(String uname) {
		
		Box b, b1, b2, b3, b4, b5, b6, b7;
		add(b = Box.createVerticalBox());
		
		b.add(Box.createVerticalStrut(20));
		b.add(b1 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b2 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b3 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b4 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b5 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b6 = Box.createHorizontalBox());
		b.add(Box.createVerticalStrut(15));
		b.add(b7 = Box.createHorizontalBox());
		
		b.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		
		JLabel lblChonHK;
		
//		b1.add(Box.createHorizontalGlue());
		b1.add(Box.createHorizontalStrut(400));
//		b1.add(cmbPhuongThucDK = new JComboBox<>());
//		cmbPhuongThucDK.setModel(new DefaultComboBoxModel(new String[] {"????ng k?? m???i", "????ng k?? h???c l???i", "H???c c???i thi???n"}));
//		b1.add(Box.createHorizontalStrut(150));
		b1.add(lblChonHK = new JLabel("Ch???n h???c k???: "));
		b1.add(cmbHocKy = new JComboBox<>());
		cmbHocKy.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(cmbNamHoc = new JComboBox<>());
		cmbNamHoc.setModel(new DefaultComboBoxModel(new String[] {"2020 - 2021"}));
		b1.add(Box.createHorizontalStrut(10));
		b1.add(btnChon = new JButton("Ch???n"));
		b1.add(Box.createHorizontalStrut(400));
		
		JPanel pnlDsHP, pnlDsLHP, pnlCTLopHP, pnlDsDaDangKy;
		pnlDsHP = new JPanel();
		pnlDsLHP = new JPanel();
		pnlCTLopHP = new JPanel();
	
		b2.add(pnlDsHP);
		pnlDsHP.setBorder(BorderFactory.createTitledBorder("Danh s??ch h???c ph???n"));
		
		String[] tieuDe = {"STT", "M?? h???c ph???n", "T??n m??n h???c", "S??? t??n ch???", "B???t bu???c", "H???c ph???n y??u c???u"};
		modelHP = new DefaultTableModel(tieuDe, 0);
		tableHP = new JTable(modelHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableHP.getTableHeader().setReorderingAllowed(false);
		tableHP.setPreferredScrollableViewportSize(new Dimension(1100, 150));
		tableHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlDsHP.add(scroll = new JScrollPane(tableHP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b4.add(pnlDsLHP);
		pnlDsLHP.setBorder(BorderFactory.createTitledBorder("Danh s??ch l???p h???c ph???n"));
		
		String[] tieuDe2 = {"STT", "M?? l???p h???c ph???n", "T??n l???p h???c ph???n", "L???p t??n ch???", "S?? s??? t???i ??a", "S?? s??? ????ng k??", "Tr???ng th??i"};
		modelLHP = new DefaultTableModel(tieuDe2, 0);
		tableLHP = new JTable(modelLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableLHP.getTableHeader().setReorderingAllowed(false);
		tableLHP.setPreferredScrollableViewportSize(new Dimension(1100, 80));
		tableLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlDsLHP.add(scroll2 = new JScrollPane(tableLHP, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b6.add(pnlCTLopHP);
		pnlCTLopHP.setBorder(BorderFactory.createTitledBorder("Chi ti???t l???p h???c ph???n"));
		
		String[] tieuDe3 = {"STT", "H??nh th???c", "Th???", "Ti???t", "Ph??ng h???c", "Gi???ng vi??n", "Ng??y b???t ?????u", "Ng??y k???t th??c"};
		modelCTLHP = new DefaultTableModel(tieuDe3, 0);
		tableCTLHP = new JTable(modelCTLHP) {
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		tableCTLHP.getTableHeader().setReorderingAllowed(false);
		tableCTLHP.setPreferredScrollableViewportSize(new Dimension(1100, 65));
		tableCTLHP.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		pnlCTLopHP.add(scroll3 = new JScrollPane(tableCTLHP, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
		
		b7.add(btnDangKy = new JButton("????ng k?? m??n h???c", new ImageIcon("img/dangky.png")));
		btnDangKy.setEnabled(false);
		
		SinhVien sv = sinhVienDAO.layThongTinSV(uname);
		String maSV = sv.getMaSinhVien();
		
		btnChon.addActionListener(e ->{
//			String hinhThucDK = cmbPhuongThucDK.getItemAt(cmbPhuongThucDK.getSelectedIndex());
			String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
			String namHoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
			int hocKy = Integer.parseInt(hk);
			loadTBHocPhan(hocKy, maSV);
			xoaTBLopHocPhan();
			xoaTBCTLopHocPhan();
			btnDangKy.setEnabled(false);
		});
		
		tableHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				xoaTBCTLopHocPhan();
				String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
				int index = tableHP.getSelectedRow();
				if(index>=0 && index<tableHP.getRowCount()) {
					String maHp = tableHP.getValueAt(index, 1).toString();
					loadTBLopHocPhan(maHp, namhoc);
					btnDangKy.setEnabled(false);
				}
				
			}
		});
		
		tableLHP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int index = tableLHP.getSelectedRow();
				if(index>=0 && index<tableLHP.getRowCount()) {
					String maLhp = tableLHP.getValueAt(index, 1).toString();
					loadTBCTLopHocPhan(maLhp);
					btnDangKy.setEnabled(true);
				}
				
			}
		});
		
		btnDangKy.addActionListener(e ->{
			int index = tableLHP.getSelectedRow();
			if(index>=0 && index<tableLHP.getRowCount()) {
				String maLhp = tableLHP.getValueAt(index, 1).toString();
				LopHocPhan lophp = lopHocPhanDAO.timLopTheoMa(maLhp);
				String trangThaiCu = lophp.getTrangThai();
				int siSoToiDa = lophp.getSiSoToiDa();
				int siSoDangKy = lophp.getSiSoDangKy();
				String hpYC = tableHP.getValueAt(tableHP.getSelectedRow(), 5).toString();
				String namhoc = cmbNamHoc.getItemAt(cmbNamHoc.getSelectedIndex());
				String hk = cmbHocKy.getItemAt(cmbHocKy.getSelectedIndex());
				int hocKy = Integer.parseInt(hk);
				if (modelCTLHP.getRowCount()==0) {
					JOptionPane.showMessageDialog(null, "L???p h???c ph???n n??y ch??a c?? chi ti???t ?????y ?????, kh??ng th??? ????ng k??", "L???i", JOptionPane.ERROR_MESSAGE);
				}else {
					if (JOptionPane.showConfirmDialog(this, "B???n c?? mu???n ????ng k?? m??n n??y kh??ng?", "Ch?? ??", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
						if (!hpYC.equals("")) {
							String maHPYC = hocPhanDAO.layMaTheoTenHP(hpYC);
							if (hocPhanDAO.kiemTraHocPhanDaHoc(maHPYC, maSV)) {
								if (siSoDangKy < siSoToiDa) {
									if (trangThaiCu.compareTo("???? kh??a") != 0) {
										if (trangThaiCu.compareTo("Ch??? h???y l???p") != 0) {
											if (lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc).size()==0) {
												lopHocPhanDAO.dangKyHocPhan(maLhp, maSV, hocKy, namhoc);
												
												String maHP = tableHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
												String maLHP = tableLHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
												kqDAO.themKQHocTap(maSV, maHP, maLHP);
												
												JOptionPane.showMessageDialog(null, "????ng k?? th??nh c??ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
												int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLhp);
												
												String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
												
												lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);

												loadTBHocPhan(hocKy, maSV);
												xoaTBLopHocPhan();
												xoaTBCTLopHocPhan();
												btnDangKy.setEnabled(false);
											}else {
												String s = "";
												for (String string : lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc)) {
													s += "\n- "+string ;
												}
												JOptionPane.showMessageDialog(null, "Tr??ng l???ch h???c, kh??ng th??? ????ng k??!\n\nC??c m??n b??? tr??ng:" + s, "L???i", JOptionPane.ERROR_MESSAGE);
											}
										}else {
											JOptionPane.showMessageDialog(null, "L???p h???c ph???n n??y ??ang ch??? h???y, kh??ng th??? ????ng k??!", "L???i", JOptionPane.ERROR_MESSAGE);
										}	
									}else {
											JOptionPane.showMessageDialog(null, "L???p h???c ph???n n??y ??ang kh??a, kh??ng th??? ????ng k??!", "L???i", JOptionPane.ERROR_MESSAGE);											
									}
								} else {
								JOptionPane.showInternalMessageDialog(null, "L???p h???c ph???n n??y ???? ????? sinh vi??n, ????ng k?? th???t b???i!", "L???i", JOptionPane.ERROR_MESSAGE);
								}
							}else {
								JOptionPane.showMessageDialog(null, "????ng k?? th???t b???i, b???n ph???i h???c m??n '"+hpYC+"' tr?????c!", "L???i", JOptionPane.ERROR_MESSAGE);
							}
						}else {
							if (siSoDangKy < siSoToiDa) {
								if (trangThaiCu.compareTo("???? kh??a") != 0) {
									if (trangThaiCu.compareTo("Ch??? h???y l???p") != 0) {
										if (lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc).size()==0) {
											lopHocPhanDAO.dangKyHocPhan(maLhp, maSV, hocKy, namhoc);
											
											String maHP = tableHP.getValueAt(tableHP.getSelectedRow(), 1).toString();
											String maLHP = tableLHP.getValueAt(tableLHP.getSelectedRow(), 1).toString();								
											kqDAO.themKQHocTap(maSV, maHP, maLHP);
											
											JOptionPane.showMessageDialog(null, "????ng k?? th??nh c??ng", "Th??ng b??o", JOptionPane.INFORMATION_MESSAGE);
											int siSoMoi = lopHocPhanDAO.laySiSoMoi(maLhp);
											
											String trThaiMoi = lopHocPhanDAO.capNhatTrangThaiLHP(siSoMoi, siSoToiDa);
											
											lopHocPhanDAO.capNhatThongTinLHP(lophp, siSoMoi, trThaiMoi);

											loadTBHocPhan(hocKy, maSV);
											xoaTBLopHocPhan();
											xoaTBCTLopHocPhan();
											btnDangKy.setEnabled(false);
										} else {
											String s = "";
											for (String string : lopHocPhanDAO.kiemTraTrungLichHoc(lophp, sv, hocKy, namhoc)) {
												s += "\n- "+string ;
											}
											JOptionPane.showMessageDialog(null, "Tr??ng l???ch h???c, kh??ng th??? ????ng k??!\n\nC??c m??n b??? tr??ng:" + s, "L???i", JOptionPane.ERROR_MESSAGE);
										}
									}else {
										JOptionPane.showMessageDialog(null, "L???p h???c ph???n n??y ??ang ch??? h???y, kh??ng th??? ????ng k??!", "L???i", JOptionPane.ERROR_MESSAGE);
									}	
									}else {
										JOptionPane.showMessageDialog(null, "L???p h???c ph???n n??y ??ang kh??a, kh??ng th??? ????ng k??!", "L???i", JOptionPane.ERROR_MESSAGE);
									}
								} else {
								JOptionPane.showInternalMessageDialog(null, "L???p h???c ph???n n??y ???? ????? sinh vi??n, ????ng k?? th???t b???i!", "L???i", JOptionPane.ERROR_MESSAGE);
							}
						}
					}	
				}	
		}
		});
		
		int hk = Integer.parseInt(cmbHocKy.getItemAt(0).toString());
		loadTBHocPhan(hk, maSV);
		
		tableDesign(tableHP);
		tableDesign(tableLHP);
		tableDesign(tableCTLHP);
		setTBHocPhanColumnWidth();
		setTBLopHocPhanColumnWidth();
		tableRenderer();
	}
	
	private void xoaTBHocPhan() {
		while (modelHP.getRowCount()>0) {
			modelHP.removeRow(0);
		}
	}
	
	private void loadTBHocPhan(int hocky, String maSV) {
		xoaTBHocPhan();
		String khoaSV = sinhVienDAO.timMaKhoaTheoMaSV(maSV);
		List<HocPhan> dshp = new ArrayList<HocPhan>();
		
		dshp = hocPhanDAO.layDsHocPhan(hocky, khoaSV);
		int i = 1;
		for (HocPhan hocPhan : dshp) {	
			if (!hocPhanDAO.kiemTraHocPhanDaDangKy(hocPhan.getMaHocPhan(), maSV)) {
				String batBuoc = "";
				HocPhan hocPhanYC = null;
				String hpYc = "";
				if (hocPhan.isBatBuoc()) {
					batBuoc = "x";
				}
				if (hocPhan.getHocPhanYeuCau() != null) {
					hocPhanYC = hocPhanDAO.timHPTheoMa(hocPhan.getHocPhanYeuCau());
					hpYc = hocPhanYC.getTenMonHoc();
				}
				String[] rowData = {i+"", hocPhan.getMaHocPhan(), hocPhan.getTenMonHoc(),
						hocPhan.getSoTinChi()+"", batBuoc, hpYc};
				modelHP.addRow(rowData);
				tableHP.setModel(modelHP);
				i++;
			}
		}
		
		
	}
	
	private void xoaTBLopHocPhan() {
		while (modelLHP.getRowCount()>0) {
			modelLHP.removeRow(0);
		}
	}
	
	private void loadTBLopHocPhan(String maHp, String namhoc) {
		xoaTBLopHocPhan();
		List<LopHocPhan> dslhp = lopHocPhanDAO.layDsLopHocPhanTheoMaHP(maHp, namhoc);
		int i = 1;
		for (LopHocPhan lopHocPhan : dslhp) {
//			lopHocPhanDAO.capNhatSiSo(lopHocPhan.getMaLopHocPhan());
//			System.out.println(lopHocPhan);
			String[] rowData = {i+"", lopHocPhan.getMaLopHocPhan(), lopHocPhan.getTenLopHocPhan(), lopHocPhan.getLopTinChi()
					, lopHocPhan.getSiSoToiDa()+"", lopHocPhan.getSiSoDangKy()+"", lopHocPhan.getTrangThai()};
			modelLHP.addRow(rowData);
			tableLHP.setModel(modelLHP);
			i++;
		}
		if (modelLHP.getRowCount()==0) {
			JOptionPane.showMessageDialog(null, "H???c ph???n n??y hi???n t???i ch??a c?? l???p, vui l??ng quay l???i sau!", "", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void xoaTBCTLopHocPhan() {
		while (modelCTLHP.getRowCount()>0) {
			modelCTLHP.removeRow(0);
		}
	}
	
	private void loadTBCTLopHocPhan(String maLhp) {
		xoaTBCTLopHocPhan();
		List<CT_LopHocPhan> dsct = lopHocPhanDAO.layDsCTLopHoc(maLhp);
		int i = 1;
		for (CT_LopHocPhan ct : dsct) {
			java.util.Date ngayBatDau = new java.util.Date(ct.getNgayBatDau().getTime());
			java.util.Date ngayKetThuc = new java.util.Date(ct.getNgayKetThuc().getTime());
			
			SimpleDateFormat sdm = new SimpleDateFormat("dd-MM-yyyy");
				
			String[] rowData = {i+"", ct.getHinhThuc(), ct.getThu(), ct.getTietHoc(), ct.getPhongHoc().getTenPhong(), ct.getGiangVien().getTenGiangVien(),
					sdm.format(ngayBatDau), sdm.format(ngayKetThuc)};
			modelCTLHP.addRow(rowData);
			tableCTLHP.setModel(modelCTLHP);
			i++;
		}
		
	}
	
	private void setTBLopHocPhanColumnWidth() {	
		TableColumn column = null;
		for (int i = 0; i < tableLHP.getColumnCount(); i++) {
			column = tableLHP.getColumnModel().getColumn(i);
			if(i==2) {
				column.setPreferredWidth(300);
			}
		}
	}
	
	private void setTBHocPhanColumnWidth() {	
		TableColumn column = null;
		for (int i = 0; i < tableHP.getColumnCount(); i++) {
			column = tableHP.getColumnModel().getColumn(i);
			if(i==2 || i==5) {
				column.setPreferredWidth(250);
			}
		}
	}
	
	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();
		
		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);
		
		tableHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("M?? h???c ph???n").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("T??n m??n h???c").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("S??? t??n ch???").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("B???t bu???c").setCellRenderer(centerCellRenderer);
		tableHP.getColumn("H???c ph???n y??u c???u").setCellRenderer(centerCellRenderer);
		
		tableLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("M?? l???p h???c ph???n").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("T??n l???p h???c ph???n").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("L???p t??n ch???").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("S?? s??? t???i ??a").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("S?? s??? ????ng k??").setCellRenderer(centerCellRenderer);
		tableLHP.getColumn("Tr???ng th??i").setCellRenderer(centerCellRenderer);
		
		tableCTLHP.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("H??nh th???c").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Th???").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ti???t").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ph??ng h???c").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Gi???ng vi??n").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ng??y b???t ?????u").setCellRenderer(centerCellRenderer);
		tableCTLHP.getColumn("Ng??y k???t th??c").setCellRenderer(centerCellRenderer);
	}
	
	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(25);
		tb.setFont(new Font("Segoe UI", Font.PLAIN, 13));
	}
}
