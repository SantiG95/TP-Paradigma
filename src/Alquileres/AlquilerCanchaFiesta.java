package Alquileres;

import Personas.Organizador;

import java.util.Date;

public class AlquilerCanchaFiesta extends AlquilerCancha {
    public AlquilerCanchaFiesta(Date fecha, String ubicacion, int tamañodecancha, String descripcion, Organizador inquilino){
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.tamañoCancha = tamañodecancha;
        inquilino.setAlquilerCanchita(this);
    }
}
