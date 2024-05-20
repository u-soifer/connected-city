package ar.utn.ba.connectedcity.entities.perfil;

import ar.utn.ba.connectedcity.entities.perfil.interes.Interes;
import ar.utn.ba.connectedcity.entities.likes.Like;
import ar.utn.ba.connectedcity.entities.match.RecomendacionMatch;
import ar.utn.ba.connectedcity.entities.signo.Signo;
import ar.utn.ba.connectedcity.entities.match.Match;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Perfil {

    private String nombre;
    private String apellido;
    private LocalDateTime fechaNacimiento;
    private List<Interes> intereses;
    private EstadoPerfil estado;
    private List<Match> matches;
    private List<RecomendacionMatch> recomendaciones;
    private List<Like> likes;
    private Integer cantidadLikes;
    private Signo signoDelZodiaco;
    private List<Zona> zonasQueFrecuenta;

    public void recibirLike(Like like) {
        this.likes.add(like);
    }

    public void cambiarEstado(EstadoPerfil estado) {
        estado.setPerfil(this); 
        this.setEstado(estado);
    }

    public Integer getCantidadLikes() {
        return this.recomendaciones.size();
    }

    public boolean aceptarRecomendacion(Perfil p) {
        return this.estado.aceptarRecomendacion(p);
    }

    public Perfil() {
        this.zonasQueFrecuenta = new ArrayList<>();
        this.likes = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.intereses = new ArrayList<>();
    }

    public Perfil(String nombre, String apellido, List<Interes> intereses) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.intereses = intereses;
    }

    public int getCantidadMaximaRecomendaciones() {
        return this.estado.getCantidadMaxRecomendaciones();
    }
}

