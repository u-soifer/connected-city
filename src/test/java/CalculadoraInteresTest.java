import ar.utn.ba.connectedcity.entities.perfil.Perfil;
import ar.utn.ba.connectedcity.entities.perfil.interes.CalculadoraDeInteres;
import ar.utn.ba.connectedcity.entities.perfil.interes.Interes;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;


import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculadoraInteresTest {

    CalculadoraDeInteres calculadora = new CalculadoraDeInteres();

    Interes interes1 = new Interes("luciano pereyra", "el mejor cantante");
    Interes interes2 = new Interes("danza", "danza contemporanea");
    Interes interes3 = new Interes("hamburguesas", "hamburguesas de mc donals");

    ArrayList<Interes> intereses1 = new ArrayList<>();
    ArrayList<Interes> intereses2 = new ArrayList<>();

    Perfil juan = new Perfil("juan", "mercurio", intereses1);
    Perfil jeferson =  new Perfil("jeferson", "guillen", intereses2);

    Perfil gabi = new Perfil("gabi", "me ignora", new ArrayList<>());
    Perfil tom = new Perfil("tom", "tambien me ignora", intereses1);


    @BeforeEach
    public void inicializarListas() {
        intereses1.add(interes1);
        intereses1.add(interes3);

        intereses2.add(interes1);
        intereses2.add(interes2);
    }

    @Test
    public void calcularPorcentajeInteresComunDe50Test() {

        inicializarListas();
        Float resultado = calculadora.calcularPorcentajeDeInteresEnComun(juan, jeferson);
        assertEquals(50, resultado);
    }

    @Test
    public void calcularPorcentajeInteresComunDe100Test() {

        inicializarListas();
        Float resultado = calculadora.calcularPorcentajeDeInteresEnComun(juan, tom);
        assertEquals(100, resultado);
    }

    @Test
    public void calcularPorcentajeInteresComunDe0Test() {

        inicializarListas();
        Float resultado = calculadora.calcularPorcentajeDeInteresEnComun(juan, gabi);
        assertEquals(0, resultado);
    }




}