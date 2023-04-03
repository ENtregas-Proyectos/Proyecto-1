package Modelo;

import java.util.ArrayList;

import Modelo.CatalogoServicios;

public class CoordinadorDeServicios
{
	
	
	private CatalogoServicios catalogo;
	private Consumo consumos;
	private ArrayList<Servicio>servicios;
	private RegistroConsumo pagos;

	
public CoordinadorDeServicios ()
	
	{
	
	this.catalogo = catalogo;
	
	this.servicios = new ArrayList<Servicio>();
	
	this.pagos = pagos;
	}

public void registrarServicios(Servicio servicio) 
{
    catalogo.agregarServicio(servicio);
}

public void registrarPagos(Consumo pago) 
{
    pagos.agregarPago(pago);
}

public void mostrarServicios() {
    for (Servicio servicio : servicios) {
        System.out.println(servicio.getNombre());
    }
}

public Servicio buscarServicio(String nombreServicio) {
    for (Servicio servicio : servicios) {
        if (servicio.getNombre().equals(nombreServicio)) {
            return servicio;
        }
    }
    return null;
}





public Factura generarFactura(Servicio servicio)
{
	return null;
	
	
}
}
