package ar.utn.ba.connectedcity.entities.match;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Match {
    private Perfil perfil1;
    private Perfil perfil2;
    private LocalDateTime fecha;
}
