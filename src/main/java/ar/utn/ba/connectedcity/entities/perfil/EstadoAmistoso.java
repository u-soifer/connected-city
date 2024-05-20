package ar.utn.ba.connectedcity.entities.perfil;

import ar.utn.ba.connectedcity.entities.Config;

public class EstadoAmistoso extends EstadoPerfil{

    private Character parametroLetra = Config.PARAMETRO_LETRA_AMISTOSO;

    public EstadoAmistoso() {
        this.porcentajeInteresesEnComun = Config.PORCENTAJE_INTERES_EN_COMUN_AMISTOSO;
    }

    @Override
    public Boolean aceptarRecomendacion(Perfil otroPerfil) {

        return calculadoraDeInteres.calcularPorcentajeDeInteresEnComun(this.perfil, otroPerfil) >= this.porcentajeInteresesEnComun

                    && otroPerfil.getNombre().contains(String.valueOf(parametroLetra));

    }



}
