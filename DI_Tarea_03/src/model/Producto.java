package model;

import java.io.Serializable;

public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int iCode, iStockAct, iStockMin, iStockMax;
	private byte bGrupo;
	private float fPVP;
	private String sNombre, sComent, sProveedor;
	private boolean bFragil, bObsoleto;

	public Producto(int iCode, String sNombre, int iStockAct, int iStockMin, int iStockMax, byte bGrupo,
			String sProveedor, String sComent, boolean bFragil, boolean bObsoleto, float fPVP) {

		setiCode(iCode);
		setsNombre(sNombre);
		setiStockAct(iStockAct);
		setiStockMin(iStockMin);
		setiStockMax(iStockMax);
		setbGrupo(bGrupo);
		setsProveedor(sProveedor);
		setsComent(sComent);
		setbFragil(bFragil);
		setbObsoleto(bObsoleto);
		setfPVP(fPVP);
	}

	public int getiCode() {
		return iCode;
	}

	public void setiCode(int iCode) {
		this.iCode = iCode;
	}
	
	public String getsNombre() {
		return sNombre;
	}

	public void setsNombre(String sNombre) {
		this.sNombre = sNombre;
	}

	public int getiStockAct() {
		return iStockAct;
	}

	public void setiStockAct(int iStockAct) {
		this.iStockAct = iStockAct;
	}

	public int getiStockMin() {
		return iStockMin;
	}

	public void setiStockMin(int iStockMin) {
		this.iStockMin = iStockMin;
	}

	public int getiStockMax() {
		return iStockMax;
	}

	public void setiStockMax(int iStockMax) {
		this.iStockMax = iStockMax;
	}

	public byte getbGrupo() {
		return bGrupo;
	}

	public void setbGrupo(byte bGrupo) {
		this.bGrupo = bGrupo;
	}

	public String getsProveedor() {
		return sProveedor;
	}

	public void setsProveedor(String sProveedor) {
		this.sProveedor = sProveedor;
	}
	
	public String getsComent() {
		return sComent;
	}

	public void setsComent(String sComent) {
		this.sComent = sComent;
	}

	public boolean isbFragil() {
		return bFragil;
	}

	public void setbFragil(boolean bFragil) {
		this.bFragil = bFragil;
	}

	public boolean isbObsoleto() {
		return bObsoleto;
	}

	public void setbObsoleto(boolean bObsoleto) {
		this.bObsoleto = bObsoleto;
	}
	
	public float getfPVP() {
		return fPVP;
	}

	public void setfPVP(float fPVP) {
		this.fPVP = fPVP;
	}

	@Override
	public String toString() {
		String sResultado = "";

		sResultado += "Código: " + getiCode() + "\n";
		sResultado += "Nombre: " + getsNombre() + "\n";
		sResultado += "Stock actual: " + getiStockAct() + "\n";
		sResultado += "Stock mínimo: " + getiStockMin() + "\n";
		sResultado += "Stock máximo: " + getiStockMax() + "\n";
		sResultado += "Grupo: " + getbGrupo() + "\n";
		sResultado += "Proveedor: " + getsProveedor() + "\n";
		sResultado += "Comentarios: " + getsComent() + "\n";
		sResultado += "Frágil: " + isbFragil() + "\n";
		sResultado += "Obsoleto: " + isbObsoleto() + "\n";
		sResultado += "Precio: " + getfPVP() + "\n";

		return sResultado;
	}
}
