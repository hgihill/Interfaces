package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Colores extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblPrueba;


	/**
	 * Create the dialog.
	 */
	public Colores() {
		setTitle("Colores");
		setResizable(false);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		Color LColor = Editor_de_textos.textArea.getBackground();
		Color RColor = Editor_de_textos.textArea.getForeground();

		{
			JLabel lblFondo = new JLabel("Fondo");
			lblFondo.setBounds(28, 40, 61, 16);
			contentPanel.add(lblFondo);
		}

		{
			JLabel lblFuente = new JLabel("Fuente");
			lblFuente.setBounds(250, 40, 61, 16);
			contentPanel.add(lblFuente);
		}

		{
			JButton btnBlackL = new JButton("");
			btnBlackL.setIcon(new ImageIcon("colores/black.png"));
			btnBlackL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.BLACK);
					lblPrueba.setBackground(Color.BLACK);
				}
			});
			btnBlackL.setBounds(28, 60, 31, 32);
			contentPanel.add(btnBlackL);
		}

		{
			JButton btnRedL = new JButton("");
			btnRedL.setIcon(new ImageIcon("colores/red.png"));
			btnRedL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.RED);
					lblPrueba.setBackground(Color.RED);
				}
			});
			btnRedL.setBounds(58, 60, 31, 32);
			contentPanel.add(btnRedL);
		}

		{
			JButton btnGreenL = new JButton("");
			btnGreenL.setIcon(new ImageIcon("colores/green.png"));
			btnGreenL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.GREEN);
					lblPrueba.setBackground(Color.GREEN);
				}
			});
			btnGreenL.setBounds(88, 60, 31, 32);
			contentPanel.add(btnGreenL);
		}

		{
			JButton btnDarkBlueL = new JButton("");
			btnDarkBlueL.setIcon(new ImageIcon("colores/dark_blue.png"));
			btnDarkBlueL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.BLUE);
					lblPrueba.setBackground(Color.BLUE);
				}
			});
			btnDarkBlueL.setBounds(118, 60, 31, 32);
			contentPanel.add(btnDarkBlueL);
		}

		{
			JButton btnWhiteL = new JButton("");
			btnWhiteL.setIcon(new ImageIcon("colores/white.png"));
			btnWhiteL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.WHITE);
					lblPrueba.setBackground(Color.WHITE);
				}
			});
			btnWhiteL.setBounds(28, 90, 31, 32);
			contentPanel.add(btnWhiteL);
		}

		{
			JButton btnOrangeL = new JButton("");
			btnOrangeL.setIcon(new ImageIcon("colores/orange.png"));
			btnOrangeL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.ORANGE);
					lblPrueba.setBackground(Color.ORANGE);
				}
			});
			btnOrangeL.setBounds(58, 90, 31, 32);
			contentPanel.add(btnOrangeL);
		}

		{
			JButton btnYellowL = new JButton("");
			btnYellowL.setIcon(new ImageIcon("colores/yellow.png"));
			btnYellowL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.YELLOW);
					lblPrueba.setBackground(Color.YELLOW);
				}
			});
			btnYellowL.setBounds(88, 90, 31, 32);
			contentPanel.add(btnYellowL);
		}

		{
			JButton btnLightBlueL = new JButton("");
			btnLightBlueL.setIcon(new ImageIcon("colores/light_blue.png"));
			btnLightBlueL.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setBackground(Color.CYAN);
					lblPrueba.setBackground(Color.CYAN);
				}
			});
			btnLightBlueL.setBounds(118, 90, 31, 32);
			contentPanel.add(btnLightBlueL);
		}

		{
			JButton btnBlackR = new JButton("");
			btnBlackR.setIcon(new ImageIcon("colores/black.png"));
			btnBlackR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.BLACK);
					lblPrueba.setForeground(Color.BLACK);
				}
			});
			btnBlackR.setBounds(250, 60, 31, 32);
			contentPanel.add(btnBlackR);
		}

		{
			JButton btnRedR = new JButton("");
			btnRedR.setIcon(new ImageIcon("colores/red.png"));
			btnRedR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.RED);
					lblPrueba.setForeground(Color.RED);
				}
			});
			btnRedR.setBounds(280, 60, 31, 32);
			contentPanel.add(btnRedR);
		}

		{
			JButton btnGreenR = new JButton("");
			btnGreenR.setIcon(new ImageIcon("colores/green.png"));
			btnGreenR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.GREEN);
					lblPrueba.setForeground(Color.GREEN);
				}
			});
			btnGreenR.setBounds(310, 60, 31, 32);
			contentPanel.add(btnGreenR);
		}

		{
			JButton btnDarkBlueR = new JButton("");
			btnDarkBlueR.setIcon(new ImageIcon("colores/dark_blue.png"));
			btnDarkBlueR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.BLUE);
					lblPrueba.setForeground(Color.BLUE);
				}
			});
			btnDarkBlueR.setBounds(340, 60, 31, 32);
			contentPanel.add(btnDarkBlueR);
		}

		{
			JButton btnWhiteR = new JButton("");
			btnWhiteR.setIcon(new ImageIcon("colores/white.png"));
			btnWhiteR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.WHITE);
					lblPrueba.setForeground(Color.WHITE);
				}
			});
			btnWhiteR.setBounds(250, 90, 31, 32);
			contentPanel.add(btnWhiteR);
		}

		{
			JButton btnOragneR = new JButton("");
			btnOragneR.setIcon(new ImageIcon("colores/orange.png"));
			btnOragneR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.ORANGE);
					lblPrueba.setForeground(Color.ORANGE);
				}
			});
			btnOragneR.setBounds(280, 90, 31, 32);
			contentPanel.add(btnOragneR);
		}

		{
			JButton btnYellowR = new JButton("");
			btnYellowR.setIcon(new ImageIcon("colores/yellow.png"));
			btnYellowR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.YELLOW);
					lblPrueba.setForeground(Color.YELLOW);
				}
			});
			btnYellowR.setBounds(310, 90, 31, 32);
			contentPanel.add(btnYellowR);
		}

		{
			JButton btnLightBlueR = new JButton("");
			btnLightBlueR.setIcon(new ImageIcon("colores/light_blue.png"));
			btnLightBlueR.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Editor_de_textos.textArea.setForeground(Color.CYAN);
					lblPrueba.setForeground(Color.CYAN);
				}
			});
			btnLightBlueR.setBounds(340, 90, 31, 32);
			contentPanel.add(btnLightBlueR);
		}

		{
			lblPrueba = new JLabel("Prueba");
			lblPrueba.setOpaque(true);
			lblPrueba.setBounds(6, 210, 89, 23);
			contentPanel.add(lblPrueba);
		}

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);

			{
				JButton okButton = new JButton("Aplicar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Editor_de_textos.textArea.setBackground(lblPrueba.getBackground());
						Editor_de_textos.textArea.setForeground(lblPrueba.getForeground());
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
						Editor_de_textos.textArea.setBackground(LColor);
						Editor_de_textos.textArea.setForeground(RColor);
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
