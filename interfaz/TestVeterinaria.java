package ar.edu.unlam.interfaz;

import java.util.Scanner;

import ar.edu.unlam.dominio.Atencion;
import ar.edu.unlam.dominio.Especie;
import ar.edu.unlam.dominio.Veterinaria;

public class TestVeterinaria {

	private static final int SALIR = 9;
	private static final int CANTIDAD_MAXIMA_ATENCIONES = 5;

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);

		String nombreVeterinaria = "UNLaM-Vet";
		mostrarMensaje("Bienvenido a " + nombreVeterinaria);
		Veterinaria veterinaria = new Veterinaria(nombreVeterinaria, CANTIDAD_MAXIMA_ATENCIONES);

		int opcion = 0;

		do {
			opcion = seleccionarOpcion(teclado);

			switch (opcion) {
			case 1:
				// Registra una atencion con los datos ingresados por el empleado e informa el
				// resultado
				crearAtencion(teclado, veterinaria);
				break;
			case 2:
				// Se solicita el ingreso del id y se muestra la informacion de la atencion
				// encontrada. Si no se encuentra, mostrar un mensaje
				mostrarMensaje("Ingrese el ID a buscar");
				int idAtencion = teclado.nextInt();
				if (veterinaria.buscarAtencionPorId(idAtencion) == null)
		mostrarMensaje("No existen atenciones realizadas con ese ID");
				{
					System.out.println(veterinaria.buscarAtencionPorId(idAtencion));
				}
				break;
			case 3:
				mostrarMensaje("Ingrese la especie: " + "\n1 - PERRO" + "\n2 - GATO" + "\n3 - AVE");
				int especie = teclado.nextInt();
				Especie especieMascota = Especie.values()[especie - 1];
				veterinaria.listarAtencionesPorEspecieDeMascota(especieMascota);// Ingresar la especie de mascota para
																				// listar las atenciones que
																				// correspondan.
				if (veterinaria.listarAtencionesPorEspecieDeMascota(especieMascota) == null) {
					mostrarMensaje("No hubieron atenciones a ese tipo de mascotas");
				} else
					mostrarLista(veterinaria.listarAtencionesPorEspecieDeMascota(especieMascota));
				break;
			case 4:
				mostrarMensaje("Ingrese ID de Atencion a Eliminar");
				idAtencion = teclado.nextInt();
				if (veterinaria.eliminarAtencionPorId(idAtencion) == true) {
					mostrarMensaje("Atencion eliminada con exito");
				} else
					mostrarMensaje("No se pudo borrar atencion");
				// Se solicita el ingresdo del id de la atencion y se elimina. Indicar el
				// resultado de la operacion
				break;
			case 5:
				System.out.println("La cantidad de atenciones disponibles es: "
						+ veterinaria.obtenerCantidadDeAtencionesDisponibles());
				System.out.println("La cantidad de atenciones realizadas es: "
						+ veterinaria.obtenerCantidadDeAtencionesRealizadas());
				// Listar las atenciones realizadas y las disponibles
				break;
			case 6:
				mostrarMensaje("Ingrese nombre de usuario");
				String usuario = teclado.next();
				System.out.println("Ingrese contrasenia");
				String contrasenia = teclado.next();

				if (veterinaria.iniciarSesion(usuario, contrasenia) == true) {
					System.out.println("Sesion Iniciada");
					System.out.println(
							"El monto total de las atenciones realizadas es $ " + veterinaria.obtenerTotalDeAtenciones());
				} else
					System.out.println("No se pudo iniciar sesion");
				// Informar el total de todas las atenciones realizadas. Debe inciar sesión
				// para realizar esta operacion.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				break;
			case 7:
				mostrarMensaje("Ingrese nombre de usuario");
				usuario = teclado.next();
				System.out.println("Ingrese contrasenia");
				contrasenia = teclado.next();

				if (veterinaria.iniciarSesion(usuario, contrasenia) == true) {
					System.out.println("Sesion Iniciada\n");
					mostrarLista(veterinaria.mostrarListaEntera());
					
					
				} else
					System.out.println("No se pudo iniciar sesion\n");
				// Informar por pantalla atenciones ordenadas en forma decreciente. Si no hay
				// atenciones mostrar un mensaje aclaratorio.
				// Si las credenciales son invalidas, indicarlo y volver al menu principal.
				break;
			case SALIR:
				mostrarMensaje("Gracias por utilizar el sistema");
				break;
			}

		} while (opcion != SALIR);

		teclado.close();
	}



	private static void mostrarLista(Atencion[] listarAtencionesPorEspecieDeMascota) {
		for (int i = 0; i < listarAtencionesPorEspecieDeMascota.length; i++) {
			if (listarAtencionesPorEspecieDeMascota[i] != null) {
				System.out.println(listarAtencionesPorEspecieDeMascota[i]);
			}
		}

	}

	/**
	 * Muestra el menu principal y solicita el ingreso de la funcionalidad deseada
	 * 
	 * @param teclado Para el ingreso de datos
	 * @return opcion seleccionada
	 */
	private static int seleccionarOpcion(Scanner teclado) {

		int opcionSeleccionada = 0;

		mostrarMensaje("\n************************");
		mostrarMensaje("Menu Principal\n");
		mostrarMensaje("1 - Registar una atencion ");
		mostrarMensaje("2 - Buscar atencion por su identificador unico");
		mostrarMensaje("3 - Listar atenciones por una especie determinada");
		mostrarMensaje("4 - Eliminar una atencion por su id");
		mostrarMensaje("5 - Informar la cantidad de atenciones realizadas y las disponibles");
		mostrarMensaje("6 - Infomar el total de todas las atenciones realizadas [Requiere iniciar sesion]");
		mostrarMensaje("7 - Listar atenciones por monto descendente [Requiere iniciar sesion]");
		mostrarMensaje("\n9 - Salir");
		mostrarMensaje("\n************************");
		mostrarMensaje("\nIngrese una opcion");

		opcionSeleccionada = teclado.nextInt();

		return opcionSeleccionada;
	}

	/**
	 * Solicita el ingreso de la informacion para crear una atencion y la crea
	 * 
	 * @param teclado Para el ingreso de datos
	 */
	private static boolean crearAtencion(Scanner teclado, Veterinaria veterinaria) {
		boolean crearAtencion = false;
		mostrarMensaje("Ingrese nombre de cliente");
		String nombreCliente = teclado.next();
		mostrarMensaje("Ingrese nombre de mascota");
		String nombreMascota = teclado.next();
		mostrarMensaje("Ingrese la especie: " + "\n1 - PERRO" + "\n2 - GATO" + "\n3 - AVE");
		int opcion = teclado.nextInt();
		Especie especieMascota = Especie.values()[opcion - 1];
		mostrarMensaje("Ingrese monto a cobrar por la atencion");
		double monto = teclado.nextDouble();
		Atencion atencion = new Atencion(nombreCliente, nombreMascota, especieMascota, monto);

		if (veterinaria.registrarAtencion(atencion) == true) {
			mostrarMensaje("Atencion creada con exito");
			crearAtencion = true;
		} else
			mostrarMensaje("No se pudo crear atencion");

		return false;
	}

	private static void mostrarMensaje(String mensaje) {
		System.out.println(mensaje);
	}
}
