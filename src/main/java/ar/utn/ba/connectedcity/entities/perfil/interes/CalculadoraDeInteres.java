package ar.utn.ba.connectedcity.entities.perfil.interes;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;

import java.util.List;

public class CalculadoraDeInteres {

    public Float calcularPorcentajeDeInteresEnComun(Perfil unPerfil, Perfil otroPerfil) {

        List<Interes> interesesUnPerfil = unPerfil.getIntereses();
        List<Interes> interesesOtroPerfil = otroPerfil.getIntereses();
        Float cantInteresesEnComun = calcularCantidad(interesesUnPerfil, interesesOtroPerfil);
        Float cantMaxIntereses = calcularMaximoLongitud(interesesUnPerfil, interesesOtroPerfil);

        return (cantInteresesEnComun / cantMaxIntereses ) * 100;
    }

    private Float calcularCantidad(List<Interes> interesesDeAlguien, List<Interes> interesesDeOtro) {
        return (float) interesesDeAlguien.stream().filter(interesesDeOtro::contains).toList().size();
    }

    private Float calcularMaximoLongitud(List<Interes> interesesDeAlguien, List<Interes> interesesDeOtro) {
        return interesesDeAlguien.size() > interesesDeOtro.size() ? (float) interesesDeAlguien.size() : (float) interesesDeOtro.size();
    }
}
