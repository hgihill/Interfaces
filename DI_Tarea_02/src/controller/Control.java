package controller;

import java.awt.Color;
import java.awt.FileDialog;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import logic.Logic;
import view.Conexion;
import view.DataBase;

public class Control {

	Logic logic = new Logic();

	public void confirmarSalir(DataBase dataBase) {
		if (JOptionPane.showConfirmDialog(dataBase, "¿Confirma que desea salir?", "Confirmar salir",
				2) == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}

	public void guardar(DataBase dataBase, JTextArea textArea) {
		if (dataBase != null) {
			logic.guardar(dataBase, textArea);
		}
	}

	public void guardarAuto(DataBase dataBase, JTextArea textArea) {
		if (dataBase != null) {
			logic.guardarAuto(dataBase, textArea);
		}
	}

	public String cargar(DataBase dataBase, JTextArea tetxArea) {
		FileDialog selecArchivos = new FileDialog(dataBase, "Cargar", FileDialog.LOAD);
		selecArchivos.setVisible(true);
		String sRoot = selecArchivos.getDirectory() + selecArchivos.getFile();
		String sLoad = logic.docReader(sRoot);
		tetxArea.setText(sLoad);
		return sRoot;
	}

	public void limpiar(JTextArea textArea) {
		textArea.setText(" ");
	}
	
	public static void retorna(String sSentenciaSql) throws SQLException {
		Logic.retorna(Conexion.connection, sSentenciaSql);
	}
	
	public static void btnConectar (Conexion frame) {

		if (frame.radiobtnOracle.isSelected() == true && frame.radiobtnMySQL.isSelected() == false) {

			char[] aChar = frame.pass.getPassword();
			String sPass = new String(aChar);
			frame.connection = dbm.gestorDB.getConnectionOracle(frame.txtHost.getText(), frame.txtPort.getText(),
					frame.txtSID.getText(), frame.txtUser.getText(), sPass);

			if (frame.connection == null) {
				DataBase.lblGestConexion.setText("Failed Connection");
				DataBase.lblGestConexion.setForeground(Color.RED);
			} else {
				DataBase.lblGestConexion.setText("Connected");
				DataBase.lblGestConexion.setForeground(Color.GREEN);
			}

		} else {

			char[] aChar = frame.pass.getPassword();
			String sPass = new String(aChar);
			frame.connection = dbm.gestorDB.getConnectionMySQL(frame.txtHost.getText(), frame.txtPort.getText(), frame.txtSID.getText(),
					frame.txtUser.getText(), sPass);

			if (frame.connection == null) {
				DataBase.lblGestConexion.setText("Failed Connection");
				DataBase.lblGestConexion.setForeground(Color.RED);
			} else {
				DataBase.lblGestConexion.setText("Connected");
				DataBase.lblGestConexion.setForeground(Color.GREEN);
			}
		}
	}

}
