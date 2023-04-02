package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Habitacion 
{	
	private double registroConsumos;
	private  String nombre;
	private int camas;
	private String ubicacion;
	private int capacidad;
	private ArrayList<String> Tamano;
	private String tipo;
	private String Extra; 
	private String tarifa;
	
	public Habitacion (String nombre,String ubicacion, int capacidad, int camas, ArrayList<String> Tamano, String tipo, String Extra, String tarifa)
	{
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.capacidad=capacidad;
		this.camas = camas;
		this.Tamano=Tamano;
		this.tipo=tipo;
		this.Extra=Extra;
		this.tarifa=tarifa;
	}
	
	
	public String getNumero()
	{
		return nombre;
	}
	
	public int getCapacidad()
	{
		return capacidad;
	}
	public int getCamas()
	{
		return camas;
	}
	public ArrayList<String> getTamano(){
		return Tamano; 
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	public String getTipo()
	{
		return tipo;
	}
	public String getExtra()
	{
		return Extra;
	}
	public String getTarifa() {
		return tarifa;
	}
	public String getTamanoString() {
		String tamanos="";
		if (Tamano.size()>1) {
			for (int a =0; a< Tamano.size();a++) {
			tamanos+= Tamano.get(a)+",";
			}
		}
		else {
			tamanos= Tamano.get(0);
		}
		
		return tamanos;
	}
	
	public void setTarifa(String nuevo) {
		tarifa=nuevo;
	}
	public void setnombre(String nuevo) {
		nombre=nuevo;
	}
	public void setcapacidad(int nuevo) {
		capacidad=nuevo;
	}
	public void setubicacion(String nuevo) {
		ubicacion=nuevo;
	}
	public void setCamas(int nuevo) {
		camas=nuevo;
	}
	public void setTamano(ArrayList<String> nuevo) {
		Tamano=nuevo;
	}
	public void setTipo(String nuevo) {
		tipo=nuevo;
	}
	public void setExtra(String nuevo) {
		Extra=nuevo;
	}
	
	private double getConsumos()
	{
		return registroConsumos;
		
	}
	
	public static void generarTextoFactura(String nombreArchivo, String cliente, String producto, double precio, int cantidad)
	{
		File file 	= new File(nombreArchivo + "txt");
		
		if (file.createNewFile())
			System.out.println("File created: " + file.getName());
		else
			System.out.println("File already exists.");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		writer.write("Factura\n\n");
		writer.write("Número habitación: " + numero);
		writer.write("Nombre: " + nombre);
		writer.write("Capacidad: " + capacidad);
		writer.write("Ubicación: " + ubicacion);
		writer.write("Precio totales: $"+ registroConsumos + "\n");
		writer.close();
		
		
	}
	

}
