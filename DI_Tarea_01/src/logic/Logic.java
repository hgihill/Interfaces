package logic;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JTextArea;

import view.Editor_de_textos;

public class Logic {

	public void charCount(JLabel lblNumChar) {
		if (Editor_de_textos.textArea.getText().length() != 0) {
			lblNumChar.setText("Caracteres: " + Editor_de_textos.textArea.getText().length());

		} else {
			lblNumChar.setText("Caracteres: 0");
		}

	}

	public String docReader(String sRoot) {
		String sRead = "";

		try {
			FileReader fReader = new FileReader(sRoot);
			BufferedReader bReader = new BufferedReader(fReader);
			String sChar = bReader.readLine();

			while (sChar != null) {
				sRead += sChar + "\n";
				sChar = bReader.readLine();
			}

			fReader.close();
			bReader.close();

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no localizado " + e);

		} catch (IOException e) {
			System.err.println("Error al leer el archivo " + e);
		}

		return sRead;
	}

	public void docWriter(String sRoot, JTextArea txt) {

		try {
			FileWriter fWriter = new FileWriter(sRoot);

			String sChar = txt.getText();

			if (sChar != null) {
				fWriter.write(sChar);
				fWriter.close();
			}

		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo " + e);
		}
	}

	public void docSave(String sRoot, JTextArea txt) {
		try {
			FileWriter fWriter = new FileWriter(sRoot);
			BufferedWriter bWriter = new BufferedWriter(fWriter);

			bWriter.write(txt.getText());
			bWriter.newLine();

			bWriter.close();
			fWriter.close();

		} catch (IOException e) {
			System.err.println("Error al guardar el archivo " + e);
		}
	}

	public JTextArea font(String sNombre, int iTipo, int iTamanio) {

		JTextArea txt = new JTextArea();
		Font font = new Font(sNombre, iTipo, iTamanio);

		txt.setFont(font);

		return txt;
	}
}
