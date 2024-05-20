package ar.utn.ba.connectedcity.entities.perfil.interes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Interes {
    private String nombre;
    private String descripcion;

    public Interes(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
