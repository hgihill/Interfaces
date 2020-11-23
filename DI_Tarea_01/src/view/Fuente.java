package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JList;
import java.awt.Checkbox;
import javax.swing.JComboBox;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class Fuente extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();

	private Control control = new Control();
	private JList lista = new JList();
	private Editor_de_textos editor;
	private String sNombre, sAux;
	private int iTipo, iTamanyo;
	private JLabel lblPrueba;
	private JCheckBox chkNormal, chkNegrita, chkCursiva, chkSubrayado;

	/**
	 * Create the dialog.
	 */
	public Fuente() {
		setTitle("Fuente");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		{
			JLabel lblFuente = new JLabel("Fuente");
			lblFuente.setBounds(16, 37, 61, 16);
			contentPanel.add(lblFuente);
		}
		{
			JLabel lblEstilo = new JLabel("Estilo");
			lblEstilo.setBounds(175, 37, 61, 16);
			contentPanel.add(lblEstilo);
		}
		{
			JLabel lblTamanyo = new JLabel("Tamaño");
			lblTamanyo.setBounds(329, 37, 61, 16);
			contentPanel.add(lblTamanyo);
		}

		{
			lblPrueba = new JLabel("Prueba");
			lblPrueba.setBounds(6, 210, 89, 23);
			contentPanel.add(lblPrueba);
		}

		{
			chkNormal = new JCheckBox("Normal");
			chkNormal.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chkNormal.setSelected(true);
					if (chkNormal.isSelected() == true) {
						chkNegrita.setSelected(false);
						chkCursiva.setSelected(false);
						chkSubrayado.setSelected(false);
					}
					lblPrueba.setFont(
							new Font(lblPrueba.getFont().getFamily(), Font.PLAIN, lblPrueba.getFont().getSize()));

				}
			});

			chkNormal.setBounds(170, 59, 78, 23);
			contentPanel.add(chkNormal);
		}

		{
			chkNegrita = new JCheckBox("Negrita");
			chkNegrita.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chkNormal.setSelected(false);
					if (chkNegrita.isSelected() == true) {
						chkNormal.setSelected(false);
						if (chkCursiva.isSelected() == true) {
							chkNegrita.setSelected(true);
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.BOLD + Font.ITALIC,
									lblPrueba.getFont().getSize()));
						} else {
							chkNegrita.setSelected(true);
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.BOLD,
									lblPrueba.getFont().getSize()));
						}

					} else {
						chkNegrita.setSelected(false);
						if (chkCursiva.isSelected() == true) {
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.ITALIC,
									lblPrueba.getFont().getSize()));
						}
					}
				}
			});
			chkNegrita.setBounds(170, 84, 78, 23);
			contentPanel.add(chkNegrita);
		}

		{
			chkCursiva = new JCheckBox("Cursiva");
			chkCursiva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					chkNormal.setSelected(false);
					if (chkCursiva.isSelected() == true) {
						chkNormal.setSelected(false);
						if (chkNegrita.isSelected() == true) {
							chkCursiva.setSelected(true);
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.BOLD + Font.ITALIC,
									lblPrueba.getFont().getSize()));
						} else {
							chkCursiva.setSelected(true);
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.ITALIC,
									lblPrueba.getFont().getSize()));
						}

					} else {
						chkCursiva.setSelected(false);
						if (chkNegrita.isSelected() == true) {
							lblPrueba.setFont(new Font(lblPrueba.getFont().getFamily(), Font.BOLD,
									lblPrueba.getFont().getSize()));
						}
					}
				}
			});
			chkCursiva.setBounds(170, 109, 89, 23);
			contentPanel.add(chkCursiva);
		}

		{
			chkSubrayado = new JCheckBox("Subrayado");
			chkSubrayado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
			chkSubrayado.setBounds(170, 134, 102, 23);
			contentPanel.add(chkSubrayado);
		}

		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(16, 63, 109, 105);
			contentPanel.add(scrollPane);
			lista.addListSelectionListener(new ListSelectionListener() {
				public void valueChanged(ListSelectionEvent e) {
					sAux = (String) lista.getSelectedValue();
					lblPrueba.setFont(new Font(sAux, lblPrueba.getFont().getStyle(), lblPrueba.getFont().getSize()));
				}
			});

			lista.setModel(new AbstractListModel() {
				String[] sTemas = new String[] { "Americana BT", "Arial", "Book Antiqua", "Calibri", "Camria",
						"Helvetica", "Times New Roman", "Walt Disney Script", "Yikes!" };

				public int getSize() {
					return sTemas.length;
				}

				public Object getElementAt(int index) {

					return sTemas[index];
				}
			});
			scrollPane.setViewportView(lista);
		}

		{
			JComboBox comboTamanyo = new JComboBox();
			comboTamanyo.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					iTamanyo = Integer.parseInt((String) comboTamanyo.getSelectedItem());
					lblPrueba.setFont(new Font(lblPrueba.getFont().getFontName(),lblPrueba.getFont().getStyle(), iTamanyo));
				}
			});
			comboTamanyo.setModel(
					new DefaultComboBoxModel(new String[] { "10", "11", "12", "14", "16", "20", "24", "30", "36" }));
			comboTamanyo.setBounds(329, 65, 72, 27);
			contentPanel.add(comboTamanyo);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aplicar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						Editor_de_textos.textArea.setFont(lblPrueba.getFont());
						dispose();
					}
				});
				okButton.setActionCommand("Aplicar");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}

		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
