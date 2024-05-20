package ar.utn.ba.connectedcity.entities.likes;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class LikesDelMes {

    private Perfil perfil;

    private Integer cantidadLikes;

    private LocalDate fechaInicioMes;

    private LocalDate fechaFinMes;

    private List<Like> likes;

    public LikesDelMes() {
        likes = new ArrayList<Like>();
    }
}
