package ui.form;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import dao.NhanVienDAO;
import entity.NhanVienPDT;
import entity.TaiKhoan;

public class frm_QuanLyNhanVienPDT extends JPanel implements ActionListener {
	private JTextField txtHoTenNhanVien;
	private JTextField txtDiaChi;
	private JDateChooser txtNgaySinh;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_1_2;
	private JLabel lblNewLabel_3;
	private JTextField txtSoDienThoai;
	private JTextField txtTimKiem;
	private JComboBox<String> cmbTimKiem;
	private JScrollPane scrollPane;
	private JRadioButton rdoNam;
	private JRadioButton rdoNu;
	private JPanel panel;
	private DefaultTableModel modelNhanVienPDT;
	private JTable tableNhanVienPDT;
	private JButton btnThem;
	private JButton btnLamMoi;
	private JButton btnSua;
	private JButton btnLuu;
	private JTextField txtMaNhanVien;
	private NhanVienDAO nhanVienDAO;

	private void napDanhSachNhanVien(List<NhanVienPDT> danhSachNhanVien) {
		xoaBang();
		int i = 1;
		for (NhanVienPDT nv : danhSachNhanVien) {
			String[] row = { i + "", nv.getMaNhanVien(), nv.getTenNhanVien(), nv.getNgaySinh() + "", nv.getGioiTinh(),
					nv.getDiaChi(), nv.getSoDienThoai() };
			modelNhanVienPDT.addRow(row);
			tableNhanVienPDT.setModel(modelNhanVienPDT);
			i++;
		}
	}

	private void xoaBang() {
		while (modelNhanVienPDT.getRowCount() > 0) {
			modelNhanVienPDT.removeRow(0);
		}

	}

	public frm_QuanLyNhanVienPDT() {
//		setBackground(new Color(0, 153, 255));
		setLayout(null);

		JLabel lblMaNhanVien = new JLabel("M?? nh??n vi??n");
		lblMaNhanVien.setBounds(20, 569, 97, 20);
		lblMaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblMaNhanVien);

		JLabel lblNewLabel_1 = new JLabel("H??? t??n nh??n vi??n");
		lblNewLabel_1.setBounds(290, 569, 118, 19);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1);

		txtHoTenNhanVien = new JTextField();
		txtHoTenNhanVien.setBounds(410, 569, 234, 20);
		txtHoTenNhanVien.setColumns(10);
		add(txtHoTenNhanVien);

		JLabel lblNewLabel_1_1 = new JLabel("Gi???i t??nh");
		lblNewLabel_1_1.setBounds(20, 609, 97, 20);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_1);

		txtDiaChi = new JTextField();
		txtDiaChi.setBounds(770, 609, 230, 20);
		txtDiaChi.setColumns(10);
		add(txtDiaChi);

		txtNgaySinh = new JDateChooser();
		txtNgaySinh.setBounds(410, 609, 234, 19);
		txtNgaySinh.setDateFormatString("dd-MM-yyyy");
		add(txtNgaySinh);

		lblNewLabel_4 = new JLabel("Ng??y Sinh");
		lblNewLabel_4.setBounds(290, 609, 83, 19);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_4);

		lblNewLabel_1_2 = new JLabel("?????a ch???");
		lblNewLabel_1_2.setBounds(680, 609, 66, 20);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_1_2);

		lblNewLabel_3 = new JLabel("S??? ??i???n tho???i");
		lblNewLabel_3.setBounds(680, 569, 83, 20);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		add(lblNewLabel_3);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setBounds(770, 569, 230, 20);
		((JTextField) txtSoDienThoai).setColumns(10);
		add(txtSoDienThoai);

		txtTimKiem = new JTextField();
		txtTimKiem.setBounds(171, 20, 159, 20);
		add(txtTimKiem);
		txtTimKiem.setColumns(10);

		cmbTimKiem = new JComboBox();
		cmbTimKiem.setModel(new DefaultComboBoxModel(new String[] { "T???t c?? nh??n vi??n", "Theo m??", "Theo t??n" }));
		cmbTimKiem.setBounds(330, 20, 140, 20);
		add(cmbTimKiem);

		JLabel lblNewLabel_6 = new JLabel("T??m nhanh");
		lblNewLabel_6.setBounds(10, 10, 151, 40);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setIcon(new ImageIcon("images/Find.png"));
		add(lblNewLabel_6);

		rdoNam = new JRadioButton("Nam", true);
		rdoNam.setBounds(140, 609, 52, 20);
		rdoNu = new JRadioButton("N???");
		rdoNu.setBounds(200, 609, 52, 20);
		add(rdoNu);
		add(rdoNam);
		ButtonGroup group = new ButtonGroup();
		group.add(rdoNam);
		group.add(rdoNu);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(1020, 515, 313, 135);
		add(panel);

		btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon("img/addNV.png"));
		btnThem.setBounds(15, 10, 130, 50);
		panel.add(btnThem);

		btnLamMoi = new JButton("L??m m???i");
		btnLamMoi.setIcon(new ImageIcon("img/reset.png"));
		btnLamMoi.setBounds(160, 10, 130, 50);
		panel.add(btnLamMoi);

		btnSua = new JButton("S???a");
		btnSua.setIcon(new ImageIcon("img/change.png"));
		btnSua.setBounds(15, 75, 130, 50);
		panel.add(btnSua);

		btnLuu = new JButton("L??u");
		btnLuu.setIcon(new ImageIcon("imgupdate.png"));
		btnLuu.setBounds(160, 75, 129, 50);
		panel.add(btnLuu);

		// Table
		this.nhanVienDAO = new NhanVienDAO();
		String[] headers = "STT;M?? nh??n vi??n;H??? t??n;Ng??y sinh;Gi???i t??nh;?????a ch???;S??? ??i???n tho???i".split(";");
		modelNhanVienPDT = new DefaultTableModel(headers, 50);
		tableNhanVienPDT = new JTable(modelNhanVienPDT) {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		scrollPane = new JScrollPane(tableNhanVienPDT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBorder(BorderFactory.createTitledBorder("DANH S??CH NH??N VI??N"));
		tableNhanVienPDT.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		tableNhanVienPDT.getTableHeader().setReorderingAllowed(false);
		scrollPane.setBounds(20, 50, 1310, 455);
		scrollPane.setViewportView(tableNhanVienPDT);
		add(scrollPane);

		txtMaNhanVien = new JTextField();
		txtMaNhanVien.setBounds(140, 569, 130, 19);
		add(txtMaNhanVien);
		txtMaNhanVien.setColumns(10);

		napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
		btnLamMoi.addActionListener(this);
		btnLuu.addActionListener(this);
		btnSua.addActionListener(this);
		btnThem.addActionListener(this);
		cmbTimKiem.addActionListener(this);

		tableNhanVienPDT.getColumnModel().getColumn(0).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(1).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(2).setPreferredWidth(150);
		tableNhanVienPDT.getColumnModel().getColumn(3).setPreferredWidth(50);
		tableNhanVienPDT.getColumnModel().getColumn(5).setPreferredWidth(300);
		tableDesign(tableNhanVienPDT);
		tableRenderer();
		tableNhanVienPDT.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<NhanVienPDT> list = nhanVienDAO.danhSachNhanVien();
				int row = tableNhanVienPDT.getSelectedRow();
				if (row >= 0 && row <= list.size()) {
					NhanVienPDT nv = list.get(row);
					napNhanVien(nv);
				}
			}

			private void napNhanVien(NhanVienPDT nv) {
				txtMaNhanVien.setText(nv.getMaNhanVien());
				txtHoTenNhanVien.setText(nv.getTenNhanVien());
				txtDiaChi.setText(nv.getDiaChi());
				txtSoDienThoai.setText(nv.getSoDienThoai());
				txtNgaySinh.setDate(nv.getNgaySinh());
				txtNgaySinh.setToolTipText(String.valueOf(nv.getNgaySinh()));
				String gt = nv.getGioiTinh();
				if (gt.equals("Nam"))
					rdoNam.setSelected(true);
				else
					rdoNu.setSelected(true);
			}

		});
	}

	private void lamMoi() {
		txtDiaChi.setText("");
		txtHoTenNhanVien.setText("");
		txtMaNhanVien.setText("");
		txtMaNhanVien.setEditable(false);
		txtNgaySinh.setDate(new java.util.Date());
		btnLuu.setEnabled(false);
		btnThem.setEnabled(true);
		btnSua.setEnabled(true);
		txtTimKiem.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			lamMoi();
			btnLuu.setEnabled(true);
			btnThem.setEnabled(false);
			txtMaNhanVien.setEditable(true);
			btnSua.setEnabled(false);
		}
		if (o.equals(btnLuu)) {
			if (kiemTra()) {
				if (nhanVienDAO.timMaNhanVien(txtMaNhanVien.getText().trim())) {
					showMes(txtMaNhanVien, "Tr??ng m??");
					return;
				}
				long ngay = txtNgaySinh.getDate().getTime();
				Date ngaysinh = new Date(ngay);
				String gt = (rdoNam.isSelected() ? "Nam" : "N???");
				NhanVienPDT nhanVienPDT = new NhanVienPDT(txtMaNhanVien.getText().trim(),
						txtHoTenNhanVien.getText().trim(), ngaysinh, gt, txtDiaChi.getText().trim(),
						txtSoDienThoai.getText().trim(), new TaiKhoan(txtMaNhanVien.getText().trim()));
				TaiKhoan tk = new TaiKhoan(nhanVienPDT.getTaiKhoan().getTenDangNhap());
				if (nhanVienDAO.themNhanVien(nhanVienPDT, tk.getTenDangNhap())) {
					napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
					JOptionPane.showMessageDialog(this, "???? th??m");
					btnLuu.setEnabled(false);
					btnThem.setEnabled(true);
					btnSua.setEnabled(true);
				} else
					JOptionPane.showMessageDialog(this, "Kh??ng th??m ???????c");
			}
		}
		if (o.equals(btnSua)) {
			if (kiemTra()) {
				if (nhanVienDAO.timMaNhanVien(txtMaNhanVien.getText().trim())) {
					showMes(txtMaNhanVien, "Tr??ng m??");
					return;
				}
				long ngay = txtNgaySinh.getDate().getTime();
				Date ngaysinh = new Date(ngay);
				String gt = (rdoNam.isSelected() ? "Nam" : "N???");
				NhanVienPDT nhanVienPDT = new NhanVienPDT(txtMaNhanVien.getText().trim(),
						txtHoTenNhanVien.getText().trim(), ngaysinh, gt, txtDiaChi.getText().trim(),
						txtSoDienThoai.getText().trim(), new TaiKhoan(txtMaNhanVien.getText().trim()));
				if (nhanVienDAO.suaNhanVien(nhanVienPDT)) {
					napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
					JOptionPane.showMessageDialog(this, "C???p nh???t th??nh c??ng", "Ch?? ??", JOptionPane.OK_OPTION);
					btnLuu.setEnabled(false);
					btnThem.setEnabled(true);
					txtMaNhanVien.setEditable(false);
				} else
					JOptionPane.showMessageDialog(this, "C???p nh???t kh??ng th??nh c??ng");
			}
		}
		if (o.equals(btnLamMoi)) {
			lamMoi();
			napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
		}
		if (o.equals(cmbTimKiem)) {
			xoaBang();
			napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoMa(txtMaNhanVien.getText().trim()));
			String s = cmbTimKiem.getSelectedItem().toString().trim();
			if (s.equalsIgnoreCase("T???t c?? nh??n vi??n"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
			else if (s.equalsIgnoreCase("Theo m??"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoMa(txtTimKiem.getText().trim()));
			else if (s.equalsIgnoreCase("Theo t??n"))
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVienTheoTen(txtTimKiem.getText().trim()));
			else
				napDanhSachNhanVien(nhanVienDAO.danhSachNhanVien());
		}
	}

	private void tableRenderer() {
		DefaultTableCellRenderer rightCellRenderer = new DefaultTableCellRenderer();
		DefaultTableCellRenderer centerCellRenderer = new DefaultTableCellRenderer();

		rightCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.RIGHT);
		centerCellRenderer.setHorizontalAlignment(DefaultTableCellRenderer.CENTER);

		tableNhanVienPDT.getColumn("STT").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("M?? nh??n vi??n").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("Ng??y sinh").setCellRenderer(centerCellRenderer);
		tableNhanVienPDT.getColumn("Gi???i t??nh").setCellRenderer(centerCellRenderer);
	}

	private void tableDesign(JTable tb) {
		tb.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 14));
		tb.getTableHeader().setOpaque(false);
		tb.getTableHeader().setBackground(new Color(32, 136, 203));
		tb.getTableHeader().setForeground(Color.white);
		tb.setRowHeight(20);
	}

	private boolean kiemTra() {

		if (txtMaNhanVien.getText().equalsIgnoreCase("")) {
			showMes(txtMaNhanVien, "Kh??ng ????? tr???ng m?? nh??n vi??n");
			return false;
		}
		if (txtHoTenNhanVien.getText().equalsIgnoreCase("")) {
			showMes(txtHoTenNhanVien, "Kh??ng ????? tr???ng t??n nh??n vi??n");
			return false;
		}

		if (txtSoDienThoai.getText().equalsIgnoreCase("")) {
			showMes(txtSoDienThoai, "Kh??ng ????? tr???ng s??? ??i???n tho???i");
			return false;
		}
		if (!txtMaNhanVien.getText().trim().matches("NV[0-9]{5}")) {
			showMes(txtMaNhanVien, "M?? nh??n vi??n b???t ?????u b???ng NV ti???p l?? 5 con s???\nV?? d???: NV12345");
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
}
