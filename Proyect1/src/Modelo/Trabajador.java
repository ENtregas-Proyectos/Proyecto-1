package Modelo;

import java.util.ArrayList;

public class Trabajador 

{
	
	private String login;
	
	private String clave;
	
	private ArrayList<Consumo> serviciosConsumidos;
	
	public Trabajador()
	{
		
		this.clave = clave;
		this.login = login;
			
	}
	
	public void ingresarConsumo(Consumo consumo)
	{
		serviciosConsumidos.add(consumo);
		
	}

}
