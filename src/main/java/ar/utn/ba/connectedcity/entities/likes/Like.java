package ar.utn.ba.connectedcity.entities.likes;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Like {

    private Perfil perfilLikeado;
    private Perfil perfilQueLikea;
    private LocalDateTime fecha;

}
