package Modelo;
import java.time.LocalDate;
import java.util.ArrayList;

public class ReservaGrupal implements IReserva {
	public ArrayList<Habitacion> listaHabitaciones = new ArrayList<Habitacion>();
	public String nombreHuespedPrincipal;
	public String documentoIdentidad;
	public String correoElectronico;
	public String numeroCelular;
	public int cantidadPersonas;
	public Habitacion habitacion;
	public LocalDate fechaEntrada;
	public LocalDate fechaSalida; 
	public static int idReservaGrupal = 0;
	
	
	public ReservaGrupal(String nombreHuespedPrincipal, String documentoIdentidad, String correoElectronico, String numeroCelular, int cantidadPersonas, Habitacion habitacion, LocalDate fechaEntrada, LocalDate fechaSalida)
	{
		this.nombreHuespedPrincipal = nombreHuespedPrincipal;
		this.documentoIdentidad = documentoIdentidad;
		this.correoElectronico = correoElectronico;
		this.numeroCelular = numeroCelular;
		this.cantidadPersonas = cantidadPersonas;
		this.fechaEntrada = fechaEntrada;
		this.fechaSalida = fechaSalida; 
		idReservaGrupal=idReservaGrupal+1;
	}

	public String getNombreHuesped() {
		return(nombreHuespedPrincipal);
	}
	public Habitacion getHabitacion() {
		return null;
	}
	public LocalDate getFechaInicial() {
		return(fechaEntrada);
	}
	public LocalDate getFechaFinal() {
		return(fechaSalida);
	}

	public int getIdreserva() {
		return(idReservaGrupal);
	}

}
