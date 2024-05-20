package ar.utn.ba.connectedcity.entities.likes;
import ar.utn.ba.connectedcity.entities.perfil.Perfil;

import java.util.List;

public interface ReiniciadorDeLikes {
    void reiniciarLikesDe(List<Perfil> perfiles);
}
