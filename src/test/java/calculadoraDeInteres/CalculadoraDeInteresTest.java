package calculadoraDeInteres;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import ar.utn.ba.connectedcity.entities.perfil.interes.CalculadoraDeInteres;
import ar.utn.ba.connectedcity.entities.perfil.interes.Interes;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraDeInteresTest {
    List<Interes> lista1;
    List<Interes> lista2;
    CalculadoraDeInteres calculadoraDeInteres = new CalculadoraDeInteres();

    @Mock Perfil perfil1;
    @Mock Perfil perfil2;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        lista1 = new ArrayList<>();
        lista2 = new ArrayList<>();
     }

    @Test
    public void unTest() {
        when(perfil1.getNombre()).thenReturn("juan");
        System.out.println(perfil1.getNombre());
        Assertions.assertEquals(perfil1.getNombre(), "juan");
    }

    @Test
    public void paraUnInteresEnComunDaMayorACero() {
        Interes rock = new Interes("rock", "");
        lista1.add(rock);
        lista2.add(rock);

        when(perfil1.getIntereses()).thenReturn(lista1);
        when(perfil2.getIntereses()).thenReturn(lista2);

        Assertions.assertTrue(calculadoraDeInteres.calcularPorcentajeDeInteresEnComun(perfil1, perfil2) > (float) 0);
    }
}
