package ar.utn.ba.connectedcity.entities.perfil;

import ar.utn.ba.connectedcity.entities.perfil.interes.CalculadoraDeInteres;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class EstadoPerfil {

    protected CalculadoraDeInteres calculadoraDeInteres;

    protected Integer cantidadMaxRecomendaciones;

    protected Float porcentajeInteresesEnComun;

    protected Integer likesParaSiguienteNivel;

    protected Perfil perfil;

    public void cambiarEstado(EstadoPerfil estado){
        perfil.cambiarEstado(estado);
    }
    
    public boolean puedeCambiarEstado(EstadoPerfil estado) {

        return perfil.getCantidadLikes() >= estado.getLikesParaSiguienteNivel();
    }


    public abstract Boolean aceptarRecomendacion(Perfil perfil);
}
