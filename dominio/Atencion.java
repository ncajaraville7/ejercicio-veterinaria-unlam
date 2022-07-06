package ar.edu.unlam.dominio;

public class Atencion {

	private int id;
	private String nombreCliente;
	private String nombreMascota;
	private Especie especieMascota; 
	private double monto;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getNombreMascota() {
		return nombreMascota;
	}

	public void setNombreMascota(String nombreMascota) {
		this.nombreMascota = nombreMascota;
	}

	public Especie getEspecieMascota() {
		return especieMascota;
	}

	public void setEspecieMascota(Especie especieMascota) {
		this.especieMascota = especieMascota;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

	public Atencion(String nombreCliente, String nombreMascota, Especie especieMascota, double monto) {
		this.nombreCliente = nombreCliente;
		this.nombreMascota = nombreMascota;
		this.especieMascota = especieMascota;
		this.monto = monto;
	}

	public Atencion(Atencion atencion, int i) {
		this.id = i;
	}

	@Override
	public String toString() {
		return "Atencion [Id=" + id + ", Nombre de Cliente=" + nombreCliente + ", Nombre de Mascota=" + nombreMascota
				+ ", Especie Mascota=" + especieMascota + ", Monto= $" + monto + "]";
	}
}

