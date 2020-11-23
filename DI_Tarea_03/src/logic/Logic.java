package logic;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import controller.Control;
import model.Producto;
import view.Registro_productos;

public class Logic {

	public static List<Producto> productos = new ArrayList<Producto>();
	public static int iPos = 0;

	public List<Producto> productos(int iCode, String sNombre, int iStockAct, int iStockMin, int iStockMax, byte bGrupo,
			String sProveedor, String sComent, boolean bFragil, boolean bObsoleto, float fPVP) {

		int iAct = 0;
		int iMin = 0;
		int iMax = 0;

		if (existencias(iStockAct, iStockMin, iStockMax) == true) {
			iAct = iStockAct;
			iMin = iStockMin;
			iMax = iStockMax;
		}

		float fPrecio = 0;

		if (precio(fPVP) == true) {
			fPrecio = fPVP;
		}

		if (idCheck(iCode) == false) {
			productos.add(new Producto(iCode, sNombre, iAct, iMin, iMax, bGrupo, sProveedor, sComent, bFragil, bObsoleto, fPrecio));
			iPos++;
		} else {
			productos.set(iPos, new Producto(iCode, sNombre, iAct, iMin, iMax, bGrupo, sProveedor, sComent, bFragil, bObsoleto, fPrecio));
		}
		return productos;
	}

	private boolean existencias(int iStockAct, int iStockMin, int iStockMax) {
		boolean bCheck = false;

		if (iStockMin > 0 && iStockMin < iStockMax) {
			bCheck = true;
			if (iStockAct > iStockMin && iStockAct < iStockMax) {
				bCheck = true;
			}
		} else {
			bCheck = false;
		}

		return bCheck;
	}

	private boolean precio(float fPVP) {
		boolean bCheck = false;

		if (fPVP > 0) {
			bCheck = true;
		}

		return bCheck;
	}

	private boolean idCheck(int iCode) {
		boolean bCheck = false;

		iPos = iCode;

		int iCont = 0;

		while (iCont < productos.size() && bCheck == false) {
			if (iPos == productos.get(iCont).getiCode()) {
				bCheck = true;
			}

			iCont++;
		}
		return bCheck;
	}

	public void binary(List<Producto> productos, String FILE_NAME) {

		ObjectOutputStream file = null;

		try {
			file = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
			file.writeObject(productos);
			
			file.close();

		} catch (IOException e) {
			System.err.println(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Producto> leerObjeto(String FILE_NAME) throws ClassNotFoundException {
		ObjectInputStream file = null;
		List<Producto> productos = new ArrayList<Producto>();
		try {
			file = new ObjectInputStream(new FileInputStream(FILE_NAME));

			productos = (List<Producto>) file.readObject();
			file.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return productos;
	}

	public Producto primerProducto() {
		Producto p = null;

		iPos = 0;

		p = productos.get(iPos);

		return p;
	}

	public Producto siguienteProducto() {
		Producto p = null;

		if (iPos != productos.size() - 1) {

			iPos++;
			p = productos.get(iPos);

		}
		return p;
	}

	public Producto anteriorProducto() {
		Producto p = null;

		if (iPos != 0) {

			iPos--;
			p = productos.get(iPos);

		}
		return p;
	}

	public Producto ultimoProducto() {
		Producto p = null;

		iPos = productos.size() - 1;
		if (iPos >= 1) {
			p = productos.get(iPos);
		}
		return p;
	}

	public void confirmarBorrar(Registro_productos resgistro) {

		if (JOptionPane.showConfirmDialog(resgistro, "¿Desea borrar " + Registro_productos.txtName.getText() + "?",
				"Confirmar borrar ", 2) == JOptionPane.YES_OPTION) {
			productos.remove(iPos);
		}

	}

	public void guardarProducto() {
		productos = productos(
				Integer.parseInt(Registro_productos.txtCode.getText()),
				Registro_productos.txtName.getText().toString(),
				Integer.parseInt(Registro_productos.txtStockActual.getText()),
				Integer.parseInt(Registro_productos.txtStockMin.getText()), 
				Integer.parseInt(Registro_productos.txtStockMax.getText()),
				Control.grupo(),
				Registro_productos.comboProveedor.getSelectedItem().toString(),
				Registro_productos.textArea.getText().toString(), 
				Registro_productos.chkFragil.isSelected(),
				Registro_productos.chkObsoleto.isSelected(), 
				Float.parseFloat(Registro_productos.txtPVP.getText()));
	}
}
