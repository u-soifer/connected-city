package ar.utn.ba.connectedcity.repositories;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RepositorioPerfil {

    private List<Perfil> perfiles;

    public RepositorioPerfil() {
        perfiles = new ArrayList<Perfil>();
    }




}
