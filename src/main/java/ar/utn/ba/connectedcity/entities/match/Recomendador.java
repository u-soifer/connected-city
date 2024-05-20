package ar.utn.ba.connectedcity.entities.match;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import ar.utn.ba.connectedcity.repositories.RepositorioDeRecomendacionesGeneradas;
import ar.utn.ba.connectedcity.repositories.RepositorioPerfil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Recomendador {

    // TAREA PROGRAMADA
    public static void main(String[] args) {

        List<Perfil> perfiles = new RepositorioPerfil().getPerfiles();

        RepositorioDeRecomendacionesGeneradas repoRecomendaciones = new RepositorioDeRecomendacionesGeneradas();

        repoRecomendaciones.reiniciarRecomendaciones();

        repoRecomendaciones.guardarRecomendacionesGeneradas(Recomendador.generarRecomendaciones(perfiles));
    }
    
    public static List<RecomendacionMatch> generarRecomendaciones(List<Perfil> perfiles) {

        List<RecomendacionMatch> recomendaciones = new ArrayList<>();

        for (Perfil perfil: perfiles) {

            List<RecomendacionMatch> recomendacionesPerfil = Recomendador.generarRecomendacionesPara(perfil, perfiles.stream().filter(p -> !p.equals(perfil)).toList());
            recomendaciones.addAll(recomendacionesPerfil);
        }

        return recomendaciones;

    }

    public static List<RecomendacionMatch> generarRecomendacionesPara(Perfil perfil, List<Perfil> demasPerfiles) {

        List<Perfil> perfilesRecomendados = demasPerfiles.stream().filter(p-> perfil.aceptarRecomendacion(p)).toList();

        List<RecomendacionMatch> recomendaciones = new ArrayList<>();

        for(Perfil perfilRecomendado : perfilesRecomendados) {

            if(recomendaciones.size() == perfil.getCantidadMaximaRecomendaciones()) {
                break;
            }

            RecomendacionMatch recomendacion = RecomendacionMatch.builder().fechaGeneracion(LocalDateTime.now()).
                    estado(EstadoRecomendacionMatch.PENDIENTE_CONFIRMACION)
                    .perfilRecomendado(perfilRecomendado).
                    perfilAQuienSeLeRecomienda(perfil).build();

            recomendaciones.add(recomendacion);


        }
        return recomendaciones;

    }
}
