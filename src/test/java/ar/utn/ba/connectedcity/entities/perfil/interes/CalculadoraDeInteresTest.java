package ar.utn.ba.connectedcity.entities.perfil.interes;

import ar.utn.ba.connectedcity.entities.perfil.Perfil;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CalculadoraDeInteresTest {

    @Mock private Perfil perfil1;
    @Mock private Perfil perfil2;


    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        Interes interes1 = new Interes();
        Interes interes2 = new Interes();
        Interes interes3 = new Interes();
        Interes interes4 = new Interes();
        when(this.perfil1.getIntereses()).thenReturn(List.of(
                interes1, interes2, interes3
        ));
        when(this.perfil2.getIntereses()).thenReturn(List.of(
                interes4, interes3, interes1
        ));
    }
    @Test
    public void calcularPorcentajeDeInteresEnComunTest() {
        CalculadoraDeInteres calculadoraDeInteres1 = new CalculadoraDeInteres();
        float porcentajeEsperado = (2f / 3f)*100f; //66,666
        assertEquals(porcentajeEsperado, calculadoraDeInteres1.calcularPorcentajeDeInteresEnComun(this.perfil1,this.perfil2));
    }
}