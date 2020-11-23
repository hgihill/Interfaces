package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.awt.event.InputEvent;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Toolkit;

public class DataBase extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	public static DataBase dataBase;
	public static JTextArea textArea, textAreaL, textAreaR;
	public static String sRoot;
	public static JLabel lblGestConexion;

	Control control = new Control();

	/**
	 * Create the frame.
	 */
	public DataBase() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/bd.png"));
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				control.confirmarSalir(dataBase);
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		JMenuItem itemConexion = new JMenuItem("Conexion...");
		itemConexion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Conexion();
			}
		});
		menuArchivo.add(itemConexion);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textAreaL = new JTextArea();
		scrollPane.setViewportView(textAreaL);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

		textAreaR = new JTextArea();
		textAreaR.setEditable(false);
		textAreaR.setBackground(Color.BLACK);
		textAreaR.setForeground(Color.WHITE);
		scrollPane_1.setViewportView(textAreaR);

		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.limpiar(textAreaL);
				control.limpiar(textAreaR);
			}
		});

		JMenu menuConsulta = new JMenu("Consulta >>");
		menuArchivo.add(menuConsulta);

		JMenuItem itemCargar = new JMenuItem("Cargar...");
		itemCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.cargar(dataBase, textAreaL);
			}
		});
		menuConsulta.add(itemCargar);

		JMenuItem itemLimpiarCons = new JMenuItem("Limpiar");
		itemLimpiarCons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaL.setText(" ");
			}
		});
		menuConsulta.add(itemLimpiarCons);

		JMenu menuResultados = new JMenu("Resultados >>");
		menuArchivo.add(menuResultados);

		JMenuItem itemGuardar = new JMenuItem("Guardar...");
		itemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.guardar(dataBase, textAreaL);
				control.guardarAuto(dataBase, textAreaR);
			}
		});
		menuResultados.add(itemGuardar);

		JMenuItem itemLimpiarRes = new JMenuItem("Limpiar");
		itemLimpiarRes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaR.setText(" ");
			}
		});
		menuResultados.add(itemLimpiarRes);

		JButton btnEjecutar = new JButton("EJECUTAR");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Control.retorna(textAreaL.getText());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JSeparator separator = new JSeparator();
		menuArchivo.add(separator);

		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.confirmarSalir(dataBase);
			}
		});
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		menuArchivo.add(itemSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		lblGestConexion = new JLabel("ESTADO: ");
		lblGestConexion.setBounds(230, 250, 100, 20);
		contentPane.add(lblGestConexion);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1)
								.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE).addGap(12)
								.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(25)
								.addComponent(btnLimpiar, GroupLayout.PREFERRED_SIZE, 78, GroupLayout.PREFERRED_SIZE)
								.addGap(2)
								.addComponent(btnEjecutar, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(lblGestConexion, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
								.addPreferredGap(ComponentPlacement.RELATED)))
				.addGap(1)));
		gl_contentPane
				.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addGap(1)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
										.addComponent(scrollPane_1, GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
								.addGap(12)
								.addGroup(
										gl_contentPane.createParallelGroup(Alignment.LEADING).addComponent(btnLimpiar)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(btnEjecutar).addComponent(lblGestConexion)))
								.addGap(10)));
		contentPane.setLayout(gl_contentPane);
		
		setVisible(true);
	}
}
