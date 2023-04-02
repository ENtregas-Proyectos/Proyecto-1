package Modelo;

import java.util.ArrayList;

public class RegistroConsumo 
{
	
	private ArrayList<Consumo> consumos;
	
	private String registroConsumos;
	
	public RegistroConsumo()
	{
		consumos = new ArrayList<Consumo>();
		this.registroConsumos = registroConsumos;
	}
	
	
	private ArrayList<Consumo> getConsumosTotales()
	{
		return consumos;
	}
	
	private double getPrecioIVA(double precioInicial)

	{
		
		double precioFinal = precioInicial+(precioInicial*0.19);
		
		return precioFinal;
		
	}
	
	private int getPrecioNeto(double precioInicial)
	{
		
		double precioIVA = getPrecioIVA(precioInicial);
		
		
		return 0;
	}
	
	public ArrayList<Consumo> getConsumos()
	{
		return consumos;
		
	}
	
	
	
	public void generarTextoFactura()
	{
		
	}
	

}
