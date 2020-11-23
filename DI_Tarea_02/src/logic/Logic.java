package logic;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextArea;

import dbm.gestorDB;
import view.DataBase;

public class Logic {

	private static String guardarArchivos;
	private static String sRuta;
	public static gestorDB gestDB = new gestorDB();

	public void docWriter(String sRoot, JTextArea textArea) {
		System.out.println(textArea.getText());
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(sRoot));
			writer.write(textArea.getText());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardar(DataBase dataBase, JTextArea textArea) {
		FileDialog saveArchivos = new FileDialog(dataBase, "Guardar", FileDialog.SAVE);
		saveArchivos.setVisible(true);

		String sRoot = saveArchivos.getDirectory() + saveArchivos.getFile();
		docWriter(sRoot, textArea);

		guardarArchivos = saveArchivos.getFile();
		sRuta = saveArchivos.getDirectory();
	}

	public void guardarAuto(DataBase dataBase, JTextArea textArea) {
		String sRoot = sRuta + "consulta " + guardarArchivos;
		System.out.println(sRoot);
		docWriter(sRoot, textArea);
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

	public String cargar(DataBase database, JTextArea textArea) {
		FileDialog selecArchivos = new FileDialog(database, "Cargar", FileDialog.LOAD);
		selecArchivos.setVisible(true);
		String sRoot = selecArchivos.getDirectory() + selecArchivos.getFile();
		String sLoad = docReader(sRoot);
		textArea.setText(sLoad);
		return sRoot;
	}

	public static void retorna(Connection conn, String sSentenciaSql) throws SQLException {
		if (conn != null) {
			ResultSet rs = gestDB.getData(conn, sSentenciaSql);
			ResultSetMetaData rsm = rs.getMetaData();
			String sRes = " ";

			for (int i = 1; i < rsm.getColumnCount() + 1; i++) {
				sRes += rsm.getColumnName(i) + "\t";
			}

			while (rs.next()) {
				sRes += "\n";

				for (int i = 1; i < rsm.getColumnCount() + 1; i++) {
					sRes += rs.getString(i) + "\t";
				}
			}
			DataBase.textAreaR.setText(sRes);
			rs.close();
		}
	}

}
