package Modelo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Habitacion 
{
	
	private double registroConsumos;
	private  String nombre;
	private int numero;
	private String ubicacion;
	private int capacidad;
	
	public Habitacion(String nombre, int capacidad, int numero, String ubicacion)
	{
		this.nombre = nombre;
		this.capacidad=capacidad;
		this.numero = numero;
		this.ubicacion = ubicacion;
		
	}
	
	public int getNumero()
	{
		return numero;
	}
	
	public int getCapacidad()
	{
		return capacidad;
	}
	
	public String getUbicacion()
	{
		return ubicacion;
	}
	
	private double getConsumos()
	{
		return registroConsumos;
		
	}
	
	public void generarTextoFactura(String nombreArchivo, String cliente, String producto, double precio, int cantidad)
	{
		try {
			
		
		File file 	= new File(nombreArchivo + "txt");
		
		if (file.createNewFile())
			System.out.println("File created: " + file.getName());
		else
			System.out.println("File already exists.");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		
		writer.write("Factura\n");
		writer.write("Número habitación: " + numero);
		writer.write("Nombre: " + nombre);
		writer.write("Capacidad: " + capacidad);
		writer.write("Ubicación: " + ubicacion);
		writer.write("Precio totales: $"+ registroConsumos + "\n");
		writer.close();
		
		}
		catch (IOException e)
		{
			System.out.println("Error writing from the standard input");
			e.printStackTrace();
		}
		
		
	}
	

}
