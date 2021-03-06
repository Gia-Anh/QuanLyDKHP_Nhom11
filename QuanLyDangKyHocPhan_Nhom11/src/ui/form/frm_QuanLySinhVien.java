package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;

import dao.ConnectDB;
import dao.SinhVienDAO;
import entity.LopSinhVien;
import entity.SinhVien;
import entity.TaiKhoan;

public class frm_QuanLySinhVien extends JPanel implements ActionListener {
	private static final long serialVersionUID = 1906248937583556942L;
	private static Connection con;
	private JPanel contentPane;
	private JTextField txtMaSinhVien;
	private JTextField txtDiaChi;
	private JDateChooser txtNgaySinh;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JTextField txtSoDienThoai;
	private JButton btnThem;
	private JTextField txtTimKiem;
	private JPanel panel;
	private JComboBox<String> cbbTimKiem;
	private JButton btnSua;
	private JScrollPane scrollPane;
	private JTextField txtHoTenSV;
	private DefaultTableModel modelSinhVien;
	private JTable tableSinhVien;
	private SinhVienDAO sinhVienDAO;
	private JComboBox cbbTenLopSV;
	private JComboBox cbbTenChuyenNganh;
	private JButton btnLuu;
	private JButton btnLamMoi;
	private JRadioButton rdNam;
	private JRadioButton rdNu;
	private ButtonGroup buttonGroup;
	private ButtonGroup group;
	private JPanel panel_1;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes", "serial" })
	private void GiaoDien() {
		setLayout(null);

		JLabel lblNewLabel = new JLabel("M?? sinh vi??n");
		lblNewLabel.setBounds(20, 541, 79, 17);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel);

		txtMaSinhVien = new JTextField();
		txtMaSinhVien.setBounds(122, 541, 180, 20);
		txtMaSinhVien.setText("SV13111");
		add(txtMaSinhVien);
		txtMaSinhVien.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("H??? t??n sinh vi??n");
		lblNewLabel_1.setBounds(370, 542, 103, 20);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("T??n l???p");
		lblNewLabel_1_1.setBounds(370, 580, 91, 17);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(490, 620, 490, 20);
		txtDiaChi.setText("24 Nguy???n Du, p1, G?? V???p");
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		txtNgaySinh.setBounds(790, 542, 190, 20);
		add(txtNgaySinh);

		lblNewLabel_4 = new JLabel("Ng??y Sinh");
		lblNewLabel_4.setBounds(700, 542, 64, 17);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("Gi???i t??nh");
		lblNewLabel_5.setBounds(20, 619, 53, 17);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_5);

		lblNewLabel_1_2 = new JLabel("?????a ch???");
		lblNewLabel_1_2.setBounds(370, 620, 43, 17);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_2);

		lblNewLabel_3 = new JLabel("S??? ??i???n tho???i");
		lblNewLabel_3.setBounds(700, 580, 83, 17);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(790, 580, 190, 20);
		txtSoDienThoai.setText("0959548574");
		txtSoDienThoai.setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setText("DHKTPM13A");
		txtTimKiem.setBounds(140, 20, 190, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cbbTimKiem = new JComboBox();
		cbbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "T???t c??? sinh vi??n", "Theo m??", "Theo t??n" }));
		cbbTimKiem.setBounds(330, 20, 140, 20);
		add(cbbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("T??m nhanh");
		lblNewLabel_6.setBounds(10, 10, 130, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);
		group = new ButtonGroup();

		txtHoTenSV = new JTextField();
		txtHoTenSV.setBounds(490, 542, 190, 20);
		txtHoTenSV.setText("Ph???m Th??nh Khoa");
		txtHoTenSV.setColumns(10);
		add(txtHoTenSV);

		JLabel lblMLp_1 = new JLabel("Chuy??n ng??nh");
		lblMLp_1.setBounds(20, 579, 110, 17);
		lblMLp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblMLp_1);

		panel_1 = new JPanel();
		panel_1.setBounds(1020, 515, 303, 135);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panel_1);
		panel_1.setLayout(null);

		btnThem = new JButton("Th??m");
		btnThem.setBounds(15, 10, 130, 50);
		panel_1.add(btnThem);
		btnThem.setIcon(new ImageIcon("img/addSV.png"));

		btnSua = new JButton("S???a");
		btnSua.setBounds(15, 75, 130, 50);
		panel_1.add(btnSua);
		btnSua.setIcon(new ImageIcon("img/change.png"));

		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setIcon(new ImageIcon("img/reset.png"));
		btnLamMoi.setBounds(160, 10, 130, 50);
		panel_1.add(btnLamMoi);

		btnLuu = new JButton("L??u");
		btnLuu.setIcon(new ImageIcon("img/update.png"));
		btnLuu.setBounds(160, 75, 129, 50);
		panel_1.add(btnLuu);

		cbbTenChuyenNganh = new JComboBox();
//		cbbTenChuyenNganh.setModel(new DefaultComboBoxModel(new String[] { "" }));
		cbbTenChuyenNganh.setBounds(122, 579, 180, 21);
		add(cbbTenChuyenNganh);

		cbbTenLopSV = new JComboBox();
//		cbbTenLopSV.setModel(new DefaultComboBoxModel(new String[] { "" }));
		cbbTenLopSV.setBounds(490, 580, 190, 21);
		add(cbbTenLopSV);

		rdNam = new JRadioButton("Nam", true);
		rdNam.setBounds(119, 619, 53, 21);
		add(rdNam);
		rdNu = new JRadioButton("N???");
		rdNu.setBounds(199, 619, 53, 21);
		add(rdNu);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdNam);
		buttonGroup.add(rdNu);
		// Table
		this.sinhVienDAO = new SinhVienDAO();
		String[] headers = "STT;M?? sinh vi??n;H??? t??n;M?? l???p;Chuy??n ng??nh;Ng??y sinh;Gi???i t??nh;?????a ch???;S??? ??i???n tho???i"
				.split(";");
		modelSinhVien = new DefaultTableModel(headers, 50);
		tableSinhVien = new JTable(modelSinhVien) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane = new JScrollPane(tableSinhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(20, 50, 1310, 446);
		scrollPane.setBorder(BorderFactory.createTitledBorder("DANH S??CH SINH VI??N"));
		tableSinhVien.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableSinhVien.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableSinhVien);
		add(scrollPane);
	}

	private void xoaBang() {
		while (modelSinhVien.getRowCount() > 0) {
			modelSinhVien.removeRow(0);
		}
	}

	private void napDanhSachSinhVien(List<SinhVien> list) {
		xoaBang();
		int i = 1;
		for (SinhVien sv : list) {
			LopSinhVien lsv = sinhVienDAO.layThongTinBoiMa(sv.getLopSinhVien().getMaLopSV());
			String[] row = { i + "", sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getLopSinhVien().getMaLopSV(),
					lsv.getChuyenNganh().getMaChuyenNganh() + "", sv.getNgaySinh() + "", sv.getGioiTinh(),
					sv.getDiaChi(), sv.getSoDienThoai() };
			modelSinhVien.addRow(row);
			tableSinhVien.setModel(modelSinhVien);
			i -= -1;
		}
	}

	public frm_QuanLySinhVien() {
		con = ConnectDB.getInstance().getConnection();
		GiaoDien();
		napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
		napComboboxChuyenNganh();
		napComboboxTenLop();

		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		cbbTenChuyenNganh.addActionListener(this);
		cbbTenLopSV.addActionListener(this);
		cbbTimKiem.addActionListener(this);
//		cbbTenLopSV.setEnabled(false);
		txtMaSinhVien.setEditable(false);
		btnLuu.setEnabled(false);

		tableSinhVien.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableSinhVien.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableSinhVien.getColumnModel().getColumn(7).setPreferredWidth(300);
		tableSinhVien.getColumnModel().getColumn(6).setPreferredWidth(30);
		tableDesign(tableSinhVien);
		tableRenderer();
		tableSinhVien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<SinhVien> list = sinhVienDAO.danhSachSinhVien();
				int row = tableSinhVien.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					SinhVien sv = list.get(row);
					napSinhVien(sv);
					String x = (String) tableSinhVien.getModel().getValueAt(row, 1);
					for (int i = 0; i < cbbTenChuyenNganh.getItemCount(); i++) {
						String chuyenNganh = sinhVienDAO.timTenChuyenNganhTheoMaSV(x);
						if (chuyenNganh.equals(cbbTenChuyenNganh.getItemAt(i).toString())) {
							cbbTenChuyenNganh.setSelectedIndex(i);
							break;
						}
					}
					for (int i = 0; i < cbbTenLopSV.getItemCount(); i++) {
						String lopSv = sinhVienDAO.timTenLopHocTheoMaSV(x);
						if (lopSv.equals(cbbTenLopSV.getItemAt(i).toString())) {
							cbbTenLopSV.setSelectedIndex(i);
							break;
						}
					}
				}
			}
		});
		cbbTenChuyenNganh.addActionListener(e -> {
			cbbTenLopSV.removeAllItems();
			cbbTenLopSV.setEnabled(true);
			napComboboxLopHoc(cbbTenChuyenNganh.getSelectedItem().toString().trim());
		});
	}

	private void napComboboxChuyenNganh() {
		String sql = "select * from [dbo].[ChuyenNganh] order by tenchuyenNganh";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				this.cbbTenChuyenNganh.addItem(rs.getString("tenChuyenNganh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napComboboxLopHoc(String ma) {
		cbbTenLopSV.removeAllItems();
		try {
			PreparedStatement stmt = con.prepareStatement(
					"select L.tenLop from [dbo].[ChuyenNganh] C join [dbo].[LopSinhVien] L on C.maChuyenNganh=L.maChuyenNganh"
							+ " where C.tenChuyenNganh =?");
			stmt.setString(1, ma);
			ResultSet rs = stmt.executeQuery();
			while (rs.next())
				this.cbbTenLopSV.addItem(rs.getString("tenLop"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napComboboxTenLop() {
		String sql = "select distinct * from [dbo].[LopSinhVien] order by  tenLop DESC  ";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenLop"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "-- Ch???n chuy??n ng??nh --";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbTenLopSV.setModel(new DefaultComboBoxModel(mang));
//				this.cbbTenChuyenNganh.addItem(rs.getString("tenChuyenNganh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napComboboxTenLopSinhVien(String ten) {
		String sql = "select distinct * "
				+ "	from [dbo].[LopSinhVien] l join [dbo].[ChuyenNganh] c on l.maChuyenNganh=c.maChuyenNganh "
				+ "	where c.tenChuyenNganh like (N'%" + ten + "%') " + "	order by tenLop DESC";
		List<String> ds = new ArrayList<String>();
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ds.add(rs.getString("tenLop"));
			}
			String[] mang = new String[ds.size() + 1];
			mang[0] = "-- Ch???n l???p sinh vi??n --";
			for (int i = 0; i < ds.size(); i++) {
				mang[i + 1] = ds.get(i);
			}
			cbbTenLopSV.setModel(new DefaultComboBoxModel(mang));
//				this.cbbTenChuyenNganh.addItem(rs.getString("tenChuyenNganh"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void napSinhVien(SinhVien sv) {
		txtMaSinhVien.setText(sv.getMaSinhVien());
		txtHoTenSV.setText(sv.getTenSinhVien());
		txtDiaChi.setText(sv.getDiaChi());
		txtNgaySinh.setDate(sv.getNgaySinh());
		txtNgaySinh.setToolTipText(String.valueOf(sv.getNgaySinh()));
		txtSoDienThoai.setText(sv.getSoDienThoai());
		txtTimKiem.setText("");
		String x = sv.getGioiTinh();
		if (x.equals("Nam"))
			rdNam.setSelected(true);
		else
			rdNu.setSelected(true);
	}

	private void lamMoi() {
		txtDiaChi.setText("");
		txtHoTenSV.setText("");
		txtMaSinhVien.setText("");
		txtSoDienThoai.setText("");
		txtTimKiem.setText("");
		rdNam.setSelected(true);

		txtNgaySinh.setDate(new java.util.Date());
		cbbTenChuyenNganh.setSelectedIndex(0);
		napComboboxTenLopSinhVien(cbbTenChuyenNganh.getSelectedItem().toString().trim());
		txtMaSinhVien.setEditable(false);
		btnLuu.setEnabled(false);
		btnThem.setEnabled(true);
		btnSua.setEnabled(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		try {
			if (o.equals(btnThem)) {
				lamMoi();
				btnLuu.setEnabled(true);
				btnThem.setEnabled(false);
				txtMaSinhVien.setEditable(true);
				cbbTenLopSV.setEnabled(true);
				btnSua.setEnabled(false);
			} else if (o.equals(btnLuu)) {

				if (kiemTra()) {
					if (sinhVienDAO.timMaTrung(txtMaSinhVien.getText().trim())) {
						showMes(txtMaSinhVien, "Tr??ng m??");
						return;
					}
					long ngay = txtNgaySinh.getDate().getTime();
					Date ngaysinh = new Date(ngay);
					String tenLop = cbbTenLopSV.getSelectedItem().toString().trim();
					if (tenLop.equals("-- Ch???n l???p sinh vi??n --")) {
						JOptionPane.showMessageDialog(this, "Ch??a ch???n l???p");
						return;
					}
					LopSinhVien lop = new LopSinhVien(sinhVienDAO.timMaLop(tenLop));
					String gioiTinh = (rdNam.isSelected() ? "Nam" : "N???");
					SinhVien sinhVien = new SinhVien(txtMaSinhVien.getText().trim(), txtHoTenSV.getText().trim(),
							ngaysinh, gioiTinh, txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim(), lop,
							new TaiKhoan(txtMaSinhVien.getText().trim()));
					TaiKhoan tk = new TaiKhoan(sinhVien.getTaiKhoan().getTenDangNhap());
					if (sinhVienDAO.themSinhVien(sinhVien, tk.getTenDangNhap())) {
						napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
						JOptionPane.showMessageDialog(this, "???? th??m");
						btnLuu.setEnabled(false);
						btnThem.setEnabled(true);
						btnSua.setEnabled(true);
					} else
						JOptionPane.showMessageDialog(this, "Kh??ng th??m ???????c");
				}

			} else if (o.equals(btnSua)) {
				if (kiemTra()) {
					long ngay = txtNgaySinh.getDate().getTime();
					Date ngaysinh = new Date(ngay);
					String chuyenNganh = cbbTenChuyenNganh.getSelectedItem().toString().trim();
					String lopSinhVien = cbbTenLopSV.getSelectedItem().toString().trim();
					String gioiTinh = (rdNam.isSelected() ? "Nam" : "N???");
					LopSinhVien lop = new LopSinhVien(
							sinhVienDAO.timMaLop(cbbTenLopSV.getSelectedItem().toString().trim()));
					SinhVien sinhVien = new SinhVien(txtMaSinhVien.getText().trim(), txtHoTenSV.getText().trim(),
							ngaysinh, gioiTinh, txtDiaChi.getText().trim(), txtSoDienThoai.getText().trim(), lop,
							new TaiKhoan(txtMaSinhVien.getText().trim()));
					if (sinhVienDAO.suaSinhVien(sinhVien)) {
						napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
						JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng");
					} else
						JOptionPane.showMessageDialog(this, "C???p nh???t kh??ng th??nh c??ng");
				}
			} else if (o.equals(btnLamMoi)) {
				lamMoi();
				btnThem.setEnabled(true);
				napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
			} else if (o.equals(cbbTimKiem)) {
				xoaBang();
				napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMaLop(txtTimKiem.getText().trim()));
				String s = cbbTimKiem.getSelectedItem().toString();
				if (s.equalsIgnoreCase("T???t c??? sinh vi??n"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVien());
				else if (s.equalsIgnoreCase("Theo l???p h???c"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMaLop(txtTimKiem.getText().trim()));
				else if (s.equalsIgnoreCase("Theo t??n"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoTen(txtTimKiem.getText().trim()));
				else if (s.equalsIgnoreCase("Theo m??"))
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoMa(txtTimKiem.getText().trim()));
				else
					napDanhSachSinhVien(sinhVienDAO.danhSachSinhVienTheoTenChuyenNganh(txtTimKiem.getText().trim()));
			}
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(this, e2.getMessage());
		}

	}

	private boolean kiemTra() {

		if (txtMaSinhVien.getText().equalsIgnoreCase("")) {
			showMes(txtMaSinhVien, "Kh??ng ????? tr???ng m?? sinh vi??n");
			return false;
		}
		if (txtHoTenSV.getText().equalsIgnoreCase("")) {
			showMes(txtHoTenSV, "Kh??ng ????? tr???ng t??n sinh vi??n");
			return false;
		}

		if (txtSoDienThoai.getText().equalsIgnoreCase("")) {
			showMes(txtSoDienThoai, "Kh??ng ????? tr???ng s??? ??i???n tho???i");
			return false;
		}

		String ma = txtMaSinhVien.getText().trim();

		if (!txtMaSinhVien.getText().trim().matches("SV[0-9]{5}")) {
			showMes(txtMaSinhVien, "M?? sinh vi??n b???t ?????u b???ng SV ti???p l?? 5 con s???\nV?? d???: SV12345");
			return false;
		}
		if (!txtSoDienThoai.getText().trim().matches("0[0-9]{9}")) {
			showMes(txtSoDienThoai, "S??? ??i???n tho???i l?? 10 con s??? b???t ?????u b???ng s??? 0");
			return false;
		}
		return true;
	}

	public void showMes(JTextField tf, String mes) {
		JOptionPane.showMessageDialog(this, mes);
		tf.selectAll();
		tf.requestFocus();
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableSinhVien.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("M?? sinh vi??n").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("H??? t??n").setCellRenderer(rightCellRenderer);
		tableSinhVien.getColumn("M?? l???p").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Chuy??n ng??nh").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Ng??y sinh").setCellRenderer(centerCellRenderer);
		tableSinhVien.getColumn("Gi???i t??nh").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("?????a ch???").setCellRenderer(centerCellRenderer);
//		tableSinhVien.getColumn("S??? ??i???n tho???i").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}
}