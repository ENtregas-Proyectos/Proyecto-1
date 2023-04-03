package Consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Modelo.Administrador;//ESTO
import Modelo.Hotel;//ESTO


public class Aplicacion {
	public Hotel hotel = new Hotel();
	private static ArrayList<Administrador> listaAdministradores= new ArrayList<Administrador>();
	
	public static void main(String[] args) {
		Aplicacion consola = new Aplicacion();
		consola.ejecutarAplicacion();
		
	}
	
	public void ejecutarAplicacion() {
		boolean continuar= true;
		 System.out.println("\t\t\t\t\tBienvenido al Hotel !\n");
		 while (continuar) {
			 mostrarMenuInicial();
			 int opcion = Integer.parseInt(input("Por favor seleccione una opción:"));
			 if (opcion ==1 ) {
				 crearCuenta();
			 }
			 else if (opcion ==2) {
				 iniciarSesion();
			 }
			 else if (opcion ==3 ) {
				 continuar=false;
			 }
		 }
	}

	public void mostrarMenuInicial() {
		System.out.println("En que te podemos ayudar hoy?\n1. Crear Cuenta");
		System.out.println("2. Iniciar Sesion");
		System.out.println("3. Cerrar Aplicacion"); 
	}
	public void crearCuenta() {
		String nombre = input ("Ingrese su nombre: ");
		String login = input ("Ingrese su login: ");
		String clave = input ("Ingrese su clave: ");
		System.out.println("Porfavor Seleccione el tipo de empleado ");
		System.out.println("1. Administrador \n2. Recepcionista \n3. Otro");
		int opcion = Integer.parseInt(input(""));
		if (opcion ==1 ) {
			Administrador nuevo = new Administrador(nombre,login,clave);
			listaAdministradores.add(nuevo);
		}
		else if (opcion ==2 ) {
			// NUEVO RECEPCIONISTA
		}
		else if (opcion ==3 ) {
			// OTRO!!!!
		}
		else {
			System.out.println("Opcion no valida ");
		}
		
	}
	public void iniciarSesion() {
		boolean encontrado = false;
		System.out.println("Porfavor Seleccione el tipo de empleado ");
		System.out.println("1. Administrador \n2. Recepcionista \n3. Otro");
		int opcion = Integer.parseInt(input(""));
		String login = input("Ingrese su login ");
		String clave = input("ingrese su clave ");
		if (opcion ==1 ) {
			for (int a =0 ; a<listaAdministradores.size();a++) {
				if (listaAdministradores.get(a).darLogin().equals(login) && listaAdministradores.get(a).darClave().equals(clave)) {
					System.out.println("Bienvenido"); 
					encontrado= true;
				}
			}
			if (encontrado ==true) {
				AplicacionAdministrador();
			}
		}
		else if (opcion ==2) {
				// LOG IN DE RECEPCIONISTA
			}
		else if (opcion ==3) {
			// LOG IN DE OTROS 
		}
			
		
	}
	
	
	public void AplicacionAdministrador() {
		hotel.aplicacionAdministrador();
		
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
}
