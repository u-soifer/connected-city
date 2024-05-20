package ar.utn.ba.connectedcity.entities.signo;


import java.time.LocalDate;

public class EvaluadorDeCompatibilidad {

    private AdapterEvaluadorCompatibilidad adapterEvaluadorCompatibilidad;

    public Boolean esCompatible(LocalDate unaFecha, LocalDate otraFecha) {

        SignoDTO signoPrimeraFecha = this.hallarSignoDelZodiaco(unaFecha);
        SignoDTO signoSegundaFecha = this.hallarSignoDelZodiaco(otraFecha);

        return signoSegundaFecha.getElemento().equals(signoPrimeraFecha.getElemento());

    }

    public Boolean esCompatible(Elemento elemento, Elemento otroElemento ) {

        return elemento.equals(otroElemento);
    }

    public SignoDTO hallarSignoDelZodiaco(LocalDate fecha) {
        return adapterEvaluadorCompatibilidad.hallarSignoDelZodiaco(fecha);
    }
}
