package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.Control;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private Control control = new Control();

	/**
	 * Create the dialog.
	 */
	public AcercaDe() {
		setTitle("Acerca de...");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblPrograma = new JLabel("Programa: Editor de textos");
		lblPrograma.setBounds(20, 20, 170, 14);
		contentPanel.add(lblPrograma);

		JLabel lblAutor = new JLabel("Creado por: Víctor Molina Vázquez");
		lblAutor.setBounds(20, 45, 216, 14);
		contentPanel.add(lblAutor);

		JLabel lblVersion = new JLabel("Número de versión: 0.2");
		lblVersion.setBounds(20, 70, 147, 14);
		contentPanel.add(lblVersion);

		JLabel lblFecha = new JLabel("Fecha: 11/11/2020");
		lblFecha.setBounds(20, 95, 122, 14);
		contentPanel.add(lblFecha);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Volver");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();

					}
				});
				okButton.setActionCommand("Volver");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setVisible(true);
	}
}
