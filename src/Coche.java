public class Coche {

	private String attId;
	private String marca;
	private String modelo;
	private int anyo;
	private int potencia;
	private String attUnidad;
	private double precio;
	private String attMoneda;
	public Coche(String attId, String marca, String modelo, int anyo, int potencia, String attUnidad, double precio,
			String attMoneda) {
		super();
		this.attId = attId;
		this.marca = marca;
		this.modelo = modelo;
		this.anyo = anyo;
		this.potencia = potencia;
		this.attUnidad = attUnidad;
		this.precio = precio;
		this.attMoneda = attMoneda;
	}
	public String getAttId() {
		return attId;
	}
	public void setAttId(String attId) {
		this.attId = attId;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnyo() {
		return anyo;
	}
	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public String getAttUnidad() {
		return attUnidad;
	}
	public void setAttUnidad(String attUnidad) {
		this.attUnidad = attUnidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getAttMoneda() {
		return attMoneda;
	}
	public void setAttMoneda(String attMoneda) {
		this.attMoneda = attMoneda;
	}
	
}

	