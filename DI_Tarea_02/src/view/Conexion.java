package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.event.ChangeListener;

import controller.Control;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;

public class Conexion extends JFrame {

	private static final long serialVersionUID = 1L;

	public static JPanel contentPane;
	public static JTextField txtHost;
	public static JTextField txtPort;
	public static JTextField txtSID;
	public static JTextField txtUser;
	public static final ButtonGroup buttonGroup = new ButtonGroup();
	public static JPasswordField pass;
	public static Connection connection;
	public static JRadioButton radiobtnOracle;
	public static JRadioButton radiobtnMySQL;
	public static Conexion frame;

	/**
	 * Create the frame.
	 */
	public Conexion() {
		setBounds(100, 100, 217, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		radiobtnOracle = new JRadioButton("Oracle");
		buttonGroup.add(radiobtnOracle);
		radiobtnOracle.setSelected(true);
		radiobtnOracle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

			}
		});
		radiobtnOracle.setBounds(20, 24, 72, 23);
		contentPane.add(radiobtnOracle);

		radiobtnMySQL = new JRadioButton("MySQL");
		buttonGroup.add(radiobtnMySQL);
		radiobtnOracle.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

			}
		});
		radiobtnMySQL.setBounds(122, 24, 74, 23);
		contentPane.add(radiobtnMySQL);

		JSeparator separator = new JSeparator();
		separator.setBounds(20, 59, 177, 12);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(20, 162, 177, 12);
		contentPane.add(separator_1);

		txtHost = new JTextField();
		txtHost.setBounds(82, 72, 114, 26);
		contentPane.add(txtHost);
		txtHost.setColumns(10);

		txtPort = new JTextField();
		txtPort.setBounds(82, 99, 114, 26);
		contentPane.add(txtPort);
		txtPort.setColumns(10);

		txtSID = new JTextField();
		txtSID.setBounds(82, 128, 114, 26);
		contentPane.add(txtSID);
		txtSID.setColumns(10);

		JLabel lblHost = new JLabel("Host:");
		lblHost.setBounds(20, 77, 34, 16);
		contentPane.add(lblHost);

		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(23, 104, 29, 16);
		contentPane.add(lblPort);

		JLabel lblSID = new JLabel("SID:");
		lblSID.setBounds(27, 133, 25, 16);
		contentPane.add(lblSID);

		txtUser = new JTextField();
		txtUser.setBounds(82, 176, 114, 26);
		contentPane.add(txtUser);
		txtUser.setColumns(10);

		pass = new JPasswordField();
		pass.setBounds(82, 202, 114, 26);
		contentPane.add(pass);

		JLabel lblUser = new JLabel("User:");
		lblUser.setBounds(20, 181, 34, 16);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Pass:");
		lblPassword.setBounds(20, 207, 34, 16);
		contentPane.add(lblPassword);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(20, 229, 176, 12);
		contentPane.add(separator_2);

		JButton btnConnect = new JButton("Conectar");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Control.btnConectar(frame);
			}
		});
		btnConnect.setBounds(62, 243, 100, 29);
		contentPane.add(btnConnect);

		setVisible(true);
	}
}
