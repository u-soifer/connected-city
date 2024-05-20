package ar.utn.ba.connectedcity.repositories;

import ar.utn.ba.connectedcity.entities.match.RecomendacionMatch;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeRecomendacionesGeneradas {

    private List<RecomendacionMatch> recomendacionesDeLaSemana;

    public RepositorioDeRecomendacionesGeneradas() {
        recomendacionesDeLaSemana = new ArrayList<>();
    }

    public void reiniciarRecomendaciones() {
        recomendacionesDeLaSemana = new ArrayList<>();
    }

    public void guardarRecomendacionesGeneradas(List<RecomendacionMatch> recomendaciones) {
        recomendacionesDeLaSemana.addAll(recomendaciones);
    }
}
