package ar.utn.ba.connectedcity.entities.match;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import ar.utn.ba.connectedcity.entities.likes.Like;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RecomendacionMatch {
  private Perfil perfilAQuienSeLeRecomienda;
  private Perfil perfilRecomendado;
  private LocalDateTime fechaGeneracion;
  private Float porcentajeDeCoincidenciaIntereses;
  private Like likeQueTuvo;
  private EstadoRecomendacionMatch estado;
}
