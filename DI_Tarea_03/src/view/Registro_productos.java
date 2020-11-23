package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;
import logic.Logic;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Toolkit;

public class Registro_productos extends JFrame {

	private static final long serialVersionUID = 1L;

	public static Registro_productos registro;
	public static JPanel contentPane;
	public static JTextField txtCode;
	public static JTextField txtName;
	public static JTextField txtStockActual;
	public static JTextField txtStockMin;
	public static JTextField txtStockMax;
	public static JTextField txtPVP;
	@SuppressWarnings("rawtypes")
	public static List productos;
	public static JRadioButton radioBtnPack;
	public static JRadioButton radioBtnUnidad;
	public static JRadioButton radioBtnCombinado;
	@SuppressWarnings("rawtypes")
	public static JComboBox comboProveedor;
	public static JTextArea textArea;
	public static JCheckBox chkFragil;
	public static JCheckBox chkObsoleto;

	Logic logic = new Logic();
	Control control = new Control();
	public static ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Registro_productos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/carrito.png"));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				control.guardarFichero();
			}
		});

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblCode = new JLabel("Código:");
		lblCode.setBounds(16, 25, 49, 16);
		contentPane.add(lblCode);

		JLabel lblName = new JLabel("Nombre:");
		lblName.setBounds(16, 53, 54, 16);
		contentPane.add(lblName);

		txtCode = new JTextField();
		txtCode.setBounds(89, 20, 96, 26);
		contentPane.add(txtCode);
		txtCode.setColumns(10);

		txtName = new JTextField();
		txtName.setBounds(89, 48, 96, 26);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblGrupo = new JLabel("Grupo:");
		lblGrupo.setBounds(16, 101, 42, 16);
		contentPane.add(lblGrupo);

		radioBtnPack = new JRadioButton("Pack");
		buttonGroup.add(radioBtnPack);
		radioBtnPack.setBounds(78, 97, 61, 23);
		contentPane.add(radioBtnPack);

		radioBtnUnidad = new JRadioButton("Unidad");
		buttonGroup.add(radioBtnUnidad);
		radioBtnUnidad.setBounds(78, 122, 76, 23);
		contentPane.add(radioBtnUnidad);

		radioBtnCombinado = new JRadioButton("Combinado");
		buttonGroup.add(radioBtnCombinado);
		radioBtnCombinado.setBounds(78, 147, 107, 23);
		contentPane.add(radioBtnCombinado);

		JLabel lblComments = new JLabel("Comentarios:");
		lblComments.setBounds(16, 179, 84, 16);
		contentPane.add(lblComments);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(112, 182, 315, 54);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);

		JLabel lblStockActual = new JLabel("Stock actual:");
		lblStockActual.setBounds(262, 25, 86, 16);
		contentPane.add(lblStockActual);

		JLabel lblStockMinimo = new JLabel("Stock mínimo:");
		lblStockMinimo.setBounds(252, 53, 95, 16);
		contentPane.add(lblStockMinimo);

		JLabel lblStockMaximo = new JLabel("Stock máximo:");
		lblStockMaximo.setBounds(250, 81, 95, 16);
		contentPane.add(lblStockMaximo);

		txtStockActual = new JTextField();
		txtStockActual.setBounds(360, 20, 67, 26);
		contentPane.add(txtStockActual);
		txtStockActual.setColumns(10);

		txtStockMin = new JTextField();
		txtStockMin.setBounds(360, 48, 67, 26);
		contentPane.add(txtStockMin);
		txtStockMin.setColumns(10);

		txtStockMax = new JTextField();
		txtStockMax.setBounds(360, 76, 67, 26);
		contentPane.add(txtStockMax);
		txtStockMax.setColumns(10);

		JLabel lblProveedor = new JLabel("Proveedor:");
		lblProveedor.setBounds(243, 151, 71, 16);
		contentPane.add(lblProveedor);

		JLabel lblOtro = new JLabel("Otros:");
		lblOtro.setBounds(16, 245, 42, 16);
		contentPane.add(lblOtro);

		chkFragil = new JCheckBox("Frágil");
		chkFragil.setBounds(78, 241, 67, 23);
		contentPane.add(chkFragil);

		chkObsoleto = new JCheckBox("Obsoleto");
		chkObsoleto.setBounds(155, 241, 96, 23);
		contentPane.add(chkObsoleto);

		JLabel lblPVP = new JLabel("PVP:");
		lblPVP.setBounds(320, 245, 34, 16);
		contentPane.add(lblPVP);

		txtPVP = new JTextField();
		txtPVP.setBounds(360, 240, 67, 26);
		contentPane.add(txtPVP);
		txtPVP.setColumns(10);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 273, 450, 12);
		contentPane.add(separator);

		JButton btnPrimero = new JButton("|<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.principio();
			}
		});
		btnPrimero.setBounds(5, 290, 40, 29);
		contentPane.add(btnPrimero);

		JButton btnAnterior = new JButton("<<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.anterior();
			}
		});
		btnAnterior.setBounds(35, 290, 49, 29);
		contentPane.add(btnAnterior);

		JButton btnSiguiente = new JButton(">>");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.siguiente();
			}
		});
		btnSiguiente.setBounds(75, 290, 49, 29);
		contentPane.add(btnSiguiente);

		JButton btnUltimo = new JButton(">|");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.fin();
			}
		});
		btnUltimo.setBounds(115, 290, 42, 29);
		contentPane.add(btnUltimo);

		JButton btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.confirmarBorrar(registro);
			}
		});
		btnBorrar.setBounds(255, 290, 61, 29);
		contentPane.add(btnBorrar);

		JButton btnSave = new JButton("Guardar");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.guardarProducto();
			}
		});
		btnSave.setBounds(310, 290, 76, 29);
		contentPane.add(btnSave);

		JButton btnNew = new JButton("Nuevo");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.anadir();
			}
		});
		btnNew.setBounds(380, 290, 67, 29);
		contentPane.add(btnNew);

		comboProveedor = new JComboBox();
		comboProveedor.setModel(new DefaultComboBoxModel(new String[] { "Dojo", "Samson", "Luna" }));
		comboProveedor.setBounds(320, 147, 107, 27);
		contentPane.add(comboProveedor);

		try {
			control.leerObj();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		setVisible(true);
	}
}
