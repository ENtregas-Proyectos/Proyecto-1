package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CoordinadorDeReservas {
	
	public Hashtable<String, ArrayList<IReserva>> mapaReservas= new Hashtable<String, ArrayList<IReserva>>();
	
	public void mostrarMenuRecepcionista() {
		System.out.println("1. CREAR NUEVA RESERVA");
		System.out.println("1. CANCELAR RESERVA EXISTENTE");
		System.out.println("1. CHECKEAR DISPONIBILIDAD HABITACION");
	}
	
	public void crearReserva(String nombreHuesped, String documentoIdentidad, String correoElectronico, String numeroCelular, int cantidadPersonas, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida) {
		
		ReservaIndividual reserva = new ReservaIndividual(nombreHuesped, documentoIdentidad, correoElectronico, numeroCelular,cantidadPersonas, habitacion,fechaEntrada, fechaSalida);
		String numHabitacion = habitacion.getNumero();
		
		if (mapaReservas.contains(numHabitacion) == false) {
			ArrayList<IReserva> listaReservasHabitacion= new ArrayList<IReserva>();
			listaReservasHabitacion.add(reserva);
			mapaReservas.put(numHabitacion, listaReservasHabitacion);
			habitacion.blockearDisponibilidad(fechaEntrada, fechaSalida);
			System.out.println("\n********LA RESERVA SE HA GENERADO CON EXITO********\n");
			
		}
		else {
			ArrayList<IReserva> lista = mapaReservas.get(numHabitacion);
			lista.add(reserva);
			mapaReservas.put(numHabitacion, lista);
			habitacion.blockearDisponibilidad(fechaEntrada, fechaSalida);
			System.out.println("\n********LA RESERVA SE HA GENERADO CON EXITO********\n");
		}
		
	}
	
	public void cancelarReserva(String nombreHuesped, String numeroHabitacion) {
		String nombre = null;
		for (IReserva reserva: (mapaReservas.get(numeroHabitacion)) ) {
			nombre = reserva.getNombreHuesped();
			if (nombre == nombreHuesped){
				(mapaReservas.get(numeroHabitacion)).remove(reserva);
				Habitacion habitacion = reserva.getHabitacion();
				LocalDate fechaInicio = reserva.getFechaInicial();
				LocalDate fechaFinal = reserva.getFechaFinal();
				habitacion.desbloquearDisponibilidad(fechaInicio, fechaFinal);
				System.out.println("LA RESERVA SE HA CANCELADO CON EXITO/n");
				break;
			}
		}
		if (nombre ==null) {
			System.out.println("NO SE ENCONTRO LA RESERVA/n");
		}
	}
	
	public boolean checkearDisponibilidad(Habitacion habitacion, LocalDate fechaIncio, LocalDate fechaFinal) {
		boolean verificar= habitacion.verificarDisponibilidad(fechaIncio, fechaFinal);
		
		if (verificar == true) {
			return(verificar);
		}
		else {
			return(verificar);
		}
	}
	
	public int getIdReserva(ReservaIndividual reserva) {
		return(reserva.getIdreserva());
	}
	
	public  Habitacion encontrarHabitacionReserva(LocalDate fechaInicial, LocalDate fechaFinal, int numeroPersonas) {
		ArrayList<Habitacion> habitacionesDisponibles = new ArrayList<Habitacion>();
		Hashtable<String, Habitacion> listaHabitaciones= CoordinadorInventario.listaHabitaciones;
		Iterator<Map.Entry<String, Habitacion>> iterator = listaHabitaciones.entrySet().iterator();

		while (iterator.hasNext()) {
		    Entry<String, Habitacion> entry = iterator.next();
		    String key = entry.getKey();
		    Habitacion habitacion = entry.getValue();
		    
		    if (habitacion.getCapacidad() >= numeroPersonas && checkearDisponibilidad(habitacion, fechaInicial, fechaFinal)) {
		    	habitacionesDisponibles.add(habitacion);
		    	}
			}
		for(Habitacion habitacion: habitacionesDisponibles) {
			String numeroHabitacion = habitacion.getNumero();
			String tamanioHabitacion = habitacion.getTamanoString();
			int camasHabitacion = habitacion.getCamas();
			int index = habitacionesDisponibles.indexOf(habitacion);
			int capacidad = habitacion.getCapacidad();
			
			System.out.println(index+". Habitacion numero: "+numeroHabitacion+", tipo: "+tamanioHabitacion+", capacidad: "+capacidad+"\n");
		}
		int seleccion = Integer.parseInt(input("Seleccione la habitacion que desee:\n"));
		Habitacion habitacion = habitacionesDisponibles.get(seleccion);
		return(habitacion);
		
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
	

