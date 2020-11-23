package controller;

import logic.Logic;
import model.Producto;
import view.Registro_productos;

public class Control {

	private String FILE_NAME = "productos/productos.data";

	Logic logic = new Logic();

	public static byte grupo() {
		byte bOpcion = 0;

		if (Registro_productos.radioBtnPack.isSelected()) {
			bOpcion = 1;

		} else if (Registro_productos.radioBtnUnidad.isSelected()) {
			bOpcion = 2;

		} else if (Registro_productos.radioBtnCombinado.isSelected()) {
			bOpcion = 3;
		}
		return bOpcion;
	}

	public static void eleccion(byte bElegir) {
		if (bElegir == 1) {
			Registro_productos.radioBtnPack.setSelected(true);
		} else if (bElegir == 2) {
			Registro_productos.radioBtnUnidad.setSelected(true);
		} else if (bElegir == 3) {
			Registro_productos.radioBtnCombinado.setSelected(true);
		}
	}

	public void guardarFichero() {
		logic.binary(Logic.productos, FILE_NAME);
	}

	public void anadir() {
		Registro_productos.txtCode.setText("");
		Registro_productos.txtName.setText("");
		Registro_productos.txtStockActual.setText("");
		Registro_productos.txtStockMin.setText("");
		Registro_productos.txtStockMax.setText("");
		eleccion((byte) 1);
		Registro_productos.comboProveedor.getSelectedItem();
		Registro_productos.textArea.getText().toString();
		Registro_productos.chkFragil.setSelected(false);
		Registro_productos.chkObsoleto.setSelected(false);
		Registro_productos.txtPVP.setText("");
	}

	public void mostrar(Producto p) {
		Registro_productos.txtCode.setText("" + p.getiCode());
		Registro_productos.txtName.setText("" + p.getsNombre());
		Registro_productos.txtStockActual.setText("" + p.getiStockAct());
		Registro_productos.txtStockMin.setText("" + p.getiStockMin());
		Registro_productos.txtStockMax.setText("" + p.getiStockMax());
		eleccion(p.getbGrupo());
		Registro_productos.comboProveedor.setSelectedItem(p.getsProveedor());
		Registro_productos.textArea.setText(p.getsComent());
		Registro_productos.chkFragil.setSelected(p.isbFragil());
		Registro_productos.chkObsoleto.setSelected(p.isbObsoleto());
		Registro_productos.txtPVP.setText("" + p.getfPVP());
	}

	public void confirmarBorrar(Registro_productos registro) {
		logic.confirmarBorrar(registro);
	}

	public void guardarProducto() {
		logic.guardarProducto();
	}

	public void principio() {
		Producto p = logic.primerProducto();
		if (p != null) {
			mostrar(p);
		}
	}

	public void siguiente() {
		Producto p = logic.siguienteProducto();
		if (p != null) {
			mostrar(p);
		}
	}

	public void anterior() {
		Producto p = logic.anteriorProducto();
		if (p != null) {
			mostrar(p);
		}
	}

	public void fin() {
		Producto p = logic.ultimoProducto();
		if (p != null)
			mostrar(p);
	}

	@SuppressWarnings("static-access")
	public void leerObj() throws ClassNotFoundException {

		logic.productos = logic.leerObjeto(FILE_NAME);

		Producto p = logic.productos.get(Logic.iPos);
		mostrar(p);
	}

}
