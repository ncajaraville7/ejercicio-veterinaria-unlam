package ar.edu.unlam.dominio;

import ar.edu.unlam.dominio.Atencion;

public class Veterinaria {

	private String nombre;
	private Atencion[] atenciones;
	private final int CANTIDAD_MAXIMA_ATENCIONES;
	private String usuario = "hola";
	private String contrasenia = "1234";

	public Veterinaria(String nombreVeterinaria, int cantidadMaximaAtenciones) {
		this.nombre = nombreVeterinaria;
		this.CANTIDAD_MAXIMA_ATENCIONES = cantidadMaximaAtenciones;
		atenciones = new Atencion[CANTIDAD_MAXIMA_ATENCIONES];

	}

	/**
	 * Agrega una atenciona al arreglo de atenciones
	 * 
	 * @param atencion Atencion que se agregara
	 * @return true en caso de exito
	 */
	public boolean registrarAtencion(Atencion atencion) {
		boolean registrarAtencion = false;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				registrarAtencion = false;
			} else {
				atenciones[i] = atencion;
				atenciones[i].setId(i);
				registrarAtencion = true;
				break;
			}
		}
		return registrarAtencion;
	}

	/**
	 * Obtiene una atencion por su identificador
	 * 
	 * @param id Identificador de la atencion
	 * @return atencion o null en caso de no encontrarse
	 */
	public Atencion buscarAtencionPorId(int id) {
		Atencion usuarioBuscadoPorId = null;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null && atenciones[i].getId() == id) {
				usuarioBuscadoPorId = atenciones[i];
				break;
			}
		}
		return usuarioBuscadoPorId;
	}

	/**
	 * Obtiene atenciones filtradas por la especie de la mascota
	 * 
	 * @return array de atenciones
	 */
	public Atencion[] listarAtencionesPorEspecieDeMascota(Especie especieMascota) {
		Atencion[] atencionPorEspecie = new Atencion[atenciones.length];
		int pos = 0;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null && atenciones[i].getEspecieMascota().equals(especieMascota)) {
				atencionPorEspecie[pos++] = atenciones[i];
			}

		}
		return atencionPorEspecie;
	}

	/**
	 * Elimina una atencion por su identificador
	 * 
	 * @param id Identificador de la atencion
	 * @return true en caso de exito
	 */
	public boolean eliminarAtencionPorId(int id) {
		boolean atencionEliminada = false;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null && atenciones[i].getId() == id) {
				atenciones[i] = null;
				atencionEliminada = true;
				break;
			}
		}
		return atencionEliminada;
	}

	/**
	 * Obtiene la cantidad de atenciones realizadas hasta el momento
	 * 
	 * @return cantidad de atenciones
	 */
	public int obtenerCantidadDeAtencionesRealizadas() {
		int atencionesRealizadas = 0;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] != null) {
				atencionesRealizadas++;
			}
		}
		return atencionesRealizadas;
	}

	/**
	 * Obtiene la cantidad de atenciones disponibles
	 * 
	 * @return atenciones
	 */
	public int obtenerCantidadDeAtencionesDisponibles() {
		int atencionesDisponibles = 0;
		for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i] == null) {
				atencionesDisponibles++;
			}
		}
		return atencionesDisponibles;

	}

	/**
	 * Calcula y devuelve el total de todas las atenciones realizadas
	 * 
	 * @return monto total
	 */
	public double obtenerTotalDeAtenciones() {
		double totalDeAtenciones = 0.0;
		for (int i = 0; i< atenciones.length; i++) {
			if (atenciones[i] != null) {
				totalDeAtenciones += atenciones[i].getMonto();
			}
		}
		return totalDeAtenciones;
	}

	/**
	 * Obtiene atenciones ordenadas por monto descendente
	 * 
	 * @return atenciones
	 */
	public void ordenarAtencionesPorMontoDescendente() {
		for (int i = 0; i < atenciones.length; i++) {
			for (int j = 0; j < atenciones.length - 1; j++) {
				if (atenciones[j] != null && atenciones[j].getMonto() < atenciones[j+1].getMonto()) {					
					Atencion aux = atenciones[j];
					atenciones[j] = atenciones[j + 1];
					atenciones[j + 1] = aux;
				}
			}
		}
	}

	/**
	 * Valida las credenciales proporcionadas
	 * 
	 * @param nombreUsuario Nombre de usuario del administrador
	 * @param contrasenia   Contrasenia del administrador
	 * @return verdadero en caso de exito
	 */
	public boolean iniciarSesion(String nombreUsuario, String contrasenia) {
		
		if (nombreUsuario.equals(this.usuario) && contrasenia.equals(this.contrasenia)) {
			return true;
		}
		
		return false;
	}

	public Atencion[] mostrarListaEntera() {
		/*for (int i = 0; i < atenciones.length; i++) {
			if (atenciones[i]!= null) {
				System.out.println(atenciones[i].toString());
			}
		}*/
		return atenciones;
	}
}
