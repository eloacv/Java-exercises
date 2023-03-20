package entidad;

public class Automovil {
	private String IdAutomovil;
	private String MARCA;
	private String NUMPLACA;
	private double PRECIO;
	private int STOCK;
	private String FECHAFABRICACION;
	private String ESTADO;
	
	public Automovil() {	
	}
	
	
	public Automovil(String idAutomovil, String mARCA, String nUMPLACA, double pRECIO, int sTOCK,
			String fECHAFABRICACION, String eSTADO) {
		IdAutomovil = idAutomovil;
		MARCA = mARCA;
		NUMPLACA = nUMPLACA;
		PRECIO = pRECIO;
		STOCK = sTOCK;
		FECHAFABRICACION = fECHAFABRICACION;
		ESTADO = eSTADO;
	}

//GETTERS AND SETTERS
	public String getIdAutomovil() {
		return IdAutomovil;
	}


	public void setIdAutomovil(String idAutomovil) {
		IdAutomovil = idAutomovil;
	}


	public String getMARCA() {
		return MARCA;
	}


	public void setMARCA(String mARCA) {
		MARCA = mARCA;
	}


	public String getNUMPLACA() {
		return NUMPLACA;
	}


	public void setNUMPLACA(String nUMPLACA) {
		NUMPLACA = nUMPLACA;
	}


	public double getPRECIO() {
		return PRECIO;
	}


	public void setPRECIO(double pRECIO) {
		PRECIO = pRECIO;
	}


	public int getSTOCK() {
		return STOCK;
	}


	public void setSTOCK(int sTOCK) {
		STOCK = sTOCK;
	}


	public String getFECHAFABRICACION() {
		return FECHAFABRICACION;
	}


	public void setFECHAFABRICACION(String fECHAFABRICACION) {
		FECHAFABRICACION = fECHAFABRICACION;
	}


	public String getESTADO() {
		return ESTADO;
	}


	public void setESTADO(String eSTADO) {
		ESTADO = eSTADO;
	}
	
	
	
	

}
