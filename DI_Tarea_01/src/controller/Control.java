package controller;

import java.awt.FileDialog;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import logic.Logic;
import view.Editor_de_textos;

public class Control {

	Logic logic = new Logic();

	public void confirmarSalir(Editor_de_textos editor) {
		if (JOptionPane.showConfirmDialog(editor, "¿Confirma que desea salir?", "Confirmar salir",
				2) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void guardar(String sRoot, JTextArea txt) {
		if (sRoot != null) {
			logic.docSave(sRoot, txt);
		}
	}

	public void guardarComo(Editor_de_textos editor, JTextArea textArea) {
		FileDialog saveArchivos = new FileDialog(editor, "Guardar como", FileDialog.SAVE);
		saveArchivos.setVisible(true);
		String sRoot = saveArchivos.getDirectory() + saveArchivos.getFile();
		logic.docWriter(sRoot, textArea);
	}

	public String abrir(Editor_de_textos editor, JTextArea tetxArea) {
		FileDialog selecArchivos = new FileDialog(editor, "Abrir", FileDialog.LOAD);
		selecArchivos.setVisible(true);
		String sRoot = selecArchivos.getDirectory() + selecArchivos.getFile();
		String sLoad = logic.docReader(sRoot);
		tetxArea.setText(sLoad);
		return sRoot;
	}

	public JTextArea font(String sNombre, int iTipo, int iTamanio) {
		return logic.font(sNombre, iTipo, iTamanio);
	}

	public void charCount(JLabel lblNumChar) {
		logic.charCount(lblNumChar);

	}

	public String manual(JTextArea textArea) {
		String sRoot = "manual/manual.txt";
		String sShow = logic.docReader(sRoot);
		textArea.setText(sShow);
		
		return sRoot;
		
	}

}
