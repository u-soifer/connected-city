package ar.utn.ba.connectedcity.entities.signo;

import java.time.LocalDate;

public interface AdapterEvaluadorCompatibilidad {

    SignoDTO hallarSignoDelZodiaco(LocalDate fecha);
}