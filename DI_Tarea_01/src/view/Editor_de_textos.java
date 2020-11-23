package view;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.Toolkit;

public class Editor_de_textos extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private String sRoot;
	public static Editor_de_textos editor;
	public static JLabel lblNumChar = new JLabel("Caracteres: ");
	public static JTextArea textArea;

	private Control control = new Control();

	public JLabel getCharCount() {
		return lblNumChar;
	}

	/**
	 * Create the frame.
	 */
	public Editor_de_textos() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("img/editor.png"));
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				control.confirmarSalir(editor);
			}
		});

		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menuArchivo = new JMenu("Archivo");
		menuBar.add(menuArchivo);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setText(sRoot);
		textArea.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {

			}

			@Override
			public void keyReleased(KeyEvent e) {
				control.charCount(lblNumChar);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
			}
		});

		contentPane.add(textArea, BorderLayout.CENTER);
		setContentPane(contentPane);

		JMenuItem itemAbrir = new JMenuItem("Abrir");
		itemAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sRoot = control.abrir(editor, textArea);
			}
		});
		itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		menuArchivo.add(itemAbrir);

		JMenuItem itemGuardar = new JMenuItem("Guardar");

		itemGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (sRoot != null) {
					control.guardar(sRoot, textArea);
				} else {
					control.guardarComo(editor, textArea);
				}

			}
		});
		itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		menuArchivo.add(itemGuardar);

		JMenuItem itemGuardarComo = new JMenuItem("Guardar Como");
		itemGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		itemGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.guardarComo(editor, textArea);
			}
		});
		menuArchivo.add(itemGuardarComo);

		itemGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		menuArchivo.add(itemGuardarComo);

		JSeparator separator = new JSeparator();
		menuArchivo.add(separator);
		JLabel lblEtiqueta = new JLabel("¿Confirma que desea salir del programa?");
		lblEtiqueta.setBounds(113, 26, 161, 24);
		lblEtiqueta.setFont(new Font("Helvetica", Font.ITALIC, 14));

		JMenuItem itemSalir = new JMenuItem("Salir");
		itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		itemSalir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				control.confirmarSalir(editor);
			}

		});
		menuArchivo.add(itemSalir);

		JMenu menuEstilo = new JMenu("Estilo");
		menuBar.add(menuEstilo);

		JMenuItem itemColores = new JMenuItem("Colores");
		itemColores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Colores();
			}
		});
		menuEstilo.add(itemColores);

		JMenuItem itemFuente = new JMenuItem("Fuente");
		itemFuente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Fuente();
			}
		});
		menuEstilo.add(itemFuente);

		JMenu menuAyuda = new JMenu("Ayuda");
		menuBar.add(menuAyuda);

		JMenuItem itemAyuda = new JMenuItem("Ayuda");
		itemAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new Ayuda();
			}
		});
		menuAyuda.add(itemAyuda);

		JMenuItem itemAcercaDe = new JMenuItem("Acerca de...");
		itemAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new AcercaDe();
			}
		});
		menuAyuda.add(itemAcercaDe);

		JPanel panInf = new JPanel();
		contentPane.add(panInf, BorderLayout.SOUTH);

		GroupLayout glInf = new GroupLayout(panInf);
		glInf.setHorizontalGroup(glInf.createParallelGroup(Alignment.LEADING)
				.addGroup(glInf.createSequentialGroup().addComponent(lblNumChar)
						.addPreferredGap(ComponentPlacement.UNRELATED).addContainerGap(345, Short.MAX_VALUE)));
		glInf.setVerticalGroup(
				glInf.createParallelGroup(Alignment.LEADING).addGroup(glInf.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNumChar, GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)));
		panInf.setLayout(glInf);

		setVisible(true);
	}
}
