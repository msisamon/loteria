package com.babel.loteria;

import com.babel.loteria.exception.LoteriaException;
import com.babel.loteria.repositorio.ILoteriaDB;
import com.babel.loteria.servicio.IBomboService;
import com.babel.loteria.servicio.ILoteriaService;
import com.babel.loteria.servicio.LoteriaService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoteriaTest {
    @InjectMocks
    LoteriaService loteriaService;
    @Mock
    IBomboService servicioBombo;

    @Mock
    ILoteriaDB loteriaDB;

    @BeforeAll
    void beforeAll(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void whenIntroduzcoNumeroThenReturnListaGanadoresSizeNumero() {
        // Given
        int numResultados = 6;

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("00001");
        expectedResult.add("00002");
        expectedResult.add("00003");
        expectedResult.add("00004");
        expectedResult.add("00005");
        expectedResult.add("00006");

        // When

        List<String> mockitoGanadores = new ArrayList<>();
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00000");
        mockitoGanadores.add("00001");
        mockitoGanadores.add("00002");
        mockitoGanadores.add("00003");
        mockitoGanadores.add("00004");
        mockitoGanadores.add("00005");
        mockitoGanadores.add("00006");

        Mockito.when(loteriaService.getListaGanadores()).thenReturn(mockitoGanadores);

        List<String> listaRes = loteriaService.getListaGanadores(numResultados);

        // Then
        Assertions.assertEquals(expectedResult, listaRes);
    }

    @Test
    public void whenIntroduzcoNumeroMayorAlSizeGanadoresThenReturnListaGanadores() {
        // Given
        int numResultados = 10;

        List<String> expectedResult = new ArrayList<>();
        expectedResult.add("00001");
        expectedResult.add("00002");
        expectedResult.add("00003");

        // When

        List<String> mockitoGanadores = new ArrayList<>();
        mockitoGanadores.add("00001");
        mockitoGanadores.add("00002");
        mockitoGanadores.add("00003");

        Mockito.when(loteriaService.getListaGanadores()).thenReturn(mockitoGanadores);

        List<String> listaRes = loteriaService.getListaGanadores(numResultados);

        // Then
        Assertions.assertEquals(expectedResult, listaRes);
    }

    @Test
    public void whenIntroduzcoGanadorCorrectoThenReturnTrue() throws Exception {
        String ganador = "00000";

        Mockito.when(loteriaDB.addNumeroGanador(Mockito.anyString())).thenReturn(true);
        boolean resultado = loteriaService.addGanador(ganador);
        Assertions.assertEquals(true, resultado);

    }

}
