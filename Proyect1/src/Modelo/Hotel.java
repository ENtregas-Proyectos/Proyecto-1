package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel 
{
	public CoordinadorInventario inventario = new CoordinadorInventario();
	public CoordinadorDeServicios servicio = new CoordinadorDeServicios();

	public void aplicacionAdministrador() 
	{
		System.out.println("Menu Administrador ");
		iniciarapp();
		boolean continuar= true;
		while (continuar) {
			inventario.mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción: Hotel"));
			if (opcion ==1 ) 
			{
				inventario.vaciarArchico();
				inventario.crearInventario();
			}
			else if (opcion ==2 ) {
				inventario.cargarCuartos();
				inventario.escribirArchivo();
			}
			else if (opcion == 3 ) {
				inventario.AgregarCuarto();
				inventario.escribirArchivo();
			}
			else if (opcion == 4 ) {
				inventario.AgregarServicio();
				inventario.escribirArchivo();
			}
			else if (opcion == 5 ) {
				inventario.modificarCuarto();
				inventario.escribirArchivo();
			}
			else if (opcion == 6) {
				inventario.cargarTarifa();
				inventario.escribirArchivo();
			}
			else if (opcion == 7 ) {
				inventario.consultarInventario();
			}
			else if (opcion == 8 ) {
				inventario.consultarHabitacion();	
			}
			else if (opcion ==9 ) {
				//FALTA ESTO
			}
			else if (opcion==10) {
				continuar = false;
				System.out.println("Saliendo");
			}
		}
	}
	
	public void aplicacionParaServicios() 
	{
		System.out.println("Menu opciones servicios ");
		iniciarappServicio();
		boolean continuar= true;
		while (continuar) {
			servicio.mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción: "));
			if (opcion ==1 ) {
				servicio.vaciarArchico();
				servicio.crearServicios();
			}
			else if (opcion ==2 ) {
				servicio.cargarServicios();
				servicio.escribirArchivo();
			}
			else if (opcion == 3 ) {
				servicio.AgregarServicio();
				servicio.escribirArchivo();
			}
			else if (opcion == 4 ) {
				servicio.AgregarServicioAHabitacion();
				servicio.escribirArchivo();
			}
			else if (opcion == 5 ) {
				servicio.AgregarServicioAHuesped();
				servicio.escribirArchivo();
			}
			else if (opcion == 6) {
				servicio.RegistrarPago();
				servicio.escribirArchivo();
			}
			else if (opcion == 7 ) {
				servicio.consultarServicios();
			}
			else if (opcion == 8 ) {
				servicio.consultarCuentaHabitacion();	
			}
			else if (opcion == 9 ) {
				servicio.AgregarServicio();	
			}
			else if (opcion==10) {
				continuar = false;
				System.out.println("Saliendo");
			}
		}
	}
	public static String input(String mensaje)
	{
		try
		{
			System.out.print(mensaje );
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		}
		catch (IOException e)
		{
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}
	public void iniciarapp() 
	{
		
		inventario.iniciar();

	}
	
	public void iniciarappServicio()
	{
		servicio.iniciar();
	}
}




