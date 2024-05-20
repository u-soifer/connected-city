package ar.utn.ba.connectedcity.entities.perfil;

import ar.utn.ba.connectedcity.entities.Config;
import ar.utn.ba.connectedcity.entities.signo.EvaluadorDeCompatibilidad;

public class EstadoPopular extends EstadoPerfil {
    private EvaluadorDeCompatibilidad evaluadorDeCompatibilidad;

    public EstadoPopular() {
        this.porcentajeInteresesEnComun = Config.PORCENTAJE_INTERES_EN_COMUN_POPULAR;
    }

    // tengan mas del 90% de intereses en comun y cuyo signo sea comparible segun las reglas astrologicas
    @Override
    public Boolean aceptarRecomendacion(Perfil otroPerfil) {

        Boolean sonSignosCompatibles;

        if(tieneSignoZodiaco(this.perfil) && tieneSignoZodiaco(otroPerfil)) {
            sonSignosCompatibles  = evaluadorDeCompatibilidad.esCompatible(this.perfil.getSignoDelZodiaco().getElemento(), otroPerfil.getSignoDelZodiaco().getElemento());
        }

        else {
            sonSignosCompatibles = evaluadorDeCompatibilidad.esCompatible(this.perfil.getFechaNacimiento().toLocalDate(), perfil.getFechaNacimiento().toLocalDate());
        }

        return calculadoraDeInteres.calcularPorcentajeDeInteresEnComun(this.perfil, otroPerfil) >= this.porcentajeInteresesEnComun
                && sonSignosCompatibles;
    }

    private boolean tieneSignoZodiaco(Perfil perfil){
        return this.perfil.getSignoDelZodiaco() != null;
    }

}
