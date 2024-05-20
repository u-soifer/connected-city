package ar.utn.ba.connectedcity.entities.perfil;

import ar.utn.ba.connectedcity.entities.Config;

public class EstadoInicial extends EstadoPerfil{

    public EstadoInicial() {
        this.porcentajeInteresesEnComun = Config.PORCENTAJE_INTERES_EN_COMUN_INICIAL;
    }

    @Override
    public Boolean aceptarRecomendacion(Perfil otroPerfil) {

        return calculadoraDeInteres.calcularPorcentajeDeInteresEnComun(this.perfil, otroPerfil) >= this.porcentajeInteresesEnComun;
    }
}
