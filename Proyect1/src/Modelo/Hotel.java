package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hotel {
	public Inventario inventario = new Inventario();

	public void aplicacionAdministrador() {
		System.out.println("Menu Administrador ");
		iniciarapp();
		boolean continuar= true;
		while (continuar) {
			inventario.mostrarMenu();
			int opcion = Integer.parseInt(input("Por favor seleccione una opción: Hotel"));
			if (opcion ==1 ) {
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
				inventario.modificarCuarto();
				inventario.escribirArchivo();
			}
			else if (opcion == 5) {
				inventario.cargarTarifa();
				inventario.escribirArchivo();
			}
			else if (opcion == 6 ) {
				inventario.consultarInventario();
			}
			else if (opcion == 7 ) {
				inventario.consultarHabitacion();	
			}
			else if (opcion ==8 ) {
				//FALTA ESTO
			}
			else if (opcion==9) {
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
	public void iniciarapp() {
		
		inventario.iniciar();
	}
}
